#include <iostream>
#include <vector>
#include <thread>
#include <mutex>
#include <condition_variable>
#include <random>
#include <chrono>

const int NUM_STOPS = 5;
const int NUM_BUSES = 3;
const int MAX_PARK = 3;
const int MAX_DRIVE = 5;

std::random_device rd;
std::mt19937 gen(rd());

class Bus {
private:
    int id;
    int current_stop;
    bool running;
public:
    Bus(int id) : id(id), current_stop(0), running(true) {}

    int get_id() const { return id; }
    int get_current_stop() const { return current_stop; }
    bool is_running() const { return running; }

    void set_current_stop(int stop) { current_stop = stop; }
    void stop_running() { running = false; }

    void drive();
};

class Stop {
private:
    int id;
    std::mutex mtx;
    std::condition_variable cv;
    int parked;
public:
    Stop(int id) : id(id), parked(0) {}

    int get_id() const { return id; }
    int get_parked() const { return parked; }

    void park_bus();
    void leave_bus();
};

std::vector<Stop> stops;

void init_stops() {
    for (int i = 0; i < NUM_STOPS; i++) {
        stops.push_back(Stop(i));
    }
}

void Stop::park_bus() {
    std::unique_lock<std::mutex> lock(mtx);
    while (parked >= MAX_PARK) {
        cv.wait(lock);
    }
    parked++;
}

void Stop::leave_bus() {
    std::lock_guard<std::mutex> lock(mtx);
    parked--;
    cv.notify_one();
}

void Bus::drive() {
    std::uniform_int_distribution<> dis(1, MAX_DRIVE);
    while (running) {
        int next_stop = (current_stop + 1) % NUM_STOPS;
        int drive_time = dis(gen);
        std::cout << "Bus " << id << " is driving from stop " << current_stop << " to stop " << next_stop << " for " << drive_time << " seconds\n";
        std::this_thread::sleep_for(std::chrono::seconds(drive_time));
        stops[next_stop].park_bus();
        std::cout << "Bus " << id << " has arrived at stop " << next_stop << "\n";
        current_stop = next_stop;
        std::this_thread::sleep_for(std::chrono::seconds(1));
        stops[current_stop].leave_bus();
        std::cout << "Bus " << id << " has left stop " << current_stop << "\n";
    }
}

void run_bus(Bus& bus) {
    std::thread t(&Bus::drive, &bus);
    t.detach();
}

int main() {
    
    return 0;
}
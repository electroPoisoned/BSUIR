#include <iostream>
#include <thread>
#include <vector>
#include <mutex>
#include <condition_variable>
#include <random>

class Bus {
private:
    int busNumber;
    int stopNumber;
    std::mutex& mtx;
    std::condition_variable& cv;
    int& places;

public:
    Bus(int busNumber, int stopNumber, std::mutex& mtx, std::condition_variable& cv, int& places)
        : busNumber(busNumber), stopNumber(stopNumber+1), mtx(mtx), cv(cv), places(places) {}

    void operator()() {
        for (int i = 0; i < 3; i++) {
            std::unique_lock<std::mutex> lock(mtx);
            cv.wait(lock, [this] { return places > 0; });
            --places;
            std::cout << "\nBus " << busNumber << " stopped at stop " << stopNumber << std::endl;
            lock.unlock();
            std::this_thread::sleep_for(std::chrono::seconds(2));
            lock.lock();
            std::cout << "\nBus " << busNumber << " left stop " << stopNumber << std::endl;
            ++places;
            cv.notify_one();
        }
    }
};

int main() {
    const int NUM_STOPS = 3;
    const int NUM_BUSES = 6;
    const int NUM_PLACES = 2;

    std::vector<std::thread> threads;
    std::vector<int> places(NUM_STOPS, NUM_PLACES);
    std::vector<std::mutex> mtxs(NUM_STOPS);
    std::vector<std::condition_variable> cvs(NUM_STOPS);

    std::random_device rd;
    std::mt19937 gen(rd());
    std::uniform_int_distribution<> dis(0, NUM_STOPS - 1);

    for (int i = 0; i < NUM_BUSES; ++i) {
        int stop = dis(gen);
        threads.emplace_back(Bus(i + 1, stop, mtxs[stop], cvs[stop], places[stop]));
    }

    for (auto& t : threads) {
        t.join();
    }

    return 0;
}

#include <iostream>
#include <thread>
#include <vector>
#include <mutex>
#include <condition_variable>

class BusStop {
public:
    BusStop(int max_buses) : max_buses(max_buses), current_buses(0) {}

    bool try_enter() {
        std::unique_lock<std::mutex> lock(mtx);
        if (current_buses < max_buses) {
            ++current_buses;
            return true;
        }
        return false;
    }

    void leave() {
        std::unique_lock<std::mutex> lock(mtx);
        --current_buses;
        cv.notify_all();
    }

private:
    std::mutex mtx;
    std::condition_variable cv;
    int max_buses;
    int current_buses;
};

void bus_thread(std::vector<BusStop>& stops, int bus_id) {
    while (true) {
        for (auto& stop : stops) {
            if (stop.try_enter()) {
                std::cout << "Автобус " << bus_id + 1 << " остановился на остановке " << &stop - &stops[0] + 1 << ".\n";
                std::this_thread::sleep_for(std::chrono::seconds(2));
                stop.leave();
                std::cout << "Автобус " << bus_id + 1 << " покинул остановку " << &stop - &stops[0] + 1 << ".\n";
            }
            else {
                std::this_thread::sleep_for(std::chrono::seconds(1));
            }
        }
    }
}

int main() {
    const int num_buses = 3;
    const int max_buses_at_stop = 2;
    const int num_stops = 6;

    std::vector<BusStop> stops(num_stops, BusStop(max_buses_at_stop));
    std::vector<std::thread> buses;

    for (int i = 0; i < num_buses; ++i) {
        buses.push_back(std::thread(bus_thread, std::ref(stops), i + 1));
    }

    for (auto& bus : buses) {
        bus.detach();
    }

    return 0;
}
#include <iostream>
#include <vector>
#include <thread>
#include <mutex>
#include <condition_variable>

class Bus {
private:
    int busNumber;
    std::vector<std::mutex>& locks;

public:
    Bus(int busNumber, std::vector<std::mutex>& locks) : busNumber(busNumber), locks(locks) {}

    void operator()() {
        for (int i = 0; i < locks.size(); ++i) {
            locks[i].lock();
            std::cout << "Bus " << busNumber << " stopped at stop " << (i + 1) << std::endl;
            std::this_thread::sleep_for(std::chrono::seconds(2));
            std::cout << "Bus " << busNumber << " left stop " << (i + 1) << std::endl;
            locks[i].unlock();
        }
    }
};

int main() {
    const int NUM_STOPS = 6;
    const int NUM_BUSES = 3;

    std::vector<std::mutex> locks(NUM_STOPS);
    std::vector<std::thread> threads(NUM_BUSES);

    for (int i = 0; i < NUM_BUSES; ++i) {
        threads[i] = std::thread(Bus(i + 1, locks));
    }

    for (auto& thread : threads) {
        thread.join();
    }

    return 0;
}

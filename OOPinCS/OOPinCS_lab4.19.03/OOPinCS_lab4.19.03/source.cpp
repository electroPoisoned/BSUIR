#include <iostream>
#include <thread>
#include <vector>
#include <mutex>
#include <semaphore>
#include <condition_variable>

class Bus {
public:
    Bus(int busNumber, std::vector<std::mutex>& semaphores)
        : busNumber(busNumber), semaphores(semaphores) {}

    void operator()() {
        try {
            while (true) {
                for (size_t i = 0; i < semaphores.size(); ++i) {
                    semaphores[i].lock();
                    std::cout << "\nBus " << busNumber << " stopped at stop " << (i + 1) << std::endl;
                    
                    std::this_thread::sleep_for(std::chrono::milliseconds(1500));
                    semaphores[i].unlock();
                    std::cout << "\nBus " << busNumber << " left stop " << (i + 1) << std::endl;
                    
                }
            }
        }
        catch (const std::exception& e) {
            std::cerr << "Exception: " << e.what() << std::endl;
        }
    }

private:
    int busNumber;
    std::vector<std::mutex>& semaphores;
};

int main() {
    const int NUM_STOPS = 3;
    const int NUM_BUSES = 3;
    const int NUM_PLACES = 2;

    std::vector<std::mutex> semaphores(NUM_STOPS);

    std::vector<std::thread> threads;
    for (int i = 0; i < NUM_BUSES; ++i) {
        Bus bus(i + 1, semaphores);
        threads.emplace_back(bus);
    }

    for (auto& thread : threads) {
        thread.join();
    }

    return 0;
}
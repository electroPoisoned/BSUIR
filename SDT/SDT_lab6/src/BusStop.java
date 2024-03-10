import java.util.concurrent.Semaphore;

public class BusStop {
    private static final int NUM_STOPS = 6;
    private static final int NUM_BUSES = 3;
    private static final int NUM_PLACES = 2;

    public static void main(String[] args) {
        Semaphore[] semaphores = new Semaphore[NUM_STOPS];
        for (int i = 0; i < NUM_STOPS; i++) {
            semaphores[i] = new Semaphore(NUM_PLACES);
        }

        Thread[] threads = new Thread[NUM_BUSES];

        for (int i = 0; i < NUM_BUSES; i++) {
            Bus bus = new Bus(i + 1, semaphores);
            threads[i] = new Thread(bus);
            threads[i].start();
        }

        while (true) {
            for (int i = 0; i < NUM_BUSES; i++) {
                try {
                    threads[i].join();
                    Bus bus = new Bus(i + 1, semaphores);
                    threads[i] = new Thread(bus);
                    threads[i].start();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

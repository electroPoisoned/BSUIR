import java.util.concurrent.Semaphore;

class Bus implements Runnable {

    private int busNumber;
    private Semaphore[] semaphores;

    public Bus(int busNumber, Semaphore[] semaphores) {
        this.busNumber = busNumber;
        this.semaphores = semaphores;
    }

    public void run() {
        try {
            for (int i = 0; i < semaphores.length; i++) {
                semaphores[i].acquire();
                System.out.println("Bus " + busNumber + " stopped at stop " + (i + 1));
                Thread.sleep(2000);
                System.out.println("Bus " + busNumber + " left stop " + (i + 1));
                semaphores[i].release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
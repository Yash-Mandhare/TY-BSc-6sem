// Write a java program for the implementation of synchronization.
class Counter {
    private int count = 0;

    // Method to increment count synchronously
    public synchronized void increment() {
        count++;
    }

    // Method to decrement count synchronously
    public synchronized void decrement() {
        count--;
    }

    // Method to get the count value
    public synchronized int getCount() {
        return count;
    }
}

class IncrementThread extends Thread {
    private Counter counter;

    public IncrementThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increment();
        }
    }
}

class DecrementThread extends Thread {
    private Counter counter;

    public DecrementThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.decrement();
        }
    }
}

public class slip30SynchronizationExample {
    public static void main(String[] args) throws InterruptedException {
        // Create a Counter object
        Counter counter = new Counter();

        // Create multiple threads for incrementing and decrementing
        IncrementThread incrementThread1 = new IncrementThread(counter);
        IncrementThread incrementThread2 = new IncrementThread(counter);
        DecrementThread decrementThread1 = new DecrementThread(counter);
        DecrementThread decrementThread2 = new DecrementThread(counter);

        // Start the threads
        incrementThread1.start();
        incrementThread2.start();
        decrementThread1.start();
        decrementThread2.start();

        // Wait for all threads to finish
        incrementThread1.join();
        incrementThread2.join();
        decrementThread1.join();
        decrementThread2.join();

        // Display the final count value
        System.out.println("Final count: " + counter.getCount());
    }
}

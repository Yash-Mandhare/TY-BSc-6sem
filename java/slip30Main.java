// Write a java program for the implementation of synchronization.
class Counter {
    private int count = 0;

    // Synchronized method
    public synchronized void increment() {
        count++;
        System.out.println("Incremented count to: " + count);
    }

    // Non-synchronized method
    public void decrement() {
        synchronized(this) {
            count--;
            System.out.println("Decremented count to: " + count);
        }
    }
}

class MyThread extends Thread {
    Counter counter;

    public MyThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            counter.increment();
            counter.decrement();
        }
    }
}

public class slip30Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        MyThread thread1 = new MyThread(counter);
        MyThread thread2 = new MyThread(counter);

        thread1.start();
        thread2.start();
    }
}

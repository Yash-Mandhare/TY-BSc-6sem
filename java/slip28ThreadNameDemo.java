// Write a java program to display name of currently executing Thread in multithreading.


public class slip28ThreadNameDemo {
    public static void main(String[] args) {
        // Creating threads
        Thread thread1 = new Thread(new MyRunnable(), "Thread 1");
        Thread thread2 = new Thread(new MyRunnable(), "Thread 2");

        // Start threads
        thread1.start();
        thread2.start();
    }

    static class MyRunnable implements Runnable {
        public void run() {
            // Get the name of the currently executing thread
            String threadName = Thread.currentThread().getName();
            System.out.println("Currently executing thread: " + threadName);
        }
    }
}

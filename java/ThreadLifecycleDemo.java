// Write a Java program to show lifecycle (creation, sleep, and dead) of a thread. Program should print randomly the name of thread and value of sleep time. The name of the thread should be hard coded through constructor. The sleep time of a thread will be a random integer in the range 0 to 4999.

import java.util.Random;

public class ThreadLifecycleDemo {
    public static void main(String[] args) {
        // Create and start a thread
        MyThread thread = new MyThread("MyThread");
        thread.start();
    }
}

class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        Random rand = new Random();
        int sleepTime = rand.nextInt(5000); // Generate random sleep time between 0 to 4999 milliseconds
        try {
            // Print the name of the thread and the sleep time
            System.out.println("Thread Name: " + getName());
            System.out.println("Sleep Time: " + sleepTime + " milliseconds");

            // Put the thread to sleep for the generated sleep time
            Thread.sleep(sleepTime);

            // Print the thread is dead
            System.out.println("Thread " + getName() + " is dead.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

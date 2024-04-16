// Write a java program to display name and priority of a Thread.


public class slip18ThreadInfoExample {
    public static void main(String[] args) {
        // Create a new thread
        Thread thread = new Thread(() -> {
            // Task of the thread
            System.out.println("Thread name: " + Thread.currentThread().getName());
            System.out.println("Thread priority: " + Thread.currentThread().getPriority());
        });

        // Set name and priority of the thread
        thread.setName("MyThread");
        thread.setPriority(Thread.MAX_PRIORITY); // Set maximum priority for demonstration

        // Start the thread
        thread.start();
    }
}

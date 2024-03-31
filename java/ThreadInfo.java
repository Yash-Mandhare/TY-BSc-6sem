// Write a java program to display name and priority of a Thread.
public class ThreadInfo {
    public static void main(String[] args) {
        // Create a thread object
        Thread thread = Thread.currentThread();

        // Display the name and priority of the thread
        System.out.println("Thread Name: " + thread.getName());
        System.out.println("Thread Priority: " + thread.getPriority());
    }
}

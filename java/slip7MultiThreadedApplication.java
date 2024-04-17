// Write a java program that implements a multi-thread application that has three threads. First thread generates random integer number after every one second, if the number is even; second thread computes the square of that number and print it. If the number is odd, the third thread computes the of cube of that number and print it.

import java.util.Random;

public class slip7RandomNumberCalculator {
    public static void main(String[] args) {
        NumberGenerator generator = new NumberGenerator();
        NumberProcessor squareProcessor = new NumberProcessor("Square");
        NumberProcessor cubeProcessor = new NumberProcessor("Cube");

        generator.start();
        squareProcessor.start();
        cubeProcessor.start();
    }
}

class NumberGenerator extends Thread {
    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            int randomNumber = random.nextInt(100); // Generate a random number between 0 and 99
            System.out.println("Generated number: " + randomNumber);
            NumberProcessor.process(randomNumber);
            try {
                Thread.sleep(1000); // Sleep for one second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class NumberProcessor extends Thread {
    private static final Object lock = new Object(); // Lock for synchronization
    private static int number;
    private String type;

    public NumberProcessor(String type) {
        this.type = type;
    }

    public static void process(int num) {
        synchronized (lock) {
            number = num;
            lock.notifyAll(); // Notify all waiting threads
        }
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                try {
                    lock.wait(); // Wait for a number to process
                    if (type.equals("Square") && number % 2 == 0) {
                        System.out.println("Square of " + number + ": " + (number * number));
                    } else if (type.equals("Cube") && number % 2 != 0) {
                        System.out.println("Cube of " + number + ": " + (number * number * number));
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

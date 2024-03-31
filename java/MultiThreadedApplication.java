// Write a java program that implements a multi-thread application that has three threads. First thread generates random integer number after every one second, if the number is even; second thread computes the square of that number and print it. If the number is odd, the third thread computes the of cube of that number and print it.

import java.util.Random;

public class MultiThreadedApplication {
    public static void main(String[] args) {
        RandomNumberGeneratorThread generatorThread = new RandomNumberGeneratorThread();
        SquareCalculatorThread squareThread = new SquareCalculatorThread();
        CubeCalculatorThread cubeThread = new CubeCalculatorThread();

        generatorThread.start();
        squareThread.start();
        cubeThread.start();
    }
}

class RandomNumberGeneratorThread extends Thread {
    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            int randomNumber = random.nextInt(100); // Generate a random number between 0 and 99
            System.out.println("Generated number: " + randomNumber);
            if (randomNumber % 2 == 0) {
                SquareCalculatorThread.setNumber(randomNumber);
            } else {
                CubeCalculatorThread.setNumber(randomNumber);
            }
            try {
                Thread.sleep(1000); // Sleep for one second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SquareCalculatorThread extends Thread {
    private static int number;

    public static synchronized void setNumber(int number) {
        SquareCalculatorThread.number = number;
    }

    @Override
    public void run() {
        while (true) {
            if (number % 2 == 0) {
                System.out.println("Square of " + number + ": " + (number * number));
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class CubeCalculatorThread extends Thread {
    private static int number;

    public static synchronized void setNumber(int number) {
        CubeCalculatorThread.number = number;
    }

    @Override
    public void run() {
        while (true) {
            if (number % 2 != 0) {
                System.out.println("Cube of " + number + ": " + (number * number * number));
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

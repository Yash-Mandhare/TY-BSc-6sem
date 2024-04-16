// Write a java program to solve producer consumer problem in which a producer produces a value and consumer consume the value before producer generate the next value. (Hint: use thread synchronization)



import java.util.LinkedList;
import java.util.Queue;

class ProducerConsumer {
    private static final int MAX_CAPACITY = 5;
    private final Queue<Integer> buffer = new LinkedList<>();

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (this) {
                while (buffer.size() == MAX_CAPACITY) {
                    wait();
                }

                System.out.println("Producer produced: " + value);
                buffer.offer(value++);
                notify();

                Thread.sleep(1000); // Simulate some processing time
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (buffer.isEmpty()) {
                    wait();
                }

                int consumedValue = buffer.poll();
                System.out.println("Consumer consumed: " + consumedValue);
                notify();

                Thread.sleep(1000); // Simulate some processing time
            }
        }
    }
}

public class slip21Main {
    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();

        Thread producerThread = new Thread(() -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}

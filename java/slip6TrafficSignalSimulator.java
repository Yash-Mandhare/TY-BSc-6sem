//Write a java program to simulate traffic signal using threads.
import java.util.concurrent.TimeUnit;

public class slip6TrafficSignalSimulator {
    public static void main(String[] args) {
        TrafficSignal trafficSignal = new TrafficSignal();

        Thread signalThread = new Thread(trafficSignal);
        signalThread.start();
    }
}

class TrafficSignal implements Runnable {
    private SignalState currentState;

    public TrafficSignal() {
        currentState = SignalState.RED; // Start with red signal
    }

    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("Signal is: " + currentState);
                TimeUnit.SECONDS.sleep(currentState.getDuration());

                // Change signal state
                switch (currentState) {
                    case RED:
                        currentState = SignalState.GREEN;
                        break;
                    case GREEN:
                        currentState = SignalState.YELLOW;
                        break;
                    case YELLOW:
                        currentState = SignalState.RED;
                        break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

enum SignalState {
    RED(5), GREEN(5), YELLOW(2);

    private final int duration; // Duration in seconds

    SignalState(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }
}

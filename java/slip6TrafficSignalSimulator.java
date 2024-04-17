//Write a java program to simulate traffic signal using threads.
public class slip6TrafficSignalSimulator {
    public static void main(String[] args) {
        TrafficSignal trafficSignal = new TrafficSignal();
        trafficSignal.simulate();
    }
}

class TrafficSignal {
    private SignalState currentState;

    public TrafficSignal() {
        currentState = SignalState.RED; // Start with red signal
    }

    public void simulate() {
        try {
            while (true) {
                System.out.println("Signal is: " + currentState);
                Thread.sleep(currentState.getDuration() * 1000); // Convert duration to milliseconds

                // Change signal state
                currentState = currentState.nextState();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

enum SignalState {
    RED(1), GREEN(1), YELLOW(1);

    private final int duration; // Duration in seconds

    SignalState(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public SignalState nextState() {
        switch (this) {
            case RED:
                return GREEN;
            case GREEN:
                return YELLOW;
            default:
                return RED;
        }
    }
}

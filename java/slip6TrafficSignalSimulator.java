//Write a java program to simulate traffic signal using threads.
public class slip6TrafficSignalSimulator {
    public static void main(String[] args){
        Traffic traffic= new Traffic();
        traffic.simulate();
    }
}

class Traffic{
    private Signalstate current;

    public Traffic(){
        current =Signalstate.RED;
    }
    public void simulate(){
        try{
            while(true){
                System.out.println("Signal is: " + current);
                Thread.sleep(1000);

                current = current.nextState();
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

enum Signalstate{
    RED,GREEN,YELLOW;

    public Signalstate nextState() {
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
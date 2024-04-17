// Write a java program to define a thread for printing text on output screen for ‘n’ number of times. Create 3 threads and run them. Pass the text ‘n’ parameters to the thread constructor.
// Example:
// i. First thread prints “COVID19” 10 times.
// ii. Second thread prints “LOCKDOWN2020” 20 times
// iii. Third thread prints “VACCINATED2021” 30 times


public class slip8TextPrinterThread extends Thread {
    private String text;
    private int times;

    public slip8TextPrinterThread(String text, int times) {
        this.text = text;
        this.times = times;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.println(text);
        }
    }

    public static void main(String[] args) {
        slip8TextPrinterThread thread1 = new slip8TextPrinterThread("COVID19", 10);
        slip8TextPrinterThread thread2 = new slip8TextPrinterThread("LOCKDOWN2020", 20);
        slip8TextPrinterThread thread3 = new slip8TextPrinterThread("VACCINATED2021", 30);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

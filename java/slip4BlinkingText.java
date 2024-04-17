// Write a Java program using Runnable interface to blink Text on the frame.
import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class slip4BlinkingText implements Runnable {
    private JLabel label;

    public slip4BlinkingText(JLabel label) {
        this.label = label;
    }

    @Override
    public void run() {
        try {
            while (true) {
                label.setVisible(false);
                TimeUnit.MILLISECONDS.sleep(500); // Hide the text for 500 milliseconds
                label.setVisible(true);
                TimeUnit.MILLISECONDS.sleep(500); // Show the text for 500 milliseconds
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Blinking Text");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 200);
            frame.setLayout(new FlowLayout());

            JLabel label = new JLabel("Blinking Text");
            frame.add(label);

            slip4BlinkingText blinkingText = new slip4BlinkingText(label);
            Thread thread = new Thread(blinkingText);
            thread.start();

            frame.setVisible(true);
        });
    }
}

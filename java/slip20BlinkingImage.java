// Write a java program to blink image on the JFrame continuously.

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.*;

public class BlinkingImage implements Runnable {
    private JLabel label;

    public BlinkingImage(JLabel label) {
        this.label = label;
    }

    @Override
    public void run() {
        try {
            while (true) {
                label.setVisible(false);
                TimeUnit.MILLISECONDS.sleep(500); // Hide the image for 500 milliseconds
                label.setVisible(true);
                TimeUnit.MILLISECONDS.sleep(500); // Show the image for 500 milliseconds
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Blinking Image");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(300, 200);
            frame.setLayout(new FlowLayout());

            // Load the image from file
            ImageIcon imageIcon = new ImageIcon("image.jpg"); // Provide the path to your image file
            JLabel imageLabel = new JLabel(imageIcon);

            frame.add(imageLabel);

            BlinkingImage blinkingImage = new BlinkingImage(imageLabel);
            Thread thread = new Thread(blinkingImage);
            thread.start();

            frame.setVisible(true);
        });
    }
}

// Write a java program to blink image on the JFrame continuously.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class slip20BlinkingImage extends JFrame {
    private JLabel imageLabel;
    private Timer timer;
    private boolean isVisible;

    public slip20BlinkingImage() {
        setTitle("Blinking Image");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setResizable(false);
        
        // Load an image
        ImageIcon imageIcon = new ImageIcon("image.jpg"); // Replace "image.jpg" with the path to your image file
        imageLabel = new JLabel(imageIcon);
        add(imageLabel, BorderLayout.CENTER);

        // Create a timer to toggle visibility of the image label
        timer = new Timer(500, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                isVisible = !isVisible;
                imageLabel.setVisible(isVisible);
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new slip20BlinkingImage().setVisible(true);
            }
        });
    }
}

// Write a Multithreading program in java to display the number’s between 1 to 100 continuously in a TextField by clicking on button. (Use Runnable Interface).


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class slip17NumberDisplayApp extends JFrame {
    private JTextField textField;
    private JButton startButton;
    private Thread numberThread;

    public slip17NumberDisplayApp() {
        setTitle("Number Display");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textField = new JTextField(20);
        textField.setEditable(false);

        startButton = new JButton("Start Display");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (numberThread == null || !numberThread.isAlive()) {
                    // Create a new thread for displaying numbers
                    numberThread = new Thread(new NumberDisplay());
                    numberThread.start();
                }
            }
        });

        JPanel panel = new JPanel();
        panel.add(textField);
        panel.add(startButton);

        add(panel);
    }

    // Runnable interface implementation to display numbers
    private class NumberDisplay implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 100; i++) {
                final int number = i; // Declare a final variable to hold the value of i
                try {
                    // Update the TextField with the current number
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            textField.setText(Integer.toString(number));
                        }
                    });
                    // Pause for a short duration before displaying the next number
                    Thread.sleep(500); // Adjust the delay as needed
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new slip17NumberDisplayApp().setVisible(true);
            }
        });
    }
}

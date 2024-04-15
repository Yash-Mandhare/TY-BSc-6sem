// Write a Multithreading program in java to display the number’s between 1 to 100 continuously in a TextField by clicking on button. (Use Runnable Interface).


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class slip17NumberDisplayGUI extends JFrame {
    private JTextField textField;
    private JButton startButton;
    private JButton stopButton;
    private boolean running;

    public slip17NumberDisplayGUI() {
        setTitle("Number Display");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textField = new JTextField(20);
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        stopButton.setEnabled(false);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButton.setEnabled(false);
                stopButton.setEnabled(true);
                running = true;
                new Thread(new NumberDisplayTask()).start();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButton.setEnabled(true);
                stopButton.setEnabled(false);
                running = false;
            }
        });

        JPanel panel = new JPanel();
        panel.add(textField);
        panel.add(startButton);
        panel.add(stopButton);
        add(panel);

        setVisible(true);
    }

    class NumberDisplayTask implements Runnable {
        @Override
        public void run() {
            int number = 1;
            while (running && number <= 100) {
                final int currentNumber = number; // Make a copy of number
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        textField.setText(String.valueOf(currentNumber)); // Use the copy
                    }
                });
    
                try {
                    Thread.sleep(1000); // Delay for 1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
    
                number++;
    
                if (number > 100) {
                    // Reset number to 1 if it reaches 100
                    number = 1;
                }
            }
        }
    }
    
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new slip17NumberDisplayGUI();
            }
        });
    }
}

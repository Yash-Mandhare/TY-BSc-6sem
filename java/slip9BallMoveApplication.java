// Write a Java program to create a thread for moving a ball inside a panel vertically. The ball should be created when the user clicks on the start button.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class slip9BallMoveApplication extends JFrame {
    private BallPanel ballPanel;
    private JButton startButton;
    private boolean ballMoving;

    public slip9BallMoveApplication() {
        setTitle("Ball Move Application");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ballMoving = false;

        ballPanel = new BallPanel();

        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!ballMoving) {
                    ballPanel.moveBall();
                    ballMoving = true;
                }
            }
        });

        setLayout(new BorderLayout());
        add(ballPanel, BorderLayout.CENTER);
        add(startButton, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            slip9BallMoveApplication app = new slip9BallMoveApplication();
            app.setVisible(true);
        });
    }
}

class BallPanel extends JPanel {
    private int ballY = 0; // Initial Y position of the ball

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(150, ballY, 50, 50); // Draw the ball
    }

    public void moveBall() {
        new Thread(() -> {
            try {
                while (ballY < getHeight() - 50) {
                    ballY += 5; // Increment Y position
                    repaint(); // Redraw the panel
                    Thread.sleep(50); // Delay for smooth animation
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

//Write a Java program to display first record from student table (RNo, SName, Per) onto the TextFields by clicking on button. (Assume Student table is already created).

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DisplayFirstRecord extends JFrame {
    private JTextField rnoTextField;
    private JTextField snameTextField;
    private JTextField perTextField;
    private JButton displayButton;

    public DisplayFirstRecord() {
        setTitle("Display First Record");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        rnoTextField = new JTextField(10);
        snameTextField = new JTextField(10);
        perTextField = new JTextField(10);

        displayButton = new JButton("Display First Record");
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayFirstRecord();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        panel.add(new JLabel("RNo:"));
        panel.add(rnoTextField);
        panel.add(new JLabel("SName:"));
        panel.add(snameTextField);
        panel.add(new JLabel("Per:"));
        panel.add(perTextField);
        panel.add(displayButton);

        add(panel);
    }

    private void displayFirstRecord() {
        String url = "jdbc:mysql://localhost:3306/mydatabase"; // Change to your database URL
        String username = "yourusername"; // Change to your database username
        String password = "yourpassword"; // Change to your database password

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Student LIMIT 1");
            if (rs.next()) {
                rnoTextField.setText(rs.getString("RNo"));
                snameTextField.setText(rs.getString("SName"));
                perTextField.setText(rs.getString("Per"));
            } else {
                JOptionPane.showMessageDialog(this, "No records found in the Student table.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DisplayFirstRecord frame = new DisplayFirstRecord();
            frame.setVisible(true);
        });
    }
}

// Write a Java program to accept the details of Employee (Eno, EName, Designation, Salary) from a user and store it into the database. (Use Swing)
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class EmployeeDetailsForm extends JFrame implements ActionListener {
    private JLabel enoLabel, enameLabel, designationLabel, salaryLabel;
    private JTextField enoField, enameField, designationField, salaryField;
    private JButton submitButton;

    public EmployeeDetailsForm() {
        setTitle("Employee Details Form");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));
        
        enoLabel = new JLabel("Employee Number:");
        enameLabel = new JLabel("Employee Name:");
        designationLabel = new JLabel("Designation:");
        salaryLabel = new JLabel("Salary:");
        
        enoField = new JTextField();
        enameField = new JTextField();
        designationField = new JTextField();
        salaryField = new JTextField();
        
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        
        add(enoLabel);
        add(enoField);
        add(enameLabel);
        add(enameField);
        add(designationLabel);
        add(designationField);
        add(salaryLabel);
        add(salaryField);
        add(new JLabel());
        add(submitButton);
        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String eno = enoField.getText();
            String ename = enameField.getText();
            String designation = designationField.getText();
            String salary = salaryField.getText();

            try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database_name", "username", "password");

                String query = "INSERT INTO employees (eno, ename, designation, salary) VALUES (?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, eno);
                pstmt.setString(2, ename);
                pstmt.setString(3, designation);
                pstmt.setString(4, salary);
                pstmt.executeUpdate();

                JOptionPane.showMessageDialog(this, "Employee details added successfully.");

                pstmt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new EmployeeDetailsForm();
    }
}

// Write a Java Program to display the details of College (CID, CName, address, Year) on JTable.


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class slip27CollegeDetails extends JFrame {
    private JTable collegeTable;
    private JScrollPane scrollPane;

    public slip27CollegeDetails() {
        setTitle("College Details");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Sample data of colleges
        Object[][] data = {
                {101, "ABC College", "123 Main St", 2000},
                {102, "XYZ College", "456 Elm St", 1995},
                {103, "PQR College", "789 Oak St", 2005}
        };

        // Column names
        String[] columnNames = {"CID", "CName", "Address", "Year"};

        // Create a table model with sample data and column names
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        // Create JTable with the table model
        collegeTable = new JTable(model);

        // Set preferred column widths
        collegeTable.getColumnModel().getColumn(0).setPreferredWidth(50); // CID
        collegeTable.getColumnModel().getColumn(1).setPreferredWidth(150); // CName
        collegeTable.getColumnModel().getColumn(2).setPreferredWidth(200); // Address
        collegeTable.getColumnModel().getColumn(3).setPreferredWidth(80); // Year

        // Add JTable to a scroll pane
        scrollPane = new JScrollPane(collegeTable);

        // Add scroll pane to the frame
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            slip27CollegeDetails collegeDetails = new slip27CollegeDetails();
            collegeDetails.setVisible(true);
        });
    }
}

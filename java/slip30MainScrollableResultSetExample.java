// Write a Java Program for the implementation of scrollable ResultSet. Assume Teacher table with attributes (TID, TName, Salary) is already created.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class slip30MainScrollableResultSetExample {

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/your_database_name";
        String user = "your_username";
        String password = "your_password";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {

            // Query to retrieve data from Teacher table
            String query = "SELECT * FROM Teacher";
            ResultSet resultSet = statement.executeQuery(query);

            // Move cursor to the last row
            resultSet.last();

            // Get the total number of rows
            int rowCount = resultSet.getRow();

            System.out.println("Total rows: " + rowCount);

            // Move cursor to the first row
            resultSet.beforeFirst();

            // Print data
            System.out.println("TeacherID\tTeacherName\tSalary");
            while (resultSet.next()) {
                int teacherID = resultSet.getInt("TID");
                String teacherName = resultSet.getString("TName");
                double salary = resultSet.getDouble("Salary");

                System.out.println(teacherID + "\t\t" + teacherName + "\t\t" + salary);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

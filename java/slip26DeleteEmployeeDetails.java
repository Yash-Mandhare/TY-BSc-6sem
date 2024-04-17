// Write a Java program to delete the details of given employee (ENo EName Salary). Accept employee ID through command line. (Use PreparedStatement Interface)

import java.sql.*;

public class slip26DeleteEmployeeDetails {
    // JDBC URL, username, and password of the database
    static final String JDBC_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USERNAME = "postgres";
    static final String PASSWORD = "6512";

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java DeleteEmployeeDetails <employeeID>");
            return;
        }

        int employeeID = Integer.parseInt(args[0]);

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Establishing a connection to the database
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // Creating SQL query to delete employee details
            String sql = "DELETE FROM Employee WHERE ENo = ?";

            // Creating PreparedStatement object
            preparedStatement = connection.prepareStatement(sql);

            // Setting the parameters
            preparedStatement.setInt(1, employeeID);

            // Executing the query
            int rowsAffected = preparedStatement.executeUpdate();

            // Checking if any row is affected
            if (rowsAffected > 0) {
                System.out.println("Employee details deleted successfully.");
            } else {
                System.out.println("Employee with ID " + employeeID + " not found.");
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            // Closing resources
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}

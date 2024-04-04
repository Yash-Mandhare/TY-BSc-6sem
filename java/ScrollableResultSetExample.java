// Write a Java Program for the implementation of scrollable ResultSet. Assume Teacher table with attributes (TID, TName, Salary) is already created.


import java.sql.*;

public class ScrollableResultSetExample {
    // JDBC URL, username, and password of the database
    static final String JDBC_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USERNAME = "postgres";
    static final String PASSWORD = "6512";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Establishing a connection to the database
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // Creating a PreparedStatement with scrollable ResultSet
            preparedStatement = connection.prepareStatement("SELECT * FROM Teacher", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            // Executing the prepared statement
            resultSet = preparedStatement.executeQuery();

            // Move the cursor to the last row
            resultSet.last();

            // Display the last record
            System.out.println("Last Record:");
            displayRecord(resultSet);

            // Move the cursor to the first row
            resultSet.first();

            // Display the first record
            System.out.println("\nFirst Record:");
            displayRecord(resultSet);

            // Move the cursor to the 3rd row
            resultSet.absolute(3);

            // Display the 3rd record
            System.out.println("\nRecord at 3rd position:");
            displayRecord(resultSet);

            // Move the cursor to the 2nd row from the end
            resultSet.absolute(-2);

            // Display the record at 2nd position from the end
            System.out.println("\nRecord at 2nd position from the end:");
            displayRecord(resultSet);

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            // Closing resources
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    // Method to display a record from the ResultSet
    private static void displayRecord(ResultSet resultSet) throws SQLException {
        int tid = resultSet.getInt("TID");
        String tname = resultSet.getString("TName");
        double salary = resultSet.getDouble("Salary");
        System.out.println("TID: " + tid + ", TName: " + tname + ", Salary: " + salary);
    }
}

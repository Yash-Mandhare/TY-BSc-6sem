// Write a Java program to display information about all columns in the DONAR table using ResultSetMetaData.
import java.sql.*;

public class DisplayTableColumns {
    // JDBC URL, username, and password
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydatabase"; // Change to your database URL
    static final String USERNAME = "yourusername"; // Change to your database username
    static final String PASSWORD = "yourpassword"; // Change to your database password

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            // Create a Statement
            Statement stmt = conn.createStatement();

            // Execute a query to retrieve all columns from the DONAR table
            ResultSet rs = stmt.executeQuery("SELECT * FROM DONAR");

            // Get the metadata of the ResultSet
            ResultSetMetaData rsMetaData = rs.getMetaData();

            // Print information about each column
            int columnCount = rsMetaData.getColumnCount();
            System.out.println("Information about columns in the DONAR table:");
            for (int i = 1; i <= columnCount; i++) {
                String columnName = rsMetaData.getColumnName(i);
                String columnType = rsMetaData.getColumnTypeName(i);
                int columnSize = rsMetaData.getColumnDisplaySize(i);
                System.out.println("Column Name: " + columnName);
                System.out.println("Column Type: " + columnType);
                System.out.println("Column Size: " + columnSize);
                System.out.println("---------------------------------------------");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

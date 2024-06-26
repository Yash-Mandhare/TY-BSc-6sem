// Write a Java program to display information about all columns in the DONAR table using ResultSetMetaData.
import java.sql.*;

public class slip11DisplayTableColumns {
    // JDBC URL, username, and password
    static final String JDBC_URL = "jdbc:postgresql://localhost:5432/postgres"; // Change to your PostgreSQL database URL
    static final String USERNAME = "postgres"; // Change to your database username
    static final String PASSWORD = "6512"; // Change to your database password

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

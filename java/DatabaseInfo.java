// Write a Java program to display information about the database and list all the tables in the database. (Use DatabaseMetaData).

import java.sql.*;

public class DatabaseInfo {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "yourusername", "yourpassword")) {
            DatabaseMetaData metaData = conn.getMetaData();

            // Display database information
            System.out.println("Database Product Name: " + metaData.getDatabaseProductName());
            System.out.println("Database Product Version: " + metaData.getDatabaseProductVersion());
            System.out.println("Database Username: " + metaData.getUserName());

            // List all tables in the database
            ResultSet tablesResultSet = metaData.getTables(null, null, null, new String[]{"TABLE"});
            System.out.println("Tables in the database:");
            while (tablesResultSet.next()) {
                String tableName = tablesResultSet.getString("TABLE_NAME");
                System.out.println(tableName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

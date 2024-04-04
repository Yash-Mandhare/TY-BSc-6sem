// Write a Java program to display information about all columns in the DONAR table using ResultSetMetaData.


import java.sql.*;

public class slip29ColumnInfo {
    // JDBC URL, username, and password of the database
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/your_database_name";
    static final String USERNAME = "your_username";
    static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Establishing a connection to the database
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // Creating and executing SQL query
            String sql = "SELECT * FROM DONAR";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            // Retrieving metadata
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Displaying column information
            System.out.println("Column Information:");
            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                String columnType = metaData.getColumnTypeName(i);
                int columnSize = metaData.getColumnDisplaySize(i);
                System.out.println("Column " + i + ":");
                System.out.println("  Name: " + columnName);
                System.out.println("  Type: " + columnType);
                System.out.println("  Size: " + columnSize);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            // Closing resources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}

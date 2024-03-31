// Write a java program for the following:
// i. To create a Product(Pid, Pname, Price) table.
// ii. Insert at least five records into the table.
// iii. Display all the records from a table.
import java.sql.*;

public class ProductManagement {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/mydatabase"; // Change 'mydatabase' to your database name

    static final String USER = "username"; // Change 'username' to your database username
    static final String PASS = "password"; // Change 'password' to your database password

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Create a table
            System.out.println("Creating table...");
            stmt = conn.createStatement();
            String sql = "CREATE TABLE Product " +
                         "(Pid INT NOT NULL AUTO_INCREMENT, " +
                         " Pname VARCHAR(255), " +
                         " Price DECIMAL(10,2), " +
                         " PRIMARY KEY ( Pid ))";
            stmt.executeUpdate(sql);
            System.out.println("Table created successfully");

            // Insert records
            System.out.println("Inserting records...");
            sql = "INSERT INTO Product (Pname, Price) VALUES ('Product1', 10.50)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Product (Pname, Price) VALUES ('Product2', 20.00)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Product (Pname, Price) VALUES ('Product3', 15.75)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Product (Pname, Price) VALUES ('Product4', 12.99)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO Product (Pname, Price) VALUES ('Product5', 25.49)";
            stmt.executeUpdate(sql);
            System.out.println("Records inserted successfully");

            // Display records
            System.out.println("Displaying all records...");
            sql = "SELECT * FROM Product";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int pid = rs.getInt("Pid");
                String pname = rs.getString("Pname");
                double price = rs.getDouble("Price");
                System.out.println("Pid: " + pid + ", Pname: " + pname + ", Price: " + price);
            }
            rs.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // Finally block to close resources
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
        System.out.println("Goodbye!");
    }
}

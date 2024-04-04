// Write a Menu Driven program in Java for the following: Assume Employee table with attributes (ENo, EName, Salary) is already created. 1. Insert 2. Update 3. Display 4. Exit.

import java.sql.*;
import java.util.Scanner;

public class slip22EmployeeManagementSystem {
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USER = "postgres";
    static final String PASS = "6512";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            Scanner scanner = new Scanner(System.in);

            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Execute a query
            stmt = conn.createStatement();

            while (true) {
                System.out.println("\nMENU:");
                System.out.println("1. Insert");
                System.out.println("2. Update");
                System.out.println("3. Display");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        insertEmployee(conn, scanner);
                        break;
                    case 2:
                        updateEmployee(conn, scanner);
                        break;
                    case 3:
                        displayEmployees(stmt);
                        break;
                    case 4:
                        System.out.println("Exiting program...");
                        return;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    private static void insertEmployee(Connection conn, Scanner scanner) throws SQLException {
        System.out.println("\nInserting new employee...");
        System.out.print("Enter employee number: ");
        int eNo = scanner.nextInt();
        System.out.print("Enter employee name: ");
        String eName = scanner.next();
        System.out.print("Enter employee salary: ");
        double salary = scanner.nextDouble();

        String sql = "INSERT INTO Employee (ENo, EName, Salary) VALUES (?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, eNo);
        pstmt.setString(2, eName);
        pstmt.setDouble(3, salary);
        pstmt.executeUpdate();
        System.out.println("Employee inserted successfully.");
    }

    private static void updateEmployee(Connection conn, Scanner scanner) throws SQLException {
        System.out.println("\nUpdating employee salary...");
        System.out.print("Enter employee number: ");
        int eNo = scanner.nextInt();
        System.out.print("Enter new salary: ");
        double newSalary = scanner.nextDouble();

        String sql = "UPDATE Employee SET Salary=? WHERE ENo=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setDouble(1, newSalary);
        pstmt.setInt(2, eNo);
        int rowsUpdated = pstmt.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Salary updated successfully.");
        } else {
            System.out.println("Employee not found.");
        }
    }

    private static void displayEmployees(Statement stmt) throws SQLException {
        System.out.println("\nDisplaying employees:");
        String sql = "SELECT * FROM Employee";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            int eNo = rs.getInt("ENo");
            String eName = rs.getString("EName");
            double salary = rs.getDouble("Salary");
            System.out.println("Employee Number: " + eNo + ", Employee Name: " + eName + ", Salary: " + salary);
        }
        rs.close();
    }
}

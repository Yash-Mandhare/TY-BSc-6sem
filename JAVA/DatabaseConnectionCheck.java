import java.sql.*;

public class DatabaseConnectionCheck {
    public static void main(String[] args) {
        // JDBC URL, username, and password of PostgreSQL server
        String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "6512";

        // Try to establish a connection
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println("Database connected successfully!");
        } catch (SQLException e) {
            System.err.println("Database connection failed:");
            e.printStackTrace();
        }
    }
}

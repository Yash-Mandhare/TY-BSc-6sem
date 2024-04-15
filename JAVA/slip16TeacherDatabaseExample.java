// Write a Java program to accept the details of Teacher (TNo, TName, Subject). Insert at least 5 Records into Teacher Table and display the details of Teacher who is teaching “JAVA” Subject. (Use PreparedStatement Interface)

import java.sql.*;

public class slip16TeacherDatabaseExample {
    // JDBC URL, username, and password of PostgreSQL server
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "6512";

    public static void main(String[] args) {
        try {
            // Load the PostgreSQL JDBC driver dynamically
            Class.forName("org.postgresql.Driver");

            // Establishing a connection to the database
            Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // Creating a PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO Teacher (TNo, TName, Subject) VALUES (?, ?, ?)");

            // Inserting at least 5 records into Teacher table
            insertTeacher(preparedStatement, 101, "John Doe", "JAVA");
            insertTeacher(preparedStatement, 102, "Alice Smith", "C++");
            insertTeacher(preparedStatement, 103, "Bob Johnson", "Python");
            insertTeacher(preparedStatement, 104, "Emily Brown", "JAVA");
            insertTeacher(preparedStatement, 105, "Michael Wilson", "JAVA");

            // Displaying details of teachers teaching "JAVA" subject
            displayTeachersOfSubject(connection, "JAVA");

            // Closing the resources
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to insert a record into the Teacher table
    private static void insertTeacher(PreparedStatement preparedStatement, int tNo, String tName, String subject)
            throws SQLException {
        preparedStatement.setInt(1, tNo);
        preparedStatement.setString(2, tName);
        preparedStatement.setString(3, subject);
        preparedStatement.executeUpdate();
    }

    // Method to display details of teachers teaching a specific subject
    private static void displayTeachersOfSubject(Connection connection, String subject) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT TNo, TName FROM Teacher WHERE Subject = ?");
        preparedStatement.setString(1, subject);
        ResultSet resultSet = preparedStatement.executeQuery();

        System.out.println("Details of Teachers teaching " + subject + " subject:");
        while (resultSet.next()) {
            int tNo = resultSet.getInt("TNo");
            String tName = resultSet.getString("TName");
            System.out.println("Teacher No: " + tNo + ", Teacher Name: " + tName);
        }
        resultSet.close();
        preparedStatement.close();
    }
}

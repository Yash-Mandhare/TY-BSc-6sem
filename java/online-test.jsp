<!-- Create a JSP page for an online multiple choice test. The questions are randomly selected from a database and displayed on the screen. The choices are displayed using radio buttons. When the user clicks on next, the next question is displayed. When the user clicks on submit, display the total score on the screen. -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Online Multiple Choice Test</title>
</head>
<body>

<%
    // JDBC driver name and database URL
    String JDBC_DRIVER = "your_jdbc_driver";
    String DB_URL = "your_database_url";

    // Database credentials
    String USER = "your_database_username";
    String PASS = "your_database_password";

    Connection conn = null;
    Statement stmt = null;

    try {
        // Register JDBC driver
        Class.forName(JDBC_DRIVER);

        // Open a connection
        conn = DriverManager.getConnection(DB_URL, USER, PASS);

        // Execute a query to select a random question
        stmt = conn.createStatement();
        String sql = "SELECT * FROM questions ORDER BY RAND() LIMIT 1";
        ResultSet rs = stmt.executeQuery(sql);

        // Display the question and choices using radio buttons
        if (rs.next()) {
            String question = rs.getString("question_text");
            String choice1 = rs.getString("choice1");
            String choice2 = rs.getString("choice2");
            String choice3 = rs.getString("choice3");
            String choice4 = rs.getString("choice4");
            int correctChoice = rs.getInt("correct_choice");

            out.println("<h2>Question:</h2>");
            out.println("<p>" + question + "</p>");
            out.println("<form method=\"post\">");
            out.println("<input type=\"radio\" name=\"choice\" value=\"1\">" + choice1 + "<br>");
            out.println("<input type=\"radio\" name=\"choice\" value=\"2\">" + choice2 + "<br>");
            out.println("<input type=\"radio\" name=\"choice\" value=\"3\">" + choice3 + "<br>");
            out.println("<input type=\"radio\" name=\"choice\" value=\"4\">" + choice4 + "<br>");
            out.println("<input type=\"submit\" name=\"action\" value=\"Next\">");
            out.println("<input type=\"submit\" name=\"action\" value=\"Submit\">");
            out.println("</form>");
        }

        // Clean-up environment
        rs.close();
        stmt.close();
        conn.close();
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
%>

<%
    // Handle form submission
    if ("POST".equalsIgnoreCase(request.getMethod())) {
        String action = request.getParameter("action");
        if ("Next".equalsIgnoreCase(action)) {
            // Display the next question
            response.sendRedirect("online-test.jsp");
        } else if ("Submit".equalsIgnoreCase(action)) {
            // Handle submission and calculate total score
            // You need to implement this logic based on the selected choices and correct answers
            // For this example, let's assume total score is always 0
            int totalScore = 0;
            out.println("<h2>Total Score:</h2>");
            out.println("<p>" + totalScore + "</p>");
        }
    }
%>

</body>
</html>

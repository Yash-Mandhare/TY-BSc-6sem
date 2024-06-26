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
    <%!
        String JDBC_DRIVER = "org.postgresql.Driver";
        String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
        String USER = "postgres";
        String PASS = "6512";
    %>

    <%@ page import="java.util.Random" %>
    <%
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM questions ORDER BY RANDOM() LIMIT 1";
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                String question = rs.getString("question_text");
                String choice1 = rs.getString("choice1");
                String choice2 = rs.getString("choice2");
                String choice3 = rs.getString("choice3");
                String choice4 = rs.getString("choice4");

                session.setAttribute("question", question);
                session.setAttribute("choice1", choice1);
                session.setAttribute("choice2", choice2);
                session.setAttribute("choice3", choice3);
                session.setAttribute("choice4", choice4);
            } else {
                out.println("No questions found in the database.");
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            out.println("Failed to load PostgreSQL JDBC driver.");
            e.printStackTrace();
        } catch (SQLException se) {
            out.println("SQL Exception: " + se.getMessage());
            se.printStackTrace();
        } catch (Exception e) {
            out.println("Exception: " + e.getMessage());
            e.printStackTrace();
        }
    %>

    <h2>Question:</h2>
    <p><%= session.getAttribute("question") %></p>
    <form method="post" action="online-test.jsp">
        <input type="radio" name="choice" value="1"><%= session.getAttribute("choice1") %><br>
        <input type="radio" name="choice" value="2"><%= session.getAttribute("choice2") %><br>
        <input type="radio" name="choice" value="3"><%= session.getAttribute("choice3") %><br>
        <input type="radio" name="choice" value="4"><%= session.getAttribute("choice4") %><br>
        <input type="submit" name="action" value="Next">
        <input type="submit" name="action" value="Submit">
    </form>

    <%-- Handle form submission --%>
    <% 
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            String action = request.getParameter("action");
            if ("Next".equalsIgnoreCase(action)) {
                response.sendRedirect("online-test.jsp");
            } else if ("Submit".equalsIgnoreCase(action)) {
                int totalScore = 0;
    %>
                <h2>Total Score:</h2>
                <p><%= totalScore %></p>
    <%
            }
        }
    %>
</body>
</html>

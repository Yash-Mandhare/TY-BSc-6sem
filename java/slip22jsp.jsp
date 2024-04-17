<!-- Write a JSP program which accepts UserName in a TextBox and greets the user according to the time on server machine. -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Greeting Page</title>
</head>
<body>
    <h2>Greeting Page</h2>
    <form action="GreetingServlet" method="post">
        Enter your name: <input type="text" name="username">
        <input type="submit" value="Submit">
    </form>

    <%-- JSP code to get current time and greet the user --%>
    <%
        // Get the current time on the server
        java.util.Date currentTime = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm:ss");
        String currentTimeString = sdf.format(currentTime);

        // Get the username from the request parameter
        String username = request.getParameter("username");

        // Generate a greeting message based on the time
        String greetingMessage = "";
        int hour = Integer.parseInt(currentTimeString.substring(0, 2));
        if (hour >= 0 && hour < 12) {
            greetingMessage = "Good morning";
        } else if (hour >= 12 && hour < 18) {
            greetingMessage = "Good afternoon";
        } else {
            greetingMessage = "Good evening";
        }

        // Print the greeting message with the username
        if (username != null && !username.isEmpty()) {
            out.println("<p>" + greetingMessage + ", " + username + "! The current time is " + currentTimeString + ".</p>");
        }
    %>
</body>
</html>

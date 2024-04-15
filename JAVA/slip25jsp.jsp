<!-- Write a JSP program to accept Name and Age of Voter and check whether he is eligible for voting or not. -->


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Voter Eligibility Checker</title>
</head>
<body>
    <h2>Voter Eligibility Checker</h2>
    <form action="CheckEligibility.jsp" method="post">
        Enter your name: <input type="text" name="name"><br>
        Enter your age: <input type="number" name="age"><br>
        <input type="submit" value="Check Eligibility">
    </form>

    <%-- JSP code to check eligibility --%>
    <%
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));

        String message = "";
        if (age >= 18) {
            message = "Congratulations, " + name + "! You are eligible for voting.";
        } else {
            message = "Sorry, " + name + ". You are not eligible for voting. You must be at least 18 years old.";
        }

        // Display eligibility message
        out.println("<p>" + message + "</p>");
    %>
</body>
</html>

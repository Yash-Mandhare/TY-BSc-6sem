<!-- Write a JSP script to accept a String from a user and display it in reverse order. -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Reverse String</title>
</head>
<body>
    <h2>Reverse String</h2>
    <form action="" method="post">
        Enter a string: <input type="text" name="inputString">
        <input type="submit" value="Reverse">
    </form>

    <%-- JSP code to reverse the string --%>
    <%
        String inputString = request.getParameter("inputString");
        String reversedString = "";

        if (inputString != null && !inputString.isEmpty()) {
            // Reverse the string
            for (int i = inputString.length() - 1; i >= 0; i--) {
                reversedString += inputString.charAt(i);
            }
        }
    %>

    <%-- Display the reversed string --%>
    <p>Reversed string: <%= reversedString %></p>
</body>
</html>

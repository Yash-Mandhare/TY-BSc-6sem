<!-- Write a JSP program to calculate sum of first and last digit of a given number. Display sum in Red Color with font size 18. -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sum of First and Last Digit</title>
</head>
<body>
    <h2>Sum of First and Last Digit</h2>
    <form action="" method="post">
        Enter a number: <input type="text" name="number">
        <input type="submit" value="Calculate">
    </form>

    <%-- JSP code to calculate sum of first and last digit --%>
    <%
        String numberStr = request.getParameter("number");
        int sum = 0;

        if (numberStr != null && !numberStr.isEmpty()) {
            int number = Integer.parseInt(numberStr);

            // Calculate sum of first and last digit
            int lastDigit = number % 10;
            int firstDigit = number;
            while (firstDigit >= 10) {
                firstDigit /= 10;
            }
            sum = firstDigit + lastDigit;
        }
    %>

    <div style="color: red; font-size: 18px;">
        <%-- Display sum in red color with font size 18 --%>
        <% out.println("Sum of first and last digit: " + sum); %>
    </div>
</body>
</html>

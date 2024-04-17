<!-- Write a JSP program to check whether a given number is prime or not. Display the result in red color. -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Prime Number Checker</title>
</head>
<body>
    <form>
        <input type="number" name="number">
    </form>
    <%
    // Get the number from the request parameter
    String numberstr = request.getParameter("number");
    int number=Integer.parseInt(numberstr);
    // Check if the number is prime
    boolean isPrime = true;
    if (number <= 1) {
        isPrime = false;
    } else {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }
    }
    %>

    <h2>Prime Number Checker</h2>
    <p>
        The number <%= number %> is
        <span style="color: red;">
            <%= isPrime ? "prime" : "not prime" %>
        </span>.
    </p>
</body>
</html>

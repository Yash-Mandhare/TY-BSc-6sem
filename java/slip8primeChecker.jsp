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
    int number = 0; // Initialize to handle empty or non-numeric input
    boolean isPrime = false; // Initialize to handle errors

    // Check if the parameter is not empty and can be parsed as an integer
    if (numberstr != null && !numberstr.isEmpty()) {
        try {
            number = Integer.parseInt(numberstr);
            // Check if the number is prime
            if (number <= 1) {
                isPrime = false;
            } else {
                isPrime = true;
                for (int i = 2; i <= Math.sqrt(number); i++) {
                    if (number % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }
        } catch (NumberFormatException e) {
            // Handle the case where the parameter cannot be parsed as an integer
            // You can display an error message or take any appropriate action here
            e.printStackTrace(); // You might want to log this error for debugging
        }
    }
    %>

    <h2>Prime Number Checker</h2>
    <p>
        <% if (number != 0) { %>
            The number <%= number %> is
            <span style="color: red;">
                <%= isPrime ? "prime" : "not prime" %>
            </span>.
        <% } else { %>
            Please enter a valid number.
        <% } %>
    </p>
</body>
</html>


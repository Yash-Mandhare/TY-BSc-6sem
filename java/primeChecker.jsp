<!-- Write a JSP program to check whether a given number is prime or not. Display the result in red color. -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Prime Number Checker</title>
</head>
<body>

<%
    // Get the number from the request parameter
    int number = Integer.parseInt(request.getParameter("number"));

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
    <font color="red"><%= isPrime ? "prime" : "not prime" %></font>.
</p>

</body>
</html>

<!-- Write a JSP program to check whether given number is Perfect or not. (Use Include directive). -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    class PerfectNumberChecker {
        public boolean isPerfectNumber(int number) {
            if (number <= 0) {
                return false;
            }
            int sum = 0;
            for (int i = 1; i <= number / 2; i++) {
                if (number % i == 0) {
                    sum += i;
                }
            }
            return sum == number;
        }
    }

    // Usage:
    PerfectNumberChecker checker = new PerfectNumberChecker();
    int inputNumber = 28; // You can change this to any number you want to check
    boolean isPerfect = checker.isPerfectNumber(inputNumber);
%>

<html>
<head>
    <title>Perfect Number Checker</title>
</head>
<body>
    <h1>Perfect Number Checker</h1>
    <p>Input Number: <%= inputNumber %></p>
    <p>Is Perfect Number: <%= isPerfect ? "Perfect" : "Not Perfect" %></p>
</body>
</html>



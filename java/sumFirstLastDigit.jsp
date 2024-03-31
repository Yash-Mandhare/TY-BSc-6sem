<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sum of First and Last Digit</title>
</head>
<body>
    <h2>Sum of First and Last Digit</h2>
    
    <%
        // Method to calculate sum of first and last digits
        int sumFirstLastDigit(int num) {
            int lastDigit = num % 10;
            int firstDigit = 0;
            while (num != 0) {
                firstDigit = num % 10;
                num /= 10;
            }
            return firstDigit + lastDigit;
        }

        // Get the number from the request parameter
        String numberStr = request.getParameter("number");
        int sum = 0;

        // Check if numberStr is not null and not empty
        if (numberStr != null && !numberStr.isEmpty()) {
            int number = Integer.parseInt(numberStr);
            sum = sumFirstLastDigit(number);
        }
    %>

    <div style="color: red; font-size: 18px;">
        Sum of First and Last Digit: <%= sum %>
    </div>
    
    <form method="get" action="">
        <label for="number">Enter a number:</label>
        <input type="number" id="number" name="number">
        <button type="submit">Calculate</button>
    </form>
</body>
</html>

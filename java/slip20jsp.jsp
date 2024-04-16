<!-- Create a JSP page to accept a number from a user and display it in words: Example: 123 – One Two Three. The output should be in red color. -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Number to Words Converter</title>
</head>
<body>
    <h2>Number to Words Converter</h2>
    <form action="NumberToWords.jsp" method="post">
        Enter a number: <input type="text" name="number">
        <input type="submit" value="Convert">
    </form>

    <%-- JSP code to convert number to words --%>
    <%@ page import="java.util.HashMap" %>
    <%@ page import="java.util.Map" %>
    <%@ page import="java.util.Scanner" %>
    <%@ page import="java.util.Stack" %>

    <%-- Define the number to word mapping --%>
    <%!
        private static final Map<Character, String> map = new HashMap<>();
        static {
            map.put('0', "Zero");
            map.put('1', "One");
            map.put('2', "Two");
            map.put('3', "Three");
            map.put('4', "Four");
            map.put('5', "Five");
            map.put('6', "Six");
            map.put('7', "Seven");
            map.put('8', "Eight");
            map.put('9', "Nine");
        }
    %>

    <%-- Convert number to words function --%>
    <%
        String numberStr = request.getParameter("number");
        if (numberStr != null && !numberStr.isEmpty()) {
            out.print("<div style='color: red;'>");
            out.print("Number in words: ");
            for (char digit : numberStr.toCharArray()) {
                if (map.containsKey(digit)) {
                    out.print(map.get(digit) + " ");
                }
            }
            out.print("</div>");
        }
    %>
</body>
</html>

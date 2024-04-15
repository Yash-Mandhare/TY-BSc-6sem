<!--  Write a JSP program to display the details of Patient (PNo, PName, Address, age, disease) in tabular form on browser. -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Patient Details</title>
    <style>
        table {
            border-collapse: collapse;
            width: 80%;
            margin: auto;
        }
        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>

<%
    // Sample data for patients
    String[][] patients = {
            {"1", "John Doe", "123 Main St, City", "35", "Fever"},
            {"2", "Jane Smith", "456 Oak St, Town", "40", "Cold"},
            {"3", "Alice Johnson", "789 Elm St, Village", "50", "Flu"},
            {"4", "Bob Williams", "101 Pine St, County", "45", "Cough"}
    };
%>

<h2>Patient Details</h2>
<table>
    <tr>
        <th>Patient Number</th>
        <th>Patient Name</th>
        <th>Address</th>
        <th>Age</th>
        <th>Disease</th>
    </tr>
    <% for (String[] patient : patients) { %>
    <tr>
        <td><%= patient[0] %></td>
        <td><%= patient[1] %></td>
        <td><%= patient[2] %></td>
        <td><%= patient[3] %></td>
        <td><%= patient[4] %></td>
    </tr>
    <% } %>
</table>

</body>
</html>

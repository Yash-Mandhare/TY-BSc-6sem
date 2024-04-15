<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.util.*" %>

<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    if (username != null && password != null && username.equals(password)) {
        response.sendRedirect("Login.html");
    } else {
        response.sendRedirect("Error.html");
    }
%>

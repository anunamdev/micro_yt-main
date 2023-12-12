<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Registration</title>
</head>
<body>
    <h2>Employee Registration</h2>
    
    <form action="/employee/register" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>
        
        <label for="designation">Designation:</label>
        <input type="text" id="designation" name="designation" required><br>
        
        <input type="submit" value="Register">
    </form>
    
    <br>
    
    <c:url var="listUrl" value="/employee/list" />
    <a href="${listUrl}">View Employee List</a>

    <!-- Add a link to the login page -->
    <br>
    <c:url var="loginUrl" value="/login.jsp" />
    <a href="${loginUrl}">Login</a>
</body>
</html>

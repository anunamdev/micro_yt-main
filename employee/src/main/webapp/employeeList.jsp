<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee List</title>
</head>
<body>
    <h2>Employee List</h2>
    
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Designation</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        
        <c:forEach var="employee" items="${employees}">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.name}</td>
                <td>${employee.designation}</td>
                <td><a href="/employee/edit/${employee.id}">Edit</a></td>
                <td><a href="/employee/delete/${employee.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    
    <br>
    
    <c:url var="registerUrl" value="/employee/register" />
    <a href="${registerUrl}">Register New Employee</a>
</body>
</html>

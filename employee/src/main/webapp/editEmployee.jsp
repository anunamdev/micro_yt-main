<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Employee</title>
</head>
<body>
    <h2>Edit Employee</h2>
    
    <form action="/employee/edit/${employee.id}" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${employee.name}" required><br>
        
        <label for="designation">Designation:</label>
        <input type="text" id="designation" name="designation" value="${employee.designation}" required><br>
        
        <input type="submit" value="Update">
    </form>
    
    <br>
    
    <a href="/employee/list">Back to Employee List</a>
</body>
</html>

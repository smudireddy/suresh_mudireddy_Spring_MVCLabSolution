<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Student Registration Form</title>
	</head>
	<body>
		<h3>Student Form for ${mode}</h3>
		<form method="POST" action="save">
			<table>
				<tr>
				    <td><label>Student Id: </label></td>
	   				<td><input type="hidden" name="studentId" value="${student.id}" /></td>
	   			</tr>	
	   			<tr>
	   			    <td><label>First Name: </label></td>
	   				<td><input type="text" name="firstName" value="${student.firstName}" /></td>
	   			</tr>
	   		
	   			<tr>
	   			    <td><label>Last Name: </label></td>
	   				<td><input type="text" name="lastName" value="${student.lastName}" /></td>
	   			</tr>
	   			<tr>
	   			    <td><label>Course: </label></td>
	   				<td><input type="text" name="course" value="${student.course}" /></td>
	   			</tr>
	   			<tr>
	   			    <td><label>Country: </label></td>
	   			    <td><input type="text" name="country" value="${student.country}" /></td>
	   			</tr>
	   		</table>
	   		<button type="submit">Register</button>
		</form>
		<br>
		<h3><a href="students">Back to Students List</a></h3>
		
	</body>
</html>
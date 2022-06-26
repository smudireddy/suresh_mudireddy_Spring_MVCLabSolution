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
	   		<input type="hidden" name="Id" value="${student.id}" />
	   		<input type="text" name="firstName" value="${student.firstName}" placeholder="First Name" />
	   		<input type="text" name="lastName" value="${student.lastName}" placeholder="Last Name" />
	   		<input type="text" name="course" value="${student.course}" placeholder="Course" />
	   		<input type="text" name="country" value="${student.country}" placeholder="Country" />
		</form>
		<a href="students">Back to Students List</a>
	</body>
</html>
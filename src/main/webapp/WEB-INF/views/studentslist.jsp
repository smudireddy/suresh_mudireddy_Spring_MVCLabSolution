<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
caption {
	padding: 20px;
}
</style>

<title>Student Registration</title>
</head>
<body>
	<h3>College Festival - Student Registrations</h3>
	
	<h3 align="center"><a href="welcome">Home</a></h3>
	
	<c:if test="${!empty studentlist}">
		<table border="1">
			<caption>Registered Students</caption>
			<tr>
				<th>Student ID</th>
				<th>Student First Name</th>
				<th>Student Last Name</th>
				<th>Student Course Name</th>
				<th>Student Country</th>
				<th>Actions</th>
			</tr>

			<c:forEach items="${studentlist}" var="student">
				<tr>
					<td><c:out value="${student.id}" /></td>
					<td><c:out value="${student.firstName}" /></td>
					<td><c:out value="${student.lastName}" /></td>
					<td><c:out value="${student.course}" /></td>
					<td><c:out value="${student.country}" /></td>
					<td align="center"><a
						href="showFormToUpdate?studentId=${student.id}">Edit</a> | <a
						href="unregister?studentId=${student.id}"
						onclick="if (!confirm('Are you sure you want to un-register the student?'))">Delete</a></td>
				</tr>
			</c:forEach>			
		</table>
	</c:if>
	<br>
	<h3 align="center"><a href="showFormForRegister">Click to register a student</a></h3>

</body>
</html>
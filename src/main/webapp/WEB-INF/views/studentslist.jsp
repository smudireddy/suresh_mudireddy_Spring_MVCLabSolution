<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Registered Students</title>
</head>
<body>
<h1>List Students</h1>
<h3><a href="student.html">Register Student</a></h3>

<c:if test="${!empty studentlist}">
	<table align="left" border="1">
		<tr>
			<th>Student ID</th>
			<th>Student First Name</th>
			<th>Student Last Name</th>
			<th>Student Course Name</th>
			<th>Student Country</th>
		</tr>

		<c:forEach items="${studentlist}" var="student">
			<tr>
				<td><c:out value="${student.id}"/></td>
				<td><c:out value="${student.firstName}"/></td>
				<td><c:out value="${student.lastName}"/></td>
				<td><c:out value="${student.course}"/></td>
				<td><c:out value="${student.country}"/></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Players</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/js/bootstrap.min.js"></script>
</head>
<body>

	<form:form method="POST" modelAttribute="players">
		<ul>
 			<c:forEach items="${players}" var="player">
 				<li>
<%--  					<form:select path="first11" items="${players}" itemValue="id" itemLabel="lastName" multiple="true"></form:select> --%>
  					<form:checkboxes items="${players}" path="first11" />
 				</li>
 			</c:forEach>
 		</ul>
 		
 		<input type="submit" value="register" />
 	</form:form>

</body>
</html>
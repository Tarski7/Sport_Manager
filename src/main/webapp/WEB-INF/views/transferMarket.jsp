<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Transfer market</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/js/bootstrap.min.js"></script>
</head>
<body>

	<h2>Transfer market</h2>

	<form:form method="POST" modelAttribute="players">
	<table class="table table-inverse table-border">
	  	<thead>
	    	<tr>
		      <th>First name</th>
		      <th>Last name</th>
		      <th>Position</th>
		      <th>Nationality</th>
		      <th>Goa</th>
		      <th>Def</th>
		      <th>Mid</th>
		      <th>Off</th>
		      <th>Team</th>
		      <th>New Team</th>
	    	</tr>
	  	</thead>
	  	<tbody>
	  		<c:forEach items="${ players }" begin="0" step="1" varStatus="theCount" var="player">
	    		<tr>
				   <td>${player.firstName}</td>
				   <td>${player.lastName}</td>
				   <td>${player.position}</td>
				   <td>${player.nationality}</td>
				   <td>${player.goa}</td>
				   <td>${player.def}</td>
				   <td>${player.mid}</td>
				   <td>${player.off}</td>
				   <td>${player.team.name}</td>
  				   <td><form:select path="player.team">
  							<form:option value="0">Select Team</form:option>
  							<form:options items="${teams}" itemValue="id" itemLabel="name" />
  						</form:select></td>
	    		</tr>
	    	</c:forEach>
	  	</tbody>
	</table>
	<input type="submit" value="Save" />
	</form:form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Standings</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>

	<div class="card card-inverse" style="background-color: #333; border-color: #333;">
	  <div class="card-block text-center">
	    <h1 class="card-title">Football manager</h1>
	    <p class="card-text">Navigation menu</p>
	    <nav class="navbar navbar-inverse bg-inverse">
			<a class="w3-button w3-hover-black" href="http://localhost:8080/SportManager/">Home page</a>
	  		<a class="w3-button w3-hover-black" href="http://localhost:8080/SportManager/team/table">Table</a>
	  		<a class="w3-button w3-hover-black" href="http://localhost:8080/SportManager/team/teams">Teams</a>
	  		<a class="w3-button w3-hover-black" href="http://localhost:8080/SportManager/round/test">Schedule</a>
	  		<a class="w3-button w3-hover-black" href="http://localhost:8080/SportManager/player/add">Add new player</a>
	  		<a class="w3-button w3-hover-black" href="http://localhost:8080/SportManager/worker/add">Add new worker</a>
		</nav>
	   </div>
	   <div class="card card-inverse text-center" style="background-color: #333; border-color: #333;">
	  <div class="card-block">
	    <h1 class="card-title">STANDINGS</h1>
	   </div>
 	</div>
 	<table class="table table-inverse table-border">
	  	<thead>
	    	<tr>
	    	  <th>#</th>
		      <th>Team</th>
		      <th>MP</th>
		      <th>W</th>
		      <th>D</th>
		      <th>L</th>
		      <th>G+</th>
		      <th>G-</th>
		      <th>G+/-</th>
		      <th>Pts</th>  
	    	</tr>
	  	</thead>
	  	<tbody>
	  		<c:forEach items="${ teams }" begin="0" step="1" varStatus="theCount" var="team">
	    		<tr>
	    		   <th scope="row">${theCount.count}</th>
				   <td><a href="http://localhost:8080/SportManager/team/players/${team.id}">${team.name}</a></td>
				   <td>${team.matches}</td>
				   <td>${team.wins}</td>
				   <td>${team.draws}</td>
				   <td>${team.losses}</td>
				   <td>${team.goalsFor}</td>
				   <td>${team.goalsAgainst}</td>
				   <td>${team.goalsDifference}</td>
				   <td>${team.points}</td>
	    		</tr>
	    	</c:forEach>
	  	</tbody>
	</table>
 	</div>
 	
 	



</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href= "css/bootstrap.min.css">
	<link rel="stylesheet" href="css/style.css">
	<title>${titulo}</title>
</head>
<body>
	<nav class="navbar navbar-light bg-dark">
	<div class="container-fluid d-flex">
		<a class="navbar-brand text-light">Musicapp</a>
		<form class="d-flex col-8 col-lg-4">
			<input class="form-control me-2 bg-dark border-1 text-light"
				style="border-color: rgb(95, 95, 95);" type="search"
				placeholder="Buscar por artista, canci�n, album" aria-label="Search">
				<button class="text-center btn btn-outline-info" type="submit">Buscar</button>
		</form>
		<button type="button" class="btn btn-info text-light">Login</button>
	</div>
	</nav>
	
	<!-- Bootstrap -->
	<script src="js/jquery-1.11.3.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="https://kit.fontawesome.com/1776a9f4e1.js" crossorigin="anonymous"></script>
	<script src="js/reproductor.js"></script>
</body>
</html>
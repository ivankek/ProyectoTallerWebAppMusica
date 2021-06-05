<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href= "css/bootstrap.min.css">
	<link rel="stylesheet" href="css/style.css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<title>${titulo}</title>
</head>
<body>
	<nav class="navbar navbar-light bg-dark">
		<div class="container-fluid d-flex">
			<a class="navbar-brand text-light" href="Inicio">Musicapp</a>
			<form action="realizarBusqueda" class="d-flex col-8 col-lg-4">
				<input name="busqueda" id="busqueda"
					class="form-control me-2 bg-dark border-1 text-light"
					style="border-color: rgb(95, 95, 95);" type="text"
					placeholder="Buscar canciones por nombre, artista, album"
					aria-label="Search">
				<button class="col-2 text-center btn btn-outline-info" type="submit"
					value="Submit">Buscar</button>
			</form>
			<button type="button" class="btn btn-info text-light">Login</button>
		</div>
	</nav>
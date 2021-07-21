<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<title>${titulo}</title>
</head>

<!-- Navbar -->
<nav class="container-fluid navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container-fluid">

		<div
			class="d-flex justify-content-end form-check form-switch form-control-lg">
			<input class="form-check-input" type="checkbox" id="toggleSidebar">
		</div>

		<a class="navbar-brand text-light" href="Inicio">Musicapp</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#topNavBar" aria-controls="topNavBar"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="topNavBar">
			<form action="realizarBusqueda" class="d-flex ms-auto my-3 my-lg-0">
				<input name="busqueda" id="busqueda"
					class="form-control me-1 bg-dark border-1 text-light"
					style="border-color: rgb(95, 95, 95);" type="text"
					placeholder="Buscar"
					aria-label="Search">
					
					
				<button class="col-2 text-center btn btn-outline-info" type="submit"
					value="Submit"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
  <path
								d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z" />
</svg></button>
			</form>
			
			
			<ul class="navbar-nav">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle ms-2" href="#" role="button"
					data-bs-toggle="dropdown" aria-expanded="false"><svg
							xmlns="http://www.w3.org/2000/svg" width="16" height="16"
							fill="currentColor" class="bi bi-person-fill" viewBox="0 0 16 16">
  <path
								d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z" />
</svg> </a>
					<ul class="dropdown-menu dropdown-menu-end">

						<%
							if (request.getAttribute("usuario") != null) {
						%>
						<li><a class="dropdown-item" href="cerrarSesion">Log out</a></li>

						<%
							} else {
						%>
						<li><a class="dropdown-item" href="login">Log in</a></li>
						<%
							}
						%>

					</ul></li>
			</ul>
		</div>
	</div>
</nav>
<!--Fin Navbar -->

<%@include file="sidebar.jsp"%>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
	crossorigin="anonymous"></script>
<script src="js/offcanvas.js"></script>
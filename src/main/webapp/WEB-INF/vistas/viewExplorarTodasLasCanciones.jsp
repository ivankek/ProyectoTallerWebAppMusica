<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@include file="Header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Explorar Canciones</title>
</head>
<body>

<div class="container-fluid main pb-4 mb-5">
	<div class="row">
<div class="col bg-dark bg-gradient p-5">
<h2 class="text-white text-center">Explorar Canciones</h2>

	<div class="mt-2">
		<ul class="list-group pb-5 mb-5 cancion">
			<c:forEach items="${cancion}" var="cancion">
				<li class="list-group-item bg-dark d-flex justify-content-between">
					<!-- parte A -->
						<div class="d-flex align-items-center">
						<i class="material-icons text-white me-3 icon-play"
							name="${cancion.nombre}">play_circle_outline</i>
						<div class="flex-shrink-0">
							<img src="${cancion.album.path_img}"
								style="width: 64px; height: 64px" alt="...">
						</div>
						<div class="flex-grow-1 ms-3 text-white">
							<h5 class="mt-0">${cancion.nombre}</h5>
							<a
								href="http://localhost:8080/proyecto-limpio-spring-master/Artista?nombre=${cancion.artista.nombre}">${cancion.artista.nombre}</a>
						</div>
					</div> <!-- parte B -->
					<div class="text-white d-flex align-items-center">
						<a
							href="http://localhost:8080/proyecto-limpio-spring-master/Album?nombre=${cancion.album.nombre}">${cancion.album.nombre}</a>
					</div> <!-- parte C -->
					<div class="text-white d-flex align-items-center">
						<div class="me-4">3:20</div>


						<div class="dropdown dropstart">
							<a href='#' role='button' id='dropdownMenuLink'
								data-bs-toggle='dropdown' aria-expanded='false'><div
									class="material-icons">more_horiz</div></a>
							<ul class="dropdown-menu" aria-labelledby='dropdownMenuLink'>

								<c:forEach items="${listas}" var="lista">
									<li id="${lista.id}"><a class='dropdown-item' href='#'>${lista.nombre}</a></li>
								</c:forEach>


							</ul>

						</div>



					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
</div>
</div>
</div>

<%@include file="queue.jsp"%>
<%@include file="reproductor.jsp"%>
<!-- Scripts -->
<script src="js/bootstrap.min.js"></script>
<script src="js/json.js"></script>
</body>
</html>
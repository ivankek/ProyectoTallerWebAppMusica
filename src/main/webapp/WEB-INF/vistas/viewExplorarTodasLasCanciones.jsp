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

<div class="container-fluid main mb-5">
	<div class="row">
<div class="col bg-dark bg-gradient p-5">
<h2 class="text-white text-center">Explorar Canciones</h2><br>

	<table class="table table-dark table-hover ${accion}"
		style="margin-bottom: 10em;">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Título</th>
				<th scope="col">Album</th>
				<th scope="col">Opciones</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${cancion}" var="cancion">
				<tr>
					<th scope="row"><i
						class="material-icons mt-3 text-white me-3 icon-play"
						name="${cancion.nombre}">play_circle_outline</i></th>
					<td><div class="d-flex align-items-center">

							<div class="flex-shrink-0">
								<img src="${cancion.album.path_img}"
									style="width: 50px; height: 50px" alt="...">
							</div>
							<div class="flex-grow-1 ms-3 text-white">
								<h5 class="mt-0 mb-0">${cancion.nombre}</h5>
								<a class="text-decoration-none text-light"
									href="http://localhost:8080/ProyectoTallerWebAppMusica/Artista?nombre=${cancion.artista.nombre}">${cancion.artista.nombre}</a>
							</div>
						</div></td>
					<td><div class="text-white d-flex align-items-end mt-3">
							<a class="text-decoration-none text-light"
								href="http://localhost:8080/ProyectoTallerWebAppMusica/Album?nombre=${cancion.album.nombre}">${cancion.album.nombre}</a>
						</div></td>


					<td>
						<div class="text-white d-flex align-items-center"
							style="margin-top: 0.8em;">
							<div class="me-4">3:20</div>
							<div class="dropdown dropstart">
								<a href='#' role='button' id='dropdownMenuLink'
									data-bs-toggle='dropdown' aria-expanded='false'><div
										class="material-icons"  style="margin-top: 0.2em; color:white;">more_horiz</div></a>
								<ul class="dropdown-menu" aria-labelledby='dropdownMenuLink'>

									<c:forEach items="${listas}" var="lista">
										<li id="${lista.id}"><a class='dropdown-item' href='#'>${lista.nombre}</a></li>
									</c:forEach>


								</ul>

							</div>
						</div>
					</td>

				</tr>


			</c:forEach>
		</tbody>

	</table>

</div>
</div>
</div>

<%@include file="queue.jsp"%>
<%@include file="reproductor.jsp"%>
<!-- Scripts -->
<script src="js/bootstrap.min.js"></script>
<script src="js/reproductor.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
	crossorigin="anonymous"></script>
</body>
</html>
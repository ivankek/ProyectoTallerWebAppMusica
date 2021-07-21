<%@include file="Header.jsp"%>
<div class="container mt-5 text-light mb-5 main">

	<div class="container d-flex flex-column mb-3 ${ocultar1}">

		<div class="align-self-center align-self-md-start mb-3">
			<div class="d-flex flex-column flex-md-row">
				<img class="border border-1 border-dark"
					style="width: 16em; height: 16em; box-shadow: rgba(0, 0, 0, 0.56) 0px 22px 70px 4px;"
					alt="" src="${album.path_img}">
				<div class="ms-md-3 align-self-center align-self-md-end">
					<h5 class="mb-0 mt-3 mt-md-0 text-center text-md-start">Album</h5>
					<p id="albumNombre" class="mt-0 mb-1 fw-bolder fs-1 text-center text-md-start">${album.nombre}</p>
					<c:forEach items="${canciones}" end="0" var="cancion">
						<div class="d-flex flex-column flex-md-row ms-2 ms-md-0">
							<div class="d-flex align-self-center mb-2 mb-md-0">
								<img class="rounded-circle border border-1 border-dark"
									style="width: 2em; height: 2em; box-shadow: rgba(0, 0, 0, 0.56) 0px 22px 70px 4px;"
									alt="" src="${cancion.artista.path_img}"> <a id="artistaNombre"
									class="text-decoration-none text-light fs-5 align-self-center ms-2"
									href="http://localhost:8080/proyecto-limpio-spring-master/Artista?nombre=${cancion.artista.nombre}">${cancion.artista.nombre}</a>

							</div>
							<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
								fill="currentColor"
								class="bi bi-dot align-self-center ms-2 me-2 mt-1 d-none d-md-block"
								viewBox="0 0 16 16">
  <path d="M8 9.5a1.5 1.5 0 1 0 0-3 1.5 1.5 0 0 0 0 3z" />
</svg>

							<a class="text-center text-decoration-none text-light fs-5">Canciones:
								${tamañoDisco}</a>



						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>



	<div class="datos" hidden>${datos}</div>

	<table class="table table-dark table-hover ${accion}"
		style="margin-bottom: 10em;">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Título</th>
				<th scope="col">Opciones</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${canciones}" var="cancion">
				<tr class="cancion">
					<th scope="row"><i
						class="material-icons mt-3 text-white me-3 icon-play"
						name="${cancion.nombre}">play_circle_outline</i></th>
					<td><div class="d-flex align-items-center">

							<div class="flex-shrink-0">
								<img src="${cancion.album.path_img}"
									style="width: 50px; height: 50px" alt="...">
							</div>
							<div class="flex-grow-1 ms-3 text-white">
								<h5 id="cancionNombre" class="mt-0 mb-0">${cancion.nombre}</h5>
								<a class="text-decoration-none text-light"
									href="http://localhost:8080/proyecto-limpio-spring-master/Artista?nombre=${cancion.artista.nombre}">${cancion.artista.nombre}</a>
							</div>
						</div></td>

					<td>
						<div class="text-white d-flex align-items-center"
							style="margin-top: 0.8em;">
							<div class="material-icons fav-icon me-3" hidden=""></div>
							<div class="me-4">3:20</div>
							<%
								if (request.getAttribute("usuario") != null) {
							%>

							<div class="dropdown dropup">
								<a href='#' role='button' id='dropdownMenuLink'
									data-bs-toggle='dropdown' aria-expanded='false'
									style="color: white;"><div class="material-icons">more_vert</div></a>
								<ul class="dropdown-menu dropdown-menu-end px-1"
									aria-labelledby='dropdownMenuLink'>
									<li class="text-center">Agregar a playlist</li>
									<hr>
									<c:forEach items="${listas}" var="lista">
										<li id="${lista.id}"><a class='dropdown-item'
											href="AgregarCancionAPlaylist?idCancion=${cancion.id}&idPlaylist=${lista.id}">${lista.nombre}</a></li>
									</c:forEach>
								</ul>

							</div>
							<%
								} else {
							%>
							<div class="dropdown dropup position-absolute end-0 me-2">
								<a href="login" role='button' id='dropdownMenuLink'
									data-bs-toggle='dropdown' aria-expanded='false'
									style="color: white;"><div class="material-icons">more_vert</div></a>

							</div>

							<%
								}
							%>
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

<script src="js/bootstrap.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
	crossorigin="anonymous"></script>
<script src="js/peticiones.js"></script>
<script src="js/reproductor.js"></script>

</body>
</html>
<%@include file="Header.jsp"%>

<div class="container mt-5 text-light mb-5 main"
	style="margin-bottom: 100em;">
	<h2 class="text-center mb-5">Resultado de tu busqueda:</h2>

	<div class="datos" hidden>${datos}</div>


	<c:forEach items="${album}" var="album">
		<div class="container d-flex flex-column mb-3">

			<div
				class="align-self-center align-self-md-start card mb-3 mt-3 border-0 shadow bg-dark"
				style="width: 15rem; border-radius: 0.5em;">
				<div class="card-body align-self-center">
					<img class="rounded"
						style="width: 12em; height: 12em; object-fit: cover; box-shadow: rgba(0, 0, 0, 0.56) 0px 22px 70px 4px;"
						alt="" src="${album.path_img}">

					<h5 class="text-center text-light mt-3 mb-3">${album.nombre}</h5>
					<!-- <p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p> -->

					<div class="d-flex justify-content-center">
						<a href="Album?nombre=${album.nombre}"
							class="card-link text-decoration-none text-info">Ver Album</a>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>

	<c:forEach items="${listaReproduccion}" var="lista">

		<div id="" class="card mt-3 border-0 shadow bg-dark"
			style="width: 18rem; border-radius: 0.5em;">
			<div class="card-body">
				<h5 class="card-title text-light mb-3">${lista.nombre}</h5>
				<!-- <p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p> -->
				<div class="d-flex">
					<a href="viewLista?idPlaylist=${lista.id}"
						class="card-link text-decoration-none text-info align-self-center">Ver
						canciones</a>

					<div class="ms-4">
						<form action="FollowPlaylist">
							<input type="hidden" name="playlist" value="${lista.id}">
							<button type="submit"
								class="card-link p-2 rounded border-0 btn-info text-light text-decoration-none text-primary"
								id="botonFollow" onclick="FbotonFollow()">Seguir</button>

						</form>
					</div>
				</div>
			</div>

		</div>
	</c:forEach>

	<c:forEach items="${user}" var="user">

		<div class="container d-flex flex-column mb-3">

			<div
				class="align-self-center align-self-md-start card mb-3 mt-3 border-0 shadow bg-dark"
				style="width: 15rem; border-radius: 0.5em;">


				<div class="card-body align-self-center">
					<img class="rounded-circle"
						style="width: 12em; height: 12em; object-fit: cover; box-shadow: rgba(0, 0, 0, 0.56) 0px 22px 70px 4px;"
						alt="" src="${user.path_img}">

					<h5 class="text-center text-light mt-3 mb-3">${user.usuario}</h5>
					<!-- <p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p> -->

					<div class="d-flex justify-content-center">
						<a href="Usuario?nombre=${user.usuario}"
							class="card-link text-decoration-none text-info">Ver Usuario</a>
						<a href="#" class="card-link text-decoration-none text-primary">Seguir</a>
					</div>
				</div>

			</div>
		</div>
	</c:forEach>


	<c:forEach items="${artista}" var="artista">
		<div class="container d-flex flex-column mb-3">

			<div
				class="align-self-center align-self-md-start card mb-3 mt-3 border-0 shadow bg-dark"
				style="width: 15rem; border-radius: 0.5em;">
				<div class="card-body align-self-center">
					<img class="rounded-circle"
						style="width: 12em; height: 12em; object-fit: cover; object-position: 0 0; box-shadow: rgba(0, 0, 0, 0.56) 0px 22px 70px 4px;"
						alt="" src="${artista.path_img}">

					<h5 class="text-center text-light mt-3 mb-3">${artista.nombre}</h5>
					<!-- <p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p> -->

					<div class="d-flex justify-content-center">
						<a href="Artista?nombre=${artista.nombre}"
							class="card-link text-decoration-none text-info">Ver Artista</a>
						<a href="#" class="card-link text-decoration-none text-primary">Seguir</a>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>

	<!-- Tabla -->

</div>

<table class="container table table-dark table-hover ${accion}"
	style="margin-bottom: 4.3em;">
	<thead>
		<tr>
			<th scope="col">#</th>
			<th scope="col">Título</th>
			<th scope="col">Album</th>
			<th scope="col">Opciones</th>
		</tr>
	</thead>

	<tbody>
		<c:forEach items="${resultado}" var="cancion">
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
								href="http://localhost:8080/proyecto-limpio-spring-master/Artista?nombre=${cancion.artista.nombre}">${cancion.artista.nombre}</a>
						</div>
					</div></td>
				<td><div class="text-white d-flex align-items-end mt-3">
						<a class="text-decoration-none text-light"
							href="http://localhost:8080/proyecto-limpio-spring-master/Album?nombre=${cancion.album.nombre}">${cancion.album.nombre}</a>
					</div></td>


				<td>
					<div class="text-white d-flex align-items-center"
						style="margin-top: 0.8em;">
						<div class="me-4">3:20</div>
						<div class="dropdown dropstart">
							<a href='#' role='button' id='dropdownMenuLink'
								data-bs-toggle='dropdown' aria-expanded='false'><div
									class="material-icons" style="margin-top: 0.2em; color: white;">more_horiz</div></a>
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

<!-- Tabla fin -->

</div>

<%@include file="queue.jsp"%>
<%@include file="reproductor.jsp"%>

<!-- Scripts -->
<script src="js/bootstrap.min.js"></script>
<script src="js/json.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
	crossorigin="anonymous"></script>
</body>
</html>
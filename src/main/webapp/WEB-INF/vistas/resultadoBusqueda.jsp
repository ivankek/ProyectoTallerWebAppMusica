<%@include file="Header.jsp"%>

<div class="container mt-5 text-light mb-5 main">
	<h2 class="text-center">Resultado de tu busqueda:</h2>

	<div class="datos" hidden>${datos}</div>


	<c:forEach items="${listaReproduccion}" var="lista">
		<div id="" class="card mt-3 border-0 shadow bg-dark"
			style="width: 18rem; border-radius: 0.5em;">
			<div class="card-body">
				<h5 class="card-title text-light mb-3">${lista.nombre}</h5>
				<!-- <p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p> -->
				<div class="d-flex">
					<a href="viewLista?idPlaylist=${lista.id}"
						class="card-link text-decoration-none text-info align-self-center">Ver canciones</a>
					
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
		<div id="" class="card mt-3 border-0 shadow bg-dark"
			style="width: 18rem; border-radius: 0.5em;">
			<div class="card-body">
				<h5 class="card-title text-light mb-3">${user.usuario}</h5>
				<!-- <p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p> -->
				<a href="Usuario?nombre=${user.usuario}"
					class="card-link text-decoration-none text-info">Ver Usuario</a> <a
					href="#" class="card-link text-decoration-none text-primary">Seguir</a>
			</div>

		</div>
	</c:forEach>


	<div
		class="mt-5 d-flex justify-content-between  text-light align-items-center">
		<p class="text-info">Foto</p>
		<p class="text-info">Titulo</p>
		<p class="text-info">Artista</p>
		<p class="text-info">Album</p>
		<p class="text-info">Opciones</p>
	</div>

	<hr class="mt-0">
	<div class="mt-2">
		<ul class="list-group">
			<c:forEach items="${artista}" var="artista">
				<li class="list-group-item bg-dark d-flex justify-content-between">
					<div class="d-flex align-items-center">
						<div class="flex-shrink-0">
							<img src="${artista.path_img}" style="width: 64px; height: 64px"
								alt="..."> <a
								href="http://localhost:8080/proyecto-limpio-spring-master/Artista?nombre=${artista.nombre}">${artista.nombre}</a>
						</div>
					</div>
				</li>
			</c:forEach>
		</ul>




	</div>

	<div class="mt-2">
		<ul class="list-group pb-5 mb-5 cancion">
			<c:forEach items="${resultado}" var="cancion">
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
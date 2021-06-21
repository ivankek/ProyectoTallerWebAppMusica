<%@include file="Header.jsp"%>
<div class="container mt-5 text-light mb-5 main">
	<h2 class="text-center">Resultado de tu busqueda:</h2>

	<div class="datos" hidden>${datos}</div>

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
		<ul class="list-group pb-5 mb-5 cancion">
			<c:forEach items="${resultado}" var="cancion">
				<li class="list-group-item bg-dark d-flex justify-content-between">
					<!-- parte A -->
					<div class="d-flex  align-items-center">
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
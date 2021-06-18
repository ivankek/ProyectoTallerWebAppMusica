<%@page import="org.springframework.ui.Model"%>
<%@include file="Header.jsp"%>
<div
	class="container d-flex flex-column justify-content-center mt-5 text-light mb-5 main">

	<%
		if (request.getAttribute("usuario") != null) {
	%>
	<h2 class="text-center">Bienvenido, ${usuario.usuario}.</h2>

	<%
		} else {
	%>
	<h2 class="text-center">Musica mejor puntuada</h2>
	<%
		}
	%>

	<%
		if (request.getAttribute("usuario") != null) {
	%>

	<p>
		<a
			class="container btn btn-info mt-3 d-flex justify-content-center col-3 text-light"
			data-bs-toggle="collapse" href="#collapseExample" role="button"
			aria-expanded="false" aria-controls="multiCollapseExample1">Crear
			una playlist <svg xmlns="http://www.w3.org/2000/svg" width="14"
				height="14" fill="currentColor" class="bi bi-plus-lg ms-2 mt-1"
				viewBox="0 0 16 16">
  <path
					d="M8 0a1 1 0 0 1 1 1v6h6a1 1 0 1 1 0 2H9v6a1 1 0 1 1-2 0V9H1a1 1 0 0 1 0-2h6V1a1 1 0 0 1 1-1z" />
</svg>
		</a>
	</p>
	<div class="collapse" id="collapseExample">
		<div
			class="container bg-dark card card-body d-flex justify-content-center rounded col-3">
			<form action="CrearPlaylist"
				class="container d-flex flex-column justify-content-center">
				<label class="text-center">Nombre de playlist:</label>
				<div class="d-flex mt-3">
					<input
						class="text-light bg-dark rounded border border-1 border-light w-75"
						name="nombrePlaylist" type="text"> <input type="hidden"
						name="usuario" value="${usuario.usuario}"> <input
						class="w-25 text-decoration-none bg-info border-0 ms-1 text-center rounded text-light"
						type="submit" value="Crear">
				</div>
			</form>
		</div>
	</div>

	<%
		}
	%>


	<div class="datos" hidden>${datos}</div>

	<div
		class="mt-5 d-flex justify-content-between  text-light align-items-center">
		<p class="text-info">Foto</p>
		<p class="text-info">Titulo</p>
		<p class="text-info">Album</p>
		<p class="text-info">Opciones</p>
	</div>

	<hr class="mt-0">

	<div class="mt-2">
		<ul class="list-group pb-5 mb-5 cancion">
			<c:forEach items="${canciones}" var="cancion">
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
						<div>3:20</div>
						<div class="material-icons ms-3">more_horiz</div>
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
</body>
</html>
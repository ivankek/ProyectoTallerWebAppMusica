<%@page import="org.springframework.ui.Model"%>
<%@include file="Header.jsp"%>
<body>

	<div class="container d-flex flex-column justify-content-center">

		<!-- Crear Playlist -->


		<%
			if (request.getAttribute("usuario") != null) {
		%>

		<p>
			<a
				class="container btn btn-info mt-5 d-flex justify-content-center col-3 text-light"
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
					<label class="text-center text-light">Nombre de playlist:</label>
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



		<!-- Fin Crear Playlist -->

		<div class="mt-4 d-flex justify-content-center flex-wrap">
			<c:forEach items="${listas}" var="lista">


				<div id="${lista.id}" class="card ms-3 mt-3 border-0 shadow bg-dark"
					style="width: 18rem; border-radius: 0.5em;">
					<div class="card-body">
						<h5 class="card-title text-light mb-3">${lista.nombre}</h5>
						<!-- <p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p> -->
						<a href="#" class="card-link text-decoration-none text-info">Ver
							canciones</a> <a href="#"
							class="card-link text-decoration-none text-danger">Eliminar</a>
					</div>

				</div>
			</c:forEach>
		</div>
	</div>

	<!-- Scripts -->
	<script src="js/bootstrap.min.js"></script>
	<script src="js/json.js"></script>
</body>

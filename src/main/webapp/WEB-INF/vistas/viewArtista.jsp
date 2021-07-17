<%@include file="HeaderArtista.jsp"%>
<!-- Main -->
<div class="container-fluid main pb-4" style="margin-bottom: 2.7em;">
	<div class="row">
		<!-- SIDEBAR -->
		<!-- Contenido Principal -->

		<style>
@media ( min-width : 768px) {
	#imagen {
		top: 0;
		position: fixed;
		top: 0;
		z-index: 0;
		position: fixed;
		position: fixed;
	}
	#divImagen {
		height: 32em;
	}
	#Titulo {
		font-weight: bold;
		font-size: 90pt;
	}
}

@media ( max-width : 768px) {
	#imagen {
		position: fixed;
		top: 0;
		z-index: 0;
		position: fixed;
	}
	#divImagen {
		height: 20em;
	}
	#Titulo {
		font-weight: bold;
		font-size: 60pt;
	}
}


@media ( max-width : 500px) {
	#imagen {
		position: fixed;
		top: 0;
		z-index: 0;
		position: fixed;
	}
	#divImagen {
		height: 15em;
	}
	#Titulo {
		font-weight: bold;
		font-size: 30pt;
	}


@media ( max-width : 400px) {
	#imagen {
		position: fixed;
		top: 0;
		z-index: 0;
		position: fixed;
	}
	#divImagen {
		height: 12em;
	}
	#Titulo {
		font-weight: bold;
		font-size: 30pt;
	}
}
</style>

		<div class="col bg-dark p-0">
			<!-- parte A -->
			<div id="divImagen" class="card bg-dark text-white">


				<img id="imagen" src="${artista.path_img_portada}" class="card-img"
					alt="...">


				<div class="p-0 d-flex flex-wrap position-absolute bottom-0 start-0 ms-5"
					style="text-shadow: 2px 2px 6px rgba(0, 0, 0, 0.6);">


					<p class="card-title fw-bolder me-4" id="Titulo">${artista.nombre}</p>

					<%
						if (request.getAttribute("usuario") != null) {
					%>
					<button type="submit"
						class="btn btn-info text-light align-self-center mt-0 mt-md-5 me-3"
						id="botonFollow"></button>
					<%
						}
					%>

					<p class="d-flex justify-content-end fs-3 card-text align-self-center mt-0 mt-md-5">Seguidores: ${seguidores}</p>

				</div>
			</div>

			<div class="datos" hidden>${datos}</div>

			<ul class="list-group" style="z-index: 1;">
				<c:forEach items="${canciones}" var="cancion">
					<li class="cancion list-group-item bg-dark d-flex"
						id="cancion${cancion.id}">
						<!-- parte A -->
						<div class="col-7 d-flex align-items-center">
							<i class="material-icons text-white me-3 icon-play"
								name="${cancion.nombre}">play_circle_outline</i>
							<div class="flex-shrink-0">
								<img src="${cancion.album.path_img}"
									style="width: 50px; height: 50px" alt="...">
							</div>
							<div class="flex-grow-1 ms-3 text-white info-cancion">
								<h5 class="mt-0 mb-0 titulo-cancion">${cancion.nombre}</h5>
								<a class="text-decoration-none text-light" href="">${cancion.artista.nombre}</a>
							</div>
						</div> <!-- parte B -->
						<div class="col-3 text-white d-flex align-items-center">
							<a class="text-decoration-none text-light"
								href="http://localhost:8080/proyecto-limpio-spring-master/Album?nombre=${cancion.album.nombre}">${cancion.album.nombre}</a>
						</div> <!-- parte C -->
						<div
							class="col text-white d-flex align-items-center justify-content-end">
							<div hidden class="material-icons fav-icon"></div>
							<div class="ps-3 pe-2">3:20</div>
							<div class="material-icons">more_horiz</div>
						</div>
					</li>
				</c:forEach>
			</ul>

		</div>

	</div>
</div>
<%@include file="queue.jsp"%>
<%@include file="reproductor.jsp"%>
<!-- Scripts -->
<script src="js/bootstrap.min.js"></script>
<script src="js/json.js"></script>
<script src="js/peticiones.js"></script>
</body>
</html>
<%@page import="org.springframework.ui.Model"%>
<%@include file="Header.jsp"%>
<!-- Main -->
<div class="container-fluid main pb-4 mb-5">
	<div class="row">

		<!-- Contenido Principal -->
		<div class="col bg-dark bg-gradient p-5">

			<%
				if (request.getAttribute("usuario") != null) {
			%>
			<h2 class="text-center text-light mb-3">Bienvenido,
				${usuario.usuario}.</h2>
			<%
				}
			%>

			<!--Artistas Recomendados -->
			<h2 class="text-white">Artistas recomendados para vos</h2>
			<c:choose>
				<c:when test="${!condicion}">
					<div class="row row-cols-1 row-cols-md-5 g-4">
						<c:forEach items="${recomendaciones}" var="recomendacion">
							<div class="col">
								<div class="card h-100 bg-dark text-white">
									<img src="${recomendacion.path_img}" class="card-img-top"
										alt="nombrealbum">
									<div class="card-body">
										<h6 class="card-title">${recomendacion.nombre}</h6>
										<p class="card-text">Artista</p>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</c:when>
				<c:otherwise>
					<h6>Por lo menos añadi a favoritos una cancion para poder
						recomendarte artistas.</h6>
				</c:otherwise>
			</c:choose>

			<!-- Top 5 MEJOR VALORADAS -->
			<h2 class="text-white">Top 5 Canciones</h2>
			<div class="row row-cols-1 row-cols-md-5 g-4">
				<c:forEach items="${canciones}" var="cancion">
					<div class="col">
						<div class="card h-100 bg-dark text-white">
							<img src="${cancion.album.path_img}" class="card-img-top"
								alt="nombrealbum">
							<div class="card-body">
								<h6 class="card-title">${cancion.nombre}</h6>
								<p class="card-text">${cancion.album.nombre}</p>
								<div class="d-flex">
									<a class="card-text"
										href="Artista?nombre=${cancion.artista.nombre}">${cancion.artista.nombre}</a>


									<%
										if (request.getAttribute("usuario") != null) {
									%>
									<div class="dropdown dropup position-absolute end-0 me-2">
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

							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>

	</div>
</div>
<%@include file="queue.jsp"%>
<%@include file="reproductor.jsp"%>
<!-- Scripts -->
<script src="js/bootstrap.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
	crossorigin="anonymous"></script>
<script src="js/json.js"></script>
</body>
</html>
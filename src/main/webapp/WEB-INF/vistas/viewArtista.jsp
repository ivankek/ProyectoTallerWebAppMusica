<%@include file="Header.jsp"%>
<!-- Main -->
<div class="container-fluid main pb-4 mb-5">
	<div class="row">
		<!-- SIDEBAR -->
		<%@include file="sidebar.jsp"%>
		<!-- Contenido Principal -->
		<div class="col bg-dark bg-gradient p-0">
			<!-- parte A -->
			<div class="card bg-dark text-white" style="height: 332px;">
  				<img src="${artista.path_img}" class="card-img h-100" alt="...">
  				<div class="card-img-overlay">
    				<h2 class="card-title fw-bolder" id="Titulo">${artista.nombre}</h2>
    				<p class="card-text">Artista</p>
    				<p class="card-text">${seguidores} seguidores</p>
  				</div>
			</div>
			<%
		if (request.getAttribute("usuario") != null) {
			%>	
				<button type="submit" class="btn btn-info text-light" id="botonFollow"></button>
	<% 
		}
	%>
			<div class="datos" hidden>${datos}</div>

			<ul class="list-group">
				<c:forEach items="${canciones}" var="cancion">	
					<li class="cancion list-group-item bg-dark d-flex justify-content-between" id="cancion${cancion.id}">
					<!-- parte A -->
						<div class="d-flex  align-items-center">
							<i class="material-icons text-white me-3 icon-play"  name="${cancion.nombre}">play_circle_outline</i>
							<div class="flex-shrink-0">
								<img src="${cancion.album.path_img}" style="width: 64px; height: 64px" alt="...">
							</div>
							<div class="flex-grow-1 ms-3 text-white info-cancion">
								<h5 class="mt-0 titulo-cancion">${cancion.nombre}</h5>
								<a href="">${cancion.artista.nombre}</a>
							</div>
						</div> 
						<!-- parte B -->
						<div class="text-white d-flex align-items-center">
							<a href="http://localhost:8080/proyecto-limpio-spring-master/Album?nombre=${cancion.album.nombre}">${cancion.album.nombre}</a>
						</div>
						<!-- parte C -->
						<div class="text-white d-flex align-items-center">
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
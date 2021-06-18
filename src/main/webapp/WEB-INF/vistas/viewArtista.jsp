<%@include file="Header.jsp"%>
<!-- Main -->
<div class="container-fluid main pb-4 mb-5">
	<div class="row">
		<!-- SIDEBAR -->
		<%@include file="sidebar.jsp"%>
		<!-- Contenido Principal -->
		<div class="col bg-dark bg-gradient p-0">
			<!-- parte A -->
			<div class="card bg-dark text-white h-50">
  				<img src="${artista.path_img}" class="card-img h-100" alt="...">
  				<div class="card-img-overlay">
    				<h2 class="card-title fw-bolder">${artista.nombre}</h2>
    				<p class="card-text">Artista</p>
  				</div>
			</div>
			
			<form:form class="" action="FollowArtista" method="GET" modelAttribute="artista">
				<button type="button" class="btn btn-info text-light" name="botonFollow" id="botonFollow" onclick="FbotonFollow()"> Seguir </button>
				<input type="hidden" name="artista" value="${cancion.artista.nombre}">
			</form:form>
		</div>
	</div>
</div>
<%@include file="queue.jsp"%>
<%@include file="reproductor.jsp"%>
<!-- Scripts -->
<script src="js/bootstrap.min.js"></script>
<script src="js/json.js"></script>
<script src="js/follow.js"></script>
</body>
</html>
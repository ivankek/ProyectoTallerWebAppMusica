<%@include file="Header.jsp"%>
<!-- Main -->
<div class="container-fluid main pb-4 mb-5">
	<div class="row">
		<!-- SIDEBAR -->
		<div class="col-2">
			<ul class="nav nav-pills flex-column mb-auto pt-2">
      			<li class="nav-item">
        			<a href="#" class="nav-link text-success d-flex p-0">
          				<i class="material-icons">home</i>
          				<p class="ps-1">Inicio</p>
       				 </a>
      			</li>
      			<li class="nav-item">
        			<a href="#" class="nav-link text-white d-flex p-0">
          				<i class="material-icons">video_library</i>
          				<p class="ps-1">Tu biblioteca</p>
        			</a>
      			</li>
            	<li class="nav-item">
        			<a href="#" class="nav-link text-white d-flex p-0">
          				<i class="material-icons">playlist_add</i>
          				<p class="ps-1">Crear lista</p>
        			</a>
      			</li>
            	<li class="nav-item">
        			<a href="#" class="nav-link text-white d-flex p-0">
          				<i class="material-icons">favorite</i>
          				<p class="ps-1">Canciones que te gustan</p>
        			</a>
      			</li>
    		</ul>
    		<hr class="text-white">
    		<div>Traer playlist que sigue el usuario</div>
		</div>
		<!-- Contenido Principal -->
		<div class="col bg-dark bg-gradient">
			
			<!--Artistas Recomendados -->
			<h2 class="text-white">Artistas recomendados para vos</h2>
			<c:choose>
			<c:when test="${!condicion}">
			<div class="row row-cols-1 row-cols-md-5 g-4">
  			<c:forEach items="${recomendaciones}" var="recomendacion">	
  				<div class="col">
    				<div class="card h-100 bg-dark text-white">
      					<img src="${recomendacion.pathImg}" class="card-img-top" alt="nombrealbum">
      					<div class="card-body">
        					<h6 class="card-title">${recomendacion.nombre}</h6>
        					<p class="card-text">Artista</p>
      					</div>
    				</div>
    			</div>	
    		</c:forEach>	
  			</div>
  			</c:when>
  			<c:otherwise><h6>Por lo menos añadi a favoritos una cancion para poder recomendarte artistas.</h6></c:otherwise>
  			</c:choose>
  			
			<!-- Top 5 MEJOR VALORADAS -->
			<h2 class="text-white">Top 5 Canciones</h2>
			<div class="row row-cols-1 row-cols-md-5 g-4">
  			<c:forEach items="${canciones}" var="cancion">	
  				<div class="col">
    				<div class="card h-100 bg-dark text-white">
      					<img src="${cancion.album.path_img}" class="card-img-top" alt="nombrealbum">
      					<div class="card-body">
        					<h6 class="card-title">${cancion.nombre}</h6>
        					<p class="card-text">${cancion.album.nombre}</p>
        					<p class="card-text">${cancion.artista.nombre}</p>
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
<script src="js/json.js"></script>
</body>
</html>
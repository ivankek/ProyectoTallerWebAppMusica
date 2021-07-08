<%@include file="Header.jsp"%>
<!-- Main -->
<div class="container-fluid main pb-4 mb-5">
	<div class="row">
		<!-- SIDEBAR -->
		<%@include file="sidebar.jsp"%>
		<!-- Contenido Principal -->
		<div class="col bg-dark bg-gradient p-0">	
			<div id = "nombrePlaylistContenedor" class = "mt-3">
				<h2 class = "text-white">Nombre de tu Playlist</h2> 
				<input id = "nombrePlaylist" type = "text" class = "form-control w-25">
				<button id = "btn-siguiente" type="button" class="btn btn-primary mt-3">Siguiente</button>
			</div>
			
			
			<div id="buscadorContenedor" class = "mt-3" hidden>
				<h2 class = "text-white">Busca canciones para tu Playlist</h2>
  				<input id = "buscador" class="typeahead form-control" type="text" placeholder="Busca canciones">
  				<button id = "btn-anadir" type="button" class="btn btn-primary mt-3">Añadir</button>
			</div>
		</div>
	</div>
</div>
<%@include file="queue.jsp"%>
<%@include file="reproductor.jsp"%>
<!-- Scripts -->
<script src="js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
 <script src="https://twitter.github.io/typeahead.js/releases/latest/typeahead.bundle.js"></script>
<script src="js/playlist.js"></script>
</body>
</html>
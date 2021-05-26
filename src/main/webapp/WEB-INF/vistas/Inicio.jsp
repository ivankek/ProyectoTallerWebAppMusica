<%@include file="Header.jsp"%>
	<div class="container mt-5 text-light mb-5">
		<h2 class="text-center">Tus Canciones</h2>
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
			<ul class="list-group mb-5" id="playlist">
			<c:forEach items="${canciones}" var="cancion">
				<li class="list-group-item bg-dark" id="${cancion.id}" name="${cancion.path_cancion}" 
					style="border-radius: 1em; margin-bottom: 2px;">
				<div class="song-info d-flex justify-content-between text-light align-items-center p-3">
					<img style="width: 3em" src="${cancion.album.path_img}" onclick="setSong(event)" alt="">
					<p class="fs-5">${cancion.nombre}</p>
					<p class="fs-5">${cancion.artista.nombre}</p>
					<a href="Album?nombre=${cancion.album.nombre}" class="fs-5">${cancion.album.nombre}</a>
					<div class="material-icons ms-3">more_horiz</div>
              	</div>
				</li>
			</c:forEach>
			</ul>
		</div>
	</div>

<%@include file="reproductor.jsp"%>
	<!-- Scripts -->>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/reproductorFooter.js"></script>
</body>
</html>
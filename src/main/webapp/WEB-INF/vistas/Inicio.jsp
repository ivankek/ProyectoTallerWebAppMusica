<%@include file="Header.jsp"%>
	<div class="container mt-5 text-light mb-5 main">
		<h2 class="text-center">Tus Canciones</h2>
		
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
<<<<<<< HEAD
		<div class="mt-2" style="margin-bottom: 8em;">
			<ul class="list-group mb-5" id="playlist">
			<c:forEach items="${canciones}" var="cancion">
				<li class="list-group-item bg-dark" id="${cancion.id}" name="${cancion.path_cancion}" 
					style="border-radius: 1em; margin-bottom: 2px;">
				<div class="song-info d-flex justify-content-between text-light align-items-center">
					<img style="width: 3em" src="${cancion.album.path_img}" onclick="setSong(event)" alt="">
					<p class="fs-5">${cancion.nombre}</p>
					<p class="fs-5">${cancion.artista.nombre}</p>
					<a href="Album?nombre=${cancion.album.nombre}" class="fs-5">${cancion.album.nombre}</a>
					<div class="material-icons ms-3">more_horiz</div>
              	</div>
=======
		
		<div class="mt-2">
			<ul class="list-group pb-5 mb-5 cancion">
			<c:forEach items="${canciones}" var="cancion">
				<li class="list-group-item bg-dark d-flex justify-content-between">
					<!-- parte A -->
					<div class="d-flex  align-items-center">
						<i class="material-icons text-white me-3 icon-play"  name="${cancion.nombre}">play_circle_outline</i>
						<div class="flex-shrink-0">
							<img src="${cancion.album.path_img}" style="width: 64px; height: 64px" alt="...">
						</div>
						<div class="flex-grow-1 ms-3 text-white">
							<h5 class="mt-0">${cancion.nombre}</h5>
							<p>${cancion.artista.nombre}</p>
						</div>
					</div> 
					<!-- parte B -->
					<div class="text-white d-flex align-items-center">
						<a href="http://localhost:8080/proyecto-limpio-spring-master/Album?nombre=${cancion.album.nombre}">${cancion.album.nombre}</a>
					</div> 
					<!-- parte C -->
					<div class="text-white d-flex align-items-center">
						<div>3:20</div>
						<div class="material-icons ms-3">more_horiz</div>
					</div>
>>>>>>> master
				</li>
			</c:forEach>
			</ul>
		</div>
	</div>
<%@include file="queue.jsp"%>
<%@include file="reproductor.jsp"%>
	<!-- Scripts -->>
	<script src="js/bootstrap.min.js"></script>
	<script src = "js/json.js"></script>
</body>
</html>
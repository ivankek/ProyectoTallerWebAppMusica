<%@include file="Header.jsp"%>
<body>

	<div class="container mt-5 text-light mb-5">
		<h2 class="text-center mb-5">Resultado de tu busqueda:</h2>
		<div
			class="mt-5 d-flex justify-content-between  text-light align-items-center">
			<p class="text-info">Foto</p>
			<p class="text-info">Titulo</p>
			<p class="text-info">Artista</p>
			<p class="text-info">Album</p>
			<p class="text-info">Opciones</p>
		</div>
		<hr class="mt-0">
		
		<!-- Busqueda canciones por genero -->
		
		<ul class="list-group" id="playlist">
			<c:forEach items="${generos}" var="genero">
				<li>${genero.nombre}</li>
			</c:forEach>

			<!-- Busqueda canciones por artista -->

			<c:forEach items="${artistas}" var="artista">
				<!-- <li>${artista.nombre}</li> -->
				<li class="list-group-item bg-dark" id="${artista.id}"
					name="${artista.path_cancion}"
					style="border-radius: 1em; margin-bottom: 2px;">
					<div
						class="d-flex justify-content-between text-light align-items-center">
						<img style="width: 3em" src="${artista.album.path_img}" alt="">
						<p class="fs-5">${artista.nombre}</p>
						<p class="fs-5">${artista.artista.nombre}</p>
						<p class="fs-5">${artista.album.nombre}</p>
						<a href=""><svg xmlns="http://www.w3.org/2000/svg" width="20"
								height="20" fill="currentColor"
								class="bi bi-three-dots text-decoration-none"
								style="color: whitesmoke;" viewBox="0 0 16 16">
                <path
									d="M3 9.5a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3zm5 0a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3zm5 0a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3z" />
              </svg> </a>

					</div>
				</li>
			</c:forEach>


			<!-- Busqueda canciones por album -->
			<c:forEach items="${albums}" var="album">
				<!-- 	<li>${album.nombre}</li> -->
				<li class="list-group-item bg-dark" id="${album.id}"
					name="${album.path_cancion}"
					style="border-radius: 1em; margin-bottom: 2px;">
					<div
						class="d-flex justify-content-between text-light align-items-center">
						<img style="width: 3em" src="${album.album.path_img}" alt="">
						<p class="fs-5">${album.nombre}</p>
						<p class="fs-5">${album.artista.nombre}</p>
						<p class="fs-5">${album.album.nombre}</p>
						<a href=""><svg xmlns="http://www.w3.org/2000/svg" width="20"
								height="20" fill="currentColor"
								class="bi bi-three-dots text-decoration-none"
								style="color: whitesmoke;" viewBox="0 0 16 16">
                <path
									d="M3 9.5a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3zm5 0a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3zm5 0a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3z" />
              </svg> </a>

					</div>
				</li>
			</c:forEach>


			<!-- Busqueda canciones por lista de reproduccion -->
			<c:forEach items="${listas}" var="lista">
				<li>${lista.nombre}</li>
			</c:forEach>


			<!-- Busqueda canciones por nombre de cancion -->

			<c:forEach items="${canciones}" var="cancion">
				<li class="list-group-item bg-dark" id="${cancion.id}"
					name="${cancion.path_cancion}"
					style="border-radius: 1em; margin-bottom: 2px;">
					<div
						class="d-flex justify-content-between text-light align-items-center">
						<img style="width: 3em" src="${cancion.album.path_img}" alt="">
						<p class="fs-5">${cancion.nombre}</p>
						<p class="fs-5">${cancion.artista.nombre}</p>
						<p class="fs-5">${cancion.album.nombre}</p>
						<a href=""><svg xmlns="http://www.w3.org/2000/svg" width="20"
								height="20" fill="currentColor"
								class="bi bi-three-dots text-decoration-none"
								style="color: whitesmoke;" viewBox="0 0 16 16">
                <path
									d="M3 9.5a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3zm5 0a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3zm5 0a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3z" />
              </svg> </a>

					</div>
				</li>

			</c:forEach>
		</ul>
		<audio class="fixed-bottom w-100" id="player" controls></audio>
	</div>


	<!-- Scripts -->
	<script src="js/jquery-1.11.3.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="https://kit.fontawesome.com/1776a9f4e1.js"
		crossorigin="anonymous"></script>
	<script src="js/reproductor.js"></script>
</body>
</html>
<%@include file="Header.jsp"%>
<body>
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
		<div class="mt-2" style="margin-bottom: 8em;">


			<ul class="list-group" id="playlist">
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
		</div>
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
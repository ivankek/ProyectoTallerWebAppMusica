<%@page import="org.springframework.ui.Model"%>
<%@include file="Header.jsp"%>
<body class="bg-dark bg-gradient">
<div class="container mt-5 text-light mb-5 main">
	
	<div class="container d-flex flex-column mb-3 ${ocultar4}">
		<div class="align-self-center border border-1 border-dark"
			 style="box-shadow: rgba(0, 0, 0, 0.56) 0px 22px 70px 4px;">
			<div class="d-flex">
				<img style="width: 8em; height: 8em;" alt="" src="${imagenesLista}">
				<img style="width: 8em; height: 8em;" alt="" src="${imagenesLista2}">
			</div>
			<div class="d-flex">
				<img style="width: 8em; height: 8em;" alt=""
					 src="${imagenesLista3}"> <img
					 style="width: 8em; height: 8em;" alt="" src="${imagenesLista4}">
			</div>			
		</div>
	</div>
	
	<div class="container d-flex flex-column mb-3 ${ocultar1}">
		<div class="align-self-center border border-1 border-dark"
			 style="box-shadow: rgba(0, 0, 0, 0.56) 0px 22px 70px 4px;">
			<div class="d-flex">
				<img style="width: 16em; height: 16em;" alt="" src="${imagenesLista}">
			</div>
		</div>
	</div>
	
	<div class="d-flex flex-column justify-content-center align-self-center mb-4">
		<h5 class="mb-0 mt-3 mt-md-0 text-center">Playlist</h5>
		<p class="text-center mb-0 fs-1 fw-bolder">${Playlist.nombre}</p>
		<a class="text-decoration-none align-self-center text-light mb-2 ms-2">${tamañoLista}canciones</a>
		<div class="d-flex align-self-center">
			<div class="d-flex">
				<a class="text-decoration-none align-self-center text-light ms-2 text-center">Creadapor&nbsp&nbsp</a> 
				<img class="rounded-circle border-dark"
					 style="width: 2em; height: 2em; box-shadow: rgba(0, 0, 0, 0.56) 0px 22px 70px 4px;"
					 alt="" src="${usuarioPlaylist.path_img}"> 
				<a class="text-decoration-none align-self-center text-light fs-5 ms-2 text-center"
				   href="http://localhost:8080/proyecto-limpio-spring-master/Usuario?nombre=${usuarioPlaylist.usuario}">${usuarioPlaylist.usuario}</a>
			</div>
		</div>

		<button type="submit" id="botonFollow"
			    class="btn btn-info text-light align-self-center mt-3 ${boton}" 
			    onclick="FbotonFollow()">Seguir</button>

		<table class="table table-dark table-hover mt-4" style="margin-bottom: 10em;">
			<tbody>
				<c:forEach items="${cancionesLista}" var="cancion">
					<tr>
						<th scope="row">
							<i class="material-icons mt-3 text-white me-3 icon-play"
						       name="${cancion.nombre}">play_circle_outline</i>
						</th>
						<td>
							<div class="d-flex align-items-center">
								<div class="flex-shrink-0">
									<img src="${cancion.album.path_img}" style="width: 50px; height: 50px" alt="...">
								</div>
								<div class="flex-grow-1 ms-3 text-white">
									<h5 class="mt-0 mb-0">${cancion.nombre}</h5>
									<a id="nombreArtista" class="text-decoration-none text-light"
								       href="./Artista?nombre=${cancion.artista.nombre}">${cancion.artista.nombre}</a>
								</div>
							</div>
						</td>
						<td>
							<div class="text-white d-flex align-items-end mt-3">
								<a id="nombreAlbum" class="text-decoration-none text-light"
							       href="./Album?nombre=${cancion.album.nombre}">${cancion.album.nombre}</a>
							</div>
						</td>
						<td class="d-none d-md-block">
							<div class="text-white d-flex align-items-center" style="margin-top: 0.8em;">
								<div class="me-4">3:20</div>
								<div class="dropdown dropstart">
									<a href='#' role='button' id='dropdownMenuLink'
							           data-bs-toggle='dropdown' aria-expanded='false'>
							    		<div class="material-icons"
								             style="margin-top: 0.2em; color: white;">more_horiz</div>
									</a>
									<ul class="dropdown-menu" aria-labelledby='dropdownMenuLink'>
										<c:forEach items="${listas}" var="lista">
											<li id="${lista.id}"><a class='dropdown-item' href='#'>${lista.nombre}</a></li>
										</c:forEach>
									</ul>
								</div>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<%@include file="queue.jsp"%>
<%@include file="reproductor.jsp"%>
<!-- Scripts -->
<script src="js/bootstrap.min.js"></script>
<script src="js/reproductor.js"></script>
</body>
</html>

<%@page import="org.springframework.ui.Model"%>
<%@include file="Header.jsp"%>
<body class="bg-dark bg-gradient">

	<div class="container mt-5 text-light mb-5 main">
		<div class="datos" hidden>${datos}</div>

		<div class="container d-flex flex-column mb-3 ${ocultar4}">

			<div class="align-self-center border border-1 border-dark"
				style="box-shadow: rgba(0, 0, 0, 0.56) 0px 22px 70px 4px;">
				<div class="d-flex">
					<img style="width: 8em; height: 8em;" alt="" src="${imagenesLista}">
					<img style="width: 8em; height: 8em;" alt=""
						src="${imagenesLista2}">

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
					<img style="width: 16em; height: 16em;" alt=""
						src="${imagenesLista}">
				</div>
			</div>
		</div>

		<h4 class="text-center mb-5">${Playlist.nombre}</h4>

		<ul class="list-group pb-5 mb-5">
			<c:forEach items="${cancionesLista}" var="cancion">
				<li class="list-group-item bg-dark d-flex justify-content-between"
					id="cancion${cancion.id}">
					<!-- parte A -->
					<div class="d-flex  align-items-center">
						<i class="material-icons text-white me-3 icon-play"
							name="${cancion.nombre}">play_circle_outline</i>
						<div class="flex-shrink-0">
							<img src="${cancion.album.path_img}"
								style="width: 64px; height: 64px" alt="...">
						</div>
						<div class="flex-grow-1 ms-3 text-white">
							<h5 class="mt-0">${cancion.nombre}</h5>
							<a
								href="http://localhost:8080/proyecto-limpio-spring-master/Artista?nombre=${cancion.artista.nombre}">${cancion.artista.nombre}</a>
						</div>
					</div> <!-- parte B -->
					<div class="text-white d-flex align-items-center">
						<a
							href="http://localhost:8080/proyecto-limpio-spring-master/Album?nombre=${cancion.album.nombre}">${cancion.album.nombre}</a>
					</div> <!-- parte C -->
					<div class="text-white d-flex align-items-center">
						<div>3:20</div>
						<div class="material-icons ms-3">more_horiz</div>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>

	<!-- Scripts -->
	<script src="js/bootstrap.min.js"></script>
	<script src="js/json.js"></script>
</body>

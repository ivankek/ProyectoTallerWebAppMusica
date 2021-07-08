<%@include file="Header.jsp"%>
<!-- Main -->
<div class="container-fluid main pb-4 mb-5">
	<div class="row">
		<!-- SIDEBAR -->
		<%@include file="sidebar.jsp"%>
		<!-- Contenido Principal -->
		<div class="col bg-dark bg-gradient">

			<div
				class="d-flex flex-row justif-content-between flex-wrap px-5 pt-5 pb-4">

				<div class="d-flex flex-column flex-wrap mb-5 mb-md-0 col-md-5">

					<div class="d-flex">

						<div>
							<img class="rounded-circle shadow"
								style="width: 12em; height: 12em;" alt="" src="${foto}">

							<div
								class="container d-flex justify-content-center mt-3">
								<form action="${Action}">
									<input type="hidden" name="user" value="${user.id}">

									<button type="submit" id="botonFollow"
										class="btn btn-info text-light" onclick="FbotonFollow()">${Boton}</button>

								</form>
								<a> <svg xmlns="http://www.w3.org/2000/svg" width="35"
										height="35" style="color: white;" fill="currentColor"
										class="bi bi-three-dots ms-3 align-self-end"
										viewBox="0 0 16 16">
  			<path
											d="M3 9.5a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3zm5 0a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3zm5 0a1.5 1.5 0 1 1 0-3 1.5 1.5 0 0 1 0 3z" />
			</svg>
								</a>
							</div>

						</div>

						<div class="text-light align-self-start mt-3 ms-4">
							<h5 class=text-info>Usuario</h5>
							<h1>${user.usuario}</h1>
							<p class="fs-5 mb-2 text-info">Seguidores</p>
							<hr class="mt-0 mb-2" style="color: aqua;">
							<h5 class="text-center mt-0">${seguidoresUsuario}</h5>
						</div>

					</div>


				</div>

				<div class="d-flex align-self-center">
					<div class="text-light">
						<h5 class="text-info">Playlist seguidas</h5>
						<hr style="color: aqua;">
						<h5 class="text-center">${seguidosPlaylist}</h5>
					</div>

					<div class="text-light ms-4">
						<h5 class="text-info">Artistas seguidos</h5>
						<hr style="color: aqua;">
						<h5 class="text-center">${seguidosArtistas}</h5>
					</div>

					<div class="text-light ms-4">
						<h5 class="text-info">Usuarios seguidos</h5>
						<hr style="color: aqua;">
						<h5 class="text-center">${seguidosUsuarios}</h5>
					</div>
				</div>
			</div>

			<div class="bg-dark bg-gradient mt-4 pt-5 pb-5 w-100">
				<div>
					<h3 class="text-light ms-2 text-center mb-4">Playlist creadas
						por el usuario:</h3>



					<div class="d-flex justify-content-around flex-wrap">

						<c:forEach items="${listas}" var="lista">

							<div id="" class="card mt-3 border-0 shadow bg-dark"
								style="width: 18rem; border-radius: 0.5em;">
								<div class="card-body">
									<h5 class="card-title text-light mb-3">${lista.nombre}</h5>
									<!-- <p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p> -->
									<form action="FollowPlaylist">
						<input type="hidden" name="playlist" value="${lista.id}">
						<button type="submit"
							class="card-link p-2 rounded border-0 btn-info text-light text-decoration-none text-primary"
							id="botonFollow" onclick="FbotonFollow()">Seguir</button>

					</form>

</div>
</div>
						</c:forEach>


					</div>
				</div>
			</div>
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
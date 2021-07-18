<div class="offcanvas offcanvas-start bg-light" tabindex="-1"
	id="offcanvasExample">
	<div
		class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark h-100 w-100">
		<div class="offcanvas-header">
			<h5 class="offcanvas-title text-info" id="offcanvasExampleLabel">Hola
				${usuario.usuario}!</h5>
			<button type="button" class="btn-close btn-close-white text-reset"
				data-bs-dismiss="offcanvas" aria-label="Close"></button>
		</div>
		<hr />

		<style>
#botones:hover {
	background: #0c63e4;
}
</style>

		<ul class="nav nav-pills flex-column mb-auto">
			<ul class="nav nav-pills flex-column mb-auto pt-2">
				<li class="nav-item"><a href="Inicio" id="botones"
					class="nav-link text-white d-flex align-items-center"
					aria-current="page"><i class="material-icons pe-2">home</i>Inicio</a></li>

				<li class="nav-item"><a
					href="Usuario?nombre=${usuario.usuario}" id="botones"
					class="nav-link text-white d-flex align-items-center"
					aria-current="page"><i class="material-icons pe-2"><span
							class="material-icons"> account_circle </span></i>Mi perfil</a></li>

				<li class="nav-item"><a href="MisPlaylist" id="botones"
					class="nav-link text-white d-flex align-items-center"
					aria-current="page"><i class="material-icons pe-2">playlist_add</i>Mis
						Playlist</a></li>

				<li class="nav-item"><a href="#" id="botones"
					class="nav-link text-white d-flex align-items-center"
					aria-current="page"><i class="material-icons pe-2">favorite</i>Canciones
						que te gustan</a></li>

				<li class="nav-item"><a href="viewArtistasSeguidos"
					id="botones" class="nav-link text-white d-flex align-items-center"
					aria-current="page"><i class="material-icons pe-2">people</i>Artistas
						que sigo</a></li>

				<li class="nav-item"><a href="viewExplorarTodo" id="botones"
					class="nav-link text-white d-flex align-items-center"
					aria-current="page"><i class="material-icons pe-2">search</i>Explorar
						todo</a></li>

			</ul>
			<hr class="text-white">
			<div>Traer playlist que sigue el usuario</div>
		</ul>
		<hr />
		<div class="dropdown">
			<a href="#"
				class="
          d-flex
          align-items-center
          text-white text-decoration-none
          dropdown-toggle
        "
				id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
				<img src="${usuario.path_img}" alt="" width="32" height="32"
				class="rounded-circle me-2" /> <strong>${usuario.usuario}</strong>
			</a>
			<ul class="dropdown-menu dropdown-menu-dark text-small shadow"
				aria-labelledby="dropdownUser1">
				<!-- <li><a class="dropdown-item" href="#">New project...</a></li>
				<li><a class="dropdown-item" href="#">Settings</a></li>
				<li><a class="dropdown-item" href="#">Profile</a></li>
				<li>
					<hr class="dropdown-divider" />
				</li> -->
				<li><a class="dropdown-item" href="cerrarSesion">Log out</a></li>
			</ul>
		</div>
	</div>
</div>
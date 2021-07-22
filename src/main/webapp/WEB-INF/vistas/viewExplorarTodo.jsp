<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@include file="Header.jsp"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="<c:url value="/css/style.css" />" rel="stylesheet">
<title>Explorar todo</title>
</head>
<body>

<br>
<h2 class="text-white text-center">Explorar Todo</h2><br>
<div class="row row-cols-1 row-cols-md-5 g-4"><br>

		<!-- Card Artista -->
		<div class="container d-flex flex-column mb-3">
			<div
				class="align-self-center align-self-md-start card mb-3 mt-3 border-0 shadow bg-dark"
				style="width: 15rem; border-radius: 0.5em;">
				<div class="card-body align-self-center">
					<img class="rounded"
						style="width: 6em; height: 6em; object-fit: cover; box-shadow: rgba(0, 0, 0, 0.56) 0px 22px 70px 4px;"
						alt="" src="img/Artista/ac_dc.jpg">
						<img class="rounded"
						style="width: 6em; height: 6em; object-fit: cover; box-shadow: rgba(0, 0, 0, 0.56) 0px 22px 70px 4px;"
						alt="" src="img/Artista/foo_fighters.jpg">
						<img class="rounded"
						style="width: 6em; height: 6em; object-fit: cover; box-shadow: rgba(0, 0, 0, 0.56) 0px 22px 70px 4px;"
						alt="" src="img/Artista/michael_jackson.jpg">
						<img class="rounded"
						style="width: 6em; height: 6em; object-fit: cover; box-shadow: rgba(0, 0, 0, 0.56) 0px 22px 70px 4px;"
						alt="" src="img/Artista/kiss.jpg">
					<h5 class="text-center text-light mt-3 mb-3">Artistas</h5>
					<div class="d-flex justify-content-center">
						<a href="http://localhost:8080/ProyectoTallerWebAppMusica/viewExplorarTodosLosArtistas"
							class="card-link text-decoration-none text-info">Ver Artistas</a>
					</div>
				</div>
			</div>
		</div>
		
		<!-- Card Album -->
		<div class="container d-flex flex-column mb-3">
			<div
				class="align-self-center align-self-md-start card mb-3 mt-3 border-0 shadow bg-dark"
				style="width: 15rem; border-radius: 0.5em;">
				<div class="card-body align-self-center">
					<img class="rounded"
						style="width: 6em; height: 6em; object-fit: cover; box-shadow: rgba(0, 0, 0, 0.56) 0px 22px 70px 4px;"
						alt="" src="img/Album/Dynasty.jpg">
						<img class="rounded"
						style="width: 6em; height: 6em; object-fit: cover; box-shadow: rgba(0, 0, 0, 0.56) 0px 22px 70px 4px;"
						alt="" src="img/Album/Thriller.jpg">
						<img class="rounded"
						style="width: 6em; height: 6em; object-fit: cover; box-shadow: rgba(0, 0, 0, 0.56) 0px 22px 70px 4px;"
						alt="" src="img/Album/MedicineAtMidnight.jpg">
						<img class="rounded"
						style="width: 6em; height: 6em; object-fit: cover; box-shadow: rgba(0, 0, 0, 0.56) 0px 22px 70px 4px;"
						alt="" src="img/Album/BackInBlack.jpg">
					<h5 class="text-center text-light mt-3 mb-3">Albums</h5>
					<div class="d-flex justify-content-center">
						<a href="http://localhost:8080/ProyectoTallerWebAppMusica/viewExplorarTodosLosAlbums"
							class="card-link text-decoration-none text-info">Ver Albums</a>
					</div>
				</div>
			</div>
		</div>
		
		<!-- Card Canciones -->
		<div class="container d-flex flex-column mb-3">
			<div
				class="align-self-center align-self-md-start card mb-3 mt-3 border-0 shadow bg-dark"
				style="width: 15rem; border-radius: 0.5em;">
				<div class="card-body align-self-center">
					<img class="rounded"
						style="width: 6m; height: 6em; object-fit: cover; box-shadow: rgba(0, 0, 0, 0.56) 0px 22px 70px 4px;"
						alt="" src="img/Album/BackInBlack.jpg">
						<img class="rounded"
						style="width: 6em; height: 6em; object-fit: cover; box-shadow: rgba(0, 0, 0, 0.56) 0px 22px 70px 4px;"
						alt="" src="img/Artista/michael_jackson.jpg">
						<img class="rounded"
						style="width: 6em; height: 6em; object-fit: cover; box-shadow: rgba(0, 0, 0, 0.56) 0px 22px 70px 4px;"
						alt="" src="img/Album/Dynasty.jpg">
						<img class="rounded"
						style="width: 6em; height: 6em; object-fit: cover; box-shadow: rgba(0, 0, 0, 0.56) 0px 22px 70px 4px;"
						alt="" src="img/Artista/foo_fighters.jpg">
					<h5 class="text-center text-light mt-3 mb-3">Canciones</h5>
					<div class="d-flex justify-content-center">
						<a href="http://localhost:8080/ProyectoTallerWebAppMusica/viewExplorarTodasLasCanciones"
							class="card-link text-decoration-none text-info">Ver Canciones</a>
					</div>
				</div>
			</div>
		</div>
		
		<!-- Card Playlist -->
		<div class="container d-flex flex-column mb-3">
			<div
				class="align-self-center align-self-md-start card mb-3 mt-3 border-0 shadow bg-dark"
				style="width: 15rem; border-radius: 0.5em;">
				<div class="card-body align-self-center">
					<img class="rounded"
						style="width: 6em; height: 6em; object-fit: cover; box-shadow: rgba(0, 0, 0, 0.56) 0px 22px 70px 4px;"
						alt="" src="img/Artista/kiss.jpg">
						<img class="rounded"
						style="width: 6em; height: 6em; object-fit: cover; box-shadow: rgba(0, 0, 0, 0.56) 0px 22px 70px 4px;"
						alt="" src="img/Album/Thriller.jpg">
						<img class="rounded"
						style="width: 6em; height: 6em; object-fit: cover; box-shadow: rgba(0, 0, 0, 0.56) 0px 22px 70px 4px;"
						alt="" src="img/Album/MedicineAtMidnight.jpg">
						<img class="rounded"
						style="width: 6em; height: 6em; object-fit: cover; box-shadow: rgba(0, 0, 0, 0.56) 0px 22px 70px 4px;"
						alt="" src="img/Artista/ac_dc.jpg">
					<h5 class="text-center text-light mt-3 mb-3">Playlists</h5>
					<div class="d-flex justify-content-center">
						<a href="http://localhost:8080/ProyectoTallerWebAppMusica/viewExplorarTodasLasPlaylists"
							class="card-link text-decoration-none text-info">Ver Playlists</a>
					</div>
				</div>
			</div>
		</div>
		
		<!-- Card Genero -->
		<div class="container d-flex flex-column mb-3">
			<div
				class="align-self-center align-self-md-start card mb-3 mt-3 border-0 shadow bg-dark"
				style="width: 15rem; height:19em ; border-radius: 0.5em;">
				<div class="card-body text-center align-self-center">
					<img class="rounded"
						style="width: 6em; height: 6em; object-fit: cover; box-shadow: rgba(0, 0, 0, 0.56) 0px 22px 70px 4px;"
						alt="" src="img/Genero/pop.png">
						<img class="rounded"
						style="width: 6em; height: 6em; object-fit: cover; box-shadow: rgba(0, 0, 0, 0.56) 0px 22px 70px 4px;"
						alt="" src="img/Genero/rock.jpg">
						<br><br><br><br><br>
					<h5 class="text-center text-light mt-3 mb-3">Géneros</h5>
					<div class="d-flex justify-content-center">
						<a href="http://localhost:8080/ProyectoTallerWebAppMusica/viewExplorarTodosLosGeneros"
							class="card-link text-decoration-none text-info">Ver Géneros</a>
					</div>
				</div>
			</div>
		</div>
</div>
<%@include file="queue.jsp"%>
<%@include file="reproductor.jsp"%>
<!-- Scripts -->
<script src="js/bootstrap.min.js"></script>
<script src="js/reproductor.js"></script>
</body>
</html>
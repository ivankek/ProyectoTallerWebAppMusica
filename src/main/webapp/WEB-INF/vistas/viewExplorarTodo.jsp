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



<div class="container-fluid main pb-4 mb-5">
	<div class="row">
<%@include file="sidebar.jsp"%>
<div class="col bg-dark bg-gradient p-5">
<h2 class="text-white text-center">Explorar todo</h2>
<br>
			<div class="row row-cols-1 row-cols-md-5 g-4">
				<!-- Tarjeta 1 -->
					<div class="col">
						<a class="text-white" href="http://localhost:8080/proyecto-limpio-spring-master/viewExplorarTodosLosArtistas" style="text-decoration:none">
							<div class="card h-100 bg-dark text-white">
								<div class="card-body text-center rounded" style="background: linear-gradient(-90deg,#BF019F, #2C5364)">
									<h5 class="card-title">Artistas</h5>
								</div>
							</div>
						</a>
					</div>
					
					<!-- Tarjeta 2 -->
					<div class="col">
						<a class="text-white" href="http://localhost:8080/proyecto-limpio-spring-master/viewExplorarTodosLosAlbums" style="text-decoration:none">
							<div class="card h-100 bg-dark text-white">
								<div class="card-body text-center rounded" style="background: linear-gradient(90deg, rgba(2,0,36,1) 0%, rgba(19,19,116,1) 35%, rgba(0,212,255,1) 100%)">
									<h5 class="card-title">Albums</h5>
								</div>
							</div>
						</a>
					</div>
		
					<!-- Tarjeta 3 -->
					<div class="col">
						<a class="text-white" href="http://localhost:8080/proyecto-limpio-spring-master/viewExplorarTodasLasCanciones" style="text-decoration:none">
							<div class="card h-100 bg-dark text-white">
								<div class="card-body text-center rounded" style="background: linear-gradient(-90deg,#BF019F, #F28A57)">
									<h5 class="card-title">Canciones</h5>
								</div>
							</div>
						</a>
					</div>
						
					<!-- Tarjeta 4 -->	
					<div class="col">
						<a class="text-white" href="http://localhost:8080/proyecto-limpio-spring-master/MisPlaylist" style="text-decoration:none">
							<div class="card h-100 bg-dark text-white">
								<div class="card-body text-center rounded" style="background: linear-gradient(-90deg,#BF019F, #4cde31)">
									<h5 class="card-title">Playlists</h5>
								</div>
							</div>
						</a>
					</div>	
						
						<!-- Tarjeta 5 -->
						<div class="col">
							<a class="text-white" href="http://localhost:8080/proyecto-limpio-spring-master/viewExplorarTodosLosGeneros" style="text-decoration:none">
								<div class="card h-100 bg-dark text-white">
									<div class="card-body text-center rounded" style="background:linear-gradient(90deg, rgba(2,0,36,1) 0%, rgba(222,49,168,1) 35%, rgba(0,212,255,1) 100%);">
										<h5 class="card-title">Géneros</h5>
									</div>
								</div>
							</a>
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
</body>
</html>
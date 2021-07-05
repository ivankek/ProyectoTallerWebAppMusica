<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@include file="Header.jsp"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Explorar Géneros</title>
</head>
<body>

<div class="container-fluid main pb-4 mb-5">
	<div class="row">
	<%@include file="sidebar.jsp"%>
		<div class="col bg-dark bg-gradient p-5">
		<h2 class="text-white text-center">Canciones que posee el género ${genero}</h2>

		<div class="datos" hidden>${datos}</div>

			<ul class="list-group">
				<c:forEach items="${cancion}" var="cancion">	
					<li class="cancion list-group-item bg-dark d-flex justify-content-between" id="cancion${cancion.id}">
					<!-- parte A -->
						<div class="d-flex  align-items-center">
							<i class="material-icons text-white me-3 icon-play"  name="${cancion.nombre}">play_circle_outline</i>
							<div class="flex-shrink-0">
								<img src="${cancion.album.path_img}" style="width: 64px; height: 64px" alt="...">
							</div>
							<div class="flex-grow-1 ms-3 text-white info-cancion">
								<h5 class="mt-0 titulo-cancion">${cancion.nombre}</h5>
								<a href="">${cancion.artista.nombre}</a>
							</div>
						</div> 
						<!-- parte B -->
						<div class="text-white d-flex align-items-center">
							<a href="http://localhost:8080/proyecto-limpio-spring-master/Album?nombre=${cancion.album.nombre}">${cancion.album.nombre}</a>
						</div>
						<!-- parte C -->
						<div class="text-white d-flex align-items-center">
							<div hidden class="material-icons fav-icon"></div>
							<div class="ps-3 pe-2">3:20</div>
							<div class="material-icons">more_horiz</div>
						</div>
					</li>
				</c:forEach>
			</ul>
	
		</div>
	</div>
</div>
<%@include file="queue.jsp"%>
<%@include file="reproductor.jsp"%>
</body>
</html>
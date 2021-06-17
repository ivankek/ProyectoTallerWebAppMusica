<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="Header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="container mt-5 text-light mb-5 main">

<div align="center">
		
			
				<img src="${artista.path_img}" style="width: 1100px; height: 400px" alt="...">
				
			
	
	<h1>${titulo}</h1>
	
	
	<form:form class="" action="FollowArtista"
							method="GET" modelAttribute="artista">
				<button type="button" class="btn btn-info text-light" name="botonFollow" id="botonFollow" onclick="FbotonFollow()"> Seguir </button>
				<input type="hidden" name="artista" value="${cancion.artista.nombre}">
			
	
	</form:form>
	
	
	</div>	<br>
				
	<div class="datos" hidden>${datos}</div>
	
	<ul class="list-group pb-5 mb-5">
		<c:forEach items="${canciones}" var="cancion">	
			<li class="list-group-item bg-dark d-flex justify-content-between" id="cancion${cancion.id}">
				<!-- parte A -->
				<div class="d-flex  align-items-center">
					<i class="material-icons text-white me-3 icon-play"  name="${cancion.nombre}">play_circle_outline</i>
					<div class="flex-shrink-0">
						<img src="${cancion.album.path_img}" style="width: 64px; height: 64px" alt="...">
					</div>
					<div class="flex-grow-1 ms-3 text-white">
						<h5 class="mt-0">${cancion.nombre}</h5>
						<a href="">${cancion.artista.nombre}</a>
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
			</li>
		</c:forEach>
	</ul>
</div>

<%@include file="queue.jsp"%>
<%@include file="reproductor.jsp"%>
	
<script src="js/bootstrap.min.js"></script>
<script src="js/json.js"></script>
<script src="js/follow.js"></script>

</body>
</html>
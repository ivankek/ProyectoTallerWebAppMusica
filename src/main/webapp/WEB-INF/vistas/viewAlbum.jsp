<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href= "css/bootstrap.min.css">
	<title>Album</title>
</head>
<body>
	<main class="container">
		<div class="row">
			<div class="col-md-6">
				<img alt="${nombreAlbum}" src="${imagenAlbum}"  width="300px">
				<audio id="player" controls></audio>
			</div>
			<div class="col-md-6">
				<buttom class="btn btn-success" id="shuffle"><i class="fa fa-random"></i></buttom>
				<ul class="list-group" id="playlist">
					<c:forEach items="${canciones}" var="cancion">
							<li class="list-group-item" id="${cancion.id}" name="${cancion.path_cancion}">${cancion.nombre}</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	
	</main>
	<p>${nombreArtista}</p>
	<p>${nombreAlbum}</p>
	<p>${imagenAlbum}</p>
	
	
	<script src="js/jquery-1.11.3.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="https://kit.fontawesome.com/1776a9f4e1.js" crossorigin="anonymous"></script>
	<script src="js/reproductor.js"></script>
</body>
</html>
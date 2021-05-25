<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Resultado busqueda</title>
</head>
<body>


	<c:forEach items="${generos}" var="genero">
	<li>${genero.nombre}</li>
	</c:forEach>

	<c:forEach items="${artistas}" var="artista">
	<li>${artista.nombre}</li>
	</c:forEach>
	
	<c:forEach items="${albums}" var="album">
	<li>${album.nombre}</li>
	</c:forEach>
	
	<c:forEach items="${listas}" var="lista">
	<li>${lista.nombre}</li>
	</c:forEach>
	
	<c:forEach items="${canciones}" var="cancion">
	<li>${cancion.nombre}</li>
	</c:forEach>
</body>
</html>
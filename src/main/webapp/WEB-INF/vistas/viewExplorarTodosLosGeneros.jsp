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
		<div class="col bg-dark bg-gradient p-5">
		<h2 class="text-white text-center">Explorar Géneros</h2>

		<ul class="list-group">
			<c:forEach items="${genero}" var="genero">
				<li class="list-group-item bg-dark d-flex justify-content-between">
						<div class="d-flex align-items-center">
							<div class="flex-shrink-0">
								<!--  <img src="${artista.path_img}" style="width: 64px; height: 64px" alt="...">-->
								<a href="http://localhost:8080/proyecto-limpio-spring-master/viewTodasCancionesPorGenero?genero=${genero.nombre}">${genero.nombre}</a>	
							</div>
						</div>
				</li>
				</c:forEach>
		</ul>
	
		</div>
	</div>
</div>

</body>
</html>
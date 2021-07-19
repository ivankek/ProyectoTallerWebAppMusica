<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@include file="Header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Explorar Artistas</title>
</head>
<body>

<div class="container-fluid main pb-4 mb-5">
	<div class="row">
<div class="col bg-dark bg-gradient p-5">
<h2 class="text-white text-center">Explorar Artistas</h2>
	
	<table class="table table-dark table-hover ${accion}"
		style="margin-bottom: 10em;">
		<thead>
			<tr>
				<th scope="col">Artista</th>
			</tr>
		</thead>
			<tbody>
			<c:forEach items="${artista}" var="artista">
				<tr>
					<td>
						<div class="text-white d-flex align-items-center">
							<div class="flex-shrink-0">
								<img src="${artista.path_img}"
									style="width: 50px; height: 50px" alt="...">
							</div>
							
							<div class="text-white d-flex align-items-center ">
							<a class="text-decoration-none text-light"
								href="http://localhost:8080/proyecto-limpio-spring-master/Artista?nombre=${artista.nombre}">${artista.nombre}</a>
							</div>
						</div>
					</td>
						
						
				</tr>
			</c:forEach>
			</tbody>
		</table>
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
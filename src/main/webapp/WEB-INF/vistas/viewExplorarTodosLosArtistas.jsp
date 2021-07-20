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

<h2 class="text-white text-center">Explorar Artistas</h2>
<div class="row row-cols-1 row-cols-md-5 g-4">
<c:forEach items="${artista}" var="artista">

		<div class="container d-flex flex-column mb-3">

			<div
				class="align-self-center align-self-md-start card mb-3 mt-3 border-0 shadow bg-dark"
				style="width: 15rem; border-radius: 0.5em;">
				<div class="card-body align-self-center">
					<img class="rounded-circle"
						style="width: 12em; height: 12em; object-fit: cover; object-position: 0 0; box-shadow: rgba(0, 0, 0, 0.56) 0px 22px 70px 4px;"
						alt="" src="${artista.path_img}">

					<h5 class="text-center text-light mt-3 mb-3">${artista.nombre}</h5>
					<!-- <p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p> -->

					<div class="d-flex justify-content-center">
						<a href="Artista?nombre=${artista.nombre}"
							class="card-link text-decoration-none text-info">Ver Artista</a>
						<a href="#" class="card-link text-decoration-none text-primary">Seguir</a>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>

	<!-- Tabla -->

</div>
<%@include file="queue.jsp"%>
<%@include file="reproductor.jsp"%>
<!-- Scripts -->
<script src="js/bootstrap.min.js"></script>
<script src="js/reproductor.js"></script>
</body>
</html>
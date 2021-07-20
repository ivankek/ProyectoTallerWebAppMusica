<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@include file="Header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Explorar Albums</title>
</head>
<body>
<h2 class="text-white text-center">Explorar Albums</h2>
<div class="row row-cols-1 row-cols-md-5 g-4"><br>
<c:forEach items="${album}" var="album">
		<div class="container d-flex flex-column mb-3">

			<div
				class="align-self-center align-self-md-start card mb-3 mt-3 border-0 shadow bg-dark"
				style="width: 15rem; border-radius: 0.5em;">
				<div class="card-body align-self-center">
					<img class="rounded"
						style="width: 12em; height: 12em; object-fit: cover; box-shadow: rgba(0, 0, 0, 0.56) 0px 22px 70px 4px;"
						alt="" src="${album.path_img}">

					<h5 class="text-center text-light mt-3 mb-3">${album.nombre}</h5>
					<!-- <p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p> -->

					<div class="d-flex justify-content-center">
						<a href="Album?nombre=${album.nombre}"
							class="card-link text-decoration-none text-info">Ver Album</a>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
</div>

<%@include file="queue.jsp"%>
<%@include file="reproductor.jsp"%>
<!-- Scripts -->
<script src="js/bootstrap.min.js"></script>
<script src="js/reproductor.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
	crossorigin="anonymous"></script>
</body>
</html>
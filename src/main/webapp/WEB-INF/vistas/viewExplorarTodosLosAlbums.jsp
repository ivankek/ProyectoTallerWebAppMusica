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


<div class="container-fluid main pb-4 mb-5">
	<div class="row">
<div class="col bg-dark bg-gradient p-5">
<h2 class="text-white text-center">Explorar Albums</h2>

	<table class="table table-dark table-hover ${accion}"
		style="margin-bottom: 10em;">
		<thead>
			<tr>
				<th scope="col">Album</th>
			</tr>
		</thead>
			<tbody>
			<c:forEach items="${album}" var="album">
				<tr>
					<td>
						<div class="text-white d-flex align-items-center">
							<div class="flex-shrink-0">
								<img src="${album.path_img}"
									style="width: 50px; height: 50px" alt="...">
							</div>
							
							<div class="text-white d-flex align-items-center ">
							<a class="text-decoration-none text-light"
								href="http://localhost:8080/proyecto-limpio-spring-master/Album?nombre=${album.nombre}">${album.nombre}</a>
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
<script src="js/json.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
	crossorigin="anonymous"></script>
</body>
</html>
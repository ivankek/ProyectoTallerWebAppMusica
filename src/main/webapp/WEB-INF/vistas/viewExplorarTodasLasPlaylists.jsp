<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@include file="Header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<br>
<h2 class="text-white text-center">Explorar Playlists</h2><br>
<div class="row row-cols-1 row-cols-md-5 g-4">
<c:forEach items="${lista}" var="lista">
<input type="hidden" name="lista" value="${lista.id}">
		<div class="container d-flex flex-column mb-3">

			<div
				class="align-self-center align-self-md-start card mb-3 mt-3 border-0 shadow bg-dark"
				style="width: 15rem; border-radius: 0.5em;">
				<div class="card-body align-self-center">
					
					<h5 class="text-center text-light mt-3 mb-3">${lista.nombre}</h5>
					<div class="d-flex justify-content-center">
						<a href="http://localhost:8080/proyecto-limpio-spring-master/viewLista?idPlaylist=${lista.id }"
							class="card-link text-decoration-none text-info">Ver Lista</a>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
</div>



</body>
</html>
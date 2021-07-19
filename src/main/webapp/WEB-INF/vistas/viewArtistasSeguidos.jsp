<%@include file="Header.jsp"%>

		<%
			if (request.getAttribute("usuario") != null) {
		%>
<div class="container mt-5 text-light mb-5 main">
	<h2 class="text-center">Artistas a los que sigue ${usuario.usuario}:</h2>
		<ul class="list-group pb-5 mb-5">
			<c:forEach items="${artistasSeguidos}" var="artista">
			<li class="list-group-item bg-dark d-flex justify-content-between">
			<div class="flex-shrink-0">
					<img src="${artista.path_img}" style="width: 80px; height: 80px" alt="...">
					<a class="text-decoration-none text-light" href="http://localhost:8080/proyecto-limpio-spring-master/Artista?nombre=${artista.nombre}">${artista.nombre}</a>	
			</div>
			</li>
	</c:forEach>
	</ul>
</div>

<%
}
%>

<%@include file="queue.jsp"%>
<%@include file="reproductor.jsp"%>
<!-- Scripts -->
<script src="js/bootstrap.min.js"></script>
<script src="js/reproductor.js"></script>	

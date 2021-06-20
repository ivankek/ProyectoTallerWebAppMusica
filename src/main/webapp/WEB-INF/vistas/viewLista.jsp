<%@page import="org.springframework.ui.Model"%>
<%@include file="Header.jsp"%>
<body>

	<div class="container d-flex flex-column justify-content-center">

		<c:forEach items="${cancionesLista}" var="cancion">
			<p class="text-center text-light">${cancion}</p>
		</c:forEach>

	</div>

	<!-- Scripts -->
	<script src="js/bootstrap.min.js"></script>
	<script src="js/json.js"></script>
</body>

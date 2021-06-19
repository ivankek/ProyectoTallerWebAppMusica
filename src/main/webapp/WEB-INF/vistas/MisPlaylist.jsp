<%@page import="org.springframework.ui.Model"%>
<%@include file="Header.jsp"%>
<body>

	<c:forEach items="${listas}" var="lista">
		<li class="list-group-item" id="${lista.id}" name="${lista.nombre}">${lista.nombre}</li>
	</c:forEach>

	<!-- Scripts -->
	<script src="js/bootstrap.min.js"></script>
	<script src="js/json.js"></script>
</body>

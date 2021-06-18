<%@page import="org.springframework.ui.Model"%>
<%@include file="Header.jsp"%>
<body>

<ul class="list-group pb-5 mb-5 cancion">
			<c:forEach items="${playlist}" var="lista">
				<li class="list-group-item bg-dark d-flex justify-content-between">
					${lista.nombre}
				</li>
			</c:forEach>
		</ul>


<!-- Scripts -->
<script src="js/bootstrap.min.js"></script>
<script src="js/json.js"></script>
</body>

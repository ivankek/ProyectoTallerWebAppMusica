<%@include file="Header.jsp"%>

		<%
			if (request.getAttribute("usuario") != null) {
		%>

	<h2 class="text-white text-center">Artistas a los que sigue ${usuario.usuario}:</h2>
	<div class="row row-cols-1 row-cols-md-5 g-4">
			<c:forEach items="${artistasSeguidos}" var="artista">
			<div class="container d-flex flex-column mb-3">

			<div
				class="align-self-center align-self-md-start card mb-3 mt-3 border-0 shadow bg-dark"
				style="width: 15rem; border-radius: 0.5em;">
				<div class="card-body align-self-center">
					<img class="rounded-circle"
						style="width: 12em; height: 12em; object-fit: cover; object-position: 0 0; box-shadow: rgba(0, 0, 0, 0.56) 0px 22px 70px 4px;"
						alt="" src="${artista.path_img}">

					<h5 class="text-center text-light mt-3 mb-3">${artista.nombre}</h5>
					<div class="d-flex justify-content-center">
						<a href="Artista?nombre=${artista.nombre}"
							class="card-link text-decoration-none text-info">Ver Artista</a>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
</div>

					<%
					} else{
					%>
					
					<h2 class="text-white text-center"> Para poder ver a que artistas sigues, puedes:</h2>
					<br>

					<div class="text-center">
					<button type="submit"
						class="btn btn-info text-light align-self-center mt-0 mt-md-5 me-3"
						id="botonRegistro"><a style="text-decoration:none" class="text-light" href="/ProyectoTallerWebAppMusica/registroUsuario">Registrarte</a></button>
					<button type="submit"
						class="btn btn-info text-light align-self-center mt-0 mt-md-5 me-3"
						id="botonLogin"><a style="text-decoration:none" class="text-light" href="/ProyectoTallerWebAppMusica/login">Ingresar</a></button>
					</div>
					<%
					} 
					%>
<%@include file="queue.jsp"%>
<%@include file="reproductor.jsp"%>
<!-- Scripts -->
<script src="js/bootstrap.min.js"></script>
<script src="js/reproductor.js"></script>	

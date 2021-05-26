<%@include file="Header.jsp"%>
		<!-- Queue -->
		<ul class="list-group" id="playlist" hidden>
			<c:forEach items="${canciones}" var="cancion">
				<li class="list-group-item bg-dark d-flex justify-content-between" id="cancion${cancion.id}">
					<!-- parte A -->
					<div class="d-flex  align-items-center">
						<i class="material-icons text-white me-3 click" id="${cancion.path_cancion}">play_circle_outline</i>
						<div class="flex-shrink-0">
							<img src="${imagenAlbum}" style="width: 64px; height: 64px" alt="...">
						</div>
						<div class="flex-grow-1 ms-3 text-white">
							<h5 class="mt-0">${cancion.nombre}</h5>
							<p>${nombreArtista}</p>
						</div>
					</div> 
					<!-- parte B -->
					<div class="text-white d-flex align-items-center">
						<a href="">${nombreAlbum}</a>
					</div> 
					<!-- parte C -->
					<div class="text-white d-flex align-items-center">
						<div>3:20</div>
						<div class="material-icons ms-3">more_horiz</div>
					</div>
				</li>
			</c:forEach>
		</ul>
	
<%@include file="reproductor.jsp"%>
	
	<script src="js/bootstrap.min.js"></script>
	<script src="js/reproductorFooter.js"></script>

</body>
</html>
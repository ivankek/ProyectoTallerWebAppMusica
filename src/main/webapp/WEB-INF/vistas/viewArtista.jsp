<%@include file="Header.jsp"%>
<!-- Main -->
<div class="container-fluid main pb-4 mb-5">
	<div class="row">
		<!-- SIDEBAR -->
		<%@include file="sidebar.jsp"%>
		<!-- Contenido Principal -->
		<div class="col bg-dark bg-gradient p-0">
			<!-- parte A -->
			<div class="card bg-dark text-white h-50">
  				<img src="img/Artista/foofighters.jpg" class="card-img h-100" alt="...">
  				<div class="card-img-overlay">
    				<h2 class="card-title fw-bolder">Foo Fighters</h2>
    				<p class="card-text">Artista</p>
  				</div>
			</div>
		</div>
	</div>
</div>


<%@include file="queue.jsp"%>
<%@include file="reproductor.jsp"%>
<!-- Scripts -->
<script src="js/bootstrap.min.js"></script>
<script src="js/json.js"></script>
</body>
</html>
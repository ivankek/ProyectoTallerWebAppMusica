<!-- reproductor -->	
	<footer class="container-fluid fixed-bottom bg-dark">
		<div class="row">
    		<div class="col-3">
      			<div class="d-flex">
        			<div class="flex-shrink-0">
          				<img src="${imagenAlbum}" style="width:64px;height:64px" class="imgReproductor" alt="...">
        			</div>
        			<div class="flex-grow-1 ms-3 text-white">
          				<h5 id="songName" class="mt-0">Song Name</h5>
          				<p id="artistName">Artist name</p>
        			</div>
      			</div>
    		</div>
    		<div class="col-6">
      			<div class="play-icons text-white align-items-center d-flex justify-content-center">
        			<i class="material-icons text-success" id="shuffle">shuffle</i>
        			<i class="material-icons ms-4" id="prev">skip_previous</i>
        			<i class="material-icons ms-4" style="font-size:40px" id="play">play_circle_outline</i>
        			<i class="material-icons ms-4" id="next">skip_next</i>
        			<i class="material-icons ms-4 text-success" id="repeat">repeat</i>
        			<audio id="audio"></audio>
      			</div>
      			<div class="progress-block mt-1 text-white d-flex justify-content-between align-items-center">
        			<div class="me-3" id="current">0:00</div>
        			<div class="progress w-100">
          				<div class="progress-bar bg-success" role="progressbar" ></div>
        			</div>
        			<div class="ms-3" id="duration">0:00</div>
      			</div>
    		</div>
    		<div class="col-3 text-white d-inline-flex flex-row-reverse align-items-center">
      			<div class="ms-2"><i class="material-icons">playlist_play</i></div>
      			<div class="ms-2"><i id="queue" class="material-icons" onclick="queueShow()">queue_music</i></div>
      			<div class="progress volume-progress">
        			<div class="progress-bar bg-success" aria-valuemin="0" aria-valuemax="100"></div>
      			</div>
      			<div class="ms-2"><i class="material-icons">volume_down</i></div>
      			<div class="ms-2"><i class="material-icons">chat</i></div>
      		</div>
    	</div>
	</footer>
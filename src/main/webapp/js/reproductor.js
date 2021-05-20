$(document).ready(function(){
	getSongs();
});

var audio = document.getElementById('player');
var music;

function playSong(rutaCancion,track){
	var cantidadCanciones = document.getElementsByClassName("list-group-item").length;
	if(track > cantidadCanciones){
		audio.pause();
	}else{
		$('#player').attr('src',rutaCancion);
		audio.play();
		track++;
		scheludeSong(track,cantidadCanciones);
		}
	}

function getSongs(){
	$('#playlist li').click(function(){
		var selectedsong = $(this).attr('name');
		var track = $(this).attr('id');
		playSong(selectedsong,parseInt(track));
	});
}

function scheludeSong(track,cantidadCanciones){
	audio.onended = function(){
		if(track <= cantidadCanciones){
			playSong(document.getElementById(track).getAttribute("name"),track);
		}else{
			console.log("finalizo lista");
			audio.pause();
		}
	}
}
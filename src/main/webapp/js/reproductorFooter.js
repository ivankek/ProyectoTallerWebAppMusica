const queueMusic = document.querySelector('#queue');
const queue = document.querySelector('#playlist');
const audio = document.querySelector('#audio');
const playBtn = document.querySelector('#play');
const songName = document.querySelector('#songName');
const artistName = document.querySelector('#artistName');
const progress = document.querySelector('.progress-bar');
const ct = document.querySelector("#current");
const timeDuration = document.querySelector("#duration");

//reproduce o pausa el audio
var playpause = function(){
	if(audio.paused){
		audio.play();
	}else{
		audio.pause();
	}
}

//Añade evento
playBtn.addEventListener("click", playpause);

//cambia los iconos de play o pause
audio.onplay = function(){
	if(audio.src == ""){
		alert("No hay cancion cargada");
		audio.pause();
			}else{
				playBtn.innerHTML = "pause";
			}
}

audio.onpause = function(){
	playBtn.innerHTML = "play_circle_outline";
}

//Actualiza progressBar y muestra la duracion y el tiempo transcurrido
audio.ontimeupdate = function (){
	let currentTime = audio.currentTime;
	let duration = audio.duration;
	
	ct.innerHTML = timeFormat(currentTime);
	timeDuration.innerHTML = timeFormat(duration);
	let prog = Math.floor((currentTime * 100) / duration);
	progress.style.setProperty("width",prog + '%');
}

//Muestra o oculta la cola de reproduccion
function queueShow(){
	if(queueMusic.className.includes("text-success")){
		queueMusic.classList.remove('text-success');
		queue.setAttribute('hidden', true);
	}else{
		queue.removeAttribute('hidden');
		queueMusic.classList.add('text-success');
	}
}

//Convierte formato de segundos a minutos y segundos
function timeFormat(time){
	let minutes = Math.floor(time / 60);
	let seconds = Math.floor(time % 60);
	
	if(seconds < 10){
		seconds = "0" + seconds;
	}
	
	return minutes + ":" + seconds;
}

document.querySelectorAll(".click").forEach(el => {
  el.addEventListener("click", e => {
    const id = e.target.getAttribute("id");
    audio.src = id;
  });
});

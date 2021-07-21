const cola_icon = document.querySelector("#queue");
var play_icon = document.querySelectorAll(".icon-play");
const cola = document.querySelector("#cola");

//Elementos Reproductor
const audio = document.querySelector('#audio');
const playBtn = document.querySelectorAll('.play');
const imgReproductor = document.querySelector(".imgReproductor");
const timeDuration = document.querySelector("#duration");
const ct = document.querySelector("#current");
const progress = document.querySelector('.progress-bar');
const songName = document.querySelector('#songName');
const artistName = document.querySelector('#artistName');

//reproduce o pausa el audio
var playpause = function(){
	if(audio.paused){
		audio.play();
	}else{
		audio.pause();
	}
}


//Añadir eventos
cola_icon.addEventListener("click" , ocultarYMostrarQueue);

for(var i = 0 ; i < play_icon.length ; i++){
    play_icon[i].addEventListener("click" , buscarCancionEnBD);
}

for(var i = 0 ; i < playBtn.length ; i++){
    playBtn[i].addEventListener("click", playpause);
}



function ocultarYMostrarQueue(){
    if(cola_icon.classList.contains("text-success")){
        cola.parentElement.setAttribute("hidden" , true);
        cola_icon.className = "material-icons";
        document.querySelector(".main").removeAttribute("hidden");
    }else{
        document.querySelector(".main").setAttribute("hidden" , true);
        cola.parentElement.removeAttribute("hidden");
        cola_icon.className += " text-success";
    }
}

function buscarCancionEnBD(evento){
    var nombreCancion = evento.target.getAttribute("name");
    
    if(window.location.pathname == "/proyecto-limpio-spring-master/viewLista"){
        var nombreArtista = evento.target.parentElement.parentElement.querySelector("#nombreArtista").innerHTML;
        var nombreAlbum = evento.target.parentElement.parentElement.querySelector("#nombreAlbum").innerHTML;
    }

    if(window.location.pathname == "/proyecto-limpio-spring-master/Album"){
        var nombreArtista = document.querySelector("#artistaNombre").innerHTML;
        var nombreAlbum = document.querySelector("#albumNombre").innerHTML;
    }

    if(window.location.pathname == "/proyecto-limpio-spring-master/Artista"){
        var nombreArtista = document.querySelector("#Titulo").innerHTML;
        var nombreAlbum = evento.target.parentElement.parentElement.querySelector("#nombreAlbum").innerHTML;
    }

    var arrayData = [nombreCancion , nombreArtista , nombreAlbum];

    fetch('traerUnaCancion' , {
        headers: {'Content-Type': 'application/json'},
        method: 'POST',
        body: JSON.stringify(arrayData)
    })
    .then(response => isResponseOk(response))
    .then(data => agregarAQueue(JSON.parse(data)))
    .catch(showError);
}

function agregarAQueue(cancion){
    var item = cola.firstElementChild;
    item.firstElementChild.firstElementChild.setAttribute("id" , cancion.path_cancion);
    item.firstElementChild.lastElementChild.firstElementChild.innerText = cancion.nombre;
    item.firstElementChild.lastElementChild.firstElementChild.className += " text-success";
    item.firstElementChild.lastElementChild.lastElementChild.innerText = cancion.artista.nombre;
    item.firstElementChild.children[1].firstElementChild.setAttribute("src" , cancion.album.path_img);
    item.children[1].firstElementChild.innerText = cancion.album.nombre;
    setSong(cancion);
}

function setSong(cancion){
    audio.src = cancion.path_cancion;
    songName.innerText = cancion.nombre;
    artistName.innerText = cancion.artista.nombre;
    imgReproductor.setAttribute("src", cancion.album.path_img);
    //aca deberia guardarse en un historial
    playpause();
}

//cambia los iconos de play o pause
audio.onplay = function(){
    for(var i = 0 ; i < playBtn.length ; i++){
        playBtn[i].innerHTML = "pause";
    }
}

audio.onpause = function(){
    for(var i = 0 ; i < playBtn.length ; i++){
        playBtn[i].innerHTML = "play_circle_outline";
    }
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

//Convierte formato de segundos a minutos y segundos
function timeFormat(time){
	let minutes = Math.floor(time / 60);
	let seconds = Math.floor(time % 60);
	
	if(seconds < 10){
		seconds = "0" + seconds;
	}
	
	return minutes + ":" + seconds;
}

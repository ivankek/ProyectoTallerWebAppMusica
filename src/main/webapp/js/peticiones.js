//Elementos
const btn_favorito = document.querySelectorAll(".fav-icon");
const elementos_cancion = document.querySelectorAll(".cancion");

//Setear eventos
btn_favorito.forEach(item => item.addEventListener("click" , agregarEliminarFavorito));

elementos_cancion.forEach(item => {
    item.addEventListener("mouseenter" , mostrarFavorito);
    item.addEventListener("mouseleave" , ocultarFavorito);
});

window.addEventListener("load" , botonSeguir);

//Funciones
function botonSeguir(){
    let nombreArtista = document.querySelector("#Titulo").innerHTML;
    fetch('consultarSeguir' , {
        headers: {'Content-Type': 'text/plain'},
        method: 'POST',
        body: nombreArtista        
    })
    .then(response => isResponseOk(response))
    .then(data => alert(data))
    .catch(showError);    
}

const isResponseOk = (response) =>{
    if(!response.ok)
        console.log(response.status);
    return response.text();    
}

function buscarTema(nombreCancion){
    let i = 0;
    while((i < canciones.length) && (canciones[i].nombre != nombreCancion)){
        i++;
    }
    return canciones[i];
}

function showError(err){
    console.log('muestro error' , err);
}

function showMessage(txt){
    alert(txt);
}

function mostrarFavorito(evento){
    let icono_favorito = evento.target.querySelector(".fav-icon");
    if(icono_favorito.innerHTML == ""){
        let cancionNombre = evento.target.querySelector(".titulo-cancion").innerHTML;
        cargarFavorito(JSON.stringify(buscarTema(cancionNombre)) , icono_favorito);
    }
    icono_favorito.hidden = false;
}

function ocultarFavorito(evento){evento.target.querySelector(".fav-icon").hidden = true}

function agregarEliminarFavorito(evento){
    let tema = JSON.stringify(buscarTema(evento.target.parentElement.parentElement.querySelector(".titulo-cancion").innerHTML));
    if(evento.target.innerHTML == "favorite_border"){
        evento.target.innerHTML = "favorite";
        agregarAFavoritos(tema);
    }else{
        evento.target.innerHTML = "favorite_border";
        quitarDeFavoritos(tema);
    }
}

function cargarFavorito(cancionJson , favorito){
    fetch('consultarFavorito' , {
        headers: {'Content-Type': 'application/json'},
        method: 'POST',
        body: cancionJson        
    })
    .then(response => isResponseOk(response))
    .then(data => favorito.innerHTML = data)
    .catch(showError);
}

function agregarAFavoritos(cancion){
    fetch('agregarFavorito' , {
        headers: {'Content-Type': 'application/json'},
        method: 'POST',
        body: cancion
    })
    .then(response => isResponseOk(response))
    .then(data => showMessage(data))
    .catch(showError);
}

function quitarDeFavoritos(cancion){
    fetch('eliminarFavorito' , {
        headers: {'Content-Type': 'application/json'},
        method: 'POST',
        body: cancion
    })
    .then(response => isResponseOk(response))
    .then(data => showMessage(data))
    .catch(showError);  
}

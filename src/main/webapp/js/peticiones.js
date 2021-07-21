const isResponseOk = (response) =>{
    if(!response.ok)
        console.log(response.status);
    return response.text();    
}

function showError(err){
    console.log('muestro error' , err);
}

function showMessage(txt){
    alert(txt);
}

//Funcionamiento para la vista Artista
if(window.location.pathname == "/proyecto-limpio-spring-master/Artista"){
    const btn_seguir = document.querySelector("#botonFollow");
    const nombreDelArtista = document.querySelector("#Titulo").innerHTML;
    const elementos_cancion = document.querySelectorAll(".cancion");

    btn_seguir.addEventListener("click" , seguirODejarDeSeguirArtista);

    elementos_cancion.forEach(item => {
        item.addEventListener("mouseenter" , mostrarFavorito);
        item.addEventListener("mouseleave" , ocultarFavorito);
    });

    window.addEventListener("load" , cargarEstadoBotonSeguir);

    function cargarEstadoBotonSeguir(){
        fetch('consultarSeguir' , {
            headers: {'Content-Type': 'text/plain'},
            method: 'POST',
            body: nombreDelArtista        
        })
        .then(response => isResponseOk(response))
        .then(data => btn_seguir.innerHTML = data)
        .catch(showError);    
    }

    function seguirODejarDeSeguirArtista(evento){
        let estado_btn_seguir = evento.target.innerHTML; 
        estado_btn_seguir == "Seguir" ? seguirArtista() : dejarDeSeguirArtista();
    }
    
    function seguirArtista(){
        fetch('seguirArtista' , {
            headers: {'Content-Type': 'text/plain'},
            method: 'POST',
            body: nombreDelArtista        
        })
        .then(response => isResponseOk(response))
        .then(data => btn_seguir.innerHTML = data)
        .catch(showError);  
    }
    
    function dejarDeSeguirArtista(){
        fetch('dejarDeSeguirArtista' , {
            headers: {'Content-Type': 'text/plain'},
            method: 'POST',
            body: nombreDelArtista        
        })
        .then(response => isResponseOk(response))
        .then(data => btn_seguir.innerHTML = data)
        .catch(showError);  
    }
}


//Elementos
const btn_favorito = document.querySelectorAll(".fav-icon");

const elementos_cancion = document.querySelectorAll(".cancion");

elementos_cancion.forEach(item => {
    item.addEventListener("mouseenter" , mostrarFavorito);
    item.addEventListener("mouseleave" , ocultarFavorito);
});

//Setear eventos
btn_favorito.forEach(item => item.addEventListener("click" , agregarEliminarFavorito));

function mostrarFavorito(evento){
    let icono_favorito = evento.target.querySelector(".fav-icon");
    if(icono_favorito.innerHTML == ""){
        if(window.location.pathname == "/proyecto-limpio-spring-master/Artista"){
            let nombreCancion = evento.target.querySelector(".titulo-cancion").innerHTML;
            let nombreArtista = evento.target.querySelector("#nombreArtista").innerHTML;
            let nombreAlbum = evento.target.querySelector("#nombreAlbum").innerHTML;
            var arrayData = [nombreCancion , nombreArtista , nombreAlbum];
            
        }

        if(window.location.pathname == "/proyecto-limpio-spring-master/Album"){
            let nombreCancion = evento.target.querySelector("#cancionNombre").innerHTML;
            let nombreArtista = document.querySelector("#artistaNombre").innerHTML;
            let nombreAlbum = document.querySelector("#albumNombre").innerHTML;
            var arrayData = [nombreCancion , nombreArtista , nombreAlbum];
            
        }

        if(window.location.pathname == "/proyecto-limpio-spring-master/viewLista"){
            let nombreCancion = evento.target.querySelector(".icon-play").getAttribute("name");
            let nombreArtista = evento.target.querySelector("#nombreArtista").innerHTML;
            let nombreAlbum = evento.target.querySelector("#nombreAlbum").innerHTML;
            var arrayData = [nombreCancion , nombreArtista , nombreAlbum]; 
        }
        cargarFavorito(arrayData , icono_favorito);
    }
    icono_favorito.hidden = false;
}

function ocultarFavorito(evento){evento.target.querySelector(".fav-icon").hidden = true}

function agregarEliminarFavorito(evento){
    if(window.location.pathname == "/proyecto-limpio-spring-master/Artista"){
        let nombreCancion = evento.target.parentElement.parentElement.querySelector(".icon-play").getAttribute("name");
        let nombreArtista = document.querySelector("#Titulo").innerHTML;
        let nombreAlbum = evento.target.parentElement.parentElement.querySelector("#nombreAlbum").innerHTML;
        var arrayData = [nombreCancion , nombreArtista , nombreAlbum];  
    }

    if(window.location.pathname == "/proyecto-limpio-spring-master/Album"){
        let nombreCancion = evento.target.parentElement.parentElement.parentElement.querySelector(".icon-play").getAttribute("name");
        let nombreArtista = document.querySelector("#artistaNombre").innerHTML;
        let nombreAlbum = document.querySelector("#albumNombre").innerHTML;
        var arrayData = [nombreCancion , nombreArtista , nombreAlbum];
    }

    if(window.location.pathname == "/proyecto-limpio-spring-master/viewLista"){
        let nombreCancion = evento.target.parentElement.parentElement.parentElement.querySelector(".icon-play").getAttribute("name");
        let nombreArtista = evento.target.parentElement.parentElement.parentElement.querySelector("#nombreArtista").innerHTML;
        let nombreAlbum = evento.target.parentElement.parentElement.parentElement.querySelector("#nombreAlbum").innerHTML;
        var arrayData = [nombreCancion , nombreArtista , nombreAlbum];
    }

    if(evento.target.innerHTML == "favorite_border"){
        evento.target.innerHTML = "favorite";
        agregarAFavoritos(arrayData);
    }else{
        evento.target.innerHTML = "favorite_border";
        quitarDeFavoritos(arrayData);
    }
}

function cargarFavorito(arrayData , favorito){
    fetch('consultarFavorito' , {
        headers: {'Content-Type': 'application/json'},
        method: 'POST',
        body: JSON.stringify(arrayData)        
    })
    .then(response => isResponseOk(response))
    .then(data => favorito.innerHTML = data)
    .catch(showError);
}

function agregarAFavoritos(arrayData){
    fetch('agregarFavorito' , {
        headers: {'Content-Type': 'application/json'},
        method: 'POST',
        body: JSON.stringify(arrayData)
    })
    .then(response => isResponseOk(response))
    .then(data => showMessage(data))
    .catch(showError);
}

function quitarDeFavoritos(arrayData){
    fetch('eliminarFavorito' , {
        headers: {'Content-Type': 'application/json'},
        method: 'POST',
        body: JSON.stringify(arrayData)
    })
    .then(response => isResponseOk(response))
    .then(data => showMessage(data))
    .catch(showError);  
}
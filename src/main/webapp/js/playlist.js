const btn_siguiente = document.querySelector("#btn-siguiente");

function recomendaciones(data){
    var engine = new Bloodhound({
        datumTokenizer: Bloodhound.tokenizers.obj.whitespace("nombre"),
        queryTokenizer: Bloodhound.tokenizers.whitespace,
        local:data
      
    });
    
    $( '#buscador' ).typeahead({
        hint: true,
        minLength: 1
    }, {
        display: 'nombre',
        source: engine.ttAdapter(),
        templates: {
            empty: 'No se encontro la cancion',
            suggestion: function ( data ) {
                return '<p>' +  data.nombre + ' - ' + data.artista.nombre + '</p>';
            }
        }
    });
}

const isResponseOk = (response) =>{
    if(!response.ok)
        console.log(response.status);
    return response.text();    
}

function showError(err){
    console.log('muestro error' , err);
}

function traerTodasLasCanciones(){
    fetch('traerTodasLasCanciones' , {
        headers: {'Content-Type': 'application/json'},
        method: 'POST'
    })
    .then(response => isResponseOk(response))
    .then(data => { 
        recomendaciones(JSON.parse(data));
        cancionesJson = JSON.parse(data);
    })
    .catch(showError);        
}

traerTodasLasCanciones();

btn_siguiente.addEventListener("click" , crearPlaylist);



function crearPlaylist(){
    let elementoNombrePlaylist = document.querySelector("#nombrePlaylist");
    if(elementoNombrePlaylist.value != ""){
        fetch('crearPlaylist' , {
            headers: {'Content-Type': 'text/plain'},
            method: 'POST',
            body: elementoNombrePlaylist.value        
        })
        .then(response => isResponseOk(response))
        .then(data => {
            alert(data);
            if(data != "Ya creaste una lista de reproduccion con ese nombre"){
                agregarCancionesALaPlaylist(elementoNombrePlaylist.value);   
            }else{
                elementoNombrePlaylist.value = "";
            }
        }
        )
        .catch(showError);  
    }else{
        alert("No se puede crear una playlist con nombre vacio");
    }
}

function agregarCancionesALaPlaylist(nombrePlaylist){
    document.querySelector("#nombrePlaylistContenedor").setAttribute("hidden" , true);
    document.querySelector("#buscadorContenedor").removeAttribute("hidden");
    btn_anadir = document.querySelector("#btn-anadir");
    arrayData = [nombrePlaylist];
    btn_anadir.addEventListener("click" , agregarCancionALaPlaylist);
}



function agregarCancionALaPlaylist(){
    let inputCancion = document.querySelector("#buscador");
    if(inputCancion.value != ""){
        arrayData.push(inputCancion.value);
        fetch('agregarCancionesALaPlaylist' , {
            headers: {'Content-Type': 'application/json'},
            method: 'POST',
            body: JSON.stringify(arrayData)
        })
        .then(response => isResponseOk(response))
        .then(data => alert(data))
        .catch(showError);
        inputCancion.value = "";
    }else{
        alert("Tenes que seleccionar una cancion");
    }
}


package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Artista;
import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.modelo.Genero;
import ar.edu.unlam.tallerweb1.servicios.ServicioCancion;

@Controller
public class ControladorUsuario {
	
	@Inject
	private ServicioCancion servicioCancion;
	
	@RequestMapping("/uploadSongs")
	public ModelAndView uploadSongs() {
		
		//Crea un album y lo almacena en la bd
		Album album = new Album();
		album.setNombre("Medicine At Midnight");
		album.setPath_img("img/Album/nombre_de_img.jpg");
		Long id_album = servicioCancion.guardarAlbum(album);
		
		//Crea un artista y lo almacena en la bd
		Artista artista = new Artista();
		artista.setNombre("nombre_de_artista");
		Long id_artista = servicioCancion.guardarArtista(artista);
		
		Genero genero = new Genero();
        //Crea 2 generos y los almacena en la bd
		//Se puede agregar o dejar un solo genero depende del album
		genero.setNombre("genero_de_la cancion");
		servicioCancion.guardarGenero(genero);
		
		genero.setNombre("genero_de_la cancio");
		servicioCancion.guardarGenero(genero);
		
		//Crea 3 canciones y las almacena en la bd
		Cancion cancion = new Cancion();
		cancion.setAlbum(servicioCancion.obtenerAlbumPorId(id_album));
		cancion.setArtista(servicioCancion.obtenerArtistaPorId(id_artista));
		
		cancion.setNombre("nombre_de_cancion");
		cancion.setPath_cancion("media/album_del_disco/cancion.mp3");
		servicioCancion.guardarCancion(cancion);
		
		cancion.setNombre("nombre_de_cancion");
		cancion.setPath_cancion("media/album_del_disco/cancion.mp3");
		servicioCancion.guardarCancion(cancion);
		
		cancion.setNombre("nombre_de_cancion");
		cancion.setPath_cancion("media/album_del_disco/cancion.mp3");
		servicioCancion.guardarCancion(cancion);
		
		ModelMap model = new ModelMap();
		
		model.put("artista", id_artista);
		model.put("album", id_album);
		return new ModelAndView("viewUploadSongs",model);
	}
	
	@RequestMapping("/Album")
	public ModelAndView album(
		@RequestParam(value="idArtista",required=false)Long id_artista,
		@RequestParam(value="idAlbum",required=false)Long id_album)
	{
		ModelMap model = new ModelMap();
		
		model.put("nombreArtista", servicioCancion.obtenerArtistaPorId(id_artista).getNombre());
		model.put("nombreAlbum", servicioCancion.obtenerAlbumPorId(id_album).getNombre());
		model.put("imagenAlbum", servicioCancion.obtenerAlbumPorId(id_album).getPath_img());
		model.put("canciones", servicioCancion.obtenerTodasLasCanciones());
		
		
		return new ModelAndView ("viewAlbum",model);
	}
}

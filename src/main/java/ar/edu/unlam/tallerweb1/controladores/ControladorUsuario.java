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
		album.setPath_img("img/Album/Medicine_at_midnight.jpg");
		album.setPuntaje(100L);
		Long id_album = servicioCancion.guardarAlbum(album);
		
		//Crea un artista y lo almacena en la bd
		Artista artista = new Artista();
		artista.setNombre("Foo Fighters");
		artista.setPuntaje(1000L);
		Long id_artista = servicioCancion.guardarArtista(artista);
		
		Genero genero = new Genero();
        //Crea 2 generos y los almacena en la bd
		//Se puede agregar o dejar un solo genero depende del album
		genero.setNombre("Rock");
		servicioCancion.guardarGenero(genero);
		
		genero.setNombre("Indie");
		servicioCancion.guardarGenero(genero);
		
		//Crea 7 canciones y las almacena en la bd
		Cancion cancion = new Cancion();
		cancion.setAlbum(servicioCancion.obtenerAlbumPorId(id_album));
		cancion.setArtista(servicioCancion.obtenerArtistaPorId(id_artista));
		
		cancion.setNombre("Making A Fire");
		cancion.setPath_cancion("media/Medicine at midnight/Making A Fire.mp3");
		cancion.setPuntaje(1L);
		servicioCancion.guardarCancion(cancion);
		
		cancion.setNombre("Shame Shame");
		cancion.setPath_cancion("media/Medicine at midnight/Shame Shame.mp3");
		cancion.setPuntaje(2L);
		servicioCancion.guardarCancion(cancion);
		
		cancion.setNombre("Cloudspotter");
		cancion.setPath_cancion("media/Medicine at midnight/Cloudspotter.mp3");
		cancion.setPuntaje(3L);
		servicioCancion.guardarCancion(cancion);
		
		cancion.setNombre("Waiting On A War");
		cancion.setPath_cancion("media/Medicine at midnight/Waiting On A War.mp3");
		cancion.setPuntaje(4L);
		servicioCancion.guardarCancion(cancion);
		
		cancion.setNombre("Medicine At Night");
		cancion.setPath_cancion("media/Medicine at midnight/Medicine At Midnight.mp3");
		cancion.setPuntaje(5L);
		servicioCancion.guardarCancion(cancion);
		
		cancion.setNombre("No Son Of Mine");
		cancion.setPath_cancion("media/Medicine at midnight/No Son Of Mine.mp3");
		cancion.setPuntaje(6L);
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
		model.put("canciones", servicioCancion.obtenerLasCincoMejoresCanciones());
		
		
		return new ModelAndView ("viewAlbum",model);
	}
}

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

		// Crea un album y lo almacena en la bd
		Album album = new Album();
		album.setNombre("Back In Black");
		album.setPath_img("img/Album/BackInBlack.jpg");
		Long id_album = servicioCancion.guardarAlbum(album);

		Album album1 = new Album();
		album1.setNombre("Dynasty");
		album1.setPath_img("img/Album/Dynasty.jpg");
		Long id_album1 = servicioCancion.guardarAlbum(album1);

		// Crea un artista y lo almacena en la bd
		Artista artista = new Artista();
		artista.setNombre("AC/DC");
		Long id_artista = servicioCancion.guardarArtista(artista);

		Artista artista1 = new Artista();
		artista1.setNombre("Kiss");
		Long id_artista1 = servicioCancion.guardarArtista(artista1);

		Genero genero = new Genero();
		// Crea 2 generos y los almacena en la bd
		// Se puede agregar o dejar un solo genero depende del album
		genero.setNombre("Rock");
		servicioCancion.guardarGenero(genero);

		genero.setNombre("Rock");
		servicioCancion.guardarGenero(genero);

		// Crea 3 canciones y las almacena en la bd
		Cancion cancion = new Cancion();
		cancion.setAlbum(servicioCancion.obtenerAlbumPorId(id_album));
		cancion.setArtista(servicioCancion.obtenerArtistaPorId(id_artista));

		cancion.setNombre("Hells Bells");
		cancion.setPath_cancion("media/BackInBlack/HellsBells.mp3");
		servicioCancion.guardarCancion(cancion);

		cancion.setNombre("Shoot To Thrill");
		cancion.setPath_cancion("media/BackInBlack/ShootToThrill.mp3");
		servicioCancion.guardarCancion(cancion);

		cancion.setNombre("You Shook Me All Night Long");
		cancion.setPath_cancion("media/BackInBlack/YouShookMeAllNightLong.mp3");
		servicioCancion.guardarCancion(cancion);

		cancion.setAlbum(servicioCancion.obtenerAlbumPorId(id_album1));
		cancion.setArtista(servicioCancion.obtenerArtistaPorId(id_artista1));

		cancion.setNombre("I Was Made For Loving You");
		cancion.setPath_cancion("media/Dynasty/IWasMadeForLovinYou.mp3");
		servicioCancion.guardarCancion(cancion);

		cancion.setNombre("Sure Know Something");
		cancion.setPath_cancion("media/Dynasty/SureKnowSomething.mp3");
		servicioCancion.guardarCancion(cancion);

		ModelMap model = new ModelMap();

		model.put("artista", id_artista);
		model.put("artista", id_artista1);
		model.put("album", id_album);
		model.put("album", id_album1);
		return new ModelAndView("viewUploadSongs", model);
	}

	@RequestMapping("/Album")
	public ModelAndView album(@RequestParam(value = "idArtista", required = false) Long id_artista,
			@RequestParam(value = "idAlbum", required = false) Long id_album) {
		ModelMap model = new ModelMap();

		model.put("nombreArtista", servicioCancion.obtenerArtistaPorId(id_artista).getNombre());
		model.put("nombreAlbum", servicioCancion.obtenerAlbumPorId(id_album).getNombre());
		model.put("imagenAlbum", servicioCancion.obtenerAlbumPorId(id_album).getPath_img());
		model.put("canciones", servicioCancion.obtenerTodasLasCanciones());

		return new ModelAndView("viewAlbum", model);
	}

	int upload = 0;

	@RequestMapping("/Inicio")
	public ModelAndView inicio() {

		if (upload < 1) {
			uploadSongs();
			upload++;
		}

		ModelMap model = new ModelMap();

		model.put("titulo", "Inicio");
		model.put("canciones", servicioCancion.obtenerTodasLasCanciones());

		return new ModelAndView("Inicio", model);
	}

}

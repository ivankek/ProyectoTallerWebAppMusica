package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Follow;
import ar.edu.unlam.tallerweb1.modelo.ListaReproduccion;
import ar.edu.unlam.tallerweb1.servicios.ServicioBusqueda;
import ar.edu.unlam.tallerweb1.servicios.ServicioCancion;
import ar.edu.unlam.tallerweb1.servicios.ServicioFollow;
import ar.edu.unlam.tallerweb1.servicios.ServicioListaReproduccion;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

@Controller
public class ControladorUsuario {

	@Inject
	private ServicioCancion servicioCancion;

	@Inject
	private ServicioBusqueda servicioBusqueda;

	@Inject
	private ServicioListaReproduccion servicioListaReproduccion;
	
	@Inject
	private ServicioFollow servicioFollow;

	@RequestMapping("/uploadSongs")
	public ModelAndView uploadSongs() {
		/*
		 * Antes se inicializaba por aca ahora se ejecuta un script ver scrpit loadSongs
		 * // Crea un album y lo almacena en la bd Album album = new Album();
		 * album.setNombre("Back In Black");
		 * album.setPath_img("img/Album/BackInBlack.jpg"); Long id_album =
		 * servicioCancion.guardarAlbum(album);
		 * 
		 * Album album1 = new Album(); album1.setNombre("Dynasty");
		 * album1.setPath_img("img/Album/Dynasty.jpg"); Long id_album1 =
		 * servicioCancion.guardarAlbum(album1);
		 * 
		 * // Crea un artista y lo almacena en la bd Artista artista = new Artista();
		 * artista.setNombre("AC/DC"); Long id_artista =
		 * servicioCancion.guardarArtista(artista);
		 * 
		 * Artista artista1 = new Artista(); artista1.setNombre("Kiss"); Long
		 * id_artista1 = servicioCancion.guardarArtista(artista1);
		 * 
		 * Genero genero = new Genero(); // Crea 2 generos y los almacena en la bd // Se
		 * puede agregar o dejar un solo genero depende del album
		 * genero.setNombre("Rock"); servicioCancion.guardarGenero(genero);
		 * 
		 * genero.setNombre("Rock"); servicioCancion.guardarGenero(genero);
		 * 
		 * // Crea 3 canciones y las almacena en la bd Cancion cancion = new Cancion();
		 * cancion.setAlbum(servicioCancion.obtenerAlbumPorId(id_album));
		 * cancion.setArtista(servicioCancion.obtenerArtistaPorId(id_artista));
		 * 
		 * cancion.setNombre("Hells Bells");
		 * cancion.setPath_cancion("media/BackInBlack/HellsBells.mp3");
		 * servicioCancion.guardarCancion(cancion);
		 * 
		 * cancion.setNombre("Shoot To Thrill");
		 * cancion.setPath_cancion("media/BackInBlack/ShootToThrill.mp3");
		 * servicioCancion.guardarCancion(cancion);
		 * 
		 * cancion.setNombre("You Shook Me All Night Long");
		 * cancion.setPath_cancion("media/BackInBlack/YouShookMeAllNightLong.mp3");
		 * servicioCancion.guardarCancion(cancion);
		 * 
		 * cancion.setAlbum(servicioCancion.obtenerAlbumPorId(id_album1));
		 * cancion.setArtista(servicioCancion.obtenerArtistaPorId(id_artista1));
		 * 
		 * cancion.setNombre("I Was Made For Loving You");
		 * cancion.setPath_cancion("media/Dynasty/IWasMadeForLovinYou.mp3");
		 * servicioCancion.guardarCancion(cancion);
		 * 
		 * cancion.setNombre("Sure Know Something");
		 * cancion.setPath_cancion("media/Dynasty/SureKnowSomething.mp3");
		 * servicioCancion.guardarCancion(cancion);
		 * 
		 * ModelMap model = new ModelMap();
		 * 
		 * model.put("artista", id_artista); model.put("artista", id_artista1);
		 * model.put("album", id_album); model.put("album", id_album1);
		 */

		return new ModelAndView("viewUploadSongs");
	}

	@RequestMapping("/Album")
	public ModelAndView album(@RequestParam(value = "nombre", required = false) String album) {
		ModelMap model = new ModelMap();

		model.put("canciones", servicioBusqueda.buscarCancionPorTodosLosCampos(album));
		model.put("titulo", "Album - " + album);
		model.put("datos", servicioCancion.serializarDatosCanciones());

		return new ModelAndView("viewAlbum", model);
	}
	
	@RequestMapping("/Artista")
	public ModelAndView artista(@RequestParam(value= "nombre", required = false) String artista) {
		ModelMap model = new ModelMap();

		model.put("canciones", servicioBusqueda.buscarCancionPorTodosLosCampos(artista));
		model.put("titulo", "Artista - " + artista);
		model.put("datos", servicioCancion.serializarDatosCanciones());
		model.put("artista",servicioCancion.obtenerArtistaPorNombre(artista));

		return new ModelAndView("viewArtista", model);
	}

	@RequestMapping("/Inicio")
	public ModelAndView inicio(HttpServletRequest request) {

		ModelMap model = new ModelMap();

		model.put("titulo", "Inicio");
		model.put("canciones", servicioCancion.obtenerLasCincoMejoresCanciones());
		model.put("datos", servicioCancion.serializarDatosCanciones());
		Object usuario = request.getSession().getAttribute("usuario");
		model.put("usuario", usuario);
		model.put("PlaylistCantidad", servicioListaReproduccion.obtenerTodasLasListasDeReproduccion().size());

		return new ModelAndView("Inicio", model);
	}

	@RequestMapping("/CrearPlaylist")
	public ModelAndView crearPlaylist(@RequestParam(value = "nombrePlaylist", required = false) String nombrePlaylist,
			@RequestParam(value = "usuario", required = false) String usuario) {
		ModelMap model = new ModelMap();

		ListaReproduccion listaReproduccion = new ListaReproduccion();

		listaReproduccion.setUsuario(servicioListaReproduccion.obtenerUsuarioPorNombre(usuario));
		listaReproduccion.setNombre(nombrePlaylist);
		servicioListaReproduccion.guardarListaReproduccion(listaReproduccion);

		return new ModelAndView("redirect:/Inicio");

	}
	
	@RequestMapping("/FollowArtista")
	public ModelAndView seguirArtista(@RequestParam(value="artista",required= false) String artista) {
		ModelMap modelo = new ModelMap();
		
		Follow follow = new Follow();
		
		follow.setArtista(servicioFollow.obtenerArtistaPorNombre(artista));
		servicioFollow.guardarArtistaSeguido(follow);
		return new ModelAndView("viewArtista");
	}
}

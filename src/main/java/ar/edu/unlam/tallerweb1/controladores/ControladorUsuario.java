package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Artista;
import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.modelo.CancionLista;
import ar.edu.unlam.tallerweb1.modelo.Follow;
import ar.edu.unlam.tallerweb1.modelo.ListaReproduccion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioBusqueda;
import ar.edu.unlam.tallerweb1.servicios.ServicioCancion;
import ar.edu.unlam.tallerweb1.servicios.ServicioFavorito;
import ar.edu.unlam.tallerweb1.servicios.ServicioFollow;
import ar.edu.unlam.tallerweb1.servicios.ServicioListaReproduccion;
import ar.edu.unlam.tallerweb1.servicios.ServicioRecomendar;

@Controller
public class ControladorUsuario {

	@Inject
	private ServicioRecomendar servicioRecomendar;

	@Inject
	private ServicioCancion servicioCancion;

	@Inject
	private ServicioBusqueda servicioBusqueda;

	@Inject
	private ServicioListaReproduccion servicioListaReproduccion;

	@Inject
	private ServicioFollow servicioFollow;

	@RequestMapping("/Album")
	public ModelAndView album(@RequestParam(value = "nombre", required = false) String album) {
		ModelMap model = new ModelMap();

		model.put("canciones", servicioBusqueda.buscarCancionPorTodosLosCampos(album));
		model.put("titulo", "Album - " + album);
		model.put("datos", servicioCancion.serializarDatosCanciones());

		return new ModelAndView("viewAlbum", model);
	}

	@RequestMapping("/Artista")
	public ModelAndView artista(@RequestParam(value = "nombre", required = false) String artista) {
		ModelMap model = new ModelMap();

		model.put("canciones", servicioBusqueda.buscarCancionPorTodosLosCampos(artista));
		model.put("titulo", "Artista - " + artista);
		model.put("datos", servicioCancion.serializarDatosCanciones());
		model.put("artista", servicioCancion.obtenerArtistaPorNombre(artista));

		return new ModelAndView("viewArtista", model);
	}

	@RequestMapping("/Inicio")
	public ModelAndView inicio(HttpServletRequest request) {

		ModelMap model = new ModelMap();

		model.put("titulo", "Inicio");
		model.put("canciones", servicioCancion.obtenerLasCincoMejoresCanciones());
		model.put("datos", servicioCancion.serializarDatosCanciones());
		Object usuario = request.getSession().getAttribute("usuario");
		Usuario user = (Usuario) request.getSession().getAttribute("usuario");

		model.put("recomendaciones", servicioRecomendar.recomendarArtistaPorGenerosDelUsuario(user));
		model.put("condicion", servicioRecomendar.recomendarArtistaPorGenerosDelUsuario(user).isEmpty());
		model.put("usuario", usuario);
//		model.put("PlaylistCantidad", servicioListaReproduccion.obtenerTodasLasListasDeReproduccion().size());

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

	@RequestMapping("/MisPlaylist")
	public ModelAndView crearPlaylist(HttpServletRequest request) {
		ModelMap model = new ModelMap();
		Usuario user = (Usuario) request.getSession().getAttribute("usuario");
		model.put("usuario", user);
		model.put("listas", servicioListaReproduccion.obtenerListaReproduccionPorUsuario(user));

//		Artista artista = new Artista();
//		artista.setNombre("AC/DC");
//		Long id_artista = servicioCancion.guardarArtista(artista);
//
//		Album album = new Album();
//		album.setNombre("Back In Black");
//		Long id_album = servicioCancion.guardarAlbum(album);
//
//		ListaReproduccion listaReproduccion = new ListaReproduccion();
//		listaReproduccion.setNombre("Rock");
//		listaReproduccion.setUsuario(user);
//		servicioListaReproduccion.guardarListaReproduccion(listaReproduccion);
//
//		ListaReproduccion listaReproduccion2 = new ListaReproduccion();
//		listaReproduccion2.setNombre("Metal");
//		listaReproduccion2.setUsuario(user);
//		servicioListaReproduccion.guardarListaReproduccion(listaReproduccion2);
//
//		Cancion cancion = new Cancion();
//		cancion.setNombre("Hells Bells");
//		cancion.setArtista(servicioCancion.obtenerArtistaPorId(id_artista));
//		cancion.setAlbum(servicioCancion.obtenerAlbumPorId(id_album));
//		servicioCancion.guardarCancion(cancion);
//
//		Cancion cancion2 = new Cancion();
//		cancion2.setNombre("Back In Black");
//		cancion2.setArtista(servicioCancion.obtenerArtistaPorId(id_artista));
//		cancion2.setAlbum(servicioCancion.obtenerAlbumPorId(id_album));
//		servicioCancion.guardarCancion(cancion2);
//
//		// Asociar canci�n a Playlist
//		CancionLista cancionLista = new CancionLista();
//		cancionLista.setCancion(cancion);
//		cancionLista.setListaReproduccion(listaReproduccion);
//		servicioListaReproduccion.guardarCancionLista(cancionLista);
//
//		CancionLista cancionLista2 = new CancionLista();
//		cancionLista2.setCancion(cancion);
//		cancionLista2.setListaReproduccion(listaReproduccion2);
//		servicioListaReproduccion.guardarCancionLista(cancionLista2);
//
//		CancionLista cancionLista3 = new CancionLista();
//		cancionLista3.setCancion(cancion2);
//		cancionLista3.setListaReproduccion(listaReproduccion);
//		servicioListaReproduccion.guardarCancionLista(cancionLista3);
//
//		CancionLista cancionLista4 = new CancionLista();
//		cancionLista4.setCancion(cancion2);
//		cancionLista4.setListaReproduccion(listaReproduccion2);
//		servicioListaReproduccion.guardarCancionLista(cancionLista4);

		return new ModelAndView("MisPlaylist", model);
	}

	@RequestMapping("/FollowArtista")
	public ModelAndView seguirArtista(@RequestParam(value = "artista", required = false) String artista) {
		ModelMap modelo = new ModelMap();

		Follow follow = new Follow();

		follow.setArtista(servicioFollow.obtenerArtistaPorNombre(artista));
		servicioFollow.guardarArtistaSeguido(follow);
		return new ModelAndView("viewArtista");
	}
}

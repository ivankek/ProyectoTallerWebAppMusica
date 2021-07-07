package ar.edu.unlam.tallerweb1.controladores;

import java.util.Set;

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
import ar.edu.unlam.tallerweb1.modelo.FollowPlaylist;
import ar.edu.unlam.tallerweb1.modelo.FollowUsuario;
import ar.edu.unlam.tallerweb1.modelo.ListaReproduccion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioBusqueda;
import ar.edu.unlam.tallerweb1.servicios.ServicioCancion;
import ar.edu.unlam.tallerweb1.servicios.ServicioFavorito;
import ar.edu.unlam.tallerweb1.servicios.ServicioFollow;
import ar.edu.unlam.tallerweb1.servicios.ServicioFollowPlaylist;
import ar.edu.unlam.tallerweb1.servicios.ServicioFollowUsuario;
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

	@Inject
	private ServicioFollowPlaylist servicioFollowPlaylist;

	@Inject
	private ServicioFollowUsuario servicioFollowUsuario;

	@RequestMapping("/Album")
	public ModelAndView album(HttpServletRequest request,
			@RequestParam(value = "nombre", required = false) String album) {
		ModelMap model = new ModelMap();
		Usuario user = (Usuario) request.getSession().getAttribute("usuario");
		model.put("usuario", user);
		model.put("canciones", servicioBusqueda.buscarCancionPorTodosLosCampos(album));
		model.put("titulo", "Album - " + album);
		model.put("datos", servicioCancion.serializarDatosCanciones());

		return new ModelAndView("viewAlbum", model);
	}

	@RequestMapping("/Artista")
	public ModelAndView artista(HttpServletRequest request,
			@RequestParam(value = "nombre", required = false) String artista) {
		ModelMap model = new ModelMap();

		model.put("canciones", servicioBusqueda.buscarCancionPorTodosLosCampos(artista));
		model.put("titulo", "Artista - " + artista);
		model.put("datos", servicioCancion.serializarDatosCanciones());
		model.put("artista", servicioCancion.obtenerArtistaPorNombre(artista));
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		model.put("usuario", usuario);
		model.put("seguidores", servicioFollow.obtenerSeguidoresPorArtista(artista).size());
		return new ModelAndView("viewArtista", model);
	}

	@RequestMapping("/Usuario")
	public ModelAndView usuario(HttpServletRequest request,
			@RequestParam(value = "nombre", required = false) String user) {
		ModelMap model = new ModelMap();
		model.put("titulo", "Usuario - " + user);
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		model.put("usuario", usuario);
		model.put("seguidoresUsuario", servicioFollowUsuario
				.obtenerSeguidoresPorUsuario(servicioListaReproduccion.obtenerUsuarioPorNombre(user)).size());
		model.put("user", servicioListaReproduccion.obtenerUsuarioPorNombre(user));
		model.put("seguidosArtistas", servicioFollow
				.obtenerArtistasSeguidosPorUsuario(servicioListaReproduccion.obtenerUsuarioPorNombre(user)).size());
		model.put("seguidosPlaylist", servicioFollowPlaylist
				.obtenerPlaylistSeguidosPorUsuario(servicioListaReproduccion.obtenerUsuarioPorNombre(user)).size());
		model.put("seguidosUsuarios", servicioFollowUsuario
				.obtenerUsuariosSeguidosPorUsuario(servicioListaReproduccion.obtenerUsuarioPorNombre(user)).size());
		model.put("listas", servicioListaReproduccion
				.obtenerListaReproduccionPorUsuario(servicioListaReproduccion.obtenerUsuarioPorNombre(user)));

		return new ModelAndView("viewUsuario", model);
	}

	@RequestMapping("/Inicio")
	public ModelAndView inicio(HttpServletRequest request) {

		ModelMap model = new ModelMap();

		model.put("titulo", "Inicio");
		model.put("canciones", servicioCancion.obtenerLasCincoMejoresCanciones());
		model.put("datos", servicioCancion.serializarDatosCanciones());
		Usuario user = (Usuario) request.getSession().getAttribute("usuario");
		model.put("listas", servicioListaReproduccion.obtenerListaReproduccionPorUsuario(user));
		model.put("recomendaciones", servicioRecomendar.recomendarArtistaPorGenerosDelUsuario(user));
		model.put("condicion", servicioRecomendar.recomendarArtistaPorGenerosDelUsuario(user).isEmpty());
		model.put("usuario", user);
//		model.put("PlaylistCantidad", servicioListaReproduccion.obtenerTodasLasListasDeReproduccion().size());

		return new ModelAndView("Inicio", model);
	}

	@RequestMapping("/CrearPlaylist")
	public ModelAndView crearPlaylist(HttpServletRequest request,
			@RequestParam(value = "nombrePlaylist", required = false) String nombrePlaylist,
			@RequestParam(value = "usuario", required = false) String usuario) {

		ModelMap model = new ModelMap();
		ListaReproduccion listaReproduccion = new ListaReproduccion();
		Usuario user = (Usuario) request.getSession().getAttribute("usuario");
		model.put("usuario", user);
		listaReproduccion.setUsuario(servicioListaReproduccion.obtenerUsuarioPorNombre(usuario));
		listaReproduccion.setNombre(nombrePlaylist);
		servicioListaReproduccion.guardarListaReproduccion(listaReproduccion);
		return new ModelAndView("redirect:/MisPlaylist");

	}

	@RequestMapping("/MisPlaylist")
	public ModelAndView crearPlaylist(HttpServletRequest request) {
		ModelMap model = new ModelMap();
		Usuario user = (Usuario) request.getSession().getAttribute("usuario");
		model.put("usuario", user);
		model.put("listas", servicioListaReproduccion.obtenerListaReproduccionPorUsuario(user));

		return new ModelAndView("MisPlaylist", model);
	}

	@RequestMapping("/viewLista")
	public ModelAndView viewLista(HttpServletRequest request,
			@RequestParam(value = "idPlaylist", required = false) Long idPlaylist) {
		ModelMap model = new ModelMap();
		Usuario user = (Usuario) request.getSession().getAttribute("usuario");
		model.put("usuario", user);
		model.put("idPlaylist", idPlaylist);
		model.put("Playlist", servicioListaReproduccion.obtenerListaPorId(idPlaylist));
		model.put("cancionesLista", servicioListaReproduccion
				.obtenerCancionesDeLista(servicioListaReproduccion.obtenerListaPorId(idPlaylist)));

		return new ModelAndView("viewLista", model);
	}

	@RequestMapping("/AgregarCancionAPlaylist")
	public ModelAndView agregarCancionAPlaylist(HttpServletRequest request,
			@RequestParam(value = "idCancion", required = false) Long idCancion,
			@RequestParam(value = "idPlaylist", required = false) Long idPlaylist) {

		ModelMap model = new ModelMap();
		Usuario user = (Usuario) request.getSession().getAttribute("usuario");
		model.put("usuario", user);
		model.put("idCancion", idCancion);
		model.put("idPlaylist", idPlaylist);
		CancionLista cancionLista = new CancionLista();
		cancionLista.setCancion(servicioCancion.obtenerCancionPorId(idCancion));
		cancionLista.setListaReproduccion(servicioListaReproduccion.obtenerListaPorId(idPlaylist));
		servicioListaReproduccion.guardarCancionLista(cancionLista);

		return new ModelAndView("redirect:/Inicio");
	}

	@RequestMapping("/FollowArtista")
	public ModelAndView seguirArtista(HttpServletRequest request,
			@RequestParam(value = "artista", required = false) Long artista) {

		ModelMap modelo = new ModelMap();
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		Follow follow = new Follow();
		follow.setArtista(servicioCancion.obtenerArtistaPorId(artista));
		follow.setUsuario(servicioListaReproduccion.obtenerUsuarioPorId(usuario.getId()));
		servicioFollow.guardarFollow(follow);
		return new ModelAndView("redirect:/Artista?nombre=" + follow.getArtista().getNombre());
	}

	@RequestMapping("/FollowPlaylist")
	public ModelAndView seguirPlaylist(HttpServletRequest request,
			@RequestParam(value = "playlist", required = false) Long playlist) {

		ModelMap modelo = new ModelMap();
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		FollowPlaylist followPlaylist = new FollowPlaylist();
		followPlaylist.setListaReproduccion(servicioListaReproduccion.obtenerListaPorId(playlist));
		followPlaylist.setUsuario(servicioListaReproduccion.obtenerUsuarioPorId(usuario.getId()));
		servicioFollowPlaylist.guardarFollowPlaylist(followPlaylist);
		return new ModelAndView(
				"redirect:/realizarBusqueda?busqueda=" + followPlaylist.getListaReproduccion().getNombre());
	}

	@RequestMapping("/FollowUsuario")
	public ModelAndView seguirUsuario(HttpServletRequest request,
			@RequestParam(value = "user", required = false) Long user) {

		ModelMap modelo = new ModelMap();
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
		FollowUsuario followUsuario = new FollowUsuario();
		followUsuario.setUsuario(servicioListaReproduccion.obtenerUsuarioPorId(usuario.getId()));
		followUsuario.setUsuarioSeguido(servicioListaReproduccion.obtenerUsuarioPorId(user));
		servicioFollowUsuario.guardarFollowUsuario(followUsuario);
		return new ModelAndView("redirect:/Usuario?nombre=" + followUsuario.getUsuarioSeguido().getUsuario());

	}

	@RequestMapping("/viewArtistasSeguidos")
	public ModelAndView mostrarArtistasSeguidos(HttpServletRequest request) {

		ModelMap modelo = new ModelMap();
		Usuario user = (Usuario) request.getSession().getAttribute("usuario");
		modelo.put("usuario", user);
		modelo.put("artistasSeguidos", servicioFollow.obtenerArtistasSeguidosPorUsuario(user));
		return new ModelAndView("viewArtistasSeguidos", modelo);
	}

	@RequestMapping("/viewExplorarTodo")
	public ModelAndView explorarTodo(HttpServletRequest request) {
		ModelMap model = new ModelMap();

		model.put("titulo", "Explorar Todo");
		Usuario user = (Usuario) request.getSession().getAttribute("usuario");
		model.put("usuario", user);
		model.put("datos", servicioCancion.serializarDatosCanciones());
		return new ModelAndView("viewExplorarTodo", model);
	}

	@RequestMapping("/viewExplorarTodosLosArtistas")
	public ModelAndView explorarArtistas(HttpServletRequest request,
			@RequestParam(value = "artista", required = false) String artista) {
		ModelMap model = new ModelMap();

		Usuario user = (Usuario) request.getSession().getAttribute("usuario");
		model.put("usuario", user);
		model.put("titulo", "Explorar Artistas");
		model.put("datos", servicioCancion.serializarDatosCanciones());
		model.put("artista", servicioCancion.obtenerTodosLosArtistas());

		return new ModelAndView("viewExplorarTodosLosArtistas", model);
	}

	@RequestMapping("/viewExplorarTodosLosAlbums")
	public ModelAndView explorarAlbums(HttpServletRequest request,
			@RequestParam(value = "album", required = false) String album) {
		ModelMap model = new ModelMap();

		Usuario user = (Usuario) request.getSession().getAttribute("usuario");
		model.put("usuario", user);
		model.put("titulo", "Explorar Albums");
		model.put("datos", servicioCancion.serializarDatosCanciones());
		model.put("album", servicioCancion.obtenerTodosLosAlbums());

		return new ModelAndView("viewExplorarTodosLosAlbums", model);
	}

	@RequestMapping("/viewExplorarTodasLasCanciones")
	public ModelAndView explorarCanciones(HttpServletRequest request,
			@RequestParam(value = "cancion", required = false) String cancion) {
		ModelMap model = new ModelMap();

		Usuario user = (Usuario) request.getSession().getAttribute("usuario");
		model.put("usuario", user);
		model.put("titulo", "Explorar Canciones");
		model.put("datos", servicioCancion.serializarDatosCanciones());
		model.put("cancion", servicioCancion.obtenerTodasLasCanciones());

		return new ModelAndView("viewExplorarTodasLasCanciones", model);
	}

	@RequestMapping("viewExplorarTodosLosGeneros")
	public ModelAndView explorarGeneros(HttpServletRequest request,
			@RequestParam(value = "genero", required = false) String genero) {

		ModelMap model = new ModelMap();

		Usuario user = (Usuario) request.getSession().getAttribute("usuario");
		model.put("usuario", user);
		model.put("titulo", "Explorar Géneros");
		model.put("datos", servicioCancion.serializarDatosCanciones());
		model.put("genero", servicioCancion.obtenerTodosLosGeneros());

		return new ModelAndView("viewExplorarTodosLosGeneros", model);
	}

	@RequestMapping("/viewTodasCancionesPorGenero")
	public ModelAndView mostrarCancionesPorGenero(HttpServletRequest request,
			@RequestParam(value = "genero", required = false) String genero) {

		ModelMap model = new ModelMap();

		Usuario user = (Usuario) request.getSession().getAttribute("usuario");
		model.put("usuario", user);
		model.put("genero", genero);
		Set<Cancion> lista = servicioBusqueda.buscarCancionPorTodosLosCampos(genero);
		model.put("cancion", lista);
		return new ModelAndView("viewTodasCancionesPorGenero", model);
	}
}

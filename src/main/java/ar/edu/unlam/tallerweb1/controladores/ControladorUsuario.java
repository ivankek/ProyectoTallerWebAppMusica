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

		Object usuario = request.getSession().getAttribute("usuario");
		model.put("usuario", usuario);
		model.put("seguidores", servicioFollow.obtenerSeguidoresPorArtista(artista).size());
		return new ModelAndView("viewArtista", model);
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
	public ModelAndView seguirArtista(@RequestParam(value = "artista", required = false) Long artista,
			@RequestParam(value = "usuario", required = false) Long usuario) {
		ModelMap modelo = new ModelMap();
		Follow follow = new Follow();
		follow.setArtista(servicioCancion.obtenerArtistaPorId(artista));
		follow.setUsuario(servicioListaReproduccion.obtenerUsuarioPorId(usuario));
		servicioFollow.guardarFollow(follow);
		
		return new ModelAndView("redirect:/Artista?nombre=" + follow.getArtista().getNombre());
	}
}

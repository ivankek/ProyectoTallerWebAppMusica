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
	public ModelAndView artista(HttpServletRequest request, @RequestParam(value= "nombre", required = false) String artista) {
		ModelMap model = new ModelMap();

		model.put("canciones", servicioBusqueda.buscarCancionPorTodosLosCampos(artista));
		model.put("titulo", "Artista - " + artista);
		model.put("datos", servicioCancion.serializarDatosCanciones());
		model.put("artista",servicioCancion.obtenerArtistaPorNombre(artista));
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
		Object usuario = request.getSession().getAttribute("usuario"); 
		Usuario user = (Usuario) request.getSession().getAttribute("usuario");
		
		model.put("recomendaciones", servicioRecomendar.recomendarArtistaPorGenerosDelUsuario(user));
		model.put("condicion", servicioRecomendar.recomendarArtistaPorGenerosDelUsuario(user).isEmpty());
		model.put("usuario", usuario);

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
	public ModelAndView seguirArtista(@RequestParam(value="artista",required= false) Long artista,
									  @RequestParam(value="usuario", required= false) Long usuario) {
		ModelMap modelo = new ModelMap();
		
		Follow follow = new Follow();
		
		follow.setArtista(servicioCancion.obtenerArtistaPorId(artista));
		follow.setUsuario(servicioListaReproduccion.obtenerUsuarioPorId(usuario));
		servicioFollow.guardarFollow(follow);
		return new ModelAndView("redirect:/Inicio");
	}
}

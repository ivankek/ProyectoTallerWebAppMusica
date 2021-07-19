package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioCancion;
import ar.edu.unlam.tallerweb1.servicios.ServicioCancionLista;
import ar.edu.unlam.tallerweb1.servicios.ServicioFavorito;
import ar.edu.unlam.tallerweb1.servicios.ServicioFollow;
import ar.edu.unlam.tallerweb1.servicios.ServicioListaReproduccion;

@RestController
public class ControladorAJAX {

	@Inject
	private ServicioFavorito servicioFavorito;
	
	@Inject
	private ServicioFollow servicioFollow;
	
	@Inject
	private ServicioCancion servicioCancion;
	
	@Inject
	private ServicioListaReproduccion servicioListaReproduccion;
	
	@Inject
	private ServicioCancionLista servicioCancionLista;

	@RequestMapping(value = "/agregarFavorito" , method = RequestMethod.POST)
	public String añadirFavorito(@RequestBody Cancion cancion , HttpServletRequest request) {
		return servicioFavorito.añadirAFavoritos(cancion, (Usuario)request.getSession().getAttribute("usuario"));
	}
	
	@RequestMapping(value = "/eliminarFavorito" , method = RequestMethod.POST)
	public String eliminarFavorito(@RequestBody Cancion cancion , HttpServletRequest request) {
		return servicioFavorito.eliminarFavorito(cancion, (Usuario)request.getSession().getAttribute("usuario"));
	}
	
	@RequestMapping(value = "/consultarFavorito" , method = RequestMethod.POST)
	public String consultarFavorito(@RequestBody Cancion cancion , HttpServletRequest request) {
		return servicioFavorito.consultarSiEstaEnFavoritos(cancion, (Usuario)request.getSession().getAttribute("usuario"));
	}
	
	@RequestMapping(value = "/consultarSeguir" , method = RequestMethod.POST)
	public String consultoSiElUsuarioSigueAlArtista(@RequestBody String artistaNombre , HttpServletRequest request) {
		return servicioFollow.consultarSiElUsuarioSigueAlArtista((Usuario)request.getSession().getAttribute("usuario") , artistaNombre);
	}
	
	@RequestMapping(value = "/seguirArtista" , method = RequestMethod.POST)
	public String seguirArtista(@RequestBody String artistaNombre , HttpServletRequest request) {
		return servicioFollow.seguirArtista((Usuario)request.getSession().getAttribute("usuario"), artistaNombre);
	}
	
	@RequestMapping(value = "/dejarDeSeguirArtista" , method = RequestMethod.POST)
	public String dejarDeSeguirArtista(@RequestBody String artistaNombre , HttpServletRequest request) {
		return servicioFollow.dejarDeSeguir((Usuario)request.getSession().getAttribute("usuario") , artistaNombre);
	}
	
	@RequestMapping(value = "/traerTodasLasCanciones" , method = RequestMethod.POST , produces = "application/json")
	public @ResponseBody List<Cancion> enviarTodasLasCanciones(){
		return servicioCancion.obtenerTodasLasCanciones();
	}
	
	@RequestMapping(value = "/crearPlaylist" , method = RequestMethod.POST)
	public String crearPlaylist(@RequestBody String playlistNombre , HttpServletRequest request ) {
		return servicioListaReproduccion.crearYAlmacenarListaReproduccion(playlistNombre, (Usuario)request.getSession().getAttribute("usuario"));
	}
	
	@RequestMapping(value = "/agregarCancionesALaPlaylist" , method = RequestMethod.POST)
	public String prueba(@RequestBody List<String>datos , HttpServletRequest request) {
		String nombrePlaylist = datos.get(0);
		String nombreCancion = datos.get(1);
		
		return servicioCancionLista.crearYAlmacenarCancionLista((Usuario)request.getSession().getAttribute("usuario"), nombrePlaylist, nombreCancion);
	}
	
	@RequestMapping(value = "/traerUnaCancion" , method = RequestMethod.POST , produces = "application/json")
	public @ResponseBody Cancion enviarCancion(@RequestBody List<String>datos){
		String nombreCancion = datos.get(0);
		String nombreArtista = datos.get(1);
		String nombreAlbum = datos.get(2);
		
		return servicioCancion.obtenerCancionPorNombreArtistaAlbum(nombreCancion, nombreArtista, nombreAlbum);
	}
}

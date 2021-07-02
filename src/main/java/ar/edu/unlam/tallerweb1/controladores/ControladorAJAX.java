package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;


import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioFavorito;
import ar.edu.unlam.tallerweb1.servicios.ServicioFollow;

@RestController
public class ControladorAJAX {

	@Inject
	private ServicioFavorito servicioFavorito;
	
	@Inject
	private ServicioFollow servicioFollow;

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
}

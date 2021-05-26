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
import ar.edu.unlam.tallerweb1.servicios.ServicioBusqueda;
import ar.edu.unlam.tallerweb1.servicios.ServicioCancion;

@Controller
public class ControladorUsuario {

	@Inject
	private ServicioCancion servicioCancion;
	
	@Inject
	private ServicioBusqueda servicioBusqueda;

	@RequestMapping("/uploadSongs")
	public ModelAndView uploadSongs() {


		return new ModelAndView("viewUploadSongs");
	}

	@RequestMapping("/Album")
	public ModelAndView album(@RequestParam(value = "nombre", required = false) String album) {
		ModelMap model = new ModelMap();


		model.put("canciones", servicioBusqueda.obtenerCancionesPorAlbum(album));

		return new ModelAndView("viewAlbum", model);
	}

	@RequestMapping("/Inicio")
	public ModelAndView inicio() {
		
		ModelMap model = new ModelMap();

		model.put("titulo", "Inicio");
		model.put("canciones", servicioCancion.obtenerLasCincoMejoresCanciones());

		return new ModelAndView("Inicio", model);
	}
}

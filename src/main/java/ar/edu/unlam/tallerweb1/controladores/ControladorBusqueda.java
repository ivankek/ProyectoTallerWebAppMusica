package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.modelo.Genero;
import ar.edu.unlam.tallerweb1.servicios.ServicioBusqueda;

@Controller
public class ControladorBusqueda {

	
	private ServicioBusqueda servicioBusqueda;

	@Autowired
	public ControladorBusqueda(ServicioBusqueda servicioBusqueda) {
		this.servicioBusqueda = servicioBusqueda;
	}
	@RequestMapping("/buscar")
	public ModelAndView buscar() {
		return new ModelAndView("busqueda");
	}
	
	@RequestMapping(path=("realizarBusqueda"), method=RequestMethod.GET)
	public ModelAndView realizarBusqueda(
			@RequestParam(value="tipoBusqueda", required=true) String tipo,
			@RequestParam(value="busqueda", required=true) String nombre
			) {
		ModelMap modelo = new ModelMap();
		switch (tipo) {
		case "Genero":
			modelo.put("generos" ,servicioBusqueda.obtenerCancionesPorGenero(nombre));
			break;
			
		case "Artista":
			modelo.put("artistas" ,servicioBusqueda.obtenerCancionesPorArtista(nombre));
			break;
			
		case "Album":
			modelo.put("albums" ,servicioBusqueda.obtenerCancionesPorAlbum(nombre));
			break;
			
		case "Lista":
			modelo.put("listas" ,servicioBusqueda.obtenerCancionesPorLista(nombre));
			break;
			
		case "Cancion":
			modelo.put("canciones" ,servicioBusqueda.obtenerCancionesPorNombre(nombre));
			break;
		default:
			break;
		}
		return new ModelAndView("resultadoBusqueda", modelo);
	}
}

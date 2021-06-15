package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;

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
import ar.edu.unlam.tallerweb1.servicios.ServicioCancion;

@Controller
public class ControladorBusqueda {

	@Inject
	private ServicioCancion servicioCancion;
	
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
			@RequestParam(value="busqueda", required=true) String nombre
			) {
		
		ModelMap modelo = new ModelMap();
		
		modelo.put("datos", servicioCancion.serializarDatosCanciones());
		
		Set<Cancion> lista = servicioBusqueda.buscarCancionPorTodosLosCampos(nombre);
		
		modelo.put("resultado",lista);
		
		return new ModelAndView("resultadoBusqueda", modelo);
	}
}

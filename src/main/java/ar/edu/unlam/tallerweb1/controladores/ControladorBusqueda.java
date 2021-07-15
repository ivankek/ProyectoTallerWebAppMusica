package ar.edu.unlam.tallerweb1.controladores;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Artista;
import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.modelo.Genero;
import ar.edu.unlam.tallerweb1.modelo.ListaReproduccion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioBusqueda;
import ar.edu.unlam.tallerweb1.servicios.ServicioCancion;
import ar.edu.unlam.tallerweb1.servicios.ServicioListaReproduccion;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

@Controller
public class ControladorBusqueda {

	@Inject
	private ServicioCancion servicioCancion;
	private ServicioListaReproduccion servicioListaReproduccion;
	private ServicioBusqueda servicioBusqueda;
	private ServicioLogin servicioLogin;

	@Autowired
	public ControladorBusqueda(ServicioBusqueda servicioBusqueda) {
		this.servicioBusqueda = servicioBusqueda;
	}

	@RequestMapping("/buscar")
	public ModelAndView buscar(HttpServletRequest request) {

		return new ModelAndView("busqueda");
	}

	@RequestMapping(path = ("realizarBusqueda"), method = RequestMethod.GET)
	public ModelAndView realizarBusqueda(HttpServletRequest request,
			@RequestParam(value = "busqueda", required = true) String nombre) {

		ModelMap modelo = new ModelMap();

		Usuario user = (Usuario) request.getSession().getAttribute("usuario");
		modelo.put("usuario", user);
		modelo.put("datos", servicioCancion.serializarDatosCanciones());
		List<Artista> listaArtista = servicioBusqueda.obtenerUnArtistaPorNombre(nombre);
		modelo.put("artista", listaArtista);

		Set<Cancion> lista = servicioBusqueda.buscarCancionPorTodosLosCampos(nombre);

		modelo.put("resultado", lista);

		if (lista.size() == 0) {
			modelo.put("accion", "d-none");
		}

		List<Usuario> usuarioBusqueda = servicioBusqueda.obtenerUsuarioPorNombre(nombre);
		modelo.put("user", usuarioBusqueda);

		List<ListaReproduccion> listaListaReproduccion = servicioBusqueda.obtenerListaReproduccionPorNombre(nombre);
		modelo.put("listaReproduccion", listaListaReproduccion);

		return new ModelAndView("resultadoBusqueda", modelo);
	}
}

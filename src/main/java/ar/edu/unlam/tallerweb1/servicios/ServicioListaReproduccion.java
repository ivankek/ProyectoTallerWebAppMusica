package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.ListaReproduccion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioListaReproduccion {

	Long guardarListaReproduccion(ListaReproduccion listaReproduccion);

	Long guardarUsuario(Usuario usuario);

	Usuario obtenerUsuarioPorId(Long id);

	List<ListaReproduccion> obtenerTodasLasListasDeReproduccion();

	Usuario obtenerUsuarioPorNombre(String usuario);
	
}

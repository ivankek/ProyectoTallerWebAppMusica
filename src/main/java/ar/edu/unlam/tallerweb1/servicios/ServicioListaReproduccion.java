package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.modelo.CancionLista;
import ar.edu.unlam.tallerweb1.modelo.ListaReproduccion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioListaReproduccion {

	Long guardarListaReproduccion(ListaReproduccion listaReproduccion);
	
	Long guardarUsuario(Usuario usuario);
	
	Usuario obtenerUsuarioPorId(Long id);

	Long guardarCancionLista(CancionLista cancionLista);
		
	List<ListaReproduccion> obtenerTodasLasListasDeReproduccion();

	List<ListaReproduccion> obtenerListaReproduccionPorUsuario(Usuario usuario);
	
	Usuario obtenerUsuarioPorNombre(String usuario);
	
}

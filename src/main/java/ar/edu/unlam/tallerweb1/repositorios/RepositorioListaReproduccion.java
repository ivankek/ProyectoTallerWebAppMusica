package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.ListaReproduccion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

import java.util.List;

public interface RepositorioListaReproduccion {

	Long insertarLista(ListaReproduccion listaReproduccion);
	
	List<ListaReproduccion> obtenerTodasLasListasDeReproduccion();

	List<ListaReproduccion> obtenerListaReproduccionPorUsuario(Usuario usuario);

	ListaReproduccion obtenerListaPorId(Long id);

	List<ListaReproduccion> obtenerListaReproduccionPorNombre(String lista);
	
	ListaReproduccion obtenerUnaListaReproduccionPorSuNombreYUsuario(String nombreLista , Usuario usuario);
}

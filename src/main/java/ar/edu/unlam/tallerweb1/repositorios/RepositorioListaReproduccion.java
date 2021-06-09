package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.ListaReproduccion;
import java.util.List;

public interface RepositorioListaReproduccion {

	Long insertarLista(ListaReproduccion listaReproduccion);
	

	List<ListaReproduccion> obtenerTodasLasListasDeReproduccion();

}

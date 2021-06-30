package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.modelo.CancionLista;
import ar.edu.unlam.tallerweb1.modelo.ListaReproduccion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface RepositorioCancionLista {

	Long insertarCancionLista(CancionLista cancionLista);

	List<String> obtenerListasDeUnaCancion(Cancion cancion);

	List<Cancion> obtenerCancionesDeLista(ListaReproduccion listaReproduccion);

}
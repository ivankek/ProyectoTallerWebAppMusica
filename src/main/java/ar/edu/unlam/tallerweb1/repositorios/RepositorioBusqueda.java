package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;
import java.util.Set;

import ar.edu.unlam.tallerweb1.modelo.Artista;
import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.modelo.Genero;

public interface RepositorioBusqueda {

	List<Cancion> obtenerCancionesPorGenero(String nombre);
	
	List<Cancion> obtenerCancionesPorArtista(String nombre);
	
	List<Cancion> obtenerCancionesPorAlbum(String nombre);
	
	List<Cancion> obtenerCancionesPorLista(String nombre);
	
	List<Cancion> obtenerCancionesPorNombre(String nombre);
	
}

package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Artista;
import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.modelo.Genero;

public interface ServicioBusqueda {

	List<Cancion> obtenerCancionesPorGenero(String nombre);
	
	List<Cancion> obtenerCancionesPorArtista(String nombre);
	
	List<Cancion> obtenerCancionesPorAlbum(String nombre);
	
	List<Cancion> obtenerCancionesPorLista(String nombre);
	
	List<Cancion> obtenerCancionesPorNombre(String nombre);
}

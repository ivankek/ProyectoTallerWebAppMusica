package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Artista;

public interface RepositorioArtista {

	Long insertarArtista(Artista artista);
	
	Artista obtenerArtistaPorId (Long id);
	
	List<Artista> obtenerCincoMejoresArtistas();
	
	List<Artista>obtenerTodosLosArtistas();

	Artista obtenerArtistaPorNombre(String artista);

	List<Artista> obtenerUnArtistaPorNombre(String artista);

}

package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Artista;

public interface RepositorioArtista {

	Long insertarArtista(Artista artista);
	
	Artista obtenerArtistaPorId (Long id);
	
	List<Artista> obtenerCincoMejoresArtistas();
	
	Artista obtenerArtistaPorNombre(String artista);
}

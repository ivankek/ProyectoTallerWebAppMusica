package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Artista;

public interface RepositorioArtista {

	Long insertarArtista(Artista artista);
	
	Artista obtenerArtistaPorId (Long id);
}

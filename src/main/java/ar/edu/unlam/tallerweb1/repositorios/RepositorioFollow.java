package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Artista;
import ar.edu.unlam.tallerweb1.modelo.Follow;

public interface RepositorioFollow {

	Long guardarArtistaSeguido(Follow follow);

	Artista obtenerArtistaPorNombre(String artista);

}

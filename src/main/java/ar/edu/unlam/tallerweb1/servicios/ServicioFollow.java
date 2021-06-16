package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Artista;
import ar.edu.unlam.tallerweb1.modelo.Follow;

public interface ServicioFollow {

	Long guardarArtistaSeguido(Follow follow);

	Artista obtenerArtistaPorNombre(String artista);

}

package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Artista;
import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.modelo.CancionGenero;
import ar.edu.unlam.tallerweb1.modelo.Favorito;

public interface ServicioGenero {
	
	Long insertarCancionGenero(CancionGenero cancionGenero);
	List<String> obtenerGenerosDeUnaCancion(Cancion cancion);
	List<String> obtenerGenerosDeUnAlbum(Album album);
	List<String> obtenerGenerosDeUnArtista(Artista artista);
	List<String> obtenerGenerosDeListaDeFavoritos(List<Favorito> listaDeFavoritos);
}

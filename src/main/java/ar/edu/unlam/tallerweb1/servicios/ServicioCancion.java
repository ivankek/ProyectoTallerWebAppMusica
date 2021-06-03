package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Artista;
import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.modelo.CancionGenero;
import ar.edu.unlam.tallerweb1.modelo.Genero;

public interface ServicioCancion {

	Long guardarCancion(Cancion cancion);
	
	Long guardarCancionGenero(CancionGenero cancionGenero);
	
	Long guardarArtista(Artista artista);
	
	Long guardarGenero (Genero genero);
	
	Long guardarAlbum(Album album);
	
	List<Cancion> obtenerTodasLasCanciones();
	
	Artista obtenerArtistaPorId(Long id);
	
	Album obtenerAlbumPorId(Long id);
	
	List<Cancion>obtenerLasCincoMejoresCanciones();
	
	List<Album> obtenerLosCincoMejoresAlbumes();
	
	List<Artista> obtenerLosCincoMejoresArtistas();
	
	String serializarDatosCanciones();
}

package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Album;

public interface RepositorioAlbum {

	Long insertarAlbum(Album album);
	
	Album obtenerAlbumPorId(Long id);
	
	List<Album> obtenerCincoMejoresAlbum();
}

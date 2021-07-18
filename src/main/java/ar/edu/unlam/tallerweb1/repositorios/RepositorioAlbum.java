package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import org.hibernate.SessionFactory;

import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Artista;

public interface RepositorioAlbum {

	Long insertarAlbum(Album album);
	
	Album obtenerAlbumPorId(Long id);

	List<Album> obtenerCincoMejoresAlbum();
	
	List<Album>obtenerTodosLosAlbums();

	Album obtenerAlbumPorNombre(String nombre);

	SessionFactory getSessionFactory();
	
	void setSessionFactory(SessionFactory sessionFactory);
}

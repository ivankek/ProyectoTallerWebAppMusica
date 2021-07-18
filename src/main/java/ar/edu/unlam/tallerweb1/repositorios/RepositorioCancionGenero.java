package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import org.hibernate.SessionFactory;

import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Artista;
import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.modelo.CancionGenero;

public interface RepositorioCancionGenero {
	
	Long insertarCancionGenero(CancionGenero cancionGenero);
	List<String> obtenerGenerosDeUnaCancion(Cancion cancion);
	List<String> obtenerGenerosDeUnAlbum(Album album);
	List<String> obtenerGenerosDeUnArtista(Artista artista);
	
	SessionFactory getSessionFactory();
	
	void setSessionFactory(SessionFactory sessionFactory);
}

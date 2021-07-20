package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;

import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Artista;
import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.modelo.Genero;
import ar.edu.unlam.tallerweb1.modelo.ListaReproduccion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioBusqueda {

	Set<Cancion> buscarCancionPorTodosLosCampos(String nombre);
	
	List<Artista> obtenerUnArtistaPorNombre(String nombre);

	List<ListaReproduccion> obtenerListaReproduccionPorNombre(String nombre);
	
	List<Usuario> obtenerUsuarioPorNombre(String usuario);
	
	List<Album> obtenerUnAlbumPorNombre(String nombre);
}

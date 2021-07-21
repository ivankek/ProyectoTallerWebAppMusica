package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioFavorito {
	List<Favorito> obtenerFavoritosDelUsuario(Usuario usuario);
	
	String a�adirAFavoritos(String nombreCancion, String nombreArtista, String nombreAlbum, Usuario usuario);
	
	String eliminarFavorito(String nombreCancion, String nombreArtista, String nombreAlbum, Usuario usuario);
	
	String consultarSiEstaEnFavoritos(String nombreCancion, String nombreArtista, String nombreAlbum, Usuario usuario);
}

package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioFavorito {
	List<Favorito> obtenerFavoritosDelUsuario(Usuario usuario);
	
	String a�adirAFavoritos(Cancion cancion , Usuario usuario);
	
	String eliminarFavorito(Cancion cancion , Usuario usuario);
	
	String consultarSiEstaEnFavoritos(Cancion cancion , Usuario usuario);
}

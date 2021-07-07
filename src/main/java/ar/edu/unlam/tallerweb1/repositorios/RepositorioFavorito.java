package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface RepositorioFavorito {
	Long añadirAFavoritos(Favorito favorito);
	Boolean quitarFavorito(Favorito favorito);	
	List<Favorito> obtenerListaDeFavoritos(Usuario usuario);
	Favorito buscarFavorito(Cancion cancion , Usuario usuario);
}

package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface RepositorioFavorito {
	Long aņadirAFavoritos(Favorito favorito);
	List<Favorito> obtenerListaDeFavoritos(Usuario usuario);
}

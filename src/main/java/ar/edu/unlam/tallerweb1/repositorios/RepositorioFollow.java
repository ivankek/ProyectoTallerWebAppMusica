package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Artista;
import ar.edu.unlam.tallerweb1.modelo.Follow;
import ar.edu.unlam.tallerweb1.modelo.ListaReproduccion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface RepositorioFollow {

	Long guardarFollow(Follow follow);

	List<Follow> obtenerSeguidoresPorArtista(String artista);

	List<Artista> obtenerArtistasSeguidosPorUsuario(Usuario Usuario);

	List<Follow> obtenerSeguidoresPorUsuario(String usuario);
	
	void dejarDeSeguir(Follow follow);
	
	Follow obtenerRegistroFollow(Usuario usuario , String artistaNombre);
}

package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.FollowPlaylist;
import ar.edu.unlam.tallerweb1.modelo.ListaReproduccion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface RepositorioFollowPlaylist {

	Long guardarFollow(FollowPlaylist followPlaylist);

	List<ListaReproduccion> obtenerPlaylistSeguidasPorUsuario(Usuario usuario);

}

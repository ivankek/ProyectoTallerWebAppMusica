package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.FollowPlaylist;
import ar.edu.unlam.tallerweb1.modelo.ListaReproduccion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioFollowPlaylist {

	Long guardarFollowPlaylist(FollowPlaylist followPlaylist);

	List<ListaReproduccion> obtenerPlaylistSeguidosPorUsuario(Usuario usuario);
}

package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Follow;
import ar.edu.unlam.tallerweb1.modelo.FollowPlaylist;
import ar.edu.unlam.tallerweb1.modelo.FollowUsuario;
import ar.edu.unlam.tallerweb1.modelo.ListaReproduccion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioFollow;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioFollowPlaylist;

@Service
@Transactional
public class ServicioFollowPlaylistImpl implements ServicioFollowPlaylist {

	private RepositorioFollowPlaylist repositorioFollowPlaylist;

	@Autowired
	public ServicioFollowPlaylistImpl(RepositorioFollowPlaylist repositorioFollowPlaylist) {
		this.repositorioFollowPlaylist = repositorioFollowPlaylist;
	}

	@Override
	public Long guardarFollowPlaylist(FollowPlaylist followPlaylist) {
		return repositorioFollowPlaylist.guardarFollow(followPlaylist);
	}

	@Override
	public List<ListaReproduccion> obtenerPlaylistSeguidosPorUsuario(Usuario usuario) {
		return repositorioFollowPlaylist.obtenerPlaylistSeguidasPorUsuario(usuario);
	}

	@Override
	public String dejarDeSeguirPlaylist(Usuario usuario, String listaReproduccion) {
		String estadoDelBotonSeguir = "Siguiendo";
		FollowPlaylist followPlaylist = repositorioFollowPlaylist.obtenerRegistroFollowPlaylist(usuario,
				listaReproduccion);
		if (followPlaylist != null) {
			repositorioFollowPlaylist.dejarDeSeguirPlaylist(followPlaylist);
		}

		return estadoDelBotonSeguir;
	}

}

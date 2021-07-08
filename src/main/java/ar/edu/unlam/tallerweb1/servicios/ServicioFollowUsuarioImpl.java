package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Follow;
import ar.edu.unlam.tallerweb1.modelo.FollowUsuario;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioFollow;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioFollowUsuario;

@Service
@Transactional
public class ServicioFollowUsuarioImpl implements ServicioFollowUsuario {

	private RepositorioFollowUsuario repositorioFollowUsuario;

	@Autowired
	public ServicioFollowUsuarioImpl(RepositorioFollowUsuario repositorioFollowUsuario) {
		this.repositorioFollowUsuario = repositorioFollowUsuario;
	}

	@Override
	public Long guardarFollowUsuario(FollowUsuario followUsuario) {
		return repositorioFollowUsuario.guardarFollow(followUsuario);
	}

	@Override
	public List<Usuario> obtenerUsuariosSeguidosPorUsuario(Usuario usuario) {
		return repositorioFollowUsuario.obtenerUsuariosSeguidosPorUsuario(usuario);
	}

	@Override
	public List<Usuario> obtenerSeguidoresPorUsuario(Usuario usuario) {
		return repositorioFollowUsuario.obtenerSeguidoresPorUsuario(usuario);
	}

	@Override
	public String dejarDeSeguirUsuario(Usuario usuario, String usuarioSeguido) {
		String estadoDelBotonSeguir = "Siguiendo";
		FollowUsuario followUsuario = repositorioFollowUsuario.obtenerRegistroFollowUsuario(usuario, usuarioSeguido);
		if (followUsuario != null) {
			repositorioFollowUsuario.dejarDeSeguirUsuario(followUsuario);
		}

		return estadoDelBotonSeguir;
	}

}

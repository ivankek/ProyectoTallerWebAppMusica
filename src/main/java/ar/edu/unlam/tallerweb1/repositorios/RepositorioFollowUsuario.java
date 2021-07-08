package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.FollowUsuario;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface RepositorioFollowUsuario {

	Long guardarFollow(FollowUsuario followUsuario);

	List<Usuario> obtenerUsuariosSeguidosPorUsuario(Usuario usuario);

	List<Usuario> obtenerSeguidoresPorUsuario(Usuario usuario);

}

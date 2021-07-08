package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.FollowUsuario;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioFollowUsuario {

	Long guardarFollowUsuario(FollowUsuario followUsuario);

	List<Usuario> obtenerUsuariosSeguidosPorUsuario(Usuario usuario);

	List<Usuario> obtenerSeguidoresPorUsuario(Usuario usuario);

	String dejarDeSeguirUsuario(Usuario usuario, String usuarioSeguido);
}

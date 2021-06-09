package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

// Interface que define los metodos del Repositorio de Usuarios.
public interface RepositorioUsuario {
	
	Long insertarUsuario(Usuario usuario);
	Usuario obtenerUsuarioPorId(Long id);
	Usuario consultarUsuario (Usuario usuario);
	Usuario obtenerUsuarioPorNombre(String usuario);
}

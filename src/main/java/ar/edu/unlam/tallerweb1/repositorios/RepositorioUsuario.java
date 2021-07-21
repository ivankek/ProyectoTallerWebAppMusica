package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import org.hibernate.SessionFactory;

import ar.edu.unlam.tallerweb1.modelo.ListaReproduccion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;


public interface RepositorioUsuario {
	
	Long insertarUsuario(Usuario usuario);
	Usuario obtenerUsuarioPorId(Long id);
	Usuario consultarUsuario (Usuario usuario);
	Usuario obtenerUsuarioPorNombre(String usuario);
//	List<Usuario> obtenerUnUsuarioPorNombre(String usuario);
	List<Usuario> obtenerUnUsuarioPorNombre(String usuario);
	
	SessionFactory getSessionFactory();
	
	void setSessionFactory(SessionFactory sessionFactory);
	
}

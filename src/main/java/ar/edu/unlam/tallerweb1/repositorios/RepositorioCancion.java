package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import org.hibernate.SessionFactory;

import ar.edu.unlam.tallerweb1.modelo.Cancion;

public interface RepositorioCancion {
	
	Long insertarCancion(Cancion cancion);
	
	List<Cancion> obtenerTodasLasCanciones();
	
	List<Cancion>obtenerLasCincoMejoresCanciones();
	
	Boolean subirPuntajeDeLaCancion(Cancion cancion);

	Cancion obtenerCancionPorId(Long id);
	
	Cancion obtenerCancionPorSuNombre(String nombreCancion);
	
	SessionFactory getSessionFactory();
	
	void setSessionFactory(SessionFactory sessionFactory);

}

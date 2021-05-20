package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Cancion;


@Repository
public class RepositorioCancionImpl implements RepositorioCancion {

	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public Long insertarCancion(Cancion cancion) {
		Session session = sessionFactory.getCurrentSession();
		return (Long)session.save(cancion);
	}

	@Override
	public List<Cancion> obtenerTodasLasCanciones() {
		Session session = sessionFactory.getCurrentSession();
		return  session.createCriteria(Cancion.class).list();
	}

}

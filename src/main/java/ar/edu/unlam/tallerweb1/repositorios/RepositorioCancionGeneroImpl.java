package ar.edu.unlam.tallerweb1.repositorios;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.CancionGenero;

@Repository
public class RepositorioCancionGeneroImpl implements RepositorioCancionGenero {
	
	@Inject
	private SessionFactory sessionFactory;

	@Override
	public Long insertarCancionGenero(CancionGenero cancionGenero) {
		Session session = sessionFactory.getCurrentSession();
		return (Long)session.save(cancionGenero);
	}

}

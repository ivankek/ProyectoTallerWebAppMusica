package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Genero;

@Repository
public class RepositorioGeneroImpl implements RepositorioGenero {

	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public Long insertarGenero(Genero genero) {
		Session session = sessionFactory.getCurrentSession();
		return (Long)session.save(genero);
	}

	@Override
	public List<Genero> obtenerTodosLosGeneros() {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Genero.class)
				.list();
	}

	
	
}

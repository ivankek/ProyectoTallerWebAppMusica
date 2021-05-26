package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
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

	@Override
	public List<Cancion> obtenerLasCincoMejoresCanciones() {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Cancion.class)
				.addOrder(Order.desc("puntaje"))
				.setMaxResults(5)
				.list();
	}

}

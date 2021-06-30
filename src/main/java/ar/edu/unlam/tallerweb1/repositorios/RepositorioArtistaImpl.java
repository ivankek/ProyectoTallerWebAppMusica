package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Artista;

@Repository
public class RepositorioArtistaImpl implements RepositorioArtista {

	@Inject
	private SessionFactory sessionFactory;

	@Override
	public Long insertarArtista(Artista artista) {
		Session session = sessionFactory.getCurrentSession();
		return (Long)session.save(artista);
	}

	@Override
	public Artista obtenerArtistaPorId(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Artista.class, id);
	}

	@Override
	public List<Artista> obtenerCincoMejoresArtistas() {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Artista.class)
				      .addOrder(Order.desc("puntaje"))
				      .setMaxResults(5)
				      .list();
	}

	@Override
	public List<Artista> obtenerTodosLosArtistas() {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Artista.class)
				      .list();
	}

	public Artista obtenerArtistaPorNombre(String artista) {
		Session session = sessionFactory.getCurrentSession();
		return (Artista) session.createCriteria(Artista.class)
				.add(Restrictions.eq("nombre", artista))
				.uniqueResult();
	}

	@Override
	public List<Artista> obtenerUnArtistaPorNombre(String artista) {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Artista.class)
				.add(Restrictions.ilike("nombre", artista, MatchMode.ANYWHERE ))
				.list();
	}
	
	

}

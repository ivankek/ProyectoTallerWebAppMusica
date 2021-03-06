package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Artista;

@Repository
public class RepositorioAlbumImpl implements RepositorioAlbum {

	@Inject
	private SessionFactory sessionFactory;

	@Override
	public Long insertarAlbum(Album album) {
		Session session = sessionFactory.getCurrentSession();
		return (Long) session.save(album);
	}

	@Override
	public Album obtenerAlbumPorId(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return (Album) session.get(Album.class, id);
	}

	@Override
	public List<Album> obtenerCincoMejoresAlbum() {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Album.class).addOrder(Order.desc("puntaje")).setMaxResults(5).list();
	}

	@Override
	public List<Album> obtenerTodosLosAlbums() {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Album.class).list();
	}

	@Override
	public Album obtenerAlbumPorNombre(String nombre) {
		Session session = sessionFactory.getCurrentSession();
		return (Album) session.createCriteria(Album.class).add(Restrictions.eq("nombre", nombre)).uniqueResult();
	}

	@Override
	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Album> obtenerAlbumsPorNombre(String nombre) {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Album.class).add(Restrictions.ilike("nombre", nombre, MatchMode.ANYWHERE)).list();
	}

}

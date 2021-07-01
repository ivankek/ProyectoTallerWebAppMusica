package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Follow;
import ar.edu.unlam.tallerweb1.modelo.FollowPlaylist;
import ar.edu.unlam.tallerweb1.modelo.ListaReproduccion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Repository
public class RepositorioFollowPlaylistImpl implements RepositorioFollowPlaylist {

	@Inject
	private SessionFactory sessionFactory;

	@Autowired
	public RepositorioFollowPlaylistImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Long guardarFollow(FollowPlaylist followPlaylist) {
		Session session = sessionFactory.getCurrentSession();
		return (Long) session.save(followPlaylist);
	}

	@Override
	public List<ListaReproduccion> obtenerPlaylistSeguidasPorUsuario(Usuario usuario) {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(FollowPlaylist.class).add(Restrictions.eq("usuario", usuario))
				.setProjection(Projections.distinct(Projections.property("listaReproduccion"))).list();
	}

}

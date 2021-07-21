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
import ar.edu.unlam.tallerweb1.modelo.FollowUsuario;
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

	@Override
	public void dejarDeSeguirPlaylist(FollowPlaylist followPlaylist) {
		Session session = sessionFactory.getCurrentSession();
		session.remove(followPlaylist);
		return;
	}

	@Override
	public FollowPlaylist obtenerRegistroFollowPlaylist(Usuario usuario, String listaReproduccion) {
		Session session = sessionFactory.getCurrentSession();
		return (FollowPlaylist) session.createCriteria(FollowPlaylist.class)
				.createAlias("listaReproduccion", "tablaListaReproduccion")
				.add(Restrictions.eq("tablaListaReproduccion.nombre", listaReproduccion))
				.add(Restrictions.eq("usuario", usuario)).uniqueResult();
	}

}

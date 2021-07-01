package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Artista;
import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.modelo.Follow;
import ar.edu.unlam.tallerweb1.modelo.ListaReproduccion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Repository
public class RepositorioFollowImpl implements RepositorioFollow {

	@Inject
	private SessionFactory sessionFactory;

	@Autowired
	public RepositorioFollowImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Long guardarFollow(Follow follow) {
		Session session = sessionFactory.getCurrentSession();
		return (Long) session.save(follow);
	}

	@Override
	public List<Follow> obtenerSeguidoresPorArtista(String artista) {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Follow.class).createAlias("artista", "artistaBuscado")
				.add(Restrictions.eq("artistaBuscado.nombre", artista))
				.setProjection(Projections.distinct(Projections.property("artista"))).list();
	}

	@Override
	public List<Artista> obtenerArtistasSeguidosPorUsuario(Usuario usuario) {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Follow.class).add(Restrictions.eq("usuario", usuario))
				.setProjection(Projections.distinct(Projections.property("artista"))).list();
	}

	@Override
	public List<Follow> obtenerSeguidoresPorUsuario(String usuario) {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Follow.class).createAlias("usuario", "usuarioBuscado")
				.add(Restrictions.eq("usuarioBuscado.usuario", usuario))
				.setProjection(Projections.distinct(Projections.property("usuario"))).list();
	}

	@Override
	public List<ListaReproduccion> obtenerPlaylistSeguidasPorUsuario(Usuario usuario) {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Follow.class).add(Restrictions.eq("usuario", usuario))
				.setProjection(Projections.distinct(Projections.property("listaReproduccion"))).list();
	}

}

package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Artista;
import ar.edu.unlam.tallerweb1.modelo.Cancion;
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

	@Override
	public List<String> obtenerGenerosDeUnaCancion(Cancion cancion) {
		Session session = sessionFactory.getCurrentSession();
		return (List<String>) session.createCriteria(CancionGenero.class)
				                     .add(Restrictions.eq("cancion", cancion))
                                     .createAlias("genero", "tablaGenero")
                                     .setProjection(Projections.property("tablaGenero.nombre"))
                                     .list();
	}

	@Override
	public List<String> obtenerGenerosDeUnAlbum(Album album) {
		Session session = sessionFactory.getCurrentSession();
		return (List<String>) session.createCriteria(CancionGenero.class)
                                     .createAlias("cancion", "tablaCancion")
                                     .add(Restrictions.eq("tablaCancion.album", album))
                                     .createAlias("genero", "tablaGenero")
                                     .setProjection(Projections.distinct(Projections.property("tablaGenero.nombre")))
                                     .list();
	}

	@Override
	public List<String> obtenerGenerosDeUnArtista(Artista artista) {
		Session session = sessionFactory.getCurrentSession();
		return (List<String>) session.createCriteria(CancionGenero.class)
                                     .createAlias("cancion", "tablaCancion")
                                     .add(Restrictions.eq("tablaCancion.artista", artista))
                                     .createAlias("genero", "tablaGenero")
                                     .setProjection(Projections.distinct(Projections.property("tablaGenero.nombre")))
                                     .list();
	}
	
	@Override
	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	@Override
	public void setSessionFactory(SessionFactory sessionFactory) {
		 this.sessionFactory = sessionFactory;
	}
}

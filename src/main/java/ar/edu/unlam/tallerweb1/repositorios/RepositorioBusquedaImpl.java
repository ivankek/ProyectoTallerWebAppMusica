package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Artista;
import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.modelo.CancionGenero;
import ar.edu.unlam.tallerweb1.modelo.CancionLista;
import ar.edu.unlam.tallerweb1.modelo.Genero;

@Repository
public class RepositorioBusquedaImpl implements RepositorioBusqueda {
	@Inject
	private SessionFactory sessionFactory;
	
	@Autowired
	public RepositorioBusquedaImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Cancion> obtenerCancionesPorGenero(String nombre) {
		final Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(CancionGenero.class)
				.createAlias("genero", "generoBuscado")
				//.add(Restrictions.eq("generoBuscado.nombre", nombre))
				.add(Restrictions.ilike("generoBuscado.nombre", nombre, MatchMode.ANYWHERE))
				.setProjection(Projections.property("cancion"))
				.list();
	}

	@Override
	public List<Cancion> obtenerCancionesPorArtista(String nombre) {
		final Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Cancion.class)
				.createAlias("artista", "artistaBuscado")
				//.add(Restrictions.eq("artistaBuscado.nombre", nombre))
				.add(Restrictions.ilike("artistaBuscado.nombre", nombre, MatchMode.ANYWHERE))
				.list();
	}
	
	@Override
	public List<Cancion> obtenerCancionesPorAlbum(String nombre) {
		final Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Cancion.class)
				.createAlias("album", "albumBuscado")
				//.add(Restrictions.eq("albumBuscado.nombre", nombre))
				.add(Restrictions.ilike("albumBuscado.nombre", nombre, MatchMode.ANYWHERE))
				.list();
	}


	@Override
	public List<Cancion> obtenerCancionesPorLista(String nombre) {
		final Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(CancionLista.class)
				.createAlias("listaReproduccion", "tablaListaReproduccion")
				//.add(Restrictions.eq("listaBuscada.nombre", nombre))
				.add(Restrictions.ilike("tablaListaReproduccion.nombre", nombre, MatchMode.ANYWHERE))
				.setProjection(Projections.property("cancion"))
				.list();
	}


	@Override
	public List<Cancion> obtenerCancionesPorNombre(String nombre) { 
		final Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Cancion.class)
				//.add(Restrictions.eq("nombre", nombre))
				.add(Restrictions.ilike("nombre", nombre, MatchMode.ANYWHERE))
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

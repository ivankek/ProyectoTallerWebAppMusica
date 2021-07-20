package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.modelo.CancionGenero;
import ar.edu.unlam.tallerweb1.modelo.CancionLista;
import ar.edu.unlam.tallerweb1.modelo.ListaReproduccion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Repository
public class RepositorioCancionListaImpl implements RepositorioCancionLista {

	@Inject
	private SessionFactory sessionFactory;

	@Override
	public Long insertarCancionLista(CancionLista cancionLista) {
		Session session = sessionFactory.getCurrentSession();
		return (Long) session.save(cancionLista);
	}

	@Override
	public List<String> obtenerListasDeUnaCancion(Cancion cancion) {
		Session session = sessionFactory.getCurrentSession();
		return (List<String>) session.createCriteria(CancionLista.class).add(Restrictions.eq("cancion", cancion))
				.createAlias("listaReproduccion", "tablaListaReproduccion")
				.setProjection(Projections.property("tablaListaReproduccion.nombre")).list();
	}

	@Override
	public List<Cancion> obtenerCancionesDeLista(ListaReproduccion listaReproduccion) {
		final Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(CancionLista.class)
				.createAlias("listaReproduccion", "listaBuscada")
				.add(Restrictions.eq("listaReproduccion", listaReproduccion))
				.setProjection(Projections.property("cancion"))
				.list();
	}

	@Override
	public List<Cancion> obtenerCancionesDeListaPorNombre(String nombreListaReproduccion) {
		Session session = sessionFactory.getCurrentSession();
		return (List<Cancion>) session.createCriteria(CancionLista.class)
				                      .createAlias("listaReproduccion", "tablaListaReproduccion")
				                      .add(Restrictions.eq("tablaListaReproduccion.nombre", nombreListaReproduccion))
				                      .setProjection(Projections.property("cancion"))
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

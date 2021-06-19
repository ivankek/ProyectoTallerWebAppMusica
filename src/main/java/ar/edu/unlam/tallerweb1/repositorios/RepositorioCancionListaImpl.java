package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Cancion;
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
		return (List<String>) session.createCriteria(CancionLista.class)
				.add(Restrictions.eq("cancion", cancion))
				.createAlias("listaReproduccion", "tablaListaReproduccion")
				.setProjection(Projections.property("tablaListaReproduccion.nombre")).list();
	}

	@Override
	public List<String> obtenerCancionesDeLista(ListaReproduccion listaReproduccion) {
		Session session = sessionFactory.getCurrentSession();
		return (List<String>) session.createCriteria(CancionLista.class)
				.add(Restrictions.eq("listaReproduccion", listaReproduccion)).createAlias("cancion", "tablaCancion")
				.setProjection(Projections.property("tablaCancion.nombre")).list();
		}
	
}

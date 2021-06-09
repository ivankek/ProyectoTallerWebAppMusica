package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.ListaReproduccion;

@Repository
public class RepositorioListaReproduccionImpl implements RepositorioListaReproduccion {

	@Inject
	private SessionFactory sessionFactory;

	@Override
	public Long insertarLista(ListaReproduccion listaReproduccion) {
		Session session = sessionFactory.getCurrentSession();
		return (Long)session.save(listaReproduccion);

	}

	@Override
	public List<ListaReproduccion> obtenerTodasLasListasDeReproduccion() {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(ListaReproduccion.class).list();
	}

	
	
}

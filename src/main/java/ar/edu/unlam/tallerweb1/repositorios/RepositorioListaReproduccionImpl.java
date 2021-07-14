package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Artista;
import ar.edu.unlam.tallerweb1.modelo.Follow;
import ar.edu.unlam.tallerweb1.modelo.ListaReproduccion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Repository
public class RepositorioListaReproduccionImpl implements RepositorioListaReproduccion {

	@Inject
	private SessionFactory sessionFactory;

	@Override
	public Long insertarLista(ListaReproduccion listaReproduccion) {
		Session session = sessionFactory.getCurrentSession();
		return (Long) session.save(listaReproduccion);

	}

	@Override
	public List<ListaReproduccion> obtenerTodasLasListasDeReproduccion() {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(ListaReproduccion.class).list();
	}

	@Override
	public List<ListaReproduccion> obtenerListaReproduccionPorUsuario(Usuario usuario) {
		Session session = sessionFactory.getCurrentSession();
		return (List<ListaReproduccion>) session.createCriteria(ListaReproduccion.class)
				.add(Restrictions.eq("usuario", usuario)).list();
	}

	@Override
	public ListaReproduccion obtenerListaPorId(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(ListaReproduccion.class, id);
	}

	@Override
	public List<ListaReproduccion> obtenerListaReproduccionPorNombre(String lista) {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(ListaReproduccion.class)
				.add(Restrictions.ilike("nombre", lista, MatchMode.ANYWHERE)).list();
	}

	@Override
	public ListaReproduccion obtenerUnaListaReproduccionPorSuNombreYUsuario(String nombreLista , Usuario usuario) {
		Session session = sessionFactory.getCurrentSession();
		return (ListaReproduccion) session.createCriteria(ListaReproduccion.class)
				                          .add(Restrictions.eq("nombre", nombreLista))
				                          .add(Restrictions.eq("usuario", usuario))
				                          .uniqueResult();
	}

}

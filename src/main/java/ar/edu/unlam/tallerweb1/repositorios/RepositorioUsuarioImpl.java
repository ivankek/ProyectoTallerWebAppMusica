package ar.edu.unlam.tallerweb1.repositorios;

import ar.edu.unlam.tallerweb1.modelo.ListaReproduccion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.inject.Inject;

@Repository("repositorioUsuario")
public class RepositorioUsuarioImpl implements RepositorioUsuario {

	private SessionFactory sessionFactory;

	@Autowired
	public RepositorioUsuarioImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Usuario consultarUsuario(Usuario usuario) {

		final Session session = sessionFactory.getCurrentSession();
		return (Usuario) session.createCriteria(Usuario.class).add(Restrictions.eq("usuario", usuario.getUsuario()))
				.add(Restrictions.eq("password", usuario.getPassword())).uniqueResult();
	}

	@Override
	public Long insertarUsuario(Usuario usuario) {
		Session session = sessionFactory.getCurrentSession();
		return (Long) session.save(usuario);
	}

	@Override
	public Usuario obtenerUsuarioPorId(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Usuario.class, id);
	}

	@Override
	public Usuario obtenerUsuarioPorNombre(String usuario) {
		Session session = sessionFactory.getCurrentSession();
		return (Usuario) session.createCriteria(Usuario.class).add(Restrictions.eq("usuario", usuario)).uniqueResult();
	}

	@Override
	public List<Usuario> obtenerUnUsuarioPorNombre(String usuario) {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Usuario.class).add(Restrictions.ilike("usuario", usuario, MatchMode.ANYWHERE))
				.list();
	}

}

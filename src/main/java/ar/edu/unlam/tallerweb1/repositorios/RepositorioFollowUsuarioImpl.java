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
import ar.edu.unlam.tallerweb1.modelo.FollowUsuario;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Repository
public class RepositorioFollowUsuarioImpl implements RepositorioFollowUsuario {

	@Inject
	private SessionFactory sessionFactory;

	@Autowired
	public RepositorioFollowUsuarioImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Long guardarFollow(FollowUsuario followUsuario) {
		Session session = sessionFactory.getCurrentSession();
		return (Long) session.save(followUsuario);
	}

	@Override
	public List<Usuario> obtenerUsuariosSeguidosPorUsuario(Usuario usuario) {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(FollowUsuario.class).add(Restrictions.eq("usuario", usuario))
				.setProjection(Projections.distinct(Projections.property("usuarioSeguido"))).list();
	}

	@Override
	public List<Usuario> obtenerSeguidoresPorUsuario(Usuario usuario) {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(FollowUsuario.class).add(Restrictions.eq("usuarioSeguido", usuario))
				.setProjection(Projections.distinct(Projections.property("usuario"))).list();
	}

	@Override
	public void dejarDeSeguirUsuario(FollowUsuario followUsuario) {
		Session session = sessionFactory.getCurrentSession();
		session.remove(followUsuario);
		return;
	}

	@Override
	public FollowUsuario obtenerRegistroFollowUsuario(Usuario usuario, String usuarioSeguido) {
		Session session = sessionFactory.getCurrentSession();
		return (FollowUsuario) session.createCriteria(FollowUsuario.class)
				.createAlias("usuarioSeguido", "tablaUsuarioSeguido")
				.add(Restrictions.eq("tablaUsuarioSeguido.usuario", usuarioSeguido))
				.add(Restrictions.eq("usuario", usuario)).uniqueResult();
	}

}

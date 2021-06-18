package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Repository
public class RepositorioFavoritoImpl implements RepositorioFavorito{
	
	@Inject
	private SessionFactory sessionFactory;

	@Override
	public Long añadirAFavoritos(Favorito favorito) {
		Session session = sessionFactory.getCurrentSession();
		return (Long) session.save(favorito);
	}

	@Override
	public List<Favorito> obtenerListaDeFavoritos(Usuario usuario) {
		Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Favorito.class)
				      .add(Restrictions.eq("usuario", usuario))
				      .list();
	}

}

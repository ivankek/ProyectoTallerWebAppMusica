package ar.edu.unlam.tallerweb1.repositorios;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Artista;
import ar.edu.unlam.tallerweb1.modelo.Follow;
import ar.edu.unlam.tallerweb1.modelo.ListaReproduccion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Repository
public class RepositorioFollowImpl implements RepositorioFollow{

	@Inject
	private SessionFactory sessionFactory;
	
	@Autowired
	public RepositorioFollowImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Long guardarArtistaSeguido(Follow follow) {
		Session session = sessionFactory.getCurrentSession();
		return (Long)session.save(follow);
	}

	@Override
	public Artista obtenerArtistaPorNombre(String artista) {
		Session session = sessionFactory.getCurrentSession();
		return (Artista) session.createCriteria(Artista.class).add(Restrictions.eq("artista", artista)).uniqueResult();
		
	}

	
}

package ar.edu.unlam.tallerweb1;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public class FavoritoTest extends SpringTest {
	
	@Inject
	private SessionFactory sessionFactory;
	
	@Test
	@Transactional @Rollback
	public void testDeAñadirAFavorito() {
		Favorito registro_1 = new Favorito();
		Usuario user = new Usuario();
		Cancion track = new Cancion();
		
		//Setear usuario y guardarlo
		user.setUsuario("pepeRock");
		user.setPassword("1234");
		user.setRol("usuario");
		
		Long userID = (Long) sessionFactory.getCurrentSession().save(user);
		
		//Setear Cancion y guardarla
		track.setNombre("tema 1");
		
		Long cancionID = (Long) sessionFactory.getCurrentSession().save(track);
		
		//Añado a favorito y guardo en BD
		registro_1.setCancion(sessionFactory.getCurrentSession().get(Cancion.class , cancionID));
		registro_1.setUsuario(sessionFactory.getCurrentSession().get(Usuario.class , userID));

		Long id = (Long) sessionFactory.getCurrentSession().save(registro_1);
		Long actual = 1L;
		
		assertEquals(actual , id);
	}
	
	@Test
	@Transactional @Rollback
	public void testVerFavoritosDeUsuario() {
		Favorito registro_1 = new Favorito();
		Usuario user = new Usuario();
		Cancion track = new Cancion();
		
		//Setear usuario y guardarlo
		user.setUsuario("pepeRock");
		user.setPassword("1234");
		user.setRol("usuario");
		
		Long userID = (Long) sessionFactory.getCurrentSession().save(user);
		
		//Setear Cancion y guardarla
		track.setNombre("tema 1");
		
		Long cancionID = (Long) sessionFactory.getCurrentSession().save(track);
		
		//Añado a favorito y guardo en BD
		registro_1.setCancion(sessionFactory.getCurrentSession().get(Cancion.class , cancionID));
		registro_1.setUsuario(sessionFactory.getCurrentSession().get(Usuario.class , userID));

		sessionFactory.getCurrentSession().save(registro_1);
		
		//Veo favoritos del usuario
		List<Favorito> listaDeFavoritos = sessionFactory.getCurrentSession().createCriteria(Favorito.class)
		                                                                    .add(Restrictions.eq("usuario", user))
		                                                                    .list();
		
		assertEquals(1 , listaDeFavoritos.size());
	}
}

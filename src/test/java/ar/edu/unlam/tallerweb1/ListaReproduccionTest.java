package ar.edu.unlam.tallerweb1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Artista;
import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.modelo.CancionGenero;
import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.modelo.Genero;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public class ListaReproduccionTest extends SpringTest {

	@Inject
	private SessionFactory sessionFactory;

	@Test
	@Transactional
	@Rollback
	public void testListaDeReproduccion() {

		Usuario usuario = new Usuario();
		usuario.setId((long) 1);
		usuario.setUsuario("ivank");
		usuario.setPassword("1234");
		usuario.setRol("User");
		sessionFactory.getCurrentSession().save(usuario);

	}
}

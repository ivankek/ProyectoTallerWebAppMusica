package ar.edu.unlam.tallerweb1;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import javax.inject.Inject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;


import ar.edu.unlam.tallerweb1.modelo.Artista;


public class RepositorioArtistaTest extends SpringTest{
	
	@Inject
	private SessionFactory sessionFactory;
		
	@Test
	@Transactional @Rollback
	public void testDeInsertarArtista() {
		Session session = sessionFactory.getCurrentSession();
		Artista artista = new Artista();
		artista.setNombre("AC/DC");
		
		Long idObtenido = (Long) session.save(artista);
		Long idEsperado = 2L;
		
		assertEquals(idEsperado , idObtenido);
	}
	
	@Test
	@Transactional @Rollback
	public void testObtenerArtistaPorId() {
		Session session = sessionFactory.getCurrentSession();
		Artista artista = new Artista();
		artista.setNombre("AC/DC");
		session.save(artista);
		assertNotNull(session.get(Artista.class, 1L));
	}
}

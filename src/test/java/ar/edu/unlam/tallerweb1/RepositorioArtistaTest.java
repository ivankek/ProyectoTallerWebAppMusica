package ar.edu.unlam.tallerweb1;

import static org.junit.Assert.assertEquals;

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
	
	private Artista artista = new Artista();
	
	@Test
	@Transactional @Rollback
	public void testDeObtenerArtistaPorId() {
		Session session = sessionFactory.getCurrentSession();
		artista.setNombre("AC/DC");
		session.save(artista);
		Artista artistaObtenidoPorId = session.get(Artista.class, 1L);
		String nombreDeArtistaEsperado = "AC/DC";
		String nombreObtenido = artistaObtenidoPorId.getNombre();
		assertEquals(nombreObtenido , nombreDeArtistaEsperado);
	}

}

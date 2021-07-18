package ar.edu.unlam.tallerweb1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.modelo.Artista;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioArtista;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioArtistaImpl;


public class RepositorioArtistaTest extends SpringTest{
	
	private RepositorioArtista repoArtista = new RepositorioArtistaImpl();
	private Artista artista = new Artista();
	private Artista artista2 = new Artista();
	private Artista artista3 = new Artista();
	
	@Test
	@Transactional @Rollback
	public void testDeInsertarArtista() {
		artista.setNombre("AC/DC");
		repoArtista.setSessionFactory(this.sessionFactory);
		
		Long idObtenido = repoArtista.insertarArtista(artista);
		Long idEsperado = artista.getId();
		
		assertEquals(idEsperado , idObtenido);
	}
	
	@Test
	@Transactional @Rollback
	public void testObtenerArtistaPorId() {
		repoArtista.setSessionFactory(this.sessionFactory);
		artista.setNombre("Metallica");
		repoArtista.insertarArtista(artista);
		
		Artista artistaObtenido = repoArtista.obtenerArtistaPorId(artista.getId());
		String artistaEsperado = "Metallica";
		
		assertEquals(artistaEsperado , artistaObtenido.getNombre());
	}
	
	@Test
	@Transactional @Rollback
	public void testObtenerArtistaPorNombre() {
		repoArtista.setSessionFactory(this.sessionFactory);
		artista.setNombre("Foo Fighters");
		repoArtista.insertarArtista(artista);
		
		Artista artistaObtenido = repoArtista.obtenerArtistaPorNombre("Foo Fighters");
		String artistaEsperado = "Foo Fighters";
		
		assertEquals(artistaEsperado , artistaObtenido.getNombre());
	}
	
	@Test
	@Transactional @Rollback
	public void testDeTraerTodosLosArtistas() {
		repoArtista.setSessionFactory(this.sessionFactory);
		artista.setNombre("The Stroke");
		repoArtista.insertarArtista(artista);
		artista2.setNombre("Soda Stereo");
		repoArtista.insertarArtista(artista2);
		artista3.setNombre("Queens of The Stone Age");
		repoArtista.insertarArtista(artista3);
		
		List<Artista> listaDeArtistasObtenidos = repoArtista.obtenerTodosLosArtistas();
		Integer numeroDeArtistasEsperados = 3;
		
		assertEquals(numeroDeArtistasEsperados , (Integer)listaDeArtistasObtenidos.size());
	}
	
	@Test
	@Transactional @Rollback
	public void testDeTraerArtistasPorOcurrencia() {
		repoArtista.setSessionFactory(this.sessionFactory);
		artista.setNombre("The Stroke");
		repoArtista.insertarArtista(artista);
		artista2.setNombre("Soda Stereo");
		repoArtista.insertarArtista(artista2);
		artista3.setNombre("Queens of The Stone Age");
		repoArtista.insertarArtista(artista3);
		
		List<Artista> listaDeArtistasObtenidos = repoArtista.obtenerUnArtistaPorNombre("The");
		Integer numeroDeArtistasEsperados = 2;
		
		assertEquals(numeroDeArtistasEsperados , (Integer)listaDeArtistasObtenidos.size());
	}
	
	@Test
	@Transactional @Rollback
	public void testDeTraerArtistasPorOcurrenciaNoEsCaseSensitive() {
		repoArtista.setSessionFactory(this.sessionFactory);
		artista.setNombre("The Stroke");
		repoArtista.insertarArtista(artista);
		artista2.setNombre("Soda Stereo");
		repoArtista.insertarArtista(artista2);
		artista3.setNombre("Queens of The Stone Age");
		repoArtista.insertarArtista(artista3);
		
		List<Artista> listaDeArtistasObtenidos = repoArtista.obtenerUnArtistaPorNombre("ThE");
		Integer numeroDeArtistasEsperados = 2;
		
		assertEquals(numeroDeArtistasEsperados , (Integer)listaDeArtistasObtenidos.size());
	}
	
	@Test
	@Transactional @Rollback
	public void testDeNullCuandoElArtistaNoExista() {
		repoArtista.setSessionFactory(this.sessionFactory);
		
		Artista nullArtistaPorId = repoArtista.obtenerArtistaPorId(1L);
		Artista nullArtistaPorNombre = repoArtista.obtenerArtistaPorNombre("Miranda");
		
		assertNull(nullArtistaPorId);
		assertNull(nullArtistaPorNombre);
	}
	
	@Test
	@Transactional @Rollback
	public void testDeListaVaciaCuandoNoHayArtistas() {
		repoArtista.setSessionFactory(this.sessionFactory);
		
		List<Artista> todosLosArtistas = repoArtista.obtenerTodosLosArtistas();
		List<Artista> artistasPorOcurrencia = repoArtista.obtenerUnArtistaPorNombre("zzz");
		
		assertEquals(0 , todosLosArtistas.size());
		assertEquals(0 , artistasPorOcurrencia.size());
	}
}

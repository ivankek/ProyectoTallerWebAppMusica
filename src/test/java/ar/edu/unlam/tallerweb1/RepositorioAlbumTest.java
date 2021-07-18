package ar.edu.unlam.tallerweb1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAlbum;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAlbumImpl;

public class RepositorioAlbumTest extends SpringTest {

	@Inject
	private SessionFactory sessionFactory;
	
	@Test
	@Transactional
	@Rollback
	public void testQueInserteAlbum(){
		Album album = new Album();
		album.setNombre("Thriller");
		RepositorioAlbum repoAlbum = new RepositorioAlbumImpl();
		repoAlbum.setSessionFactory(sessionFactory);
		
		repoAlbum.insertarAlbum(album);
		
		assertEquals(1, repoAlbum.obtenerTodosLosAlbums().size());
	}
	
	@Test 
	@Transactional
	@Rollback
	public void testQueObtieneAlbumPorId() {
		Album album = new Album();
		album.setNombre("Thriller");
		RepositorioAlbum repoAlbum = new RepositorioAlbumImpl();
		repoAlbum.setSessionFactory(sessionFactory);
		
		repoAlbum.insertarAlbum(album);
		
		assertEquals(album, repoAlbum.obtenerAlbumPorId(album.getId()));
		
	}
	
	@Test
	@Transactional
	@Rollback
	public void testQueObtieneAlbumPorNombre() {
		Album album = new Album();
		album.setNombre("Thriller");
		RepositorioAlbum repoAlbum = new RepositorioAlbumImpl();
		repoAlbum.setSessionFactory(sessionFactory);
		
		repoAlbum.insertarAlbum(album);
		
		assertEquals(album, repoAlbum.obtenerAlbumPorNombre(album.getNombre()));
	}
	
	@Test
	@Transactional
	@Rollback
	public void testQueObtieneTodosLosAlbums() {
		Album album = new Album();
		Album album2 = new Album();
		Album album3 = new Album();
		album.setNombre("Thriller");
		album2.setNombre("Back in Black");
		album3.setNombre("Dynasty");
		RepositorioAlbum repoAlbum = new RepositorioAlbumImpl();
		repoAlbum.setSessionFactory(sessionFactory);
		
		repoAlbum.insertarAlbum(album);
		repoAlbum.insertarAlbum(album2);
		repoAlbum.insertarAlbum(album3);
		
		Integer valorObtenido = repoAlbum.obtenerTodosLosAlbums().size();
		Integer valorEsperado = 3;
		
		assertEquals(valorEsperado, valorObtenido);
	}
}

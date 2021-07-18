package ar.edu.unlam.tallerweb1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Artista;
import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.modelo.CancionGenero;
import ar.edu.unlam.tallerweb1.modelo.Genero;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAlbum;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAlbumImpl;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioArtista;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioArtistaImpl;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioBusqueda;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioBusquedaImpl;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCancion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCancionGenero;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCancionGeneroImpl;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCancionImpl;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioGenero;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioGeneroImpl;

public class RepositorioBusquedaTest extends SpringTest{

	@Inject
	private SessionFactory sessionFactory;
	
	@Test
	@Transactional
	@Rollback
	public void testQueObtengaCancionesPorAlbum() {
		Cancion cancion = new Cancion();
		Album album = new Album();
		cancion.setNombre("Hells Bells");
		album.setNombre("Back in Black");
		RepositorioCancion repoCancion = new RepositorioCancionImpl();
		RepositorioAlbum repoAlbum = new RepositorioAlbumImpl();
		RepositorioBusqueda repositorioBusqueda = new RepositorioBusquedaImpl(sessionFactory);
		repoCancion.setSessionFactory(this.sessionFactory);
		repoAlbum.setSessionFactory(this.sessionFactory);
		repositorioBusqueda.setSessionFactory(this.sessionFactory);
		
		repoCancion.insertarCancion(cancion);
		repoAlbum.insertarAlbum(album);	
		
		assertNotNull(repositorioBusqueda.obtenerCancionesPorAlbum(album.getNombre()));
	}
	
	@Test
	@Transactional
	@Rollback
	public void testQueObtengaCancionesPorArtista() {
		Cancion cancion = new Cancion();
		Artista artista = new Artista();
		cancion.setNombre("Hells Bells");
		artista.setNombre("AC/DC");
		RepositorioCancion repoCancion = new RepositorioCancionImpl();
		RepositorioArtista repoArtista = new RepositorioArtistaImpl();
		RepositorioBusqueda repositorioBusqueda = new RepositorioBusquedaImpl(sessionFactory);
		repoCancion.setSessionFactory(this.sessionFactory);
		repoArtista.setSessionFactory(this.sessionFactory);
		repositorioBusqueda.setSessionFactory(this.sessionFactory);
		
		repoCancion.insertarCancion(cancion);
		repoArtista.insertarArtista(artista);	
		
		assertNotNull(repositorioBusqueda.obtenerCancionesPorAlbum(artista.getNombre()));
	}
	
	@Test
	@Transactional
	@Rollback
	public void testQueObtengaCancionesPorGenero() {
		Cancion cancion = new Cancion();
		Genero genero = new Genero();
		CancionGenero cancionGenero = new CancionGenero();
		cancion.setNombre("Thriller");
		genero.setNombre("Rock");
		cancionGenero.setCancion(cancion);
		cancionGenero.setGenero(genero);
		
		RepositorioCancion repoCancion = new RepositorioCancionImpl();
		RepositorioGenero repoGenero = new RepositorioGeneroImpl();
		RepositorioCancionGenero repoCancionGenero = new RepositorioCancionGeneroImpl();
		RepositorioBusqueda repositorioBusqueda = new RepositorioBusquedaImpl(sessionFactory);
		repoCancion.setSessionFactory(this.sessionFactory);
		repoGenero.setSessionFactory(this.sessionFactory);
		repoCancionGenero.setSessionFactory(this.sessionFactory);
		repositorioBusqueda.setSessionFactory(this.sessionFactory);
		
		repoCancion.insertarCancion(cancion);
		repoGenero.insertarGenero(genero);
		repoCancionGenero.insertarCancionGenero(cancionGenero);
		
		assertNotNull(repositorioBusqueda.obtenerCancionesPorGenero(cancionGenero.getGenero().getNombre()));
	}
	
	
	@Test
	@Transactional
	@Rollback
	public void testQueObtengaCancionesPorNombre() {
		Cancion cancion = new Cancion();
		Cancion cancion2 = new Cancion();
		cancion.setNombre("Hells Bells");
		cancion2.setNombre("Shake a Leg");
		RepositorioCancion repositorioCancion = new RepositorioCancionImpl();
		RepositorioBusqueda repositorioBusqueda = new RepositorioBusquedaImpl(sessionFactory);
		repositorioCancion.setSessionFactory(this.sessionFactory);
		repositorioBusqueda.setSessionFactory(this.sessionFactory);
		
		repositorioCancion.insertarCancion(cancion);
		
		assertNotNull(repositorioBusqueda.obtenerCancionesPorNombre(cancion.getNombre()));
	
	}
}

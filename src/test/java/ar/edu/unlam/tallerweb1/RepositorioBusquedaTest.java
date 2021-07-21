package ar.edu.unlam.tallerweb1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCancionLista;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCancionListaImpl;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioGenero;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioGeneroImpl;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioListaReproduccion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioListaReproduccionImpl;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuarioImpl;

public class RepositorioBusquedaTest extends SpringTest{

	@Inject
	private SessionFactory sessionFactory;
	
	RepositorioBusqueda repoBusqueda = new RepositorioBusquedaImpl(sessionFactory);
	RepositorioCancion repoCancion = new RepositorioCancionImpl();
	RepositorioUsuario repoUsuario = new RepositorioUsuarioImpl(sessionFactory);
	RepositorioArtista repoArtista = new RepositorioArtistaImpl();
	RepositorioListaReproduccion repoLista = new RepositorioListaReproduccionImpl();
	RepositorioAlbum repoAlbum = new RepositorioAlbumImpl();
	RepositorioCancionGenero repoCancionGenero = new RepositorioCancionGeneroImpl();
	RepositorioGenero repoGenero = new RepositorioGeneroImpl();
	RepositorioCancionLista repoCancionLista = new RepositorioCancionListaImpl();
	
	@Test
	@Transactional
	@Rollback
	public void testQueObtengaCancionesPorAlbum() {
		Cancion cancion = new Cancion();
		Album album = new Album();
		cancion.setNombre("Hells Bells");
		album.setNombre("Back in Black");
		cancion.setAlbum(album);
		
		repoCancion.setSessionFactory(this.sessionFactory);
		repoAlbum.setSessionFactory(this.sessionFactory);
		repoBusqueda.setSessionFactory(this.sessionFactory);
		
		repoCancion.insertarCancion(cancion);
		repoAlbum.insertarAlbum(album);	
		
		List<Cancion> listaCanciones = new ArrayList<Cancion>();
		listaCanciones.add(cancion);
		
		assertEquals(listaCanciones, repoBusqueda.obtenerCancionesPorAlbum("Back in Black"));
	}
	
	@Test
	@Transactional
	@Rollback
	public void testQueObtengaCancionesPorArtista() {
		Cancion cancion = new Cancion();
		Artista artista = new Artista();
		cancion.setNombre("Hells Bells");
		artista.setNombre("AC/DC");
		cancion.setArtista(artista);

		repoCancion.setSessionFactory(this.sessionFactory);
		repoArtista.setSessionFactory(this.sessionFactory);
		repoBusqueda.setSessionFactory(this.sessionFactory);
		
		repoCancion.insertarCancion(cancion);
		repoArtista.insertarArtista(artista);	
		
		List<Cancion> listaCanciones = new ArrayList<Cancion>();
		listaCanciones.add(cancion);
		
		assertEquals(listaCanciones, repoBusqueda.obtenerCancionesPorArtista("AC/DC"));
	}
	
	@Test
	@Transactional
	@Rollback
	public void testQueObtengaCancionesPorGenero() {
		Cancion cancion = new Cancion();
		Genero genero = new Genero();
		CancionGenero cancionGenero = new CancionGenero();
		cancion.setNombre("Thriller");
		genero.setNombre("Pop");
		cancionGenero.setCancion(cancion);
		cancionGenero.setGenero(genero);
		

		repoCancion.setSessionFactory(this.sessionFactory);
		repoGenero.setSessionFactory(this.sessionFactory);
		repoCancionGenero.setSessionFactory(this.sessionFactory);
		repoBusqueda.setSessionFactory(this.sessionFactory);
		
		repoCancion.insertarCancion(cancion);
		repoGenero.insertarGenero(genero);
		repoCancionGenero.insertarCancionGenero(cancionGenero);
		
		assertNotNull(repoBusqueda.obtenerCancionesPorGenero(cancionGenero.getGenero().getNombre()));
	}
	
	
	@Test
	@Transactional
	@Rollback
	public void testQueObtengaCancionesPorNombre() {
		Cancion cancion = new Cancion();
		Cancion cancion2 = new Cancion();
		cancion.setNombre("Hells Bells");
		cancion2.setNombre("Shake a Leg");

		repoCancion.setSessionFactory(this.sessionFactory);
		repoBusqueda.setSessionFactory(this.sessionFactory);
		
		repoCancion.insertarCancion(cancion);
		List<Cancion> listaCanciones = new ArrayList<Cancion>();
		listaCanciones.add(cancion);
		
		assertEquals(listaCanciones, repoBusqueda.obtenerCancionesPorNombre("Hells Bells"));	
	}
}

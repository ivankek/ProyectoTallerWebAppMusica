package ar.edu.unlam.tallerweb1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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
import ar.edu.unlam.tallerweb1.modelo.Genero;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAlbum;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAlbumImpl;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioArtista;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioArtistaImpl;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioBusqueda;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioBusquedaImpl;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCancion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCancionImpl;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioListaReproduccion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioListaReproduccionImpl;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuarioImpl;
import ar.edu.unlam.tallerweb1.servicios.ServicioBusqueda;
import ar.edu.unlam.tallerweb1.servicios.ServicioBusquedaImpl;

public class ServicioBusquedaTest extends SpringTest{

	@Inject
	private SessionFactory sessionFactory;
	
	@Test
	@Transactional
	@Rollback
	public void testQueBusqueUnaCancionPorNombre() {
		Cancion cancionBuscada = new Cancion();
		cancionBuscada.setNombre("Thriller");
		RepositorioBusqueda repoBusqueda = new RepositorioBusquedaImpl(sessionFactory);
		repoBusqueda.setSessionFactory(this.sessionFactory);
		RepositorioCancion repoCancion = new RepositorioCancionImpl();
		repoCancion.setSessionFactory(this.sessionFactory);
		RepositorioUsuario repoUsuario = new RepositorioUsuarioImpl(sessionFactory);
		repoUsuario.setSessionFactory(this.sessionFactory);
		RepositorioArtista repoArtista = new RepositorioArtistaImpl();
		repoArtista.setSessionFactory(this.sessionFactory);
		RepositorioListaReproduccion repoLista = new RepositorioListaReproduccionImpl();
		repoLista.setSessionFactory(this.sessionFactory);
		RepositorioAlbum repoAlbum = new RepositorioAlbumImpl();
		repoAlbum.setSessionFactory(this.sessionFactory);
		
		ServicioBusqueda servicioBusqueda = new ServicioBusquedaImpl(repoBusqueda, repoArtista, repoUsuario,repoLista, repoAlbum);
	
		repoCancion.insertarCancion(cancionBuscada);
		
		Set<Cancion> listaCanciones = new HashSet<Cancion>();
		listaCanciones.add(cancionBuscada);
		
		
		assertEquals(listaCanciones, servicioBusqueda.buscarCancionPorTodosLosCampos("Thriller"));
		
	}
	
	
	@Test
	@Transactional
	@Rollback
	public void testQueNoEncuentreUnaCancion() {
		Cancion cancionBuscada = new Cancion();
		cancionBuscada.setNombre("Shake a leg");
		
		RepositorioBusqueda repoBusqueda = new RepositorioBusquedaImpl(sessionFactory);
		repoBusqueda.setSessionFactory(this.sessionFactory);
		RepositorioCancion repoCancion = new RepositorioCancionImpl();
		repoCancion.setSessionFactory(this.sessionFactory);
		RepositorioUsuario repoUsuario = new RepositorioUsuarioImpl(sessionFactory);
		repoUsuario.setSessionFactory(this.sessionFactory);
		RepositorioArtista repoArtista = new RepositorioArtistaImpl();
		repoArtista.setSessionFactory(this.sessionFactory);
		RepositorioListaReproduccion repoLista = new RepositorioListaReproduccionImpl();
		repoLista.setSessionFactory(this.sessionFactory);
		RepositorioAlbum repoAlbum = new RepositorioAlbumImpl();
		repoAlbum.setSessionFactory(this.sessionFactory);
		
		ServicioBusqueda servicioBusqueda = new ServicioBusquedaImpl(repoBusqueda, repoArtista, repoUsuario,repoLista, repoAlbum);
		
		
		repoCancion.insertarCancion(cancionBuscada);
		
		Set <Cancion> listaCanciones = new HashSet<Cancion>();
		listaCanciones.add(cancionBuscada);
		
		//tendria que dar verde al no encontrar la cancion (usar assertFalse?)
		//da rojo porque no encuentra la cancion pero porque es un equals
		assertEquals(listaCanciones, servicioBusqueda.buscarCancionPorTodosLosCampos("thriller"));
	
	}

	@Test
	@Transactional
	@Rollback
	public void testQueBusqueCancionPorArtista() {
		Cancion cancionBuscada = new Cancion();
		cancionBuscada.setNombre("Thriller");
		Artista artistaBuscado = new Artista();
		artistaBuscado.setNombre("Michael Jackson");
		cancionBuscada.setArtista(artistaBuscado);
		

		RepositorioBusqueda repoBusqueda = new RepositorioBusquedaImpl(sessionFactory);
		repoBusqueda.setSessionFactory(this.sessionFactory);
		RepositorioCancion repoCancion = new RepositorioCancionImpl();
		repoCancion.setSessionFactory(this.sessionFactory);
		RepositorioUsuario repoUsuario = new RepositorioUsuarioImpl(sessionFactory);
		repoUsuario.setSessionFactory(this.sessionFactory);
		RepositorioArtista repoArtista = new RepositorioArtistaImpl();
		repoArtista.setSessionFactory(this.sessionFactory);
		RepositorioListaReproduccion repoLista = new RepositorioListaReproduccionImpl();
		repoLista.setSessionFactory(this.sessionFactory);
		RepositorioAlbum repoAlbum = new RepositorioAlbumImpl();
		repoAlbum.setSessionFactory(this.sessionFactory);
		
		ServicioBusqueda servicioBusqueda = new ServicioBusquedaImpl(repoBusqueda, repoArtista, repoUsuario,repoLista, repoAlbum);
	
		repoCancion.insertarCancion(cancionBuscada);
		repoArtista.insertarArtista(artistaBuscado);
		
		Set<Cancion> listaCanciones = new HashSet<Cancion>();
		listaCanciones.add(cancionBuscada);
		
		assertEquals(listaCanciones, servicioBusqueda.buscarCancionPorTodosLosCampos("Michael Jackson"));
		
	}
	
	@Test
	@Transactional
	@Rollback
	public void testQueBusqueCancionPorAlbum() {
		Cancion cancionBuscada = new Cancion();
		cancionBuscada.setNombre("Thriller");
		Artista artistaBuscado = new Artista();
		artistaBuscado.setNombre("Michael Jackson");
		//cancionBuscada.setArtista(artistaBuscado);
		Album albumBuscado = new Album();
		cancionBuscada.setAlbum(albumBuscado);
		

		RepositorioBusqueda repoBusqueda = new RepositorioBusquedaImpl(sessionFactory);
		repoBusqueda.setSessionFactory(this.sessionFactory);
		RepositorioCancion repoCancion = new RepositorioCancionImpl();
		repoCancion.setSessionFactory(this.sessionFactory);
		RepositorioUsuario repoUsuario = new RepositorioUsuarioImpl(sessionFactory);
		repoUsuario.setSessionFactory(this.sessionFactory);
		RepositorioArtista repoArtista = new RepositorioArtistaImpl();
		repoArtista.setSessionFactory(this.sessionFactory);
		RepositorioListaReproduccion repoLista = new RepositorioListaReproduccionImpl();
		repoLista.setSessionFactory(this.sessionFactory);
		RepositorioAlbum repoAlbum = new RepositorioAlbumImpl();
		repoAlbum.setSessionFactory(this.sessionFactory);
		
		ServicioBusqueda servicioBusqueda = new ServicioBusquedaImpl(repoBusqueda, repoArtista, repoUsuario,repoLista, repoAlbum);
	
		repoCancion.insertarCancion(cancionBuscada);
		repoArtista.insertarArtista(artistaBuscado);
		repoAlbum.insertarAlbum(albumBuscado);
		
		Set<Cancion> listaCanciones = new HashSet<Cancion>();
		listaCanciones.add(cancionBuscada);
		
		assertEquals(listaCanciones, servicioBusqueda.buscarCancionPorTodosLosCampos("Thriller"));
		
	}
	
}

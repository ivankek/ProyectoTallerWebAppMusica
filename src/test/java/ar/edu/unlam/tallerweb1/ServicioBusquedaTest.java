package ar.edu.unlam.tallerweb1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;
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
import ar.edu.unlam.tallerweb1.modelo.CancionLista;
import ar.edu.unlam.tallerweb1.modelo.Genero;
import ar.edu.unlam.tallerweb1.modelo.ListaReproduccion;
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
import ar.edu.unlam.tallerweb1.servicios.ServicioBusqueda;
import ar.edu.unlam.tallerweb1.servicios.ServicioBusquedaImpl;

public class ServicioBusquedaTest extends SpringTest{

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
	public void testQueBusqueUnaCancionPorNombre() {
		Cancion cancionBuscada = new Cancion();
		cancionBuscada.setNombre("Thriller");
		
		repoBusqueda.setSessionFactory(this.sessionFactory);
		repoCancion.setSessionFactory(this.sessionFactory);		
		repoUsuario.setSessionFactory(this.sessionFactory);		
		repoArtista.setSessionFactory(this.sessionFactory);		
		repoLista.setSessionFactory(this.sessionFactory);		
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
		
		repoBusqueda.setSessionFactory(this.sessionFactory);
		repoCancion.setSessionFactory(this.sessionFactory);		
		repoUsuario.setSessionFactory(this.sessionFactory);		
		repoArtista.setSessionFactory(this.sessionFactory);		
		repoLista.setSessionFactory(this.sessionFactory);		
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
		

		repoBusqueda.setSessionFactory(this.sessionFactory);
		repoCancion.setSessionFactory(this.sessionFactory);		
		repoUsuario.setSessionFactory(this.sessionFactory);		
		repoArtista.setSessionFactory(this.sessionFactory);		
		repoLista.setSessionFactory(this.sessionFactory);		
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
		

		repoBusqueda.setSessionFactory(this.sessionFactory);
		repoCancion.setSessionFactory(this.sessionFactory);		
		repoUsuario.setSessionFactory(this.sessionFactory);		
		repoArtista.setSessionFactory(this.sessionFactory);		
		repoLista.setSessionFactory(this.sessionFactory);		
		repoAlbum.setSessionFactory(this.sessionFactory);
		
		ServicioBusqueda servicioBusqueda = new ServicioBusquedaImpl(repoBusqueda, repoArtista, repoUsuario,repoLista, repoAlbum);
	
		repoCancion.insertarCancion(cancionBuscada);
		repoArtista.insertarArtista(artistaBuscado);
		repoAlbum.insertarAlbum(albumBuscado);
		
		Set<Cancion> listaCanciones = new HashSet<Cancion>();
		listaCanciones.add(cancionBuscada);
		
		assertEquals(listaCanciones, servicioBusqueda.buscarCancionPorTodosLosCampos("Thriller"));
		
	}
	
	@Test
	@Transactional
	@Rollback
	public void testQueBusqueCancionPorGenero() {
		Cancion cancionBuscada = new Cancion();
		cancionBuscada.setNombre("Thriller");
		Artista artistaBuscado = new Artista();
		artistaBuscado.setNombre("Michael Jackson");
		Genero generoBuscado = new Genero();
		generoBuscado.setNombre("pop");
		CancionGenero cancionGenero = new CancionGenero();
		cancionGenero.setCancion(cancionBuscada);
		cancionGenero.setGenero(generoBuscado);

		repoBusqueda.setSessionFactory(this.sessionFactory);
		repoCancion.setSessionFactory(this.sessionFactory);		
		repoUsuario.setSessionFactory(this.sessionFactory);		
		repoArtista.setSessionFactory(this.sessionFactory);		
		repoLista.setSessionFactory(this.sessionFactory);		
		repoAlbum.setSessionFactory(this.sessionFactory);
		repoCancionGenero.setSessionFactory(this.sessionFactory);
		repoGenero.setSessionFactory(this.sessionFactory);
		
		ServicioBusqueda servicioBusqueda = new ServicioBusquedaImpl(repoBusqueda, repoArtista, repoUsuario,repoLista, repoAlbum);
	
		repoCancion.insertarCancion(cancionBuscada);
		repoArtista.insertarArtista(artistaBuscado);
		repoGenero.insertarGenero(generoBuscado);
		repoCancionGenero.insertarCancionGenero(cancionGenero);
		
		
		Set<CancionGenero> listaCanciones = new HashSet<CancionGenero>();
		listaCanciones.add(cancionGenero);
		
		assertEquals(listaCanciones, servicioBusqueda.buscarCancionPorTodosLosCampos("pop"));
		
	}
	
//	@Test
//	@Transactional
//	@Rollback
//	public void testQueBusqueCancionPorLista() {
//		Cancion cancion = new Cancion();
//		cancion.setNombre("Hells Bells");
//		CancionLista cancionBuscada = new CancionLista();
//		cancionBuscada.setCancion(cancion);
//		ListaReproduccion listaRepro = new ListaReproduccion();
//		cancionBuscada.setListaReproduccion(listaRepro);
//		
//
//		repoBusqueda.setSessionFactory(this.sessionFactory);
//		repoCancion.setSessionFactory(this.sessionFactory);		
//		repoUsuario.setSessionFactory(this.sessionFactory);		
//		repoArtista.setSessionFactory(this.sessionFactory);		
//		repoLista.setSessionFactory(this.sessionFactory);		
//		repoAlbum.setSessionFactory(this.sessionFactory);
//		repoCancionLista.setSessionFactory(this.sessionFactory);
//		
//		ServicioBusqueda servicioBusqueda = new ServicioBusquedaImpl(repoBusqueda, repoArtista, repoUsuario,repoLista, repoAlbum);
//	
//		repoCancion.insertarCancion(cancion);
//		repoCancionLista.insertarCancionLista(cancionBuscada);
//		repoLista.insertarLista(listaRepro);
//		
//		
//		Set<CancionLista> listaCancionLista = new HashSet<CancionLista>();
//		listaCancionLista.add(cancionBuscada);
//		
//		assertEquals(listaCancionLista, servicioBusqueda.buscarCancionPorTodosLosCampos("Hells Bells"));
//		
//	}
	
}

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
import ar.edu.unlam.tallerweb1.modelo.CancionLista;
import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.modelo.Genero;
import ar.edu.unlam.tallerweb1.modelo.ListaReproduccion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
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
import ar.edu.unlam.tallerweb1.servicios.ServicioCancionLista;
import ar.edu.unlam.tallerweb1.servicios.ServicioListaReproduccion;
import ar.edu.unlam.tallerweb1.servicios.ServicioListaReproduccionImpl;

public class ListaReproduccionTest extends SpringTest {

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
	public void testCrearListaDeReproduccion() {

		Usuario usuario = new Usuario();
		usuario.setId((long) 1);
		usuario.setUsuario("ivank");
		usuario.setPassword("1234");
		usuario.setRol("User");
		sessionFactory.getCurrentSession().save(usuario);

		ListaReproduccion listaReproduccion = new ListaReproduccion();
		listaReproduccion.setId((long) 1);
		listaReproduccion.setNombre("Playlist Rock");
		listaReproduccion.setUsuario(usuario);
		repoLista.setSessionFactory(sessionFactory);
		repoLista.insertarLista(listaReproduccion);

		assertEquals(1, repoLista.obtenerTodasLasListasDeReproduccion().size());

	}

	@Test
	@Transactional
	@Rollback
	public void testObtenerListaReproduccionPorUsuario() {

		Usuario usuario = new Usuario();
		usuario.setId((long) 1);
		usuario.setUsuario("ivank");
		usuario.setPassword("1234");
		usuario.setRol("User");
		sessionFactory.getCurrentSession().save(usuario);

		Album album = new Album();
		album.setId((long) 1);
		album.setNombre("Thriller");
		album.setPath_img("img/Album/BackInBlack.jpg");
		repoAlbum.setSessionFactory(sessionFactory);
		repoAlbum.insertarAlbum(album);

		Artista artista = new Artista();
		artista.setId((long) 1);
		artista.setNombre("Michael Jackson");
		artista.setPath_img("img/Artista/ac_dc.jpg");
		repoArtista.setSessionFactory(sessionFactory);
		repoArtista.insertarArtista(artista);

		Cancion cancion = new Cancion();
		cancion.setAlbum(album);
		cancion.setArtista(artista);
		cancion.setNombre("Thriller");
		repoCancion.setSessionFactory(sessionFactory);
		repoCancion.insertarCancion(cancion);

		ListaReproduccion listaReproduccion = new ListaReproduccion();
		listaReproduccion.setNombre("Playlist Rock");
		listaReproduccion.setUsuario(usuario);
		repoLista.setSessionFactory(sessionFactory);
		repoLista.insertarLista(listaReproduccion);

		ListaReproduccion listaReproduccion2 = new ListaReproduccion();
		listaReproduccion2.setNombre("Pop");
		listaReproduccion2.setUsuario(usuario);
		repoLista.insertarLista(listaReproduccion2);

		ListaReproduccion listaReproduccion3 = new ListaReproduccion();
		listaReproduccion3.setNombre("Chamamé");
		listaReproduccion3.setUsuario(usuario);
		repoLista.insertarLista(listaReproduccion3);

		assertEquals(3, repoLista.obtenerListaReproduccionPorUsuario(usuario).size());

	}

	@Test
	@Transactional
	@Rollback
	public void testAgregarCancionAPlaylist() {

		Usuario usuario = new Usuario();
		usuario.setId((long) 1);
		usuario.setUsuario("ivank");
		usuario.setPassword("1234");
		usuario.setRol("User");
		sessionFactory.getCurrentSession().save(usuario);

		Album album = new Album();
		album.setId((long) 1);
		album.setNombre("Thriller");
		album.setPath_img("img/Album/BackInBlack.jpg");
		repoAlbum.setSessionFactory(sessionFactory);
		repoAlbum.insertarAlbum(album);

		Artista artista = new Artista();
		artista.setId((long) 1);
		artista.setNombre("Michael Jackson");
		artista.setPath_img("img/Artista/ac_dc.jpg");
		repoArtista.setSessionFactory(sessionFactory);
		repoArtista.insertarArtista(artista);

		Cancion cancion = new Cancion();
		cancion.setAlbum(album);
		cancion.setArtista(artista);
		cancion.setNombre("Thriller");
		repoCancion.setSessionFactory(sessionFactory);
		repoCancion.insertarCancion(cancion);

		ListaReproduccion listaReproduccion = new ListaReproduccion();
		listaReproduccion.setId((long) 1);
		listaReproduccion.setNombre("Playlist Rock");
		listaReproduccion.setUsuario(usuario);
		repoLista.setSessionFactory(sessionFactory);
		repoLista.insertarLista(listaReproduccion);

		CancionLista cancionLista = new CancionLista();
		cancionLista.setCancion(cancion);
		cancionLista.setListaReproduccion(listaReproduccion);
		repoCancionLista.setSessionFactory(sessionFactory);
		repoCancionLista.insertarCancionLista(cancionLista);
		assertEquals(1, repoCancionLista.obtenerCancionesDeLista(listaReproduccion).size());

	}

	@Test
	@Transactional
	@Rollback
	public void testEliminarCancionDePlaylist() {

		Usuario usuario = new Usuario();
		usuario.setId((long) 1);
		usuario.setUsuario("ivank");
		usuario.setPassword("1234");
		usuario.setRol("User");
		sessionFactory.getCurrentSession().save(usuario);

		Album album = new Album();
		album.setId((long) 1);
		album.setNombre("Thriller");
		album.setPath_img("img/Album/BackInBlack.jpg");
		repoAlbum.setSessionFactory(sessionFactory);
		repoAlbum.insertarAlbum(album);

		Artista artista = new Artista();
		artista.setId((long) 1);
		artista.setNombre("Michael Jackson");
		artista.setPath_img("img/Artista/ac_dc.jpg");
		repoArtista.setSessionFactory(sessionFactory);
		repoArtista.insertarArtista(artista);

		Cancion cancion = new Cancion();
		cancion.setAlbum(album);
		cancion.setArtista(artista);
		cancion.setNombre("Thriller");
		repoCancion.setSessionFactory(sessionFactory);
		repoCancion.insertarCancion(cancion);

		ListaReproduccion listaReproduccion = new ListaReproduccion();
		listaReproduccion.setId((long) 1);
		listaReproduccion.setNombre("Playlist Rock");
		listaReproduccion.setUsuario(usuario);
		repoLista.setSessionFactory(sessionFactory);
		repoLista.insertarLista(listaReproduccion);

		CancionLista cancionLista = new CancionLista();
		cancionLista.setCancion(cancion);
		cancionLista.setListaReproduccion(listaReproduccion);
		repoCancionLista.setSessionFactory(sessionFactory);
		repoCancionLista.insertarCancionLista(cancionLista);

		assertEquals(1, repoCancionLista.obtenerCancionesDeLista(listaReproduccion).size());

		repoCancionLista.borrarCancionLista(cancionLista);

		assertEquals(0, repoCancionLista.obtenerCancionesDeLista(listaReproduccion).size());

	}
	
	@Test
	@Transactional
	@Rollback
	public void testObtenerCancionesDeUnaPlaylist() {

		Usuario usuario = new Usuario();
		usuario.setId((long) 1);
		usuario.setUsuario("ivank");
		usuario.setPassword("1234");
		usuario.setRol("User");
		sessionFactory.getCurrentSession().save(usuario);

		Album album = new Album();
		album.setId((long) 1);
		album.setNombre("Thriller");
		album.setPath_img("img/Album/Thriller.jpg");
		repoAlbum.setSessionFactory(sessionFactory);
		repoAlbum.insertarAlbum(album);

		Artista artista = new Artista();
		artista.setId((long) 1);
		artista.setNombre("Michael Jackson");
		artista.setPath_img("img/Artista/michael_jackson.jpg");
		repoArtista.setSessionFactory(sessionFactory);
		repoArtista.insertarArtista(artista);
		
		Album album2 = new Album();
		album2.setId((long) 2);
		album2.setNombre("Dynasty");
		album2.setPath_img("img/Album/Dynasty.jpg");
		repoAlbum.setSessionFactory(sessionFactory);
		repoAlbum.insertarAlbum(album2);

		Artista artista2 = new Artista();
		artista2.setId((long) 2);
		artista2.setNombre("Kiss");
		artista2.setPath_img("img/Artista/kiss.jpg");
		repoArtista.setSessionFactory(sessionFactory);
		repoArtista.insertarArtista(artista2);

		Cancion cancion = new Cancion();
		cancion.setAlbum(album);
		cancion.setArtista(artista);
		cancion.setNombre("Thriller");
		repoCancion.setSessionFactory(sessionFactory);
		repoCancion.insertarCancion(cancion);
		
		Cancion cancion2 = new Cancion();
		cancion2.setAlbum(album2);
		cancion2.setArtista(artista2);
		cancion2.setNombre("Sure Know Something");
		repoCancion.setSessionFactory(sessionFactory);
		repoCancion.insertarCancion(cancion2);

		ListaReproduccion listaReproduccion = new ListaReproduccion();
		listaReproduccion.setId((long) 1);
		listaReproduccion.setNombre("Playlist Rock");
		listaReproduccion.setUsuario(usuario);
		repoLista.setSessionFactory(sessionFactory);
		repoLista.insertarLista(listaReproduccion);

		CancionLista cancionLista = new CancionLista();
		cancionLista.setCancion(cancion);
		cancionLista.setListaReproduccion(listaReproduccion);
		repoCancionLista.setSessionFactory(sessionFactory);
		repoCancionLista.insertarCancionLista(cancionLista);
		
		CancionLista cancionLista2 = new CancionLista();
		cancionLista2.setCancion(cancion2);
		cancionLista2.setListaReproduccion(listaReproduccion);
		repoCancionLista.setSessionFactory(sessionFactory);
		repoCancionLista.insertarCancionLista(cancionLista2);

		assertEquals(2, repoCancionLista.obtenerCancionesDeLista(listaReproduccion).size());


	}	

}

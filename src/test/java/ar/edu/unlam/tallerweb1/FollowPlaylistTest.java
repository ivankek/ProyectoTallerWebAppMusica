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
import ar.edu.unlam.tallerweb1.modelo.FollowPlaylist;
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
import ar.edu.unlam.tallerweb1.repositorios.RepositorioFollowPlaylist;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioFollowPlaylistImpl;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioGenero;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioGeneroImpl;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioListaReproduccion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioListaReproduccionImpl;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuarioImpl;
import ar.edu.unlam.tallerweb1.servicios.ServicioCancionLista;
import ar.edu.unlam.tallerweb1.servicios.ServicioListaReproduccion;
import ar.edu.unlam.tallerweb1.servicios.ServicioListaReproduccionImpl;

public class FollowPlaylistTest extends SpringTest {

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
	public void testDarleFollowAUnaPlaylist() {

		Usuario usuario = new Usuario();
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
		
		Usuario usuario2 = new Usuario();
		usuario.setUsuario("maradona");
		usuario.setPassword("1234");
		usuario.setRol("User");
		sessionFactory.getCurrentSession().save(usuario2);
		
		Usuario usuario3 = new Usuario();
		usuario3.setUsuario("veron");
		usuario3.setPassword("1234");
		usuario3.setRol("User");
		sessionFactory.getCurrentSession().save(usuario3);
		
		RepositorioFollowPlaylist repoFollowLista = new RepositorioFollowPlaylistImpl(sessionFactory);
		
		FollowPlaylist followPlaylist = new FollowPlaylist();
		followPlaylist.setUsuario(usuario2);
		followPlaylist.setListaReproduccion(listaReproduccion);
		repoFollowLista.guardarFollow(followPlaylist);
		
		FollowPlaylist followPlaylist2 = new FollowPlaylist();
		followPlaylist2.setUsuario(usuario3);
		followPlaylist2.setListaReproduccion(listaReproduccion);
		repoFollowLista.guardarFollow(followPlaylist2);
		
		FollowPlaylist followPlaylist3 = new FollowPlaylist();
		followPlaylist3.setUsuario(usuario2);
		followPlaylist3.setListaReproduccion(listaReproduccion2);
		repoFollowLista.guardarFollow(followPlaylist3);

		assertEquals(2, repoFollowLista.obtenerPlaylistSeguidasPorUsuario(usuario2).size());

	}

	@Test
	@Transactional
	@Rollback
	public void testUnfollowPlaylist() {

		Usuario usuario = new Usuario();
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
		
		Usuario usuario2 = new Usuario();
		usuario.setUsuario("maradona");
		usuario.setPassword("1234");
		usuario.setRol("User");
		sessionFactory.getCurrentSession().save(usuario2);
		
		Usuario usuario3 = new Usuario();
		usuario3.setUsuario("veron");
		usuario3.setPassword("1234");
		usuario3.setRol("User");
		sessionFactory.getCurrentSession().save(usuario3);
		
		RepositorioFollowPlaylist repoFollowLista = new RepositorioFollowPlaylistImpl(sessionFactory);
		
		FollowPlaylist followPlaylist = new FollowPlaylist();
		followPlaylist.setUsuario(usuario2);
		followPlaylist.setListaReproduccion(listaReproduccion);
		repoFollowLista.guardarFollow(followPlaylist);
		
		FollowPlaylist followPlaylist2 = new FollowPlaylist();
		followPlaylist2.setUsuario(usuario3);
		followPlaylist2.setListaReproduccion(listaReproduccion);
		repoFollowLista.guardarFollow(followPlaylist2);
		
		FollowPlaylist followPlaylist3 = new FollowPlaylist();
		followPlaylist3.setUsuario(usuario2);
		followPlaylist3.setListaReproduccion(listaReproduccion2);
		repoFollowLista.guardarFollow(followPlaylist3);

		assertEquals(2, repoFollowLista.obtenerPlaylistSeguidasPorUsuario(usuario2).size());
		
		repoFollowLista.dejarDeSeguirPlaylist(followPlaylist3);
		
		assertEquals(1, repoFollowLista.obtenerPlaylistSeguidasPorUsuario(usuario2).size());
		

	}
	
}
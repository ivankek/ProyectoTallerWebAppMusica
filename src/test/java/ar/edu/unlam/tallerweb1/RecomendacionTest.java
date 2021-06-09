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
import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.modelo.Genero;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public class RecomendacionTest extends SpringTest{

	@Inject
	private SessionFactory sessionFactory;
	
	private List<Long> cargarArtistas() {
		List<Long> artistasID = new ArrayList<Long>();
		
		Artista artista = new Artista();
		artista.setNombre("Foo Fighters");
		artistasID.add((Long) sessionFactory.getCurrentSession().save(artista));
		
		artista = new Artista();
		artista.setNombre("Chet baker");
		artistasID.add((Long) sessionFactory.getCurrentSession().save(artista));
		
		return artistasID;
	}
	
	private List<Long> cargarAlbums() {
		List<Long>albumIDS = new ArrayList<Long>();
		
		Album album = new Album();
		album.setNombre("Wasting light");
		albumIDS.add((Long) sessionFactory.getCurrentSession().save(album));
		
		album = new Album();
		album.setNombre("Solo jazz");
		albumIDS.add((Long) sessionFactory.getCurrentSession().save(album));
		
		return albumIDS;
	}
	
	private List<Long> cargarGeneros() {
		List<Long>generosID = new ArrayList<Long>();
		Genero genero = new Genero();
		genero.setNombre("Rock");
		generosID.add((Long) sessionFactory.getCurrentSession().save(genero));
		
		genero = new Genero();
		genero.setNombre("Indie");
		generosID.add((Long) sessionFactory.getCurrentSession().save(genero));
		
		genero = new Genero();
		genero.setNombre("Heavy Metal");
		generosID.add((Long) sessionFactory.getCurrentSession().save(genero));
		
		genero = new Genero();
		genero.setNombre("Jazz");
		generosID.add((Long) sessionFactory.getCurrentSession().save(genero));

		return generosID;
	}
	
	private List<Long> cargarUsuarios() {
		List<Long>usuariosID = new ArrayList<Long>();
		Usuario user = new Usuario();
		
		//Setear usuario y guardarlo
		user.setUsuario("pepeRock");
		user.setPassword("1234");
		user.setRol("usuario");
		
		usuariosID.add((Long) sessionFactory.getCurrentSession().save(user));
		
		return usuariosID;
	}

	private List<Long> cargarCanciones(List<Long>albumsID , List<Long>artistasID) {
		List<Long>cancionesID = new ArrayList<Long>();
		Cancion cancion = new Cancion();
		
		cancion.setNombre("Arlandria");
		cancion.setAlbum(sessionFactory.getCurrentSession().get(Album.class, albumsID.get(0)));
		cancion.setArtista(sessionFactory.getCurrentSession().get(Artista.class, artistasID.get(0)));
		cancionesID.add((Long) sessionFactory.getCurrentSession().save(cancion));
		
		cancion = new Cancion();
		cancion.setNombre("White Limo");
		cancion.setAlbum(sessionFactory.getCurrentSession().get(Album.class, albumsID.get(0)));
		cancion.setArtista(sessionFactory.getCurrentSession().get(Artista.class, artistasID.get(0)));
		cancionesID.add((Long) sessionFactory.getCurrentSession().save(cancion));
		
		cancion = new Cancion();
		cancion.setNombre("Valentine");
		cancion.setAlbum(sessionFactory.getCurrentSession().get(Album.class, albumsID.get(1)));
		cancion.setArtista(sessionFactory.getCurrentSession().get(Artista.class, artistasID.get(1)));
		cancionesID.add((Long) sessionFactory.getCurrentSession().save(cancion));
		
		return cancionesID;
	}
	
	private void asociarGenerosALasCanciones(List<Long>cancionesID , List<Long>generosID) {
		CancionGenero cancionGenero = new CancionGenero();
		cancionGenero.setCancion(sessionFactory.getCurrentSession().get(Cancion.class, cancionesID.get(0)));
		cancionGenero.setGenero(sessionFactory.getCurrentSession().get(Genero.class, generosID.get(0)));
		sessionFactory.getCurrentSession().save(cancionGenero);
		
		cancionGenero = new CancionGenero();
		cancionGenero.setCancion(sessionFactory.getCurrentSession().get(Cancion.class, cancionesID.get(0)));
		cancionGenero.setGenero(sessionFactory.getCurrentSession().get(Genero.class, generosID.get(1)));
		sessionFactory.getCurrentSession().save(cancionGenero);
		
		cancionGenero = new CancionGenero();
		cancionGenero.setCancion(sessionFactory.getCurrentSession().get(Cancion.class, cancionesID.get(0)));
		cancionGenero.setGenero(sessionFactory.getCurrentSession().get(Genero.class, generosID.get(2)));
		sessionFactory.getCurrentSession().save(cancionGenero);
		
		cancionGenero = new CancionGenero();		
		cancionGenero.setCancion(sessionFactory.getCurrentSession().get(Cancion.class, cancionesID.get(1)));
		cancionGenero.setGenero(sessionFactory.getCurrentSession().get(Genero.class, generosID.get(0)));
		sessionFactory.getCurrentSession().save(cancionGenero);
		
		cancionGenero = new CancionGenero();
		cancionGenero.setCancion(sessionFactory.getCurrentSession().get(Cancion.class, cancionesID.get(1)));
		cancionGenero.setGenero(sessionFactory.getCurrentSession().get(Genero.class, generosID.get(1)));
		sessionFactory.getCurrentSession().save(cancionGenero);
		
		cancionGenero = new CancionGenero();
		cancionGenero.setCancion(sessionFactory.getCurrentSession().get(Cancion.class, cancionesID.get(1)));
		cancionGenero.setGenero(sessionFactory.getCurrentSession().get(Genero.class, generosID.get(2)));	
		sessionFactory.getCurrentSession().save(cancionGenero);
		
		cancionGenero = new CancionGenero();
		cancionGenero.setCancion(sessionFactory.getCurrentSession().get(Cancion.class, cancionesID.get(2)));
		cancionGenero.setGenero(sessionFactory.getCurrentSession().get(Genero.class, generosID.get(3)));	
		sessionFactory.getCurrentSession().save(cancionGenero);
	}
	
	private void añadirCancionesAFavoritos(List<Long>cancionesID , List<Long>usuariosID) {
		Favorito favorito = new Favorito();
		favorito.setCancion(sessionFactory.getCurrentSession().get(Cancion.class, cancionesID.get(0)));
		favorito.setUsuario(sessionFactory.getCurrentSession().get(Usuario.class, usuariosID.get(0)));
		sessionFactory.getCurrentSession().save(favorito);
		
		favorito = new Favorito();
		favorito.setCancion(sessionFactory.getCurrentSession().get(Cancion.class, cancionesID.get(1)));
		favorito.setUsuario(sessionFactory.getCurrentSession().get(Usuario.class, usuariosID.get(0)));
		sessionFactory.getCurrentSession().save(favorito);
		
	}
	
	private List<Favorito> obtenerFavoritosDelUsuario(List<Long> usuarios){
		Usuario usuarioBuscado = sessionFactory.getCurrentSession().get(Usuario.class, usuarios.get(0));
		return (List<Favorito>) sessionFactory.getCurrentSession().createCriteria(Favorito.class)
                                                                  .add(Restrictions.eq("usuario", usuarioBuscado))
                                                                  .list();
	}

	private List<String> obtenerGenerosDeInteresDelUsuarioSegunSuListaDeFavoritos(List<Favorito>favoritos){
		List<CancionGenero>generosDeLaCancion = new ArrayList<CancionGenero>();
		List<String>generosDelUsuario = new ArrayList<String>();
	
		for(Favorito iterator : favoritos) {
			generosDeLaCancion = sessionFactory.getCurrentSession().createCriteria(CancionGenero.class)
                                                                   .add(Restrictions.eq("cancion" , iterator.getCancion())) 
                                                                   .list();
			for(CancionGenero iterator2 : generosDeLaCancion) {
				if(!generosDelUsuario.contains(iterator2.getGenero().getNombre())) {
					generosDelUsuario.add(iterator2.getGenero().getNombre());
				}
			}
		}
		
		return generosDelUsuario;
	}

	private List<Artista> recomendarArtista(List<String>generosDelUsuario) {
		List<Artista>artistasRecomendados = new ArrayList<Artista>();
		
		List<Artista>artistas = sessionFactory.getCurrentSession().createCriteria(Artista.class)
				                                                  .list();
		
		List<CancionGenero>generos = new ArrayList<CancionGenero>();
		
		
		for(Artista artista : artistas) {
			List<String>generosDelArtista = new ArrayList<String>();
			//Trae todos los generos del artista
			generos = sessionFactory.getCurrentSession().createCriteria(CancionGenero.class)
					                                    .createAlias("cancion", "tablaCancion")
					                                    .add(Restrictions.eq("tablaCancion.artista", artista))
					                                    .list();
			//Arma una lista de generos del artista sin que se repita el genero
			for(CancionGenero genero : generos) {
				if(!generosDelArtista.contains(genero.getGenero().getNombre())) {
					generosDelArtista.add(genero.getGenero().getNombre());
				}
			}
			
  //Añade el artista a una lista de artistas recomendados si uno de los generos del artista esta dentro de los generos del usuario
			Boolean añadido = false;
			Integer i = 0;
			while((!añadido) && (i < generosDelUsuario.size())) {
				if(generosDelArtista.contains(generosDelUsuario.get(i))) {
					añadido = artistasRecomendados.add(artista);
				}
				i++;
			}
		}
		return artistasRecomendados;
	}
	
	@Test
	@Transactional @Rollback
	public void testQueRecomiendeArtistasSegunLosGenerosQueEscuchaElUsuario() {
		List<Long> artistas = cargarArtistas();
		List<Long> albums = cargarAlbums();
		List<Long> generos = cargarGeneros();
		List<Long> usuarios = cargarUsuarios();
		List<Long> canciones = cargarCanciones(albums, artistas);
		asociarGenerosALasCanciones(canciones, generos);
		añadirCancionesAFavoritos(canciones, usuarios);
		List<Favorito>listaDeFavoritos = obtenerFavoritosDelUsuario(usuarios);
		List<String>generosDelUsuario = obtenerGenerosDeInteresDelUsuarioSegunSuListaDeFavoritos(listaDeFavoritos);
		List<Artista>valorEsperado = recomendarArtista(generosDelUsuario);
		
		assertEquals(1 , valorEsperado.size());
		assertEquals("Foo Fighters" , valorEsperado.get(0).getNombre());
	}
}
/*
1. Si estos es un select * = sessionFactory.getCurrentSession().createAlias(entity)
   como hago entonces un select x campo?
   
2. Como hago un DISTINCT por campo?

3. Preguntar sobre agregar a favoritos y seguir un artista/usuario ejemplo spotify
*/
	


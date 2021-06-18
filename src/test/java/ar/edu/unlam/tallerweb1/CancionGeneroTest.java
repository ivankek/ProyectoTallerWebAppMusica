package ar.edu.unlam.tallerweb1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.hibernate.SessionFactory;

import org.hibernate.criterion.Projections;
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

public class CancionGeneroTest extends SpringTest{
	
	@Inject
	private SessionFactory sessionFactory;
	
	private List<Long> cargarArtistas() {
		List<Long> artistasID = new ArrayList<Long>();
		
		Artista artista = new Artista();
		artista.setNombre("Foo Fighters");
		artistasID.add((Long) sessionFactory.getCurrentSession().save(artista));
		
		return artistasID;
	}

	private List<Long> cargarAlbums() {
		List<Long>albumIDS = new ArrayList<Long>();
		
		Album album = new Album();
		album.setNombre("Wasting light");
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
		
		return generosID;
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
		
	}
	
	private List<String>obtenerGenerosDeUnaCancion(Cancion cancion){
		return sessionFactory.getCurrentSession().createCriteria(CancionGenero.class)
                                                 .add(Restrictions.eq("cancion", cancion))
                                                 .createAlias("genero", "tablaGenero")
                                                 .setProjection(Projections.property("tablaGenero.nombre"))
                                                 .list();
	}
	
	@Test
	@Transactional @Rollback
	public void agregarGenerosALasCanciones() {
		
		List<Long>artistas = cargarArtistas();
		List<Long>albums = cargarAlbums();
		List<Long>generosQueHayEnLaPlataforma  = cargarGeneros();
		List<Long>canciones = cargarCanciones(albums, artistas);
		asociarGenerosALasCanciones(canciones, generosQueHayEnLaPlataforma);
		
		//El resultado me tiene que dar 3 registros
		Integer actual = sessionFactory.getCurrentSession().createCriteria(CancionGenero.class).list().size();
		Integer expected = 5;
		
		assertEquals(expected , actual);
	}
	
	@Test
	@Transactional @Rollback
	public void conseguirGenerosDeUnaCancion() {
		List<Long>artistas = cargarArtistas();
		List<Long>albums = cargarAlbums();
		List<Long>generosQueHayEnLaPlataforma  = cargarGeneros();
		List<Long>canciones = cargarCanciones(albums, artistas);
		asociarGenerosALasCanciones(canciones, generosQueHayEnLaPlataforma);
		Cancion tema1 = sessionFactory.getCurrentSession().get(Cancion.class, canciones.get(0));
		Cancion tema2 = sessionFactory.getCurrentSession().get(Cancion.class, canciones.get(1));
		
		List<String>generosDelTema2 = obtenerGenerosDeUnaCancion(tema2);
		
		
		assertEquals("Rock" , generosDelTema2.get(0));
		assertEquals(3 , generosDelTema2.size());
		
	}
	
	@Test
	@Transactional @Rollback
	public void conseguirGenerosDeUnAlbum() {
		List<Long>artistas = cargarArtistas();
		List<Long>albums = cargarAlbums();
		List<Long>generosQueHayEnLaPlataforma  = cargarGeneros();
		List<Long>canciones = cargarCanciones(albums, artistas);
		asociarGenerosALasCanciones(canciones, generosQueHayEnLaPlataforma);
		
		Album album = sessionFactory.getCurrentSession().get(Album.class, albums.get(0));
		//Trae generos repetidos
		List<CancionGenero>generosDelAlbum = sessionFactory.getCurrentSession().createCriteria(CancionGenero.class)
				                                                               .createAlias("cancion", "tablaCancion")
				                                                               .add(Restrictions.eq("tablaCancion.album", album))
				                                                               .list();
		
		List<String>generosSinRepetir = sessionFactory.getCurrentSession().createCriteria(CancionGenero.class)
		                                  .createAlias("cancion", "tablaCancion")
		                                  .add(Restrictions.eq("tablaCancion.album", album))
		                                  .createAlias("genero", "tablaGenero")
		                                  .setProjection(Projections.distinct(Projections.property("tablaGenero.nombre")))
		                                  .list();
		
		
		
		
		assertEquals(5 , generosDelAlbum.size());
		assertEquals(3 , generosSinRepetir.size());
		
		
		assertEquals("Heavy Metal" , generosSinRepetir.get(0));
		assertEquals("Indie" , generosSinRepetir.get(1));
		assertEquals("Rock" , generosSinRepetir.get(2));
	}
	
	@Test
	@Transactional @Rollback
	public void conseguirGenerosDeUnArtista() {
		
		Artista artista = new Artista();
		
		Genero genero_1 = new Genero();
		Genero genero_2 = new Genero();
		Genero genero_3 = new Genero();
		Genero genero_4 = new Genero();
		
		Album album = new Album();
		Album album_2 = new Album();
		
		Cancion cancion = new Cancion();
		Cancion cancion_2 = new Cancion();
		Cancion cancion_3 = new Cancion();
		
		CancionGenero cancionGenero_1 = new CancionGenero();
		CancionGenero cancionGenero_2 = new CancionGenero();
		CancionGenero cancionGenero_3 = new CancionGenero();
		CancionGenero cancionGenero_4 = new CancionGenero();
		
		artista.setNombre("Foo Fighters");
		
		album.setNombre("Wasting light");
		album_2.setNombre("Sonic Highways");
		
		cancion.setNombre("Arlandria");
		cancion_2.setNombre("White Limo");
		cancion_3.setNombre("Subterranean");
		
		genero_1.setNombre("Rock");
		genero_2.setNombre("Indie");
		genero_3.setNombre("Heavy Metal");
		genero_4.setNombre("Progressive");
		
		//Guardo Generos
		Long generoRock = (Long) sessionFactory.getCurrentSession().save(genero_1);	
		Long generoIndie = (Long) sessionFactory.getCurrentSession().save(genero_2);
		Long generoHeavyMetal = (Long) sessionFactory.getCurrentSession().save(genero_3);
		Long generoProgressive = (Long) sessionFactory.getCurrentSession().save(genero_4);
		
		//Guardo Artista
		Long artistaID = (Long) sessionFactory.getCurrentSession().save(artista);
		
		//Guardo Album
		Long albumID = (Long) sessionFactory.getCurrentSession().save(album);
		Long albumID2 = (Long) sessionFactory.getCurrentSession().save(album_2);
		
		//Setear album y artista a la cancion
		cancion.setAlbum(sessionFactory.getCurrentSession().get(Album.class, albumID));
		cancion.setArtista(sessionFactory.getCurrentSession().get(Artista.class, artistaID));
		
		cancion_2.setAlbum(sessionFactory.getCurrentSession().get(Album.class, albumID));
		cancion_2.setArtista(sessionFactory.getCurrentSession().get(Artista.class, artistaID));
		
		cancion_3.setAlbum(sessionFactory.getCurrentSession().get(Album.class, albumID2));
		cancion_3.setArtista(sessionFactory.getCurrentSession().get(Artista.class, artistaID));
		
		
		//Guardo Cancion
		Long cancionID = (Long) sessionFactory.getCurrentSession().save(cancion);
		Long cancionID2 = (Long) sessionFactory.getCurrentSession().save(cancion_2);
		Long cancionID3 = (Long) sessionFactory.getCurrentSession().save(cancion_3);
		
		//Agrego generos a la cancion
		cancionGenero_1.setCancion(sessionFactory.getCurrentSession().get(Cancion.class, cancionID));
		cancionGenero_1.setGenero(sessionFactory.getCurrentSession().get(Genero.class, generoRock));
		
		cancionGenero_2.setCancion(sessionFactory.getCurrentSession().get(Cancion.class, cancionID));
		cancionGenero_2.setGenero(sessionFactory.getCurrentSession().get(Genero.class, generoIndie));
		
		cancionGenero_3.setCancion(sessionFactory.getCurrentSession().get(Cancion.class, cancionID2));
		cancionGenero_3.setGenero(sessionFactory.getCurrentSession().get(Genero.class, generoHeavyMetal));
		
		cancionGenero_4.setCancion(sessionFactory.getCurrentSession().get(Cancion.class, cancionID3));
		cancionGenero_4.setGenero(sessionFactory.getCurrentSession().get(Genero.class, generoProgressive));
		
		//Guardo en la tabla GeneroCancion
		sessionFactory.getCurrentSession().save(cancionGenero_1);
		sessionFactory.getCurrentSession().save(cancionGenero_2);
		sessionFactory.getCurrentSession().save(cancionGenero_3);
		sessionFactory.getCurrentSession().save(cancionGenero_4);
		
		//Obtengo el artista que quiero saber que generos tiene asociado 		
		Artista artistaObtenido = (Artista) sessionFactory.getCurrentSession().createCriteria(Artista.class)
				                                                              .add(Restrictions.eq("nombre" , "Foo Fighters"))
				                                                              .uniqueResult();
		
		//Consulto que generos tiene asociado el artista
		List<CancionGenero> generosEncontrados = sessionFactory.getCurrentSession().createCriteria(CancionGenero.class)
		                                                                           .createAlias("cancion", "tablaCancion")
										                                           .add(Restrictions.eq("tablaCancion.artista" , artistaObtenido)) 
										                                           .list();
		
		assertEquals("Rock" , generosEncontrados.get(0).getGenero().getNombre());
		assertEquals("Indie" , generosEncontrados.get(1).getGenero().getNombre());
		assertEquals("Heavy Metal" , generosEncontrados.get(2).getGenero().getNombre());
		assertEquals("Progressive" , generosEncontrados.get(3).getGenero().getNombre());
		assertEquals(4 , generosEncontrados.size());
	}
	
	//Preguntar por distinct por columna
	@Test
	@Transactional @Rollback
	public void testDeQueNoMeTraigaGenerosRepetidos() {
		
		Artista artista = new Artista();
		
		Genero genero_1 = new Genero();
		Genero genero_2 = new Genero();
		Genero genero_3 = new Genero();
		
		Album album = new Album();
		Cancion cancion = new Cancion();
		Cancion cancion_2 = new Cancion();
		
		CancionGenero cancionGenero_1 = new CancionGenero();
		CancionGenero cancionGenero_2 = new CancionGenero();
		CancionGenero cancionGenero_3 = new CancionGenero();
		CancionGenero cancionGenero_4 = new CancionGenero();
		CancionGenero cancionGenero_5 = new CancionGenero();
		CancionGenero cancionGenero_6 = new CancionGenero();
		
		artista.setNombre("Foo Fighters");
		album.setNombre("Wasting light");
		cancion.setNombre("Arlandria");
		cancion_2.setNombre("White Limo");
		genero_1.setNombre("Rock");
		genero_2.setNombre("Indie");
		genero_3.setNombre("Heavy Metal");
		
		
		//Guardo Generos
		Long generoRock = (Long) sessionFactory.getCurrentSession().save(genero_1);	
		Long generoIndie = (Long) sessionFactory.getCurrentSession().save(genero_2);
		Long generoHeavyMetal = (Long) sessionFactory.getCurrentSession().save(genero_3);
		
		//Guardo Artista
		Long artistaID = (Long) sessionFactory.getCurrentSession().save(artista);
		
		//Guardo Album
		Long albumID = (Long) sessionFactory.getCurrentSession().save(album);
		
		//Setear album y artista a la cancion
		cancion.setAlbum(sessionFactory.getCurrentSession().get(Album.class, albumID));
		cancion.setArtista(sessionFactory.getCurrentSession().get(Artista.class, artistaID));
		
		cancion_2.setAlbum(sessionFactory.getCurrentSession().get(Album.class, albumID));
		cancion_2.setArtista(sessionFactory.getCurrentSession().get(Artista.class, artistaID));
		
		
		//Guardo Cancion
		Long cancionID = (Long) sessionFactory.getCurrentSession().save(cancion);
		Long cancionID2 = (Long) sessionFactory.getCurrentSession().save(cancion_2);
		
		//Agrego generos a la cancion
		cancionGenero_1.setCancion(sessionFactory.getCurrentSession().get(Cancion.class, cancionID));
		cancionGenero_1.setGenero(sessionFactory.getCurrentSession().get(Genero.class, generoRock));
		
		cancionGenero_2.setCancion(sessionFactory.getCurrentSession().get(Cancion.class, cancionID));
		cancionGenero_2.setGenero(sessionFactory.getCurrentSession().get(Genero.class, generoIndie));
		
		cancionGenero_3.setCancion(sessionFactory.getCurrentSession().get(Cancion.class, cancionID));
		cancionGenero_3.setGenero(sessionFactory.getCurrentSession().get(Genero.class, generoHeavyMetal));
		
		cancionGenero_4.setCancion(sessionFactory.getCurrentSession().get(Cancion.class, cancionID2));
		cancionGenero_4.setGenero(sessionFactory.getCurrentSession().get(Genero.class, generoRock));
		
		cancionGenero_5.setCancion(sessionFactory.getCurrentSession().get(Cancion.class, cancionID2));
		cancionGenero_5.setGenero(sessionFactory.getCurrentSession().get(Genero.class, generoIndie));
		
		cancionGenero_6.setCancion(sessionFactory.getCurrentSession().get(Cancion.class, cancionID2));
		cancionGenero_6.setGenero(sessionFactory.getCurrentSession().get(Genero.class, generoHeavyMetal));
		
		//Guardo en la tabla GeneroCancion
		sessionFactory.getCurrentSession().save(cancionGenero_1);
		sessionFactory.getCurrentSession().save(cancionGenero_2);
		sessionFactory.getCurrentSession().save(cancionGenero_3);
		sessionFactory.getCurrentSession().save(cancionGenero_4);
		sessionFactory.getCurrentSession().save(cancionGenero_5);
		sessionFactory.getCurrentSession().save(cancionGenero_6);
		
		//Obtengo el album que quiero saber que generos tiene asociado 		
		Album albumObtenido = (Album) sessionFactory.getCurrentSession().createCriteria(Album.class)
				                                                .add(Restrictions.eq("nombre" , "Wasting light"))
				                                                .uniqueResult();
		
		//Consulto que generos tiene asociado el album
		List<CancionGenero> generosEncontrados = sessionFactory.getCurrentSession().createCriteria(CancionGenero.class)
		                                                                           .createAlias("cancion", "tablaCancion")
										                                           .add(Restrictions.eq("tablaCancion.album" , albumObtenido))
										                                           .list();
		
		List<String> falsoDistinctGeneros = new ArrayList<String>();
		
		for(CancionGenero item : generosEncontrados) {
			if(!falsoDistinctGeneros.contains(item.getGenero().getNombre())) {
				falsoDistinctGeneros.add(item.getGenero().getNombre());
			}
		}
		
		/*assertNotEquals(6 , generosEncontrados.size());*/
		assertNotEquals(6 , falsoDistinctGeneros.size());
		assertEquals("Rock" , generosEncontrados.get(0).getGenero().getNombre());
		assertEquals("Indie" , generosEncontrados.get(1).getGenero().getNombre());
		assertEquals("Heavy Metal" , generosEncontrados.get(2).getGenero().getNombre());
		assertEquals("Rock" , falsoDistinctGeneros.get(0));
		assertEquals("Indie" , falsoDistinctGeneros.get(1));
		assertEquals("Heavy Metal" , falsoDistinctGeneros.get(2));
		assertEquals(3 , falsoDistinctGeneros.size());
	}
	
	@Test
	@Transactional @Rollback
	public void testVerQueGenerosEscuchaElUsuarioPorFavoritos() {
		
		List<Long>artistas = cargarArtistas();
		List<Long>albums = cargarAlbums();
		List<Long>generosQueHayEnLaPlataforma  = cargarGeneros();
		List<Long>canciones = cargarCanciones(albums, artistas);
		asociarGenerosALasCanciones(canciones, generosQueHayEnLaPlataforma);
		
		Usuario user = new Usuario();
		
		//Setear usuario y guardarlo
		user.setUsuario("pepeRock");
		user.setPassword("1234");
		user.setRol("usuario");
		
		Long userID = (Long) sessionFactory.getCurrentSession().save(user);
		
		Favorito favorito = new Favorito();
		
		//Añado a favorito y guardo en BD
		favorito.setCancion(sessionFactory.getCurrentSession().get(Cancion.class , canciones.get(0)));
		favorito.setUsuario(sessionFactory.getCurrentSession().get(Usuario.class , userID));
		sessionFactory.getCurrentSession().save(favorito);
		
		favorito = new Favorito();
		favorito.setCancion(sessionFactory.getCurrentSession().get(Cancion.class, canciones.get(1)));
        favorito.setUsuario(sessionFactory.getCurrentSession().get(Usuario.class , userID));
		sessionFactory.getCurrentSession().save(favorito);
		
		//Veo favoritos del usuario
		List<Favorito> listaDeFavoritos = sessionFactory.getCurrentSession().createCriteria(Favorito.class)
                                                                            .add(Restrictions.eq("usuario", user))
                                                                            .list();
		List<String>generosDelUsuario = new ArrayList<String>();
		
		for(Favorito fav : listaDeFavoritos) {
			generosDelUsuario.addAll(obtenerGenerosDeUnaCancion(fav.getCancion()));
		}
		
		List<String>sinRepetir = generosDelUsuario.stream().distinct().collect(Collectors.toList());
		
		assertEquals(2 , listaDeFavoritos.size());
		assertEquals(5 ,generosDelUsuario.size());
		assertEquals(3 , sinRepetir.size());
		assertEquals("Rock" , sinRepetir.get(0));
		assertEquals("Indie" , sinRepetir.get(1));
		assertEquals("Heavy Metal" , sinRepetir.get(2));
		
	}
}

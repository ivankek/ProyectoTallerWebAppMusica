//package ar.edu.unlam.tallerweb1;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.function.Predicate;
//
//import javax.inject.Inject;
//
//import org.hibernate.SessionFactory;
//import org.hibernate.criterion.Restrictions;
//import org.junit.Test;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.transaction.annotation.Transactional;
//
//import ar.edu.unlam.tallerweb1.modelo.Album;
//import ar.edu.unlam.tallerweb1.modelo.Artista;
//import ar.edu.unlam.tallerweb1.modelo.Cancion;
//import ar.edu.unlam.tallerweb1.modelo.CancionGenero;
//import ar.edu.unlam.tallerweb1.modelo.Favorito;
//import ar.edu.unlam.tallerweb1.modelo.Genero;
//import ar.edu.unlam.tallerweb1.modelo.ListaReproduccion;
//import ar.edu.unlam.tallerweb1.modelo.Usuario;
//
//public class ListaReproduccionTest extends SpringTest {
//
//	@Inject
//	private SessionFactory sessionFactory;
//
//	@Test
//	@Transactional
//	@Rollback
//	public void testQueRecomiendeArtistasSegunLosGenerosQueEscuchaElUsuario() {
//
//		Usuario usuario = new Usuario();
//		usuario.setId((long) 1);
//		usuario.setUsuario("ivank");
//		usuario.setPassword("1234");
//		usuario.setRol("User");
//
//		Usuario usuario2 = new Usuario();
//		usuario.setId((long) 2);
//		usuario.setUsuario("ivan11");
//		usuario.setPassword("9911");
//		usuario.setRol("User");
//
//		Artista artista = new Artista();
//		artista.setId((long) 1);
//		artista.setNombre("AC/DC");
//
//		Album album = new Album();
//		album.setId((long) 1);
//		album.setNombre("Back In Black");
//
//		ListaReproduccion listaReproduccion = new ListaReproduccion();
//		listaReproduccion.setId((long) 1);
//		listaReproduccion.setNombre("Rock");
//		listaReproduccion.setUsuario(usuario);
//
//		ListaReproduccion listaReproduccion2 = new ListaReproduccion();
//		listaReproduccion2.setId((long) 2);
//		listaReproduccion2.setNombre("Metal");
//		listaReproduccion2.setUsuario(usuario);
//
//		Cancion cancion = new Cancion();
//		cancion.setId((long) 1);
//		cancion.setNombre("Hells Bells");
//		cancion.setArtista(artista);
//		cancion.setAlbum(album);
//		cancion.setListaReproduccion(listaReproduccion);
//		cancion.setListaReproduccion(listaReproduccion2);
//
//		Cancion cancion2 = new Cancion();
//		cancion2.setId((long) 1);
//		cancion2.setNombre("Back In Black");
//		cancion2.setArtista(artista);
//		cancion2.setAlbum(album);
//		cancion2.setListaReproduccion(listaReproduccion);
//		cancion2.setListaReproduccion(listaReproduccion2);
//
//	}
//}

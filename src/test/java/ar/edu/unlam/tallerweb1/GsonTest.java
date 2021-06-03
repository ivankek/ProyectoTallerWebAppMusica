package ar.edu.unlam.tallerweb1;



import static org.junit.Assert.assertEquals;

import java.lang.reflect.Type;
import java.util.List;

import javax.inject.Inject;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Artista;
import ar.edu.unlam.tallerweb1.modelo.Cancion;

public class GsonTest extends SpringTest{
	
	@Inject
	private SessionFactory sessionFactory;
	
	@Test
	@Transactional @Rollback
	public void serializarCancionesDeLaBD() {
		Album album = new Album();
		Artista artista = new  Artista();
		Cancion cancion = new Cancion();
		Cancion cancion2 = new Cancion();
		
		album.setNombre("1995");
		album.setPath_img("ruta_de imagen");
		
		sessionFactory.getCurrentSession().save(album);
		
		artista.setNombre("Foo Fighters");
		
		sessionFactory.getCurrentSession().save(artista);
		
		cancion.setAlbum(album);
		cancion.setArtista(artista);
		cancion.setNombre("Alone easy target");
		cancion.setPath_cancion("ruta cancion");
		
		sessionFactory.getCurrentSession().save(cancion);
		
		cancion2.setAlbum(album);
		cancion2.setArtista(artista);
		cancion2.setNombre("walk");
		cancion2.setPath_cancion("ruta cancion");
		
		sessionFactory.getCurrentSession().save(cancion2);
		
		final Gson gson = new Gson();
		
		List<Cancion> canciones = sessionFactory.getCurrentSession().createCriteria(Cancion.class).list();
		
		final String representacionJson = gson.toJson(canciones);
		final String valorEsperado = "[{\"id\":1,"
									 + "\"nombre\":\"Alone easy target\","
									 + "\"album\":{\"id\":1,\"nombre\":\"1995\",\"path_img\":\"ruta_de imagen\"},"
									 + "\"artista\":{\"id\":1,\"nombre\":\"Foo Fighters\"},"
									 + "\"path_cancion\":\"ruta cancion\"},"
									 + "{\"id\":2,"
									 + "\"nombre\":\"walk\","
									 + "\"album\":{\"id\":1,\"nombre\":\"1995\",\"path_img\":\"ruta_de imagen\"},"
									 + "\"artista\":{\"id\":1,\"nombre\":\"Foo Fighters\"},"
									 + "\"path_cancion\":\"ruta cancion\"}]";
		
		assertEquals(valorEsperado , representacionJson);
		
	}
	
	@Test
	@Transactional @Rollback
	public void deserializarCancion() {
		
		final Gson gson = new Gson();		
		
		final String jsonCancion = "{\"id\":1,"
									 + "\"nombre\":\"Alone easy target\","
									 + "\"album\":{\"id\":1,\"nombre\":\"1995\",\"path_img\":\"ruta_de imagen\"},"
									 + "\"artista\":{\"id\":1,\"nombre\":\"Foo Fighters\"},"
									 + "\"path_cancion\":\"ruta cancion\"}";
		
		Cancion cancion = gson.fromJson(jsonCancion, Cancion.class);
		
		assertEquals("Alone easy target",cancion.getNombre());
		
	}
	
	@Test
	@Transactional @Rollback
	public void deserializarCancionesAUnaListaDeCanciones() {
		
		final Gson gson = new Gson();		
		
		final String jsonCanciones = "[{\"id\":1,"
				 + "\"nombre\":\"Alone easy target\","
				 + "\"album\":{\"id\":1,\"nombre\":\"1995\",\"path_img\":\"ruta_de imagen\"},"
				 + "\"artista\":{\"id\":1,\"nombre\":\"Foo Fighters\"},"
				 + "\"path_cancion\":\"ruta cancion\"},"
				 + "{\"id\":2,"
				 + "\"nombre\":\"walk\","
				 + "\"album\":{\"id\":1,\"nombre\":\"1995\",\"path_img\":\"ruta_de imagen\"},"
				 + "\"artista\":{\"id\":1,\"nombre\":\"Foo Fighters\"},"
				 + "\"path_cancion\":\"ruta cancion\"}]";
		
		final Type tipoListaCanciones = new TypeToken<List<Cancion>>(){}.getType();
		final List<Cancion> canciones = gson.fromJson(jsonCanciones, tipoListaCanciones);
		
		assertEquals(2 ,canciones.size());
		assertEquals("Alone easy target",canciones.get(0).getNombre());
		assertEquals("walk",canciones.get(1).getNombre());
	}
	
}

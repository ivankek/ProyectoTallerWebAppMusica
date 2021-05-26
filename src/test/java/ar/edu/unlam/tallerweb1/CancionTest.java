package ar.edu.unlam.tallerweb1;



import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.inject.Inject;


import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Artista;
import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.servicios.ServicioCancion;

public class CancionTest extends SpringTest{

	@Inject
	private ServicioCancion servicioCancion;
	
	@Test
	@Transactional @Rollback
	public void testDeQueMeTraigaLasCincoMejoresCanciones(){
		/*Album album = new Album();
		album.setNombre("Medicine At Midnight");
		album.setPath_img("img/Album/Medicine_at_midnight.jpg");
		album.setPuntaje(100L);
		Long id_album = servicioCancion.guardarAlbum(album);
		
		Artista artista = new Artista();
		artista.setNombre("Foo Fighters");
		artista.setPuntaje(1000L);
		Long id_artista = servicioCancion.guardarArtista(artista);
		
		Cancion cancion = new Cancion();
		cancion.setAlbum(servicioCancion.obtenerAlbumPorId(id_album));
		cancion.setArtista(servicioCancion.obtenerArtistaPorId(id_artista));
		
		cancion.setNombre("Making A Fire");
		cancion.setPath_cancion("media/Medicine at midnight/Making A Fire.mp3");
		cancion.setPuntaje(1L);
		servicioCancion.guardarCancion(cancion);
		
		cancion.setNombre("Shame Shame");
		cancion.setPath_cancion("media/Medicine at midnight/Shame Shame.mp3");
		cancion.setPuntaje(2L);
		servicioCancion.guardarCancion(cancion);
		
		cancion.setNombre("Cloudspotter");
		cancion.setPath_cancion("media/Medicine at midnight/Cloudspotter.mp3");
		cancion.setPuntaje(3L);
		servicioCancion.guardarCancion(cancion);
		
		cancion.setNombre("Waiting On A War");
		cancion.setPath_cancion("media/Medicine at midnight/Waiting On A War.mp3");
		cancion.setPuntaje(4L);
		servicioCancion.guardarCancion(cancion);
		
		cancion.setNombre("Medicine At Night");
		cancion.setPath_cancion("media/Medicine at midnight/Medicine At Night.mp3");
		cancion.setPuntaje(5L);
		servicioCancion.guardarCancion(cancion);
		
		cancion.setNombre("No Son Of Mine");
		cancion.setPath_cancion("media/Medicine at midnight/No Son Of Mine.mp3");
		cancion.setPuntaje(7L);
		servicioCancion.guardarCancion(cancion);
		
		List<Cancion> todasLasCanciones = servicioCancion.obtenerTodasLasCanciones();
		List<Cancion> cincoMejoresCanciones = servicioCancion.obtenerLasCincoMejoresCanciones();
		
		assertEquals(todasLasCanciones.size(),7);
		assertEquals(cincoMejoresCanciones.size(),5);*/
	}
}
package ar.edu.unlam.tallerweb1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.assertj.core.api.Assert;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;

import ar.edu.unlam.tallerweb1.modelo.Artista;
import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCancion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCancionImpl;

public class RepositorioCancionTest extends SpringTest{
	
	@Inject
	private SessionFactory sessionFactory;
	
	@Test
	@Transactional
	@Rollback
	public void testQueVerifiqueQueSePuedaInsertarCanciones() {
		Cancion cancion = new Cancion();
		Cancion cancion2 = new Cancion();
		cancion.setNombre("Hells Bells");
		cancion2.setNombre("Shake a Leg");
		RepositorioCancion repositorioCancion = new RepositorioCancionImpl();
		repositorioCancion.setSessionFactory(this.sessionFactory);
		
		repositorioCancion.insertarCancion(cancion2);
		repositorioCancion.insertarCancion(cancion);
		
		Integer cantidadObtenida = repositorioCancion.obtenerTodasLasCanciones().size();
		Integer cantidadEsperada = 2;
		
		assertEquals(cantidadObtenida, cantidadEsperada);
	}

	@Test
	@Transactional @Rollback
	public void testObtengaUnaCancionPorId() {
		Cancion cancion = new Cancion();
		cancion.setNombre("Hells Bells");
		RepositorioCancion repositorioCancion = new RepositorioCancionImpl();
		repositorioCancion.setSessionFactory(this.sessionFactory);
		
		repositorioCancion.insertarCancion(cancion);
		assertEquals(cancion, repositorioCancion.obtenerCancionPorId(cancion.getId()));
	}
	
	@Test
	@Transactional
	@Rollback
	public void testQueObtengaUnaCancionPorNombre() {
		Cancion cancion = new Cancion();
		cancion.setNombre("Hells Bells");
		RepositorioCancion repositorioCancion = new RepositorioCancionImpl();
		repositorioCancion.setSessionFactory(this.sessionFactory);
		
		repositorioCancion.insertarCancion(cancion);
	 
		assertEquals(cancion,repositorioCancion.obtenerCancionPorSuNombre(cancion.getNombre()));
		
	}
	
}

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
import ar.edu.unlam.tallerweb1.modelo.ListaReproduccion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioCancion;
import ar.edu.unlam.tallerweb1.servicios.ServicioListaReproduccion;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

public class ListaReproduccionTest extends SpringTest {

	@Inject
	private ServicioListaReproduccion servicioListaReproduccion;

	@Test
	@Transactional
	@Rollback
	public void testQueCreeUnaPlaylist() {

		Usuario usuario = new Usuario();
		usuario.setId((long) 2);
		usuario.setPassword("1234");
		usuario.setRol("usuario");
		usuario.setUsuario("ivankek");
		
		ListaReproduccion listaReproduccion = new ListaReproduccion();
		listaReproduccion.setId((long) 1);
		listaReproduccion.setNombre("Lista 1");
		listaReproduccion.setUsuario(servicioListaReproduccion.obtenerUsuarioPorId(usuario.getId()));
		servicioListaReproduccion.guardarListaReproduccion(listaReproduccion);

		assertEquals(1, servicioListaReproduccion.obtenerTodasLasListasDeReproduccion().size());

	}
}
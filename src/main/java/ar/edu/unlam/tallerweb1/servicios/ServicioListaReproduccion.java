package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import org.springframework.ui.ModelMap;

import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.modelo.CancionLista;
import ar.edu.unlam.tallerweb1.modelo.ListaReproduccion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioListaReproduccion {

	Long guardarListaReproduccion(ListaReproduccion listaReproduccion);

	Long guardarUsuario(Usuario usuario);

	Usuario obtenerUsuarioPorId(Long id);

	ListaReproduccion obtenerListaPorId(Long id);

	Long guardarCancionLista(CancionLista cancionLista);

	List<Cancion> obtenerCancionesDeLista(ListaReproduccion listaReproduccion);

	List<ListaReproduccion> obtenerTodasLasListasDeReproduccion();

	List<ListaReproduccion> obtenerListaReproduccionPorUsuario(Usuario usuario);

	Usuario obtenerUsuarioPorNombre(String usuario);

	List<ListaReproduccion> obtenerListaPorNombre(String nombre);

	String crearYAlmacenarListaReproduccion(String nombrePlaylist, Usuario usuario);

	List<String> obtenerImagenesDePlaylist(ListaReproduccion listaReproduccion);

	void imagenesDePlaylistModelo(ModelMap model, Long idPlaylist);

}

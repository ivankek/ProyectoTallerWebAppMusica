package ar.edu.unlam.tallerweb1.servicios;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Artista;
import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.modelo.Genero;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioBusqueda;

@Service
@Transactional
public class ServicioBusquedaImpl implements ServicioBusqueda {

	private RepositorioBusqueda repositorioBusqueda;

	@Autowired
	public ServicioBusquedaImpl(RepositorioBusqueda repositorioBusqueda) {
		this.repositorioBusqueda = repositorioBusqueda;
	}
	
	@Override
	public Set<Cancion> buscarCancionPorTodosLosCampos(String nombre) {
		List<Cancion> genero = repositorioBusqueda.obtenerCancionesPorGenero(nombre);
		List<Cancion> artista = repositorioBusqueda.obtenerCancionesPorArtista(nombre);
		List<Cancion> album = repositorioBusqueda.obtenerCancionesPorAlbum(nombre);
		List<Cancion> lista = repositorioBusqueda.obtenerCancionesPorLista(nombre);
		List<Cancion> nombreCancion = repositorioBusqueda.obtenerCancionesPorNombre(nombre);
		
		Set<Cancion> todos = new HashSet<>();
		
		todos.addAll(genero);
		todos.addAll(artista);
		todos.addAll(album);
		todos.addAll(lista);
		todos.addAll(nombreCancion);
		
		return todos;
	}
}

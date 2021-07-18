package ar.edu.unlam.tallerweb1.servicios;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Artista;
import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.modelo.Genero;
import ar.edu.unlam.tallerweb1.modelo.ListaReproduccion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAlbum;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioArtista;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioBusqueda;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioListaReproduccion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;

@Service
@Transactional
public class ServicioBusquedaImpl implements ServicioBusqueda {

	private RepositorioBusqueda repositorioBusqueda;
	private RepositorioArtista repositorioArtista;
	private RepositorioAlbum repositorioAlbum;
	private RepositorioListaReproduccion repositorioListaReproduccion;
	private RepositorioUsuario repositorioUsuario;

	@Autowired
	public ServicioBusquedaImpl(RepositorioBusqueda repositorioBusqueda, RepositorioArtista repositorioArtista,
			RepositorioUsuario repositorioUsuario, RepositorioListaReproduccion repositorioListaReproduccion,
			RepositorioAlbum repositorioAlbum) {
		this.repositorioBusqueda = repositorioBusqueda;
		this.repositorioArtista = repositorioArtista;
		this.repositorioUsuario = repositorioUsuario;
		this.repositorioListaReproduccion = repositorioListaReproduccion;
		this.repositorioAlbum = repositorioAlbum;

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

	@Override
	public List<Artista> obtenerUnArtistaPorNombre(String nombre) {
		return repositorioArtista.obtenerUnArtistaPorNombre(nombre);
	}

	@Override
	public List<ListaReproduccion> obtenerListaReproduccionPorNombre(String nombre) {
		return repositorioListaReproduccion.obtenerListaReproduccionPorNombre(nombre);
	}

	@Override
	public List<Usuario> obtenerUsuarioPorNombre(String usuario) {
		return repositorioUsuario.obtenerUnUsuarioPorNombre(usuario);
	}

	@Override
	public List<Album> obtenerUnAlbumPorNombre(String nombre) {
		return repositorioAlbum.obtenerAlbumsPorNombre(nombre);
	}

}

package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;

import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Artista;
import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.modelo.CancionGenero;
import ar.edu.unlam.tallerweb1.modelo.Genero;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAlbum;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioArtista;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCancion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCancionGenero;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioGenero;

@Service
@Transactional
public class ServicioCancionImpl implements ServicioCancion {
	
	@Inject
	private RepositorioCancion repositorioCancion;
	
	@Inject
	private RepositorioCancionGenero repositorioCancionGenero;
	
	@Inject
	private RepositorioAlbum repositorioAlbum;
	
	@Inject
	private RepositorioGenero repositorioGenero;
	
	@Inject
	private RepositorioArtista repositorioArtista;

	@Override
	public Long guardarCancion(Cancion cancion) {
		return repositorioCancion.insertarCancion(cancion);
	}

	@Override
	public Long guardarCancionGenero(CancionGenero cancionGenero) {
		return repositorioCancionGenero.insertarCancionGenero(cancionGenero);
	}

	@Override
	public Cancion obtenerCancionPorId(Long id) {
		return repositorioCancion.obtenerCancionPorId(id);
	}
	
	@Override
	public Long guardarArtista(Artista artista) {
		return repositorioArtista.insertarArtista(artista);
	}

	@Override
	public Long guardarGenero(Genero genero) {
		return repositorioGenero.insertarGenero(genero);
	}

	@Override
	public Long guardarAlbum(Album album) {
		return repositorioAlbum.insertarAlbum(album);
	}
	
	@Override
	public List<Cancion> obtenerTodasLasCanciones(){
		return repositorioCancion.obtenerTodasLasCanciones();
	}
	
	@Override
	public Artista obtenerArtistaPorId(Long id) {
		return repositorioArtista.obtenerArtistaPorId(id);
	}

	@Override
	public Album obtenerAlbumPorId(Long id) {
		return repositorioAlbum.obtenerAlbumPorId(id);
	}

	@Override
	public Album obtenerAlbumPorNombre(String nombre) {
		return repositorioAlbum.obtenerAlbumPorNombre(nombre);
	}
	
	@Override
	public List<Cancion> obtenerLasCincoMejoresCanciones() {
		return repositorioCancion.obtenerLasCincoMejoresCanciones();
	}

	@Override
	public List<Album> obtenerLosCincoMejoresAlbumes() {
		return repositorioAlbum.obtenerCincoMejoresAlbum();
	}

	@Override
	public List<Artista> obtenerLosCincoMejoresArtistas() {
		return repositorioArtista.obtenerCincoMejoresArtistas();
	}

	@Override
	public String serializarDatosCanciones() {
		String representacionJson;
		List<Cancion> canciones = repositorioCancion.obtenerTodasLasCanciones();
		Gson gson = new Gson();
		
		representacionJson = gson.toJson(canciones);
		
		return representacionJson;
	}

	@Override
	public Artista obtenerArtistaPorNombre(String nombre) {
		return repositorioArtista.obtenerArtistaPorNombre(nombre);
	}

	@Override
	public List<Album> obtenerTodosLosAlbums() {
		return repositorioAlbum.obtenerTodosLosAlbums();
	}

	@Override
	public List<Artista> obtenerTodosLosArtistas() {
		return repositorioArtista.obtenerTodosLosArtistas();
	}


	public List<Genero> obtenerTodosLosGeneros(){
		return repositorioGenero.obtenerTodosLosGeneros();
	}

	@Override
	public Cancion obtenerCancionPorNombreArtistaAlbum(String nombreCancion, String nombreArtista, String nombreAlbum) {
		return repositorioCancion.obtenerCancionPorNombreArtistaAlbum(nombreCancion, nombreArtista, nombreAlbum);
	}

}

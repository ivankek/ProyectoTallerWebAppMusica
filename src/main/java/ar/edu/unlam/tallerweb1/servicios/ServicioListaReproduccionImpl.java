package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Artista;
import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.modelo.CancionLista;
import ar.edu.unlam.tallerweb1.modelo.ListaReproduccion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAlbum;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCancion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCancionLista;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioListaReproduccion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;

@Service
@Transactional
public class ServicioListaReproduccionImpl implements ServicioListaReproduccion {

	@Inject
	private RepositorioListaReproduccion repositorioListaReproduccion;

	@Inject
	private RepositorioUsuario repositorioUsuario;

	@Inject
	private RepositorioCancionLista repositorioCancionLista;

	@Inject
	private RepositorioAlbum repositorioAlbum;

	@Override
	public Long guardarListaReproduccion(ListaReproduccion listaReproduccion) {
		return repositorioListaReproduccion.insertarLista(listaReproduccion);
	}

	@Override
	public Long guardarUsuario(Usuario usuario) {
		return repositorioUsuario.insertarUsuario(usuario);
	}

	@Override
	public Usuario obtenerUsuarioPorId(Long id) {
		return repositorioUsuario.obtenerUsuarioPorId(id);
	}

	@Override
	public List<ListaReproduccion> obtenerTodasLasListasDeReproduccion() {
		return repositorioListaReproduccion.obtenerTodasLasListasDeReproduccion();
	}

	@Override
	public Usuario obtenerUsuarioPorNombre(String usuario) {
		return repositorioUsuario.obtenerUsuarioPorNombre(usuario);
	}

	@Override
	public List<ListaReproduccion> obtenerListaReproduccionPorUsuario(Usuario usuario) {
		return repositorioListaReproduccion.obtenerListaReproduccionPorUsuario(usuario);
	}

	@Override
	public Long guardarCancionLista(CancionLista cancionLista) {
		return repositorioCancionLista.insertarCancionLista(cancionLista);
	}

	@Override
	public ListaReproduccion obtenerListaPorId(Long id) {
		return repositorioListaReproduccion.obtenerListaPorId(id);
	}

	@Override
	public List<ListaReproduccion> obtenerListaPorNombre(String nombre) {
		return repositorioListaReproduccion.obtenerListaReproduccionPorNombre(nombre);
	}

	@Override
	public List<Cancion> obtenerCancionesDeLista(ListaReproduccion listaReproduccion) {
		return repositorioCancionLista.obtenerCancionesDeLista(listaReproduccion);
	}

	@Override
	public void imagenesDePlaylistModelo(ModelMap model, Long idPlaylist) {
		if (obtenerImagenesDePlaylist(obtenerListaPorId(idPlaylist))
				.size() < 4) {

			model.put("imagenesLista", obtenerImagenesDePlaylist(obtenerListaPorId(idPlaylist)).get(0));

			model.put("ocultar4", "d-none");

		} else {

			model.put("imagenesLista", obtenerImagenesDePlaylist(obtenerListaPorId(idPlaylist)).get(0));
			model.put("imagenesLista2", obtenerImagenesDePlaylist(obtenerListaPorId(idPlaylist)).get(1));
			model.put("imagenesLista3", obtenerImagenesDePlaylist(obtenerListaPorId(idPlaylist)).get(2));
			model.put("imagenesLista4", obtenerImagenesDePlaylist(obtenerListaPorId(idPlaylist)).get(3));

			model.put("ocultar1", "d-none");

		}
	}
	
	@Override
	public List<String> obtenerImagenesDePlaylist(ListaReproduccion listaReproduccion) {
		List<Cancion> canciones = new ArrayList<Cancion>();
		List<String> imagenesAlbum = new ArrayList<String>();
		canciones.addAll(obtenerCancionesDeLista(listaReproduccion));
		for (Cancion cancion : canciones) {
			if (cancion.getAlbum() != null) {
				Album album = cancion.getAlbum();
				String imagen = album.getPath_img();

				if (imagenesAlbum.contains(imagen)) {

				} else {

					imagenesAlbum.add(imagen);
				}
			}

		}

		List<String> imagenesPlaylist = new ArrayList<String>();
		if (imagenesAlbum.size() < 4) {

			imagenesPlaylist.add(imagenesAlbum.get(0));

		} else {
			imagenesPlaylist.add(imagenesAlbum.get(0));
			imagenesPlaylist.add(imagenesAlbum.get(1));
			imagenesPlaylist.add(imagenesAlbum.get(2));
			imagenesPlaylist.add(imagenesAlbum.get(3));
		}

		return imagenesPlaylist;

	}

	@Override
	public String crearYAlmacenarListaReproduccion(String nombrePlaylist, Usuario usuario) {
		ListaReproduccion listaReproduccion = new ListaReproduccion();
		listaReproduccion.setNombre(nombrePlaylist);
		listaReproduccion.setUsuario(usuario);
		repositorioListaReproduccion.insertarLista(listaReproduccion);
		return "Se creo la lista de reproduccion, agregue canciones";
	}

}

package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Artista;
import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.modelo.CancionGenero;
import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCancionGenero;

@Service
@Transactional
public class ServicioGeneroImpl implements ServicioGenero {

	@Inject
	private RepositorioCancionGenero repoCancionGenero;
	
	@Override
	public Long insertarCancionGenero(CancionGenero cancionGenero) {
		return repoCancionGenero.insertarCancionGenero(cancionGenero);
	}

	@Override
	public List<String> obtenerGenerosDeUnaCancion(Cancion cancion) {
		return repoCancionGenero.obtenerGenerosDeUnaCancion(cancion);
	}

	@Override
	public List<String> obtenerGenerosDeUnAlbum(Album album) {
		return repoCancionGenero.obtenerGenerosDeUnAlbum(album);
	}

	@Override
	public List<String> obtenerGenerosDeUnArtista(Artista artista) {
		return repoCancionGenero.obtenerGenerosDeUnArtista(artista);
	}

	@Override
	public List<String> obtenerGenerosDeListaDeFavoritos(List<Favorito> listaDeFavoritos) {
		List<String>generosDelUsuario = new ArrayList<String>();
		for(Favorito favorito : listaDeFavoritos) {
			generosDelUsuario.addAll(repoCancionGenero.obtenerGenerosDeUnaCancion(favorito.getCancion()));
		}
		return generosDelUsuario.stream().distinct().collect(Collectors.toList());
	}

}

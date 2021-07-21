package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCancion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioFavorito;

@Service
@Transactional
public class ServicioFavoritoImpl implements ServicioFavorito {
	
	@Inject
	RepositorioFavorito repoFavorito;
	
	@Inject
	RepositorioCancion repoCancion;
	
	@Override
	public List<Favorito> obtenerFavoritosDelUsuario(Usuario usuario) {
		return repoFavorito.obtenerListaDeFavoritos(usuario);
	}

	@Override
	public String añadirAFavoritos(String nombreCancion, String nombreArtista, String nombreAlbum, Usuario usuario) {
		String mensaje = "No se pudo agregar a favoritos";
		Cancion cancion = repoCancion.obtenerCancionPorNombreArtistaAlbum(nombreCancion, nombreArtista, nombreAlbum);
		if(cancion != null) {
			if(repoFavorito.buscarFavorito(cancion, usuario) == null) {
				Favorito favorito = new Favorito();
				favorito.setCancion(cancion);
				favorito.setUsuario(usuario);
				repoFavorito.añadirAFavoritos(favorito);
				mensaje = "Se agrego a favoritos";
			}else{
				mensaje = "Ya se encuentra en favoritos";
				}
		}
		
		return mensaje;
	}

	@Override
	public String eliminarFavorito(String nombreCancion, String nombreArtista, String nombreAlbum, Usuario usuario) {
		String mensaje = "No se pudo eliminar la cancion";
		Cancion cancion = repoCancion.obtenerCancionPorNombreArtistaAlbum(nombreCancion, nombreArtista, nombreAlbum);
		if(cancion != null) {
			Favorito favorito = repoFavorito.buscarFavorito(cancion, usuario);
			if(favorito == null) {
				mensaje = "La cancion no se encuentra en tus favoritos";
			}else {
				if(repoFavorito.quitarFavorito(favorito))
					mensaje = "Se elimino de favoritos";
			}
		}
		
		return mensaje;
	}

	@Override
	public String consultarSiEstaEnFavoritos(String nombreCancion, String nombreArtista, String nombreAlbum, Usuario usuario) {
		Cancion cancion = repoCancion.obtenerCancionPorNombreArtistaAlbum(nombreCancion, nombreArtista, nombreAlbum);
		String icono = "favorite_border";
		if(cancion != null) {
			if(repoFavorito.buscarFavorito(cancion, usuario) != null)
				icono = "favorite";
		}
		return icono;
	}

}

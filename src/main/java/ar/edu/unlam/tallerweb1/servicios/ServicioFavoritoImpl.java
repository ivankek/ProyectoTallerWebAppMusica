package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioFavorito;

@Service
@Transactional
public class ServicioFavoritoImpl implements ServicioFavorito {
	
	@Inject
	RepositorioFavorito repoFavorito;
	
	@Override
	public List<Favorito> obtenerFavoritosDelUsuario(Usuario usuario) {
		return repoFavorito.obtenerListaDeFavoritos(usuario);
	}

	@Override
	public String añadirAFavoritos(Cancion cancion, Usuario usuario) {
		String mensaje;
		if(repoFavorito.buscarFavorito(cancion, usuario) == null) {
			Favorito favorito = new Favorito();
			favorito.setCancion(cancion);
			favorito.setUsuario(usuario);
			repoFavorito.añadirAFavoritos(favorito);
			mensaje = "Se agrego a favoritos";
		}else{
			mensaje = "Ya se encuentra en favoritos";
			}
		
		return mensaje;
	}

	@Override
	public String eliminarFavorito(Cancion cancion, Usuario usuario) {
		Favorito favorito = repoFavorito.buscarFavorito(cancion, usuario);
		if(favorito == null)
			return "La cancion no se encuentra en tus favoritos";
		return repoFavorito.quitarFavorito(favorito) ? "Se elimino de favoritos" : "No se pudo eliminar";
	}

	@Override
	public String consultarSiEstaEnFavoritos(Cancion cancion, Usuario usuario) {
		String icono = "favorite";
		return repoFavorito.buscarFavorito(cancion, usuario) == null ? icono = "favorite_border" : icono;
	}

}

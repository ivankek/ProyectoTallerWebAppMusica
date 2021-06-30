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
		Favorito favorito = new Favorito();
		String mensaje = "Se agrego a favoritos";
		favorito.setCancion(cancion);
		favorito.setUsuario(usuario);
		repoFavorito.añadirAFavoritos(favorito);
		return mensaje;
	}

	@Override
	public String eliminarFavorito(Cancion cancion, Usuario usuario) {
		Favorito favorito = repoFavorito.buscarFavorito(cancion, usuario);
		repoFavorito.quitarFavorito(favorito);
		String mensaje = "Se elimino de favoritos";
		return mensaje;
	}

	@Override
	public String consultarSiEstaEnFavoritos(Cancion cancion, Usuario usuario) {
		String icono = "favorite";
		return repoFavorito.buscarFavorito(cancion, usuario) == null ? icono = "favorite_border" : icono;
	}

}

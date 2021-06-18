package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}

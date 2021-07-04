package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Artista;
import ar.edu.unlam.tallerweb1.modelo.Follow;
import ar.edu.unlam.tallerweb1.modelo.ListaReproduccion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioArtista;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioFollow;

@Service
@Transactional
public class ServicioFollowImpl implements ServicioFollow{

	private RepositorioFollow repositorioFollow;
		
	@Autowired
	public ServicioFollowImpl(RepositorioFollow repositorioFollow) {
		this.repositorioFollow = repositorioFollow;
	}
	
	@Inject
	private RepositorioArtista repositorioArtista;

	@Override
	public String seguirArtista(Usuario usuario , String artistaNombre) {
		String estadoDelBotonSeguir = "Seguir";
		Follow follow = new Follow();
		follow.setUsuario(usuario);
		follow.setArtista(repositorioArtista.obtenerArtistaPorNombre(artistaNombre));
		if(follow.getArtista() == null || follow.getUsuario() == null)
			return estadoDelBotonSeguir;
		repositorioFollow.guardarFollow(follow);
		return estadoDelBotonSeguir = "Siguiendo";
	}

	@Override
	public List<Follow> obtenerSeguidoresPorArtista(String artista) {
		
		return repositorioFollow.obtenerSeguidoresPorArtista(artista);
	}

	@Override
	public List<Artista> obtenerArtistasSeguidosPorUsuario(Usuario usuario) {
		return repositorioFollow.obtenerArtistasSeguidosPorUsuario(usuario);
	}

	@Override
	public String consultarSiElUsuarioSigueAlArtista(Usuario usuario, String artistaNombre) {
		List<Artista>artistasQueSigueElUsuario = repositorioFollow.obtenerArtistasSeguidosPorUsuario(usuario);
		Artista artistaABuscar = repositorioArtista.obtenerArtistaPorNombre(artistaNombre);
		return artistasQueSigueElUsuario.contains(artistaABuscar) ? "Siguiendo" : "Seguir";
	}

	@Override
	public List<Follow> obtenerSeguidoresPorUsuario(String usuario) {
		return repositorioFollow.obtenerSeguidoresPorUsuario(usuario);
	}

	@Override
	public String dejarDeSeguir(Usuario usuario, String artistaNombre) {
		String estadoDelBotonSeguir = "Siguiendo";
		Follow follow = repositorioFollow.obtenerRegistroFollow(usuario, artistaNombre);
		if(follow != null) {
			repositorioFollow.dejarDeSeguir(follow);
			estadoDelBotonSeguir = "Seguir";
		}
		
		return estadoDelBotonSeguir;
	}
}

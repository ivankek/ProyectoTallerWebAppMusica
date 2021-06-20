package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Artista;
import ar.edu.unlam.tallerweb1.modelo.Follow;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioFollow;

@Service
@Transactional
public class ServicioFollowImpl implements ServicioFollow{

	private RepositorioFollow repositorioFollow;
	
	@Autowired
	public ServicioFollowImpl(RepositorioFollow repositorioFollow) {
		this.repositorioFollow = repositorioFollow;
	}

	@Override
	public Long guardarFollow(Follow follow) {
		return repositorioFollow.guardarFollow(follow);
	}

	@Override
	public List<Follow> obtenerSeguidoresPorArtista(String artista) {
		
		return repositorioFollow.obtenerSeguidoresPorArtista(artista);
	}
}

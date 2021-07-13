package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.modelo.CancionLista;
import ar.edu.unlam.tallerweb1.modelo.ListaReproduccion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCancion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioCancionLista;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioListaReproduccion;

@Service
@Transactional
public class ServicioCancionListaImpl implements ServicioCancionLista {
	
	@Inject
	RepositorioCancion repoCancion;
	
	@Inject
	RepositorioListaReproduccion repoListaReproduccion;
	
	@Inject
	RepositorioCancionLista repoCancionLista;

	@Override
	public String crearYAlmacenarCancionLista(Usuario usuario, String nombrePlaylist, String nombreCancion) {
		Cancion cancionAgregar = repoCancion.obtenerCancionPorSuNombre(nombreCancion);
		if(repoCancionLista.obtenerCancionesDeListaPorNombre(nombrePlaylist).contains(cancionAgregar))
			return nombreCancion + " ya se encuentra en " + nombrePlaylist;
		CancionLista cancionLista = new CancionLista();
		cancionLista.setCancion(cancionAgregar);
		cancionLista.setListaReproduccion(repoListaReproduccion.obtenerUnaListaReproduccionPorSuNombreYUsuario(nombrePlaylist, usuario));
		repoCancionLista.insertarCancionLista(cancionLista);
		return nombreCancion + " se agrego a " + nombrePlaylist;
	}

}

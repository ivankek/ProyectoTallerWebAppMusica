package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.ListaReproduccion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioListaReproduccion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;

@Service
@Transactional
public class ServicioListaReproduccionImpl implements ServicioListaReproduccion {

	@Inject
	private RepositorioListaReproduccion repositorioListaReproduccion;

	@Inject
	private RepositorioUsuario repositorioUsuario;

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
	public List<ListaReproduccion> obtenerTodasLasListasDeReproduccion(){
		return repositorioListaReproduccion.obtenerTodasLasListasDeReproduccion();
	}

	@Override
	public Usuario obtenerUsuarioPorNombre(String usuario) {
		return repositorioUsuario.obtenerUsuarioPorNombre(usuario);
	}
	
	
}

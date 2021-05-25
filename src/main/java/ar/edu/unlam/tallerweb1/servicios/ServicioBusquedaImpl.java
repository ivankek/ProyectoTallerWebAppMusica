package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Artista;
import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.modelo.Genero;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioBusqueda;

@Service
@Transactional
public class ServicioBusquedaImpl implements ServicioBusqueda {

	private RepositorioBusqueda servicioBusquedaDao;

	@Autowired
	public ServicioBusquedaImpl(RepositorioBusqueda servicioBusquedaDao) {
		this.servicioBusquedaDao = servicioBusquedaDao;
	}
	@Override
	public List<Cancion> obtenerCancionesPorGenero(String nombre) {
		return servicioBusquedaDao.obtenerCancionesPorGenero(nombre);
	}

	@Override
	public List<Cancion> obtenerCancionesPorArtista(String nombre) {
		return servicioBusquedaDao.obtenerCancionesPorArtista(nombre);
	}
	
	public List<Cancion> obtenerCancionesPorAlbum(String nombre){
		return servicioBusquedaDao.obtenerCancionesPorAlbum(nombre);
	}
	@Override
	public List<Cancion> obtenerCancionesPorLista(String nombre) {
		return servicioBusquedaDao.obtenerCancionesPorLista(nombre);
	}
	@Override
	public List<Cancion> obtenerCancionesPorNombre(String nombre) {
		return servicioBusquedaDao.obtenerCancionesPorNombre(nombre);
	}
	
}

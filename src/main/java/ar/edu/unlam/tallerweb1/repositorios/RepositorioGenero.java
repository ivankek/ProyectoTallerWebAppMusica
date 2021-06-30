package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Genero;

public interface RepositorioGenero {
	
	Long insertarGenero(Genero genero);

	List<Genero> obtenerTodosLosGeneros();

}

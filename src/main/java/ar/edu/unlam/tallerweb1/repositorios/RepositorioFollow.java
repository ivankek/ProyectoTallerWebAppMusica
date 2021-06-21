package ar.edu.unlam.tallerweb1.repositorios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Artista;
import ar.edu.unlam.tallerweb1.modelo.Follow;

public interface RepositorioFollow {

	Long guardarFollow(Follow follow);

	List<Follow> obtenerSeguidoresPorArtista(String artista);

}

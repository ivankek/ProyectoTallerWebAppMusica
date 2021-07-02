package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Artista;
import ar.edu.unlam.tallerweb1.modelo.Follow;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioFollow {

	Long guardarFollow(Follow follow);

	List<Follow> obtenerSeguidoresPorArtista(String artista);

	List<Artista> obtenerArtistasSeguidosPorUsuario(Usuario usuario);
	
	String consultarSiElUsuarioSigueAlArtista(Usuario usuario , String artistaNombre);
}

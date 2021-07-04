package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Artista;
import ar.edu.unlam.tallerweb1.modelo.Follow;
import ar.edu.unlam.tallerweb1.modelo.ListaReproduccion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioFollow {

	String seguirArtista(Usuario usuario , String artistaNombre);

	List<Follow> obtenerSeguidoresPorArtista(String artista);

	List<Artista> obtenerArtistasSeguidosPorUsuario(Usuario usuario);
	
	String consultarSiElUsuarioSigueAlArtista(Usuario usuario , String artistaNombre);

	List<Follow> obtenerSeguidoresPorUsuario(String usuario);
	
	String dejarDeSeguir(Usuario usuario , String artistaNombre);

}

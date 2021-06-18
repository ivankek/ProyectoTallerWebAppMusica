package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Artista;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioRecomendar {
	List<Artista> recomendarArtistaPorGenerosDelUsuario(Usuario usuario);
}

package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioCancionLista {
	String crearYAlmacenarCancionLista(Usuario usuario , String nombrePlaylist , String nombreCancion);
}

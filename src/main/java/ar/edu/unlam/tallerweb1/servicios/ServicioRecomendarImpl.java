package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Artista;
import ar.edu.unlam.tallerweb1.modelo.Favorito;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioArtista;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioFavorito;

@Service
@Transactional
public class ServicioRecomendarImpl implements ServicioRecomendar {

	@Inject
	RepositorioArtista repoArtista;
	
	@Inject
	ServicioGenero servicioGenero;
	
	@Inject
	RepositorioFavorito repoFavorito;
	
	@Override
	public List<String> recomendarArtistaPorGeneosDelUsuario(Usuario usuario) {
		List<Favorito>listaDeFavoritos = repoFavorito.obtenerListaDeFavoritos(usuario);
		List<String>recomendaciones = new ArrayList<String>();
		List<Artista>todosLosArtistas = repoArtista.obtenerTodosLosArtistas();
		List<String>generosDelUsuario = servicioGenero.obtenerGenerosDeListaDeFavoritos(listaDeFavoritos);
		
		for(Artista artista : todosLosArtistas){
			List<String>generosDelArtista = servicioGenero.obtenerGenerosDeUnArtista(artista);
			Boolean añadio = false;
			Integer i = 0;
			while(!añadio && i < generosDelUsuario.size()){
				if(generosDelArtista.contains(generosDelUsuario.get(i))) {
					añadio = recomendaciones.add(artista.getNombre());
				}
				i++;
			}
		}

		Collections.shuffle(recomendaciones);
		
		return recomendaciones.size() > 5 ? recomendaciones.subList(0,4) : recomendaciones;
	}

}

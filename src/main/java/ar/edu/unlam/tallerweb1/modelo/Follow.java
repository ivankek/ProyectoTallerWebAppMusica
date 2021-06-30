package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Follow {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Artista artista;
	@ManyToOne
	private Usuario usuario;
	@ManyToOne
	private ListaReproduccion listaReproduccion;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Artista getArtista() {
		return artista;
	}
	public void setArtista(Artista artista) {
		this.artista = artista;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public ListaReproduccion getListaReproduccion() {
		return listaReproduccion;
	}
	
	
	public void setListaReproduccion(ListaReproduccion listaReproduccion) {
		this.listaReproduccion = listaReproduccion;
	}
	
	
	
}

package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Artista {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	private Long puntaje;

	private String path_img;
	
	private String path_img_portada;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(Long puntaje) {
		this.puntaje = puntaje;
	}

	public String getPath_img() {
		return path_img;
	}

	public void setPath_img(String path_img) {
		this.path_img = path_img;
	}

	public String getPath_img_portada() {
		return path_img_portada;
	}

	public void setPath_img_portada(String path_img_portada) {
		this.path_img_portada = path_img_portada;
	}

}

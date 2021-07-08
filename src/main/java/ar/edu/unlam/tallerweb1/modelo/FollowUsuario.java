package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class FollowUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Usuario usuario;

	@ManyToOne
	private Usuario usuarioSeguido;

	public Long getId() {
		return id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuarioSeguido() {
		return usuarioSeguido;
	}

	public void setUsuarioSeguido(Usuario usuarioSeguido) {
		this.usuarioSeguido = usuarioSeguido;
	}

	public void setId(Long id) {
		this.id = id;
	}

}

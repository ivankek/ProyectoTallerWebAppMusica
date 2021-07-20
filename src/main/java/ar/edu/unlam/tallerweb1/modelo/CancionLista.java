package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CancionLista {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Cancion cancion;
	
	@ManyToOne
	private ListaReproduccion listaReproduccion;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cancion getCancion() {
		return cancion;
	}

	public void setCancion(Cancion cancion) {
		this.cancion = cancion;
	}


	public ListaReproduccion getListaReproduccion() {
		return listaReproduccion;
	}

	
	public void setListaReproduccion(ListaReproduccion listaReproduccion) {
		this.listaReproduccion = listaReproduccion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cancion == null) ? 0 : cancion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((listaReproduccion == null) ? 0 : listaReproduccion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CancionLista other = (CancionLista) obj;
		if (cancion == null) {
			if (other.cancion != null)
				return false;
		} else if (!cancion.equals(other.cancion))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (listaReproduccion == null) {
			if (other.listaReproduccion != null)
				return false;
		} else if (!listaReproduccion.equals(other.listaReproduccion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cancion [ cancion=" + cancion.getNombre() + "]";
	}

	
}

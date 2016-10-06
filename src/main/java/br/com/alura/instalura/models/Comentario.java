package br.com.alura.instalura.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comentario {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	private Usuario usuario;
	private String texto;

	/**
	 * @deprecated
	 */
	public Comentario() {
	}

	public Comentario(Usuario usuario, String texto) {
		super();
		this.usuario = usuario;
		this.texto = texto;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public String getTexto() {
		return texto;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}

package br.com.alura.instalura.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Comentario {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@NotNull
	private Usuario usuario;
	@NotBlank
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
	
	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Integer getId() {
		return id;
	}
}

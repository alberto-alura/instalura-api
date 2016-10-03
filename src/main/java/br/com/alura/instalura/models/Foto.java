package br.com.alura.instalura.models;

import java.time.LocalDateTime;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Foto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String url;
	@ManyToOne
	@NotNull
	private Usuario usuario;		
	private LocalDateTime instante = LocalDateTime.now();
	
	/**
	 * @deprecated
	 */
	public Foto() {

	}


	public Foto(String url, Usuario usuario) {
		super();
		this.url = url;
		this.usuario = usuario;
	}
	
	public String getUrl() {
		return url;
	}
	
	public Integer getId() {
		return id;
	}


	public Usuario getUsuario() {
		return usuario;
	}
	
	public LocalDateTime getInstante() {
		return instante;
	}
	
}

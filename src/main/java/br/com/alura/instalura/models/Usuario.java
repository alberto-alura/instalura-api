package br.com.alura.instalura.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank
	private String login;
	@NotBlank
	private String senha;
	@NotBlank
	private String urlFotoPerfil;
	
	/**
	 * @deprecated
	 */
	public Usuario() {

	}
	
	
	public Usuario(String login, String senha,String urlFotoPerfil) {
		this.login = login;
		this.senha = senha;
		this.urlFotoPerfil = urlFotoPerfil;
	}


	public Integer getId() {
		return id;
	}
	
	public String getUrlFotoPerfil() {
		return urlFotoPerfil;
	}


	public String getLogin() {
		return login;
	}
	
	
}

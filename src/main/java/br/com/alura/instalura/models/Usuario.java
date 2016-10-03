package br.com.alura.instalura.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank
	private String login;
	@NotBlank
	private String senha;
	
	/**
	 * @deprecated
	 */
	public Usuario() {

	}
	
	
	public Usuario(String login, String senha) {
		this.login = login;
		this.senha = senha;
	}


	public Integer getId() {
		return id;
	}
	
	
}

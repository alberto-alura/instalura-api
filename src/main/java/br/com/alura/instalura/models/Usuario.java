package br.com.alura.instalura.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

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
	@NotBlank
	private String urlFotoPerfil;
	@ManyToMany
	private Set<Usuario> amigos = new HashSet<Usuario>();
	
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
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
		Usuario other = (Usuario) obj;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}


	public void adicionaAmigo(Usuario usuario) {
		amigos.add(usuario);
	}
	
	
	
}

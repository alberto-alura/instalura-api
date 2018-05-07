package br.com.alura.instalura.dtos.inputs;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;
import org.springframework.util.Assert;

import br.com.alura.instalura.models.Usuario;

public class NovoUsuarioForm {

	@NotBlank
	private String login;
	@NotBlank
	private String senha;
	@NotBlank
	@URL
	private String urlPerfil;

	public String getUrlPerfil() {
		return urlPerfil;
	}

	public void setUrlPerfil(String urlPerfil) {
		this.urlPerfil = urlPerfil;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean loginESenhaDiferentes() {
		Assert.notNull(login);
		Assert.notNull(senha);

		return !this.login.equals(senha);
	}

	public Usuario build() {
		return new Usuario(login, senha, urlPerfil);
	}

}

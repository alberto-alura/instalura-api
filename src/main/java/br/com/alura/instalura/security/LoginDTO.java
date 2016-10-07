package br.com.alura.instalura.security;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 * DTO que representa as informações de login enviadas pelo cliente
 * @author alberto
 *
 */
public class LoginDTO {

	@NotBlank
	@Email
	private String email;
	@NotBlank
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

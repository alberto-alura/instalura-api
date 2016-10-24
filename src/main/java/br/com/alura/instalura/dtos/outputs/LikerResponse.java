package br.com.alura.instalura.dtos.outputs;

import java.util.Set;
import java.util.stream.Collectors;

import br.com.alura.instalura.models.Usuario;

public class LikerResponse {

	private String login;

	public LikerResponse(Usuario usuario){
		this.login = usuario.getLogin();
	}
	
	public String getLogin() {
		return login;
	}
	
	public static Set<LikerResponse> map(Set<Usuario> usuarios){
		return usuarios.stream().map(LikerResponse :: new).collect(Collectors.toSet());		
	}
}

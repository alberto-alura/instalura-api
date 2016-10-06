package br.com.alura.instalura.dtos.outputs;

import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.instalura.models.Comentario;

public class ComentariosResponse {
	
	private String login;
	private String texto;
	
	public ComentariosResponse(Comentario comentario){
		this.login = comentario.getUsuario().getLogin();
		this.texto = comentario.getTexto();
	}
	
	public String getLogin() {
		return login;
	}
	
	public String getComentario() {
		return texto;
	}

	public static List<ComentariosResponse> map(List<Comentario> comentarios){
		return comentarios.stream().map(ComentariosResponse :: new).collect(Collectors.toList());		
	}
}

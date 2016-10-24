package br.com.alura.instalura.dtos.outputs;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.instalura.models.Comentario;

public class ComentarioResponse {
	
	private String login;
	private String texto;
	private Integer id;
	
	public ComentarioResponse(Comentario comentario){
		this.login = comentario.getUsuario().getLogin();
		this.texto = comentario.getTexto();
		this.id = comentario.getId();
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getLogin() {
		return login;
	}
	
	public String getTexto() {
		return texto;
	}

	public static Collection<? extends ComentarioResponse> map(List<Comentario> comentarios) {
		return comentarios.stream().map(ComentarioResponse :: new).collect(Collectors.toList());
	}

}

package br.com.alura.instalura.dtos.outputs;

import java.time.format.DateTimeFormatter;

import br.com.alura.instalura.models.Foto;

public class FotoResponse {

	private final String urlPerfil;
	private final String loginUsuario;
	private final String horario;
	private final String urlFoto;

	public FotoResponse(Foto foto){
		this.urlPerfil = foto.getUsuario().getUrlFotoPerfil();
		this.loginUsuario= foto.getUsuario().getLogin();
		this.horario = foto.getInstante().format(DateTimeFormatter.ofPattern("dd/MM/yyyy kk:mm"));
		this.urlFoto = foto.getUrl();
	}

	public String getUrlPerfil() {
		return urlPerfil;
	}

	public String getLoginUsuario() {
		return loginUsuario;
	}

	public String getHorario() {
		return horario;
	}

	public String getUrlFoto() {
		return urlFoto;
	}
	
	
	
}

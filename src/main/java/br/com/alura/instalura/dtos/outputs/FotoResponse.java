package br.com.alura.instalura.dtos.outputs;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.alura.instalura.models.Foto;

public class FotoResponse {

	private final String urlPerfil;
	private final String loginUsuario;
	private final String horario;
	private final String urlFoto;
	private final Integer id;
	private boolean likeada;
	private Set<LikerResponse> likers = new HashSet<>();
	private List<ComentariosResponse> comentarios = new ArrayList<>();

	public FotoResponse(Foto foto){
		this.urlPerfil = foto.getUsuario().getUrlFotoPerfil();
		this.loginUsuario= foto.getUsuario().getLogin();
		this.horario = foto.getInstante().format(DateTimeFormatter.ofPattern("dd/MM/yyyy kk:mm"));
		this.urlFoto = foto.getUrl();
		this.id = foto.getId();
		this.likeada = !foto.getLikers().isEmpty();
		
		this.likers.addAll(LikerResponse.map(foto.getLikers()));
		this.comentarios.addAll(ComentariosResponse.map(foto.getComentarios()));
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
	
	public Integer getId() {
		return id;
	}
	
	public boolean isLikeada() {
		return likeada;
	}
	
	public Set<LikerResponse> getLikers() {
		return likers;
	}
	
	public List<ComentariosResponse> getComentarios() {
		return comentarios;
	}
}

package br.com.alura.instalura.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.util.Assert;

@Entity
public class Foto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String url;
	@ManyToOne
	@NotNull
	private Usuario usuario;		
	private LocalDateTime instante = LocalDateTime.now();
	@ManyToMany
	private Set<Usuario> likers = new HashSet<Usuario>();
	@OneToMany
	private List<Comentario> comentarios = new ArrayList<>();
	@NotBlank
	private String comentario;	
	private LocalDateTime removedInstant;
	@Lob
	private byte[] bytes;
	
	/**
	 * @deprecated
	 */
	public Foto() {

	}


	public Foto(String url, String comentario,Usuario usuario) {
		super();
		this.url = url;
		this.comentario = comentario;
		this.usuario = usuario;
	}
	
	public Foto(String comentario, Usuario usuario, byte[] bytes) {
		this.comentario = comentario;
		this.usuario = usuario;
		this.bytes = bytes;
	}


	public String getComentario() {
		return comentario;
	}
	
	public String getUrl() {
		if(bytes != null) {
			return "/api/fotos/"+this.id+"/stream";
		}
		return url;
	}
	
	public byte[] getBytes() {
		Assert.notNull(bytes); 
		return bytes;
	}
	
	public Integer getId() {
		return id;
	}


	public Usuario getUsuario() {
		return usuario;
	}
	
	public LocalDateTime getInstante() {
		return instante;
	}

	public void adicionaLikeDo(Usuario usuario) {
		this.likers.add(usuario);
	}

	public Set<Usuario> getLikers() {
		return Collections.unmodifiableSet(likers);
	}
	
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	
	public void adicionaComentario(Comentario comentario) {
		this.comentarios.add(comentario);
	}


	/**
	 * 
	 * @param usuario
	 * @return o estado do like do usuario passado como argumento.
	 */
	public boolean toggleLike(Usuario usuario) {
		return likers.contains(usuario) ? likers.remove(usuario) : likers.add(usuario);
	}
	
	public void remove() {
		Assert.isNull(removedInstant);
		this.removedInstant = LocalDateTime.now();
	}
	
}

package br.com.alura.instalura.controllers;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.alura.instalura.models.Foto;
import br.com.alura.instalura.models.Usuario;

@RestController
@Transactional
public class GeracaoDeCoisasController {

	@PersistenceContext
	private EntityManager em;

	private List<Usuario> geraUsuariosEAmigos() {
		Usuario alberto = new Usuario("alots", "123456","https://instagram.fcgh9-1.fna.fbcdn.net/vp/960227fa1524bee9e36610f8da71889c/5B6F42E1/t51.2885-19/11199408_569104449895751_1837574990_a.jpg");
		Usuario rafael = new Usuario("rafael", "123456","https://instagram.fcgh9-1.fna.fbcdn.net/vp/faf1cd7c1d50bbf382cad0d43df15a49/5B5FF9ED/t51.2885-19/s150x150/12599387_1591433254512484_973178862_a.jpg");
		Usuario vitor = new Usuario("vitor", "123456","https://instagram.fcgh9-1.fna.fbcdn.net/vp/671f159e4aa9c3f6f3f4107305cf1462/5B5747E6/t51.2885-19/s150x150/23417279_144305519547753_7852761162822189056_n.jpg");
		
		
		alberto.adicionaAmigo(rafael);
		alberto.adicionaAmigo(vitor);
		rafael.adicionaAmigo(vitor);
		vitor.adicionaAmigo(alberto);
		
		em.persist(alberto);
		em.persist(rafael);
		em.persist(vitor);
		
		return Arrays.asList(alberto,rafael,vitor);
	}

	
	private void geraFotos(Integer usuarioId) {
		Usuario usuario = em.find(Usuario.class, usuarioId);
		Foto foto1 = new Foto(
				"https://instagram.fcgh10-1.fna.fbcdn.net/t51.2885-15/e35/14482111_1635089460122802_8984023070045896704_n.jpg?ig_cache_key=MTM1MzEzNjM4NzAxMjIwODUyMw%3D%3D.2",
				"comentario da foto",
				usuario);
		Foto foto2 = new Foto(
				"https://instagram.fcgh9-1.fna.fbcdn.net/t51.2885-15/e35/15276770_381074615568085_8052939980646907904_n.jpg?ig_cache_key=MTM5ODY4MDMyNjYyMDA1MDE4OQ%3D%3D.2",
				"comentario da foto",
				usuario);
		
		em.persist(foto1);
		em.persist(foto2);
	}
	
	@GetMapping("/gera/dados")
	public String geraDados(){
		List usuariosRegistrados = em.createQuery("select u from Usuario u").getResultList();
		if(!usuariosRegistrados.isEmpty()){
			return "<p>Opa, você já gerou os dados, não precisa rodar essa url de novo</p>";
		}
		List<Usuario> usuarios = geraUsuariosEAmigos();
		for (Usuario usuario : usuarios) {
			geraFotos(usuario.getId());
		}
		return "<p>os dados foram gerados e inseridos no banco de dados <b>instalura</b></p>";
	}
}

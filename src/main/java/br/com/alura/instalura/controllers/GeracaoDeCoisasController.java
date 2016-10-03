package br.com.alura.instalura.controllers;

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

	@GetMapping("/gera/usuario")
	public String geraUsuariosEAmigos() {
		Usuario alberto = new Usuario("alots", "123456","https://instagram.fcgh10-1.fna.fbcdn.net/t51.2885-19/11199408_569104449895751_1837574990_a.jpg");
		Usuario rafael = new Usuario("rafael", "123456","https://instagram.fcgh10-1.fna.fbcdn.net/t51.2885-19/s150x150/12599387_1591433254512484_973178862_a.jpg");
		Usuario vitor = new Usuario("vitor", "123456","https://instagram.fcgh10-1.fna.fbcdn.net/t51.2885-19/11348357_521348038019129_1965512179_a.jpg");
		
		
		alberto.adicionaAmigo(rafael);
		alberto.adicionaAmigo(vitor);
		rafael.adicionaAmigo(vitor);
		vitor.adicionaAmigo(alberto);
		
		em.persist(alberto);
		em.persist(rafael);
		em.persist(vitor);
		
		return "gerados";
	}

	@GetMapping("/gera/fotos")
	public String geraFotos(Integer usuarioId) {
		Usuario usuario = em.find(Usuario.class, usuarioId);
		Foto foto1 = new Foto(
				"https://instagram.fcgh10-1.fna.fbcdn.net/t51.2885-15/e35/14482111_1635089460122802_8984023070045896704_n.jpg?ig_cache_key=MTM1MzEzNjM4NzAxMjIwODUyMw%3D%3D.2",
				usuario);
		Foto foto2 = new Foto(
				"https://instagram.fcgh10-1.fna.fbcdn.net/t51.2885-15/e35/14553274_1838794796339803_7123267564666355712_n.jpg?ig_cache_key=MTM1MzEzNzgyMzkwNTk3MzI2OA%3D%3D.2",
				usuario);
		
		em.persist(foto1);
		em.persist(foto2);
		return "gerados";
	}
}

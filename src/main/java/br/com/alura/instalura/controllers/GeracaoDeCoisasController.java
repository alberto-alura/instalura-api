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
	public String geraUsuario() {
		Usuario usuario = new Usuario("alots", "123456");
		em.persist(usuario);
		return "usuario com id " + usuario.getId();
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

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
		Usuario alberto = new Usuario("alots", "123456","https://s3.amazonaws.com/loa-production-23ffs35gui41a/writers/images/000/000/187/big/lincoln_abraham_WD.jpg?1458837750");
		Usuario rafael = new Usuario("rafael", "123456","https://olhardigital.com.br/uploads/acervo_imagens/2015/02/r16x9/20150219125722_1200_675.jpg");
		Usuario vitor = new Usuario("vitor", "123456","https://biomania.com.br/images/materias/2264/3798585923594400768.jpg");
		
		
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
				"https://www.fatosdesconhecidos.com.br/wp-content/uploads/2018/02/thomas-edison-1.jpg",
				"Wow que legal!",
				usuario);
		Foto foto2 = new Foto(
				"https://www.investors.com/wp-content/uploads/2016/03/LSpic_Franklin_031816_pd.jpg",
				"Isso é bom demais!",
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

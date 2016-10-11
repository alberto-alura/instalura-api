package br.com.alura.instalura.controllers;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.instalura.daos.ComentarioDao;
import br.com.alura.instalura.daos.FotoDao;
import br.com.alura.instalura.daos.UsuarioDao;
import br.com.alura.instalura.dtos.inputs.ComentarioForm;
import br.com.alura.instalura.dtos.outputs.ComentariosResponse;
import br.com.alura.instalura.dtos.outputs.FotoResponse;
import br.com.alura.instalura.dtos.outputs.LikerResponse;
import br.com.alura.instalura.models.Comentario;
import br.com.alura.instalura.models.Foto;
import br.com.alura.instalura.models.Usuario;

@RestController
@CrossOrigin
public class FotosController {

	@Autowired
	private FotoDao fotoDao;
	@Autowired
	private UsuarioDao usuarioDao;
	@Autowired
	private ComentarioDao comentarioDao;

	@GetMapping(value = "/api/fotos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FotoResponse> busca(@AuthenticationPrincipal Usuario logado) {
		List<Foto> fotos = fotoDao.buscaFotosDosAmigos(logado.getId());
		return FotoResponse.map(fotos);
	}

	@Transactional
	@PostMapping(value = "/api/fotos/{idFoto}/like", produces = MediaType.APPLICATION_JSON_VALUE)
	public Set<LikerResponse> like(@PathVariable("idFoto") Integer id,@AuthenticationPrincipal Usuario logado) {

		Foto foto = fotoDao.findOne(id);
		foto.adicionaLikeDo(logado);
		return LikerResponse.map(foto.getLikers());
	}

	@Transactional
	@PostMapping(value = "/api/fotos/{idFoto}/comment", 
		consumes = MediaType.APPLICATION_JSON_VALUE, 
		produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ComentariosResponse> comment(@RequestBody ComentarioForm comentarioForm, @PathVariable("idFoto") Integer idFoto,@AuthenticationPrincipal Usuario logado ) {
		
		Comentario comentario = comentarioForm.build(logado);
		comentarioDao.save(comentario);
		
		Foto foto = fotoDao.findOne(idFoto);
		foto.adicionaComentario(comentario);

		return ComentariosResponse.map(foto.getComentarios());
	}

	@GetMapping(value="/api/fotos/{login}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<FotoResponse> buscaPorLogin(@PathVariable("login") String login){
		return FotoResponse.map(fotoDao.buscaFotosPeloUsuario(login));
	}

}

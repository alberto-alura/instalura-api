package br.com.alura.instalura.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.instalura.daos.UsuarioDao;
import br.com.alura.instalura.dtos.inputs.NovoUsuarioForm;
import br.com.alura.instalura.validators.NovoUsuarioValidator;
import br.com.alura.instalura.validators.UsuarioESenhaDiferentesValidator;

@RestController
public class UsuariosController {
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@InitBinder("novoUsuarioForm")
	public void init(WebDataBinder binder) {
		binder.addValidators(new UsuarioESenhaDiferentesValidator(),new NovoUsuarioValidator(usuarioDao));
	}

	
	@PostMapping("/usuarios")
	@Transactional
	public HttpEntity<?> novo(@Valid @RequestBody NovoUsuarioForm form) {
		
		usuarioDao.save(form.build());		
		return ResponseEntity.ok().build();
	}
	
}

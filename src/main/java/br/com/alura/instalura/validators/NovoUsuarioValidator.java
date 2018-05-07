package br.com.alura.instalura.validators;

import java.util.Optional;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.alura.instalura.daos.UsuarioDao;
import br.com.alura.instalura.dtos.inputs.NovoUsuarioForm;
import br.com.alura.instalura.models.Usuario;

public class NovoUsuarioValidator implements Validator {

	private UsuarioDao usuarioDao;

	public NovoUsuarioValidator(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return NovoUsuarioForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		NovoUsuarioForm form = (NovoUsuarioForm) target;
		
		Optional<Usuario> usuario = usuarioDao.findByLogin(form.getLogin());
		if(usuario.isPresent()) {
			errors.rejectValue("login", "","Login já existe");
		}
		
	}

}

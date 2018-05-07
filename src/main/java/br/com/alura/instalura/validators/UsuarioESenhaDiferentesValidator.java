package br.com.alura.instalura.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.alura.instalura.dtos.inputs.NovoUsuarioForm;

public class UsuarioESenhaDiferentesValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return NovoUsuarioForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		NovoUsuarioForm form = (NovoUsuarioForm) target;
		if(!form.loginESenhaDiferentes()) {
			errors.rejectValue("login", "", "Login precisa ser diferente da senha");
		}
	}

}

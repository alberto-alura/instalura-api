package br.com.alura.instalura.dtos.inputs;

import br.com.alura.instalura.models.Comentario;
import br.com.alura.instalura.models.Usuario;

public class ComentarioForm {

	private String texto;

	public String getTexto() {
		return texto;
	}

	public Comentario build(Usuario alberto) {
		return new Comentario(alberto, texto);
	}
}

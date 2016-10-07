package br.com.alura.instalura.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.instalura.models.Comentario;

@Repository
public interface ComentarioDao extends CrudRepository<Comentario, Integer> {

}

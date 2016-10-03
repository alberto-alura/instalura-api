package br.com.alura.instalura.daos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.instalura.models.Foto;

@Repository
public interface FotoDao extends CrudRepository<Foto, Integer>{

	List<Foto> findByUsuarioId(Integer idUsuario);

}

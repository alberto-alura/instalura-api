package br.com.alura.instalura.daos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.alura.instalura.models.Foto;

@Repository
public interface FotoDao extends CrudRepository<Foto, Integer>{

	@Query("select f from Foto f where f.removedInstant is null and f.usuario.id in (select amigo.id from Usuario u join u.amigos amigo where u.id = :idUsuario)")
	List<Foto> buscaFotosDosAmigos(@Param("idUsuario") Integer idUsuario);

	@Query("select f from Foto f where f.removedInstant is null and f.usuario.login = :q")
	List<Foto> buscaFotosPeloUsuario(@Param("q")String q);

}

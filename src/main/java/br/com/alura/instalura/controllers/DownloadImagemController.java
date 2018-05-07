package br.com.alura.instalura.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.instalura.daos.FotoDao;
import br.com.alura.instalura.models.Foto;

@RestController
public class DownloadImagemController {

	@Autowired
	private FotoDao fotoDao;

	@GetMapping(value = "/api/public/{fotoId}/stream")
	public ResponseEntity<ByteArrayResource> download(@PathVariable("fotoId") Integer fotoId) {
		Foto foto = fotoDao.findOne(fotoId);

		return ResponseEntity.ok().header("content-disposition", "inline").contentType(MediaType.IMAGE_PNG)
				.body(new ByteArrayResource(foto.getBytes()));
	}
}

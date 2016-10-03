package br.com.alura.instalura.mappers;

import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.instalura.dtos.outputs.FotoResponse;
import br.com.alura.instalura.models.Foto;

public class FotosMapper {

	public static List<FotoResponse> map(List<Foto> fotos) {
		return fotos.stream().map(FotoResponse :: new).collect(Collectors.toList());
	}

	
}

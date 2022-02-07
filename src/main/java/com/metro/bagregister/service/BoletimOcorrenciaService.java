/**
 * 
 */
package com.metro.bagregister.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metro.bagregister.dto.BoletimOcorrenciaDTO;
import com.metro.bagregister.model.BoletimOcorrencia;
import com.metro.bagregister.repository.BoletimOcorrenciaRepository;

/**
 * @author Anderson dos Reis Santos
 *
 */
@Service
public class BoletimOcorrenciaService {
	
	@Autowired
	private BoletimOcorrenciaRepository repository;
	
	public List<BoletimOcorrenciaDTO> findAll(){
		return repository.findAll().stream().map(BoletimOcorrenciaDTO::convert).collect(Collectors.toList());
	}
	
	public BoletimOcorrenciaDTO findById(long id) {
		Optional<BoletimOcorrencia> obj = repository.findById(id);
		if(obj.isPresent())
			return BoletimOcorrenciaDTO.convert(obj.get());
		return null;
	}
	
	public BoletimOcorrenciaDTO save(BoletimOcorrenciaDTO dto) {
		return BoletimOcorrenciaDTO.convert(repository.save(BoletimOcorrencia.convert(dto)));
	}
	
	public BoletimOcorrenciaDTO delete(BoletimOcorrencia dto) {
		repository.delete(dto);
		return BoletimOcorrenciaDTO.convert(dto);
	}

}

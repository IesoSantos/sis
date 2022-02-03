/**
 * 
 */
package com.metro.bagregister.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metro.bagregister.dto.ParteOcorrenciaDTO;
import com.metro.bagregister.model.ParteOcorrencia;
import com.metro.bagregister.repository.ParteOcorrenciaRepository;

/**
 * @author Anderson dos Reis Santos
 *
 */
@Service
public class ParteOcorrenciaService {
	
	@Autowired
	private ParteOcorrenciaRepository repository;
	
	public List<ParteOcorrenciaDTO> findAll(){
		List<ParteOcorrencia> lista = repository.findAll();
		return lista
				.stream()
				.map(ParteOcorrenciaDTO::convert)
				.collect(Collectors.toList());
	}
	
	public ParteOcorrencia findById(Long id){
		Optional<ParteOcorrencia>  obj = repository.findById(id);
		if(obj.isPresent())
			return obj.get();
		return null;
	}
	
	public ParteOcorrenciaDTO save(ParteOcorrencia obj) {
		return ParteOcorrenciaDTO.convert(repository.save(obj));
	}
	
	public ParteOcorrencia update(ParteOcorrencia obj) {
		return repository.save(obj);
	}
	
	public ParteOcorrenciaDTO delete(ParteOcorrencia obj) {
		repository.delete(obj);
		return ParteOcorrenciaDTO.convert(obj);
	}

}

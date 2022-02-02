/**
 * 
 */
package com.metro.bagregister.service;

import java.util.List;

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
	
	public List<BoletimOcorrencia> findAll(){
		return repository.findAll();
	}
	
	public BoletimOcorrenciaDTO save(BoletimOcorrencia obj) {
		return BoletimOcorrenciaDTO.convert(repository.save(obj));
	}
	
	public BoletimOcorrenciaDTO delete(BoletimOcorrencia obj) {
		repository.delete(obj);
		return BoletimOcorrenciaDTO.convert(obj);
	}

}

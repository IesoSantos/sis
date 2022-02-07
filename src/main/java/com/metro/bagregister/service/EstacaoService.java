/**
 * 
 */
package com.metro.bagregister.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metro.bagregister.dto.EstacaoDTO;
import com.metro.bagregister.model.Estacao;
import com.metro.bagregister.repository.EstacaoRepository;

/**
 * @author Anderson dos Reis Santos
 *
 */
@Service
public class EstacaoService {

	@Autowired
	private EstacaoRepository repository;
	
	public List<EstacaoDTO> findAll(){
		return repository.findAll()
				.stream()
				.map(EstacaoDTO::convert)
				.collect(Collectors.toList());
	}
	
	public EstacaoDTO findById(long id) {
		Optional<Estacao> obj = repository.findById(id);
		if(obj.isPresent()) {
			return EstacaoDTO.convert(obj.get());
		}
		return null;
	}
	
	public EstacaoDTO add(EstacaoDTO dto) {
		return EstacaoDTO.convert(repository.save(Estacao.convert(dto)));
	}
	
	public EstacaoDTO delete(EstacaoDTO dto) {
		repository.delete(Estacao.convert(dto));
		return dto;
	}
}
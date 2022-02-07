/**
 * 
 */
package com.metro.bagregister.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metro.bagregister.dto.EnderecoDTO;
import com.metro.bagregister.model.Endereco;
import com.metro.bagregister.repository.EnderecoRepository;

/**
 * @author Anderson dos Reis Santos
 *
 */
@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository repository;
	
	public List<EnderecoDTO> findAll(){
		return repository.findAll()
				.stream()
				.map(EnderecoDTO::convert)
				.collect(Collectors.toList());
	}
	
	public EnderecoDTO findById(long id) {
		Optional<Endereco> obj = repository.findById(id);
		if(obj.isPresent())
			return EnderecoDTO.convert(obj.get());
		return null;
	}
	
	public EnderecoDTO save(EnderecoDTO dto) {
		return EnderecoDTO.convert(repository.save(Endereco.convert(dto)));
	}
	
	public EnderecoDTO delete(EnderecoDTO dto) {
		repository.delete(Endereco.convert(dto));
		return dto;
	}

}

/**
 * 
 */
package com.metro.bagregister.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metro.bagregister.dto.TelefoneDTO;
import com.metro.bagregister.model.Telefone;
import com.metro.bagregister.repository.TelefoneRepository;

/**
 * @author Anderson dos Reis Santos
 *
 */
@Service
public class TelefoneService {
	
	@Autowired
	private TelefoneRepository repository;
	
	public List<TelefoneDTO> findAll(){
		return repository.findAll()
				.stream()
				.map(TelefoneDTO::convert)
				.collect(Collectors.toList()
						);
	}
	
	public TelefoneDTO findById(long id) {
		Optional<Telefone> obj = repository.findById(id);
		if(obj.isPresent())
			return TelefoneDTO.convert(obj.get());
		return null;
	}
	
	public TelefoneDTO add(Telefone obj) {
		return TelefoneDTO.convert(repository.save(obj));
	}
	
	public TelefoneDTO delete(Telefone obj) {
		repository.delete(obj);
		return TelefoneDTO.convert(obj);
	}

}

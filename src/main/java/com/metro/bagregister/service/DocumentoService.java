/**
 * 
 */
package com.metro.bagregister.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metro.bagregister.dto.DocumentoDTO;
import com.metro.bagregister.model.Documento;
import com.metro.bagregister.repository.DocumentoRepository;

/**
 * @author Anderson dos Reis Santos
 *
 */
@Service
public class DocumentoService {
	
	@Autowired
	private DocumentoRepository repository;
	
	public List<DocumentoDTO> findAll(){
		return repository.findAll()
				.stream()
				.map(DocumentoDTO::convert)
				.collect(Collectors.toList());
	}
	
	public Documento findById(long id) {
		Optional<Documento> obj = repository.findById(id);
		if(obj.isPresent())
			return obj.get();
		return null;
	}
	
	public DocumentoDTO save(DocumentoDTO obj){
		return DocumentoDTO.convert(repository.save(Documento.convert(obj)));
	}
	
	public DocumentoDTO delete (Documento obj) {
		repository.delete(obj);
		return DocumentoDTO.convert(obj);
	}

}

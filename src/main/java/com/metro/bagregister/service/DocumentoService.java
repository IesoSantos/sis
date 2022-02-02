/**
 * 
 */
package com.metro.bagregister.service;

import java.util.List;
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
	
	public DocumentoDTO save(DocumentoDTO obj){
		return DocumentoDTO.convert(repository.save(Documento.convert(obj)));
	}
	
	public DocumentoDTO delete (Long id) {
		Documento model = repository.findById(id).get();
		repository.delete(model);
		return DocumentoDTO.convert(model);
	}

}

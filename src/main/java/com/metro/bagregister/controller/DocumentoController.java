/**
 * 
 */
package com.metro.bagregister.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.metro.bagregister.dto.DocumentoDTO;
import com.metro.bagregister.model.Documento;
import com.metro.bagregister.service.DocumentoService;

/**
 * @author Anderson dos Reis Santos
 *
 */
@RestController
@RequestMapping("/documento")
public class DocumentoController {
	
	@Autowired
	private DocumentoService service;
	
	@GetMapping
	public List<DocumentoDTO> findAll(){
		return service.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DocumentoDTO add(@RequestBody @Valid DocumentoDTO dto){
		return service.save(dto);
	}
	
	@PutMapping
	public ResponseEntity<DocumentoDTO> update(@RequestBody @Valid DocumentoDTO dto){
		Documento obj = service.findById(dto.getId());
		if(obj!=null) {
			return ResponseEntity.status(HttpStatus.OK).body(
					service.save(dto));
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(Long id){
		Documento obj = service.findById(id);
		if(obj!=null) {
			service.delete(obj);
			return ResponseEntity.status(HttpStatus.OK).build();
			}
		return ResponseEntity.noContent().build();
	}
}

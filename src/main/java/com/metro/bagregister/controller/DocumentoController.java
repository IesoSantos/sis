/**
 * 
 */
package com.metro.bagregister.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.metro.bagregister.dto.DocumentoDTO;
import com.metro.bagregister.service.DocumentoService;

/**
 * @author Anderson dos Reis Santos
 *
 */
@RestController
public class DocumentoController {
	
	@Autowired
	private DocumentoService service;
	
	@GetMapping("/documento/")
	public List<DocumentoDTO> findAll(){
		return service.findAll();
	}
	
	@PostMapping("/documento")
	public ResponseEntity<DocumentoDTO> save(@RequestBody @Valid DocumentoDTO dto){
		return ResponseEntity.ok().body(service.save(dto));
	}
	
	@DeleteMapping("/documento/{id}")
	public ResponseEntity<DocumentoDTO> delete(Long id){
		return ResponseEntity.ok().body(service.delete(id));
	}
}

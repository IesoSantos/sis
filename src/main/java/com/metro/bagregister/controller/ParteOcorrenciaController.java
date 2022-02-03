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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.metro.bagregister.dto.ParteOcorrenciaDTO;
import com.metro.bagregister.model.ParteOcorrencia;
import com.metro.bagregister.service.ParteOcorrenciaService;

/**
 * @author Anderson dos Reis Santos
 *
 */
@RestController
@RequestMapping("/parte-ocorrencia")
public class ParteOcorrenciaController {
	
	@Autowired
	private ParteOcorrenciaService service;
	
	@GetMapping
	public List<ParteOcorrenciaDTO> lista(){
		return service.findAll();
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public ParteOcorrenciaDTO add(@RequestBody @Valid ParteOcorrenciaDTO dto) {
		
		return service.save(ParteOcorrencia.convert(dto));
	}
	
	@PutMapping
	public ResponseEntity<ParteOcorrenciaDTO> update(@RequestBody @Valid ParteOcorrenciaDTO dto){
		
		if(service.findById(dto.getId())!=null) {
			return ResponseEntity.
				status(HttpStatus.OK).
				body(
								service.save(ParteOcorrencia.convert(dto)
										
								)						
						);
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete( @PathVariable Long id) {
		ParteOcorrencia obj = service.findById(id);
		if(obj==null) {
			return ResponseEntity.noContent().build();
		}
		service.delete(obj);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}

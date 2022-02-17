/**
 * 
 */
package com.metro.bagregister.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metro.bagregister.dto.ParteOcorrenciaDTO;
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
	
	@PostMapping
	//@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Response<ParteOcorrenciaDTO>> add(@RequestBody @Valid ParteOcorrenciaDTO dto,
			BindingResult result) {
		Response<ParteOcorrenciaDTO> response = new Response<ParteOcorrenciaDTO>();
		if(result.hasErrors()) {
			result.getAllErrors().forEach(error->response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(service.save(dto));
		return ResponseEntity.ok(response);
	}
	
	@PutMapping
	public ResponseEntity<ParteOcorrenciaDTO> update(@RequestBody @Valid ParteOcorrenciaDTO dto){
		
		if(service.findById(dto.getId())!=null) {
			return ResponseEntity.
				status(HttpStatus.OK).
				body(
								service.save(dto)						
						);
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete( @PathVariable Long id) {
		ParteOcorrenciaDTO obj = service.findById(id);
		if(obj==null) {
			return ResponseEntity.noContent().build();
		}
		service.delete(obj);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
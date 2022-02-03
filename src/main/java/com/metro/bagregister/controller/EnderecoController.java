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

import com.metro.bagregister.dto.EnderecoDTO;
import com.metro.bagregister.model.Endereco;
import com.metro.bagregister.service.EnderecoService;

/**
 * @author Anderson dos Reis Santos
 *
 */
@RestController
@RequestMapping("/endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoService service;
	
	@GetMapping
	public List<EnderecoDTO> findAll(){
		return service.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EnderecoDTO add(@RequestBody @Valid EnderecoDTO obj) {
		return service.save(Endereco.convert(obj));
	}
	
	@PutMapping
	public ResponseEntity<EnderecoDTO> update(@RequestBody @Valid EnderecoDTO obj){
		if(service.findById(obj.getId())!= null) {
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(
							service.save(Endereco.convert(obj))
							);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id){
		Endereco obj = Endereco.convert(service.findById(id));
		if(obj!=null) {
			service.delete(obj);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

}

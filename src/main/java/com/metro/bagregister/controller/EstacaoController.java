/**
 * 
 */
package com.metro.bagregister.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metro.bagregister.dto.EstacaoDTO;
import com.metro.bagregister.service.EstacaoService;

/**
 * @author Anderson dos Reis Santos
 *
 */
@RestController
@RequestMapping("/estacao")
public class EstacaoController {
	
	@Autowired
	private EstacaoService service;
	
	@GetMapping
	public List<EstacaoDTO> findAll(){
		return service.findAll();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id){
		EstacaoDTO obj = service.findById(id);
		if(obj!=null) {
			service.delete(obj);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		return ResponseEntity.noContent().build();
	}
}

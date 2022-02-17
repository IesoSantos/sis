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

import com.metro.bagregister.dto.BoletimOcorrenciaDTO;
import com.metro.bagregister.model.BoletimOcorrencia;
import com.metro.bagregister.service.BoletimOcorrenciaService;

/**
 * @author Anderson dos Reis Santos
 *
 */
@RestController
@RequestMapping("/boletim-ocorrencia")
public class BoletimOcorrenciaController {

	@Autowired
	private BoletimOcorrenciaService service;
	
	@GetMapping
	public List<BoletimOcorrenciaDTO> getAll(){
		return service.findAll();
	}
	
	@PostMapping
	//@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Response<BoletimOcorrenciaDTO>> add(@RequestBody @Valid BoletimOcorrenciaDTO dto,
			BindingResult result) {
		Response<BoletimOcorrenciaDTO> response = new Response<>();
		if(result.hasErrors()) {
			result.getAllErrors().forEach(error->response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(service.save(dto));
		return ResponseEntity.ok().body(response);
	}
	
	@PutMapping
	public ResponseEntity<BoletimOcorrenciaDTO> update(@RequestBody @Valid BoletimOcorrenciaDTO dto){
		BoletimOcorrencia obj = BoletimOcorrencia.convert(service.findById(dto.getId()));
		if (obj!=null)
			return ResponseEntity.ok().body(service.save(dto));
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		BoletimOcorrencia obj = BoletimOcorrencia.convert(service.findById(id));
		if(obj!=null) {
			service.delete(obj);
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}

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
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.metro.bagregister.dto.ParteOcorrenciaDTO;
import com.metro.bagregister.model.ParteOcorrencia;
import com.metro.bagregister.service.ParteOcorrenciaService;

/**
 * @author Anderson dos Reis Santos
 *
 */
@RestController
public class ParteOcorrenciaController {
	
	@Autowired
	private ParteOcorrenciaService service;
	
	@GetMapping(path = "/parte-ocorrencia/" )
	public @ResponseBody List<ParteOcorrenciaDTO> lista(){
		return service.getAll();
	}
	
	@PostMapping("/parte-ocorrencia")
	public ResponseEntity<ParteOcorrenciaDTO> cadastro(@RequestBody @Valid ParteOcorrenciaDTO dto) {
		
		return ResponseEntity.
				status(HttpStatus.CREATED).
				body(
						ParteOcorrenciaDTO.convert(
								service.save(ParteOcorrencia.convert(dto)
										)
								)						
						);
	}
	
	@DeleteMapping("/parte-ocorrencia/{id}")
	public ResponseEntity<ParteOcorrenciaDTO> deletar(@RequestBody ParteOcorrenciaDTO parte) {
		service.delete(ParteOcorrencia.convert(parte));
		return ResponseEntity.status(HttpStatus.OK)
				.body(parte);
	}
	
	@PatchMapping("/parte-ocorrencia/{id}")
	public ResponseEntity<ParteOcorrenciaDTO> atualizacao(@RequestBody @Valid ParteOcorrenciaDTO dto){
		return ResponseEntity.
				status(HttpStatus.OK).
				body(
						ParteOcorrenciaDTO.convert(
								service.save(ParteOcorrencia.convert(dto)
										)
								)						
						);
	}

}
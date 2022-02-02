/**
 * 
 */
package com.metro.bagregister.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.metro.bagregister.dto.BoletimOcorrenciaDTO;
import com.metro.bagregister.service.BoletimOcorrenciaService;

/**
 * @author Anderson dos Reis Santos
 *
 */
@RestController
public class BoletimOcorrenciaController {

	@Autowired
	private BoletimOcorrenciaService service;
	
	@GetMapping("/boletim-ocorrencia/")
	public List<BoletimOcorrenciaDTO> getAll(){
		return service.findAll();
	}
	
	@PostMapping("/boletim-ocorrencia")
	public BoletimOcorrenciaDTO save(@RequestBody @Valid BoletimOcorrenciaDTO dto) {
		return service.save(dto);
	}
}

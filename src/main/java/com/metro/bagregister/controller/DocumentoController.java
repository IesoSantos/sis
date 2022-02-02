/**
 * 
 */
package com.metro.bagregister.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.metro.bagregister.service.DocumentoService;

/**
 * @author Anderson dos Reis Santos
 *
 */
@RestController
public class DocumentoController {
	
	@Autowired
	private DocumentoService service;
}

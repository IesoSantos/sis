/**
 * 
 */
package com.metro.bagregister.model;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Anderson dos Reis Santos
 *
 */
@Embeddable
@Getter
@AllArgsConstructor
public enum TipoTelefone {
	RESIDENCIAL("Residencial"), COMERCIAL("Comercial"), CELULAR("Celular");
	
	private final String descricao;
	
}

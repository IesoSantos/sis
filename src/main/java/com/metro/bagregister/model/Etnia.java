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
public enum Etnia {
	ASIATICO("Asiático"), BRANCO("Branco"), PARDO("Pardo"), NEGRO("Negro"), ANDINO("Andino");
	
	private final String descricao;
	
}

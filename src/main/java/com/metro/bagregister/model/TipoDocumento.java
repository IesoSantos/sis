/**
 * 
 */
package com.metro.bagregister.model;

import javax.persistence.Embeddable;

/**
 * @author Anderson dos Reis Santos
 *
 */
@Embeddable
public enum TipoDocumento {
	RG,CPF,CNH,PASSAPORTE,RNE,OAB;
}

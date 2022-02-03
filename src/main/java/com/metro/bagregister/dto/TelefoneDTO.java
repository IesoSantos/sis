/**
 * 
 */
package com.metro.bagregister.dto;

import javax.validation.constraints.NotBlank;

import com.metro.bagregister.model.Telefone;
import com.metro.bagregister.model.TipoTelefone;

import lombok.Data;

/**
 * @author Anderson dos Reis Santos
 *
 */
@Data
public class TelefoneDTO {
	
	private long id;
	@NotBlank
	private  String ddd;
	@NotBlank
	private String numero;
	@NotBlank
	private TipoTelefone tipoTelefone;
	
	public static TelefoneDTO convert(Telefone obj) {
		TelefoneDTO dto = new TelefoneDTO();
		dto.setDdd(obj.getDdd());
		dto.setId(obj.getId());
		dto.setNumero(obj.getNumero());
		dto.setTipoTelefone(obj.getTipoTelefone());
		return dto;
	}

}

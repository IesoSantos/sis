/**
 * 
 */
package com.metro.bagregister.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

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
	@NotBlank(message = "Campo DDD deve ser preenchido.")
	@Length(min = 2, max = 2, message = "DDD deve ser 2 números.")
	private  String ddd;
	@NotBlank(message = "Campo número de telefone deve ser preenchido.")
	@Length(min = 9, max = 10, message = "Campo número de telefone deve ser preenchido corretamente.")
	private String numero;
	@NotBlank(message = "Campo tipo de telefone deve ser preenchido.")
	@Length(max = 50, message = "Campo tipo de telefone tem o tamanho máximo de 20 caracteres.")
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

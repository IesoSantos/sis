/**
 * 
 */
package com.metro.bagregister.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.metro.bagregister.model.Documento;
import com.metro.bagregister.model.TipoDocumento;

import lombok.Data;

/**
 * @author Anderson dos Reis Santos
 *
 */
@Data
public class DocumentoDTO {
	
	private long id;
	@NotBlank(message = "Campo tipo de documento deve ser preenchido.")
	@Length(min = 3, max = 50, message = "Campo tipo de documento tem o tamanho máximo de 50 caracteres.")
	private TipoDocumento tipoDocumento;
	@NotBlank(message = "Campo número identificador deve ser preenchido.")
	@Length(min = 3, max = 15, message = "Campo número identificador tem o tamanho máximo de 15 caracteres.")
	private String numeroIdentificador;
	
	public static DocumentoDTO convert(Documento obj) {
		DocumentoDTO dto = new DocumentoDTO();
		dto.setId(obj.getId());
		dto.setTipoDocumento(obj.getTipoDocumento());
		dto.setNumeroIdentificador(obj.getNumeroIdentificador());
		return dto;
	}

}

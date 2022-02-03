/**
 * 
 */
package com.metro.bagregister.dto;

import javax.validation.constraints.NotBlank;

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
	@NotBlank
	private TipoDocumento tipoDocumento;
	@NotBlank
	private String numeroIdentificador;
	
	public static DocumentoDTO convert(Documento obj) {
		DocumentoDTO dto = new DocumentoDTO();
		dto.setId(obj.getId());
		dto.setTipoDocumento(obj.getTipoDocumento());
		dto.setNumeroIdentificador(obj.getNumeroIdentificador());
		return dto;
	}

}

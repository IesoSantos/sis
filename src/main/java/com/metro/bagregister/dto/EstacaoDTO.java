/**
 * 
 */
package com.metro.bagregister.dto;

import javax.validation.constraints.NotBlank;

import com.metro.bagregister.model.Estacao;

import lombok.Data;

/**
 * @author Anderson dos Reis Santos
 *
 */
@Data
public class EstacaoDTO {
	
	private long id;
	@NotBlank
	private String linha;
	@NotBlank
	private String estacao;
	
	public static EstacaoDTO convert(Estacao obj) {
		EstacaoDTO dto = new EstacaoDTO();
		dto.setEstacao(obj.getEstacao());
		dto.setId(obj.getId());
		dto.setLinha(obj.getLinha());
		return dto;
	}

}

/**
 * 
 */
package com.metro.bagregister.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.metro.bagregister.model.Estacao;

import lombok.Data;

/**
 * @author Anderson dos Reis Santos
 *
 */
@Data
public class EstacaoDTO {
	
	private long id;
	@NotBlank(message = "Campo linha deve ser preenchido.")
	@Length(min = 6, max = 7, message = "Campo linha deve ter entre 6 e 7 caracteres.")
	private String linha;
	@NotBlank(message = "Campo estação deve ser preenchido.")
	@Length(min = 2, max = 50, message = "Campo estação deve ter entre 2 e 50 caracteres.")
	private String estacao;
	
	public static EstacaoDTO convert(Estacao obj) {
		EstacaoDTO dto = new EstacaoDTO();
		dto.setEstacao(obj.getEstacao());
		dto.setId(obj.getId());
		dto.setLinha(obj.getLinha());
		return dto;
	}

}

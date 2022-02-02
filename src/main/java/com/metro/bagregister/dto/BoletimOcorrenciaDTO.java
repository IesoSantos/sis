/**
 * 
 */
package com.metro.bagregister.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.metro.bagregister.model.BoletimOcorrencia;
import com.metro.bagregister.model.Estacao;
import com.metro.bagregister.model.ParteOcorrencia;

import lombok.Data;

/**
 * @author Anderson dos Reis Santos
 *
 */
@Data
public class BoletimOcorrenciaDTO {

	@NotNull
	private List<ParteOcorrencia> partesDaOcorrencia;
	@NotBlank
	private String historico;
	@NotBlank
	private LocalDate dataOcorrencia;
	@NotBlank
	private Estacao estacao;
	@NotBlank
	private String naturezaBO;
	
	public static BoletimOcorrenciaDTO convert(BoletimOcorrencia obj) {
		BoletimOcorrenciaDTO dto = new BoletimOcorrenciaDTO();
		dto.setDataOcorrencia(obj.getDataOcorrencia());
		dto.setEstacao(obj.getEstacao());
		dto.setHistorico(obj.getHistorico());
		dto.setNaturezaBO(obj.getNaturezaBO());
		dto.setPartesDaOcorrencia(obj.getPartesDaOcorrencia());
		return dto;
	}
}

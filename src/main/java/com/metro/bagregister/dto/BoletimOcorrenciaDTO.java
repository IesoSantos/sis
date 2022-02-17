/**
 * 
 */
package com.metro.bagregister.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

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
	
	private long id;
	@NotNull
	private List<ParteOcorrencia> partesDaOcorrencia;
	@NotBlank(message = "Campo histórico deve ser preenchido.")
	private String historico;
	@NotBlank(message = "Campo data da ocorrência deve ser preenchido.")
	@Length(min = 10, max = 10, message = "Campo data da ocorrência deve ter o fomato ##/##/####.")
	private LocalDate dataOcorrencia;
	@NotBlank
	private Estacao estacao;
	@NotBlank(message = "Campo natureza do B.O deve ser preenchido.")
	private String naturezaBO;
	
	public static BoletimOcorrenciaDTO convert(BoletimOcorrencia obj) {
		BoletimOcorrenciaDTO dto = new BoletimOcorrenciaDTO();
		dto.setId(obj.getId());
		dto.setDataOcorrencia(obj.getDataOcorrencia());
		dto.setEstacao(obj.getEstacao());
		dto.setHistorico(obj.getHistorico());
		dto.setNaturezaBO(obj.getNaturezaBO());
		dto.setPartesDaOcorrencia(obj.getPartesDaOcorrencia());
		return dto;
	}
}

/**
 * 
 */
package com.metro.bagregister.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.metro.bagregister.dto.BoletimOcorrenciaDTO;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Anderson dos Reis Santos
 *
 */
@Entity
@Table(name = "boletins_ocorrencias")
@Getter
@Setter
public class BoletimOcorrencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private  long id;
	@NotNull
	@ManyToMany
	@JoinColumn(name = "parte_ocorrencia_id")
	private List<ParteOcorrencia> partesDaOcorrencia;
	@NotBlank
	private String historico;
	@NotBlank
	@Column(name = "data_ocorrencia")
	private LocalDate dataOcorrencia;
	@NotBlank
	@ManyToOne
	@JoinColumn(name = "estacao_id")
	private Estacao estacao;
	@NotBlank
	@Column(name = "natureza_ocorrencia")
	private String naturezaBO;
	
	public static BoletimOcorrencia convert(BoletimOcorrenciaDTO dto) {
		BoletimOcorrencia model = new BoletimOcorrencia();
		model.setDataOcorrencia(dto.getDataOcorrencia());
		model.setEstacao(dto.getEstacao());
		model.setHistorico(dto.getHistorico());
		model.setNaturezaBO(dto.getNaturezaBO());
		model.setPartesDaOcorrencia(dto.getPartesDaOcorrencia());
		return model;
	}
}

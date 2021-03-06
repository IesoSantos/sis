/**
 * 
 */
package com.metro.bagregister.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.metro.bagregister.dto.EstacaoDTO;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Anderson dos Reis Santos
 *
 */
@Entity
@Table(name = "estacoes")
@Getter 
@Setter
public class Estacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private long id;
	@NotBlank
	private String linha;
	@NotBlank
	private String estacao;
	
	public static Estacao convert(EstacaoDTO dto) {
		Estacao model = new Estacao();
		model.setEstacao(dto.getEstacao());
		model.setId(dto.getId());
		model.setLinha(dto.getLinha());
		return model;
	}
}

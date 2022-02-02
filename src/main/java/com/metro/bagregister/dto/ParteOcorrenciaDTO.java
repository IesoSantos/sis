/**
 * 
 */
package com.metro.bagregister.dto;

import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.metro.bagregister.model.Endereco;
import com.metro.bagregister.model.Etnia;
import com.metro.bagregister.model.ParteOcorrencia;
import com.metro.bagregister.model.Sexo;
import com.metro.bagregister.model.Telefone;

import lombok.Data;

/**
 * @author Anderson dos Reis Santos
 *
 */
@Data
public class ParteOcorrenciaDTO {
	
	private String nome;
	private String nomeMae;
	private String nomePai;
	@NotBlank
	private float altura;
	@NotBlank
	private LocalDate dataNascimento;
	@NotBlank
	private Sexo sexo;
	@NotNull
	private Endereco endereco;
	@NotNull
	private Etnia etnia;
	@NotBlank
	private String qualificacao;
	private List<Telefone> telefone;
	
	public static ParteOcorrenciaDTO convert(ParteOcorrencia obj) {
		ParteOcorrenciaDTO dto = new ParteOcorrenciaDTO();
		dto.setNome(obj.getNome());
		dto.setNomeMae(obj.getNomeMae());
		dto.setNomePai(obj.getNomePai());
		dto.setDataNascimento(obj.getDataNascimento());
		dto.setAltura(obj.getAltura());
		dto.setEndereco(obj.getEndereco());
		dto.setEtnia(obj.getEtnia());
		dto.setSexo(obj.getSexo());
		dto.setTelefone(obj.getTelefone());
		dto.setQualificacao(obj.getQualificacao());
		return dto;
	}
	
}

/**
 * 
 */
package com.metro.bagregister.dto;

import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

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
	
	private long id;
	private String nome;
	private String nomeMae;
	private String nomePai;
	@NotBlank(message = "Campo altura deve ser preenchido.")
	@Length(min = 4, max = 4, message = "Campo altura deve ter o formato #.##.")
	private float altura;
	@NotBlank(message = "Campo data de nascimento deve ser preenchido.")
	@Length(min = 10, max = 10, message = "Campo data de nascimento deve ter o fomato ##/##/####.")
	private LocalDate dataNascimento;
	@NotBlank(message = "Campo sexo deve ser preenchido.")
	@Length(max = 1, message = "Campo sexo deve ser preenchido como M ou F.")
	private Sexo sexo;
	@NotNull(message = "Campo endereço deve ser preenchido.")
	@Length(max = 200,message = "Campo endereço tem o tamanho máximo de 200 caracteres.")
	private Endereco endereco;
	@NotNull(message = "Campo etnia deve ser preenchido.")
	@Length(max = 20, message = "Campo etnia tem o tamanho máximo de 20 caracteres.")
	private Etnia etnia;
	@NotBlank(message = "Campo qualificação deve ser preenchido.")
	@Length(min = 3, max = 20, message = "Campo qualificação tem o tamanho máximo de 20 caracteres.")
	private String qualificacao;
	private List<Telefone> telefone;
	
	public static ParteOcorrenciaDTO convert(ParteOcorrencia obj) {
		ParteOcorrenciaDTO dto = new ParteOcorrenciaDTO();
		dto.setId(obj.getId());
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

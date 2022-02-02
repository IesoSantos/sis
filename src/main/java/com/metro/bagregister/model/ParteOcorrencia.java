/**
 * 
 */
package com.metro.bagregister.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.metro.bagregister.dto.ParteOcorrenciaDTO;

import lombok.Data;

/**
 * @author Anderson dos Reis Santos
 *
 */
@Entity
@Table(name = "parte_ocorrencia")
@Data
public class ParteOcorrencia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String nomeMae;
	private String nomePai;
	private float altura;
	private LocalDate dataNascimento;
	private Sexo sexo;
	@ManyToOne
	private Endereco endereco;
	private Etnia etnia;
	
	private String qualificacao;
	@OneToMany
	@JoinColumn(name = "telefone_id")
	private List<Telefone> telefone;
	
	public static ParteOcorrencia convert(ParteOcorrenciaDTO obj) {
		ParteOcorrencia model = new ParteOcorrencia();
		model.setAltura(obj.getAltura());
		model.setDataNascimento(obj.getDataNascimento());
		model.setEndereco(obj.getEndereco());
		model.setEtnia(obj.getEtnia());
		model.setNome(obj.getNome());
		model.setNomeMae(obj.getNomeMae());
		model.setNomePai(obj.getNomePai());
		model.setSexo(obj.getSexo());
		model.setTelefone(obj.getTelefone());
		model.setQualificacao(obj.getQualificacao());
		return model;
	}

}
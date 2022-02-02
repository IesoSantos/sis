/**
 * 
 */
package com.metro.bagregister.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.metro.bagregister.dto.EnderecoDTO;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Anderson dos Reis Santos
 *
 */
@Entity
@Table(name = "enderecos")
@Getter 
@Setter
public class Endereco {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private  String logradouro;
	
	private String numero;
	
	private String complemento;
	
	private String bairro;
	
	private String cidade;
	
	private String estado;
	
	private String cep;
	
	public static Endereco convert(EnderecoDTO dto) {
		Endereco model = new Endereco();
		model.setBairro(dto.getBairro());
		model.setCep(dto.getCep());
		model.setCidade(dto.getCidade());
		model.setComplemento(dto.getComplemento());
		model.setEstado(dto.getEstado());
		model.setLogradouro(dto.getLogradouro());
		model.setNumero(dto.getNumero());
		return model;
	}
}

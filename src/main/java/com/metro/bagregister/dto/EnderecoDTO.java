/**
 * 
 */
package com.metro.bagregister.dto;

import com.metro.bagregister.model.Endereco;

import lombok.Data;

/**
 * @author Anderson dos Reis Santos
 *
 */
@Data
public class EnderecoDTO {
	
	private  String logradouro;
	private String numero;	
	private String complemento;	
	private String bairro;	
	private String cidade;	
	private String estado;	
	private String cep;

	public static EnderecoDTO convert(Endereco obj) {
		EnderecoDTO dto = new EnderecoDTO();
		dto.setBairro(obj.getBairro());
		dto.setCep(obj.getCep());
		dto.setCidade(obj.getCidade());
		dto.setComplemento(obj.getComplemento());
		dto.setEstado(obj.getEstado());
		dto.setLogradouro(obj.getLogradouro());
		dto.setNumero(obj.getNumero());
		return dto;
	}
}

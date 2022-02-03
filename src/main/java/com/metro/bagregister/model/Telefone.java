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

import com.metro.bagregister.dto.TelefoneDTO;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Anderson dos Reis Santos
 *
 */
@Entity
@Table(name = "telefones")
@Getter
@Setter
public class Telefone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank
	private  String ddd;
	@NotBlank
	private String numero;
	@NotBlank
	private TipoTelefone tipoTelefone;
	
	public static Telefone convert(TelefoneDTO dto) {
		Telefone model = new Telefone();
		model.setDdd(dto.getDdd());
		model.setId(dto.getId());
		model.setNumero(dto.getNumero());
		model.setTipoTelefone(dto.getTipoTelefone());
		return model;
	}
}

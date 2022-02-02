package com.metro.bagregister.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Anderson dos Reis Santos
 *
 */
@Entity
@Table(name = "documentos")
@Getter 
@Setter
public class Documento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "tipo_documento")
	private TipoDocumento tipoDocumento;
	@Column(name = "numero_identificador")
	private String numeroIdentificador;
}

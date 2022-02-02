/**
 * 
 */
package com.metro.bagregister.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metro.bagregister.model.Documento;

/**
 * @author Anderson dos Reis Santos
 *
 */
public interface DocumentoRepository extends JpaRepository<Documento, Long>{

}

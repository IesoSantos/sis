/**
 * 
 */
package com.metro.bagregister.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metro.bagregister.model.BoletimOcorrencia;

/**
 * @author Anderson dos Reis Santos
 *
 */
@Repository
public interface BoletimOcorrenciaRepository extends JpaRepository<BoletimOcorrencia, Long>{

}

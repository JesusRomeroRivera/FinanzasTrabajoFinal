package com.bnpt.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.bnpt.model.entities.Credito;

@Repository
public interface CreditoRepository 
 	extends JpaRepository<Credito, Integer>{

	@Query(value = "SELECT * FROM creditos c WHERE c.cliente_id = :id", nativeQuery = true)
	List<Credito> getCreditosCliente(@Param("id") String id);
	
	@Query(value = "SELECT * FROM creditos c WHERE c.cliente_id = :id AND CURRENT_TIMESTAMP <= c.fecha_vencimiento", nativeQuery = true)
    List<Credito> getCreditosActivosCliente(@Param("id") String id);
}
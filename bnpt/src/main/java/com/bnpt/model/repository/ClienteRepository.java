package com.bnpt.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.bnpt.model.entities.Cliente;

@Repository
public interface ClienteRepository 
 	extends JpaRepository<Cliente, String>{

	@Query(value = "SELECT * FROM clientes c WHERE c.correo = :correo", nativeQuery = true)
	Optional<Cliente> getClienteByCorreo(@Param("correo") String correo);
}
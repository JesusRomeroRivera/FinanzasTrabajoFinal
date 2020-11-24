package com.bnpt.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.bnpt.model.entities.Tienda;

@Repository
public interface TiendaRepository 
 	extends JpaRepository<Tienda, Integer>{

		@Query(value = "SELECT * FROM tiendas t WHERE t.correo = :correo", nativeQuery = true)
		Optional<Tienda> getTiendaByCorreo(@Param("correo") String correo);
}
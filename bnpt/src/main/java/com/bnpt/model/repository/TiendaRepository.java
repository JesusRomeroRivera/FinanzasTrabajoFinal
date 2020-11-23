package com.bnpt.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bnpt.model.entities.Tienda;

@Repository
public interface TiendaRepository 
 	extends JpaRepository<Tienda, Integer>{
}
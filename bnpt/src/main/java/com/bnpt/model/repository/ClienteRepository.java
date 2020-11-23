package com.bnpt.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bnpt.model.entities.Cliente;

@Repository
public interface ClienteRepository 
 	extends JpaRepository<Cliente, String>{
}
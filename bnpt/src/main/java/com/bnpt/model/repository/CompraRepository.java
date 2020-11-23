package com.bnpt.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bnpt.model.entities.Compra;

@Repository
public interface CompraRepository 
 	extends JpaRepository<Compra, Integer>{
}
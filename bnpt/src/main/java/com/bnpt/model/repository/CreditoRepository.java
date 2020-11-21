package com.bnpt.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bnpt.model.entities.Credito;

@Repository
public interface CreditoRepository 
 	extends JpaRepository<Credito, Integer>{
}
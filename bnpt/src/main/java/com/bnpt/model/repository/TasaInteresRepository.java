package com.bnpt.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bnpt.model.entities.TasaInteres;

@Repository
public interface TasaInteresRepository 
 	extends JpaRepository<TasaInteres, Integer>{
}
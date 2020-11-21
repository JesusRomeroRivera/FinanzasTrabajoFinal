package com.bnpt.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bnpt.model.entities.CategoriaProducto;

@Repository
public interface CategoriaProductoRepository 
 	extends JpaRepository<CategoriaProducto, Integer>{
}
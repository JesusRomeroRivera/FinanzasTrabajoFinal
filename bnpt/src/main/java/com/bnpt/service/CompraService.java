package com.bnpt.service;

import com.bnpt.model.entities.Compra;

public interface CompraService  extends CrudService<Compra, Integer>{
    public Compra rechazarCompra(Integer id);
}

package com.bnpt.service;

import java.util.List;
import java.util.Optional;

import com.bnpt.dto.ComprasClienteDTO;
import com.bnpt.model.entities.Tienda;

public interface TiendaService extends CrudService<Tienda, Integer>{
    public Optional<Tienda> login(Tienda t);
    public Optional<Tienda> getTiendaByCorreo(String correo);
    List<ComprasClienteDTO> comprasClienteTienda(Tienda t);
}

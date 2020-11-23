package com.bnpt.service;

import java.util.Optional;

import com.bnpt.model.entities.Cliente;

public interface ClienteService extends CrudService<Cliente, String> {
    public Optional<Cliente> login(Cliente t);
    public Optional<Cliente> getClienteByCorreo(String correo);
}

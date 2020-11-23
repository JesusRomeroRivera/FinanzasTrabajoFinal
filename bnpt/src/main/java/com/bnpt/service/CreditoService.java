package com.bnpt.service;

import java.util.Date;
import java.util.List;

import com.bnpt.model.entities.Credito;

public interface CreditoService extends CrudService<Credito, Integer>{
    public List<Credito> listarPorClienteId(String id);
    public List<Credito> listarActivosPorClienteId(String id);
    public List<Credito> creditosPorFechaVencimiento(Date fecha);
    public List<Credito> CreditosPorVencerHoy(Integer id_tienda);
}

package com.bnpt.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

=======
import org.springframework.stereotype.Repository;

>>>>>>> master
import com.bnpt.model.entities.Credito;

@Repository
public interface CreditoRepository 
 	extends JpaRepository<Credito, Integer>{
<<<<<<< HEAD

	@Query(value = "SELECT * FROM creditos c WHERE c.cliente_id = :id", nativeQuery = true)
	List<Credito> getCreditosCliente(@Param("id") String id);
	
	@Query(value = "SELECT * FROM creditos c WHERE c.cliente_id = :id AND CAST(CURRENT_TIMESTAMP AS Date) <= CAST(c.fecha_vencimiento AS Date)", nativeQuery = true)
	List<Credito> getCreditosActivosCliente(@Param("id") String id);
	
	//CREDITOS POR FECHA A VENCER

	@Query(value = "SELECT * FROM creditos c WHERE  CAST(c.fecha_vencimiento AS Date) = CAST(:fecha AS Date)", nativeQuery = true)
	List<Credito> getCreditosPorFechaCliente(@Param("fecha") Date fecha_vencimiento);
	
	//CREDITOS POR COBRAR DE HOY 

	@Query(value = "SELECT * FROM creditos c WHERE  CAST(c.fecha_vencimiento AS Fecha) = CONVERT(DATE, CURRENT_TIMESTAMP) AND c.tienda_id = :id_tienda", nativeQuery = true)
	List<Credito> getCreditosPorCobrarHoy(@Param("id_tienda") Integer id_tienda  );
=======
>>>>>>> master
}
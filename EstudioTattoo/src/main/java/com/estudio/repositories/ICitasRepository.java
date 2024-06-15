package com.estudio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.estudio.dtos.CitasDTO;
import com.estudio.entities.CitasEntity;

@Repository
public interface ICitasRepository extends CrudRepository<CitasEntity, Integer>{

	@Query(value = "SELECT new com.estudio.dtos.ClientesDTO "
			   + "(ce.idCitas, ce.fecha, cle.idClientes, te.idTatuadores, tae.idTatuajes, ce.activo)"
			   + " FROM CitasEntity ce "
			   + "		JOIN ce.cliente cle "
			   + "		JOIN ce.tatuador te  "
			   + "		JOIN ce.tatuajes tae "
			   + "					WHERE CAST (ce.idCitas AS string) LIKE CONCAT ('%', :id, '%') "
			   + " 					AND ce.fecha LIKE CONCAT ('%', :fecha, '%') "
			   + " 					AND CAST (cle.idClientes AS string) LIKE CONCAT ('%', :cliente, '%') "
			   + " 					AND CAST (te.idTatuadores AS string) LIKE CONCAT ('%', :tatuador, '%') "
			   + " 					AND CAST (tae.idTatuajes AS string) LIKE CONCAT ('%', :tatuajes, '%') "
			   + " 					AND ce.activo = :activo ")
	public List<CitasDTO> buscarCitas(
		@Param("id") Integer id,
		@Param("fecha") String fecha,
		@Param("cliente") Integer cliente,
		@Param("tatuador") Integer tatuador,
		@Param("tatuajes") Integer tatuajes,
		@Param("activo") Integer activo);
	
}

package com.estudio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.estudio.dtos.CitasDTO;
import com.estudio.entities.CitasEntity;

public interface ICitasRepository extends CrudRepository<CitasEntity, Integer>{

	@Query(value = "SELECT new com.estudio.dtos.ClientesDTO "
			   + "(ce.idCitas, ce.fecha, cle.idClientes, te.idTatuadores, tae.idTatuajes, ce.activo)"
			   + " FROM com.estudio.entities.CitasEntity ce,"
			   + "		com.estudio.entities.TatuadoresEntity te "
			   + "		com.estudio.entities.TatuajesEntity tae "
			   + "		com.estudio.entities.ClientesEntity cle "
			   + "					WHERE CAST (ce.idCitas AS string) LIKE CONCAT ('%', :id, '%') "
			   + " 					AND ce.fecha LIKE CONCAT ('%', :fecha, '%') "
			   + " 					AND CAST (ce.cliente AS string) LIKE CONCAT ('%', :cliente, '%') "
			   + " 					AND CAST (ce.tatuador AS string) LIKE CONCAT ('%', :tatuador, '%') "
			   + " 					AND CAST (ce.tatuajes AS string) LIKE CONCAT ('%', :tatuajes, '%') "
			   + " 					AND ce.activo = :activo ")
	public List<CitasDTO> buscarCitas(
		@Param("id") Integer id,
		@Param("fecha") String fecha,
		@Param("cliente") Integer cliente,
		@Param("tatuador") Integer tatuador,
		@Param("tatuajes") Integer tatuajes,
		@Param("activo") Integer activo);
	
}

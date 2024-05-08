package com.estudio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.estudio.dtos.TatuajesDTO;
import com.estudio.entities.TatuajesEntity;

public interface ITatuajesRepository extends CrudRepository<TatuajesEntity, Integer>{

	@Query(value = "SELECT new com.estudio.dtos.TatuajesDTO "
			   + "(te.idTatuajes, te.descripcion, te.color)"
			   + " FROM com.estudio.entities.TatuajesEntity te "
			   + "					WHERE te.idTatuajes = :id "
			   + " 					AND te.descripcion LIKE CONCAT ('%', :descripcion, '%') "
			   + " 					AND te.color = :color ")
	public List<TatuajesDTO> buscarTatuajes(
		@Param("id") Integer id,
		@Param("descripcion") String descripcion,
		@Param("color") String color);
	
}

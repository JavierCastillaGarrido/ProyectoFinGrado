package com.estudio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.estudio.dtos.TatuajesDTO;
import com.estudio.entities.TatuajesEntity;

@Repository
public interface ITatuajesRepository extends CrudRepository<TatuajesEntity, Integer>{

	/* IS NULL OR = si viene el parametro como null lo ignora y no realiza la comprobacion y filtra por el resto */
	
	@Query(value = "SELECT new com.estudio.dtos.TatuajesDTO "
			   + "(te.idTatuajes, te.descripcion, te.color)"
			   + " FROM com.estudio.entities.TatuajesEntity te "
			   + "					WHERE (:id IS NULL OR te.idTatuajes = :id)"
			   + " 					AND te.descripcion LIKE CONCAT ('%', :descripcion, '%') "
			   + " 					AND te.color = :color "
			   + "					AND te.tamano >= :tamano "
			   + "					AND te.precio >= :precio ")
	public List<TatuajesDTO> buscarTatuajes(
		@Param("id") Integer idTatuajes,
		@Param("descripcion") String descripcion,
		@Param("color") String color,
		@Param("tamano") double tamano,
		@Param("precio") double precio);
}


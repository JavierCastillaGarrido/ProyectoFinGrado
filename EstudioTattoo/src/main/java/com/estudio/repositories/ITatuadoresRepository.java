package com.estudio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.estudio.dtos.TatuadoresDTO;
import com.estudio.entities.TatuadoresEntity;

@Repository
public interface ITatuadoresRepository extends CrudRepository<TatuadoresEntity, Integer>{

	/* IS NULL OR = si viene el parametro como null lo ignora y no realiza la comprobacion y filtra por el resto */
	
	@Query(value="SELECT new com.estudio.dtos.TatuadoresDTO "
			  + " (te.idTatuadores, te.nombre, te.apellidos, te.email, te.especialidad, te.activo) "
			  + " FROM com.estudio.entities.TatuadoresEntity te "
			  + "				   WHERE (:id IS NULL OR te.idTatuadores = :id)"
			  + "				   AND te.nombre LIKE CONCAT ('%', :nombre, '%') "
			  + "				   AND te.apellidos LIKE CONCAT ('%', :apellidos, '%') "
			  + "				   AND te.email LIKE CONCAT ('%', :email, '%') "
			  + "				   AND te.especialidad LIKE CONCAT ('%', :especialidad, '%') "
			  + "				   AND te.activo = :activo ")
	public List<TatuadoresDTO> buscarTatuadores(
			@Param("id") Integer id, 
			@Param("nombre") String nombre, 
			@Param("apellidos") String apellidos, 
			@Param("email") String email, 
			@Param("especialidad") String especialidad, 
			@Param("activo") Integer activo);
	
	
}

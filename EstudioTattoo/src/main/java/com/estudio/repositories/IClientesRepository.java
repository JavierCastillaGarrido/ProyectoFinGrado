package com.estudio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.estudio.dtos.ClientesDTO;
import com.estudio.entities.ClientesEntity;

@Repository
public interface IClientesRepository extends CrudRepository<ClientesEntity, Integer>{

	/* IS NULL OR = si viene el parametro como null lo ignora y no realiza la comprobacion y filtra por el resto */
	
	@Query(value = "SELECT new com.estudio.dtos.ClientesDTO "
			   + "(ce.idClientes, ce.nombre, ce.apellidos, ce.telefono, ce.email, ce.password)"
			   + " FROM com.estudio.entities.ClientesEntity ce "
			   + "					WHERE (:id IS NULL OR ce.idClientes = :id) "
			   + " 					AND ce.nombre LIKE CONCAT ('%', :nombre, '%') "
			   + " 					AND ce.apellidos LIKE CONCAT ('%', :apellidos, '%') "
			   + " 					AND ce.telefono LIKE CONCAT ('%', :telefono, '%') "
			   + " 					AND ce.email LIKE CONCAT ('%', :email, '%') "
			   + " 					AND ce.password LIKE CONCAT ('%', :pass, '%') ")
	public List<ClientesDTO> buscarClientes(
		@Param("id") Integer id,
		@Param("nombre") String nombre,
		@Param("apellidos") String apellidos,
		@Param("telefono") String telefono,
		@Param("email") String email,
		@Param("pass") String password);
	
}

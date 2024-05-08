package com.estudio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.estudio.dtos.ClientesDTO;
import com.estudio.entities.ClientesEntity;

public interface IClientesRepository extends CrudRepository<ClientesEntity, Integer>{

	@Query(value = "SELECT new com.estudio.dtos.ClientesDTO "
			   + "(ce.idClientes, ce.nombre, ce.apellidos, ce.telefono, ce.email, ce.password)"
			   + " FROM com.estudio.entities.ClientesEntity ce "
			   + "					WHERE ce.idClientes = :id "
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

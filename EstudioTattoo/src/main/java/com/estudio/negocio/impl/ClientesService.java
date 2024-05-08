package com.estudio.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.estudio.dao.IClientesDAO;
import com.estudio.dtos.ClientesDTO;
import com.estudio.negocio.IClientesService;

@Component
public class ClientesService implements IClientesService{

	@Autowired
	IClientesDAO clientesDAOImpl;
	
	@Override
	public List<ClientesDTO> buscarClientes(Integer id, String nombre, String apellidos, String telefono, String email,
			String password) throws ClassNotFoundException, SQLException {
		
		return clientesDAOImpl.buscarClientes(id, nombre, apellidos, telefono, email, password);
		
	}

	@Override
	public Integer insertarClientes(String nombre, String apellidos, String telefono, String email, String password)
			throws ClassNotFoundException, SQLException {
		
		return clientesDAOImpl.insertarClientes(nombre, apellidos, telefono, email, password);
		
	}

	@Override
	public Integer actualizarClientes(Integer id, String nombre, String apellidos, String telefono, String email,
			String password) throws ClassNotFoundException, SQLException {

		return clientesDAOImpl.actualizarClientes(id, nombre, apellidos, telefono, email, password);
		
	}

}

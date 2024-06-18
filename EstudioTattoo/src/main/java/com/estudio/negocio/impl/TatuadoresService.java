package com.estudio.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.estudio.dao.ITatuadoresDAO;
import com.estudio.dtos.TatuadoresDTO;
import com.estudio.negocio.ITatuadoresService;

@Component
public class TatuadoresService implements ITatuadoresService{

	@Autowired
	ITatuadoresDAO tatuadoresDAOImpl;
	
	@Override
	public List<TatuadoresDTO> buscarTatuadores(Integer id, String nombre, String apellidos, String email,
			String especialidad, String descripcion, Integer activo) throws ClassNotFoundException, SQLException {
		
		return tatuadoresDAOImpl.buscarTatuadores(id, nombre, apellidos, email, especialidad, descripcion, activo);
		
	}

	@Override
	public Integer insertarTatuador(String nombre, String apellidos, String email, String especialidad, String descripcion, Integer activo)
			throws ClassNotFoundException, SQLException {
		
		return tatuadoresDAOImpl.insertarTatuador(nombre, apellidos, email, especialidad, descripcion, activo);
		
	}

	@Override
	public Integer actualizarTatudor(Integer id, String nombre, String apellidos, String email, String especialidad, String descripcion, 
			Integer activo) throws ClassNotFoundException, SQLException {
		
		return tatuadoresDAOImpl.actualizarTatudor(id, nombre, apellidos, email, especialidad, descripcion, activo);
		
	}

	@Override
	public Integer borrarTatuador(Integer id) throws ClassNotFoundException, SQLException {
		
		return tatuadoresDAOImpl.borrarTatuador(id);
		
	}

}

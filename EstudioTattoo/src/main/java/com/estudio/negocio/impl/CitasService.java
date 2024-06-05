package com.estudio.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.estudio.dao.ICitasDAO;
import com.estudio.dtos.CitasDTO;
import com.estudio.negocio.ICitasService;

@Component
public class CitasService implements ICitasService{

	@Autowired
	ICitasDAO citasDAOImpl;
	
	@Override
	public List<CitasDTO> buscarCitas(Integer id, String fecha, Integer cliente, Integer tatuador, Integer tatuajes,
			Integer activo) throws ClassNotFoundException, SQLException {
		
		return citasDAOImpl.buscarCitas(id, fecha, cliente, tatuador, tatuajes, activo);
	}

	@Override
	public Integer insertarCitas(String fecha, Integer cliente, Integer tatuador, Integer tatuajes, Integer activo)
			throws ClassNotFoundException, SQLException {
		
		return citasDAOImpl.insertarCitas(fecha, cliente, tatuador, tatuajes, activo);
	}

	@Override
	public Integer actualizarCitas(Integer id, String fecha, Integer cliente, Integer tatuador, Integer tatuajes,
			Integer activo) throws ClassNotFoundException, SQLException {
		
		return citasDAOImpl.actualizarCitas(id, fecha, cliente, tatuador, tatuajes, activo);
	}

	@Override
	public Integer borrarCitas(Integer id) throws ClassNotFoundException, SQLException {
		
		return citasDAOImpl.borrarCitas(id);
	}

}

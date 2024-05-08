package com.estudio.negocio.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.estudio.dao.ITatuajesDAO;
import com.estudio.dtos.TatuajesDTO;
import com.estudio.negocio.ITatuajesService;

@Component
public class TatuajesService implements ITatuajesService{

	@Autowired
	ITatuajesDAO tatuajesDAOImpl; 
	
	@Override
	public List<TatuajesDTO> buscarTatuajes(Integer id, String descripcion, Integer color)
			throws ClassNotFoundException, SQLException {
		
		return tatuajesDAOImpl.buscarTatuajes(id, descripcion, color);
		
	}

	@Override
	public Integer insertarTatuajes(String descripcion, Integer color) throws ClassNotFoundException, SQLException {
		
		return tatuajesDAOImpl.insertarTatuajes(descripcion, color);
		
	}

	@Override
	public Integer actualizarTatuajes(Integer id, String descripcion, Integer color)
			throws ClassNotFoundException, SQLException {
		
		return tatuajesDAOImpl.actualizarTatuajes(id, descripcion, color);
		
	}

}

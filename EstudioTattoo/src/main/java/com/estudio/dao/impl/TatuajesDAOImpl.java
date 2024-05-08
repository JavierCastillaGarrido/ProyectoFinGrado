package com.estudio.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.estudio.dao.ITatuajesDAO;
import com.estudio.dtos.TatuajesDTO;
import com.estudio.entities.TatuajesEntity;
import com.estudio.repositories.ITatuajesRepository;

@Component
public class TatuajesDAOImpl implements ITatuajesDAO {

	@Autowired
	private ITatuajesRepository tatuajesRepository;
	
	@Override
	public List<TatuajesDTO> buscarTatuajes(Integer id, String descripcion, Integer color)
			throws ClassNotFoundException, SQLException {
		
		return tatuajesRepository.buscarTatuajes(id, descripcion, descripcion);
		
	}

	@Override
	public Integer insertarTatuajes(String descripcion, Integer color) throws ClassNotFoundException, SQLException {
		
		TatuajesEntity te = new TatuajesEntity(descripcion, color);
		tatuajesRepository.save(te);
		
		return te.getIdTatuajes();
		
	}

	@Override
	public Integer actualizarTatuajes(Integer id, String descripcion, Integer color)
			throws ClassNotFoundException, SQLException {

		TatuajesEntity te = new TatuajesEntity(id, descripcion, color);
		tatuajesRepository.save(te);
		
		return te.getIdTatuajes();
		
	}

}

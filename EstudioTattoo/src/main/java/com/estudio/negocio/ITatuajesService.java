package com.estudio.negocio;

import java.sql.SQLException;
import java.util.List;

import com.estudio.dtos.TatuajesDTO;

public interface ITatuajesService {

	public List<TatuajesDTO> buscarTatuajes(Integer id, String descripcion, Integer color) throws ClassNotFoundException, SQLException;
	
	public Integer insertarTatuajes(String descripcion, Integer color) throws ClassNotFoundException, SQLException;
	
	public Integer actualizarTatuajes(Integer id, String descripcion, Integer color) throws ClassNotFoundException, SQLException;
	
	
}

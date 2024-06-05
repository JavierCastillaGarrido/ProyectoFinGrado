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
	public List<TatuajesDTO> buscarTatuajes(Integer idTatuajes, String descripcion, Integer color, double tamano, double precio)
			throws ClassNotFoundException, SQLException {
		
		return tatuajesDAOImpl.buscarTatuajes(idTatuajes, descripcion, color, tamano, precio);
		
	}

	@Override
	public Integer insertarTatuajes(String descripcion, Integer color, double tamano, double precio) throws ClassNotFoundException, SQLException {
		
		precio = calcularPrecio(color, tamano);
		
		return tatuajesDAOImpl.insertarTatuajes(descripcion, color, tamano, precio);
		
	}

	@Override
	public Integer actualizarTatuajes(Integer idTatuajes, String descripcion, Integer color, double tamano, double precio)
			throws ClassNotFoundException, SQLException {
		
		precio = calcularPrecio(color, tamano);
		
		return tatuajesDAOImpl.actualizarTatuajes(idTatuajes, descripcion, color, tamano, precio);
		
	}

	public double calcularPrecio(Integer color, double tamano) {
		
		double precio = 50.00;
		
		if (color == 1) {
			precio += 15.00;
		}
		
		if (tamano <= 7) {
			precio += 5;
		}else if(tamano >7 && tamano<=15) {
			precio += 15;
		}else if(tamano > 15){
			precio += 30;
		}
		
		return precio;
	}

}

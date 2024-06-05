package com.estudio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.estudio.dtos.ImagenesDTO;
import com.estudio.entities.ImagenesEntity;

public interface IImagenesRepository extends CrudRepository<ImagenesEntity, Integer>{

	@Query(value = "SELECT new com.estudio.dtos.ImagenesDTO "
			   + "(ie.idImagen, te.idTatuadores, ie.Descripcion, te.Imagenes)"
			   + " FROM com.estudio.entities.ImagenesEntity ie,"
			   + "		com.estudio.entities.TatuadoresEntity te "
			   + "					WHERE CAST (ie.idImagen AS string) LIKE CONCAT ('%', :id, '%') "
			   + " 					AND CAST (ie.tatuador AS string) LIKE CONCAT ('%', :tatuador, '%') "
			   + " 					AND ie.descripcion LIKE CONCAT ('%', :descrip, '%') "
			   + " 					AND ie.imagenes LIKE CONCAT ('%', :imagenes, '%') ")
	public List<ImagenesDTO> buscarImagenes(
			@Param("id") Integer idImagen, 
			@Param("tatuador") Integer tatuador, 
			@Param("descrip") String descripcion, 
			@Param("imagenes") String imagenes);
}

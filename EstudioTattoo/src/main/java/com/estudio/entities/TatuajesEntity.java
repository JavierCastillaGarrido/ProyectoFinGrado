package com.estudio.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tatuajes")
public class TatuajesEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Tatuajes")
    private Integer idTatuajes;
    
    @Column(name = "Descripcion")
    private String descripcion;
    
    @Column(name = "Color")
    private Integer color;
	
	public TatuajesEntity() {
		super();
	}

	public TatuajesEntity(Integer idTatuajes) {
		super();
		this.idTatuajes = idTatuajes;
	}

	public TatuajesEntity(Integer idTatuajes, String descripcion, Integer color) {
		super();
		this.idTatuajes = idTatuajes;
		this.descripcion = descripcion;
		this.color = color;
	}
	
	public TatuajesEntity(String descripcion, Integer color) {
		super();
		this.descripcion = descripcion;
		this.color = color;
	}

	public Integer getIdTatuajes() {
		return idTatuajes;
	}

	public void setIdTatuajes(Integer idTatuajes) {
		this.idTatuajes = idTatuajes;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getColor() {
		return color;
	}

	public void setColor(Integer color) {
		this.color = color;
	}

}

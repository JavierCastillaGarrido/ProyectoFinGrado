package com.estudio.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="imagenestatus")
public class ImagenesEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Imagen")
	private Integer idImagen;
	
	@ManyToOne
    @JoinColumn(name="ID_Tatuadores")
    @JsonManagedReference
    private TatuadoresEntity tatuador;
	
	@Column(name = "Descripcion")
    private String Descripcion;
	
    @Column(name = "Imagenes")
    private String Imagenes;
    
	public ImagenesEntity() {
		super();
	}

	public ImagenesEntity(Integer idImagen) {
		super();
		this.idImagen = idImagen;
	}

	public ImagenesEntity(TatuadoresEntity tatuador, String descripcion, String imagenes) {
		super();
		this.tatuador = tatuador;
		Descripcion = descripcion;
		Imagenes = imagenes;
	}

	public ImagenesEntity(Integer idImagen, TatuadoresEntity tatuador, String descripcion, String imagenes) {
		super();
		this.idImagen = idImagen;
		this.tatuador = tatuador;
		Descripcion = descripcion;
		Imagenes = imagenes;
	}

	public Integer getIdImagen() {
		return idImagen;
	}

	public void setIdImagen(Integer idImagen) {
		this.idImagen = idImagen;
	}

	public TatuadoresEntity getTatuador() {
		return tatuador;
	}

	public void setTatuador(TatuadoresEntity tatuador) {
		this.tatuador = tatuador;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public String getImagenes() {
		return Imagenes;
	}

	public void setImagenes(String imagenes) {
		Imagenes = imagenes;
	}

	
}

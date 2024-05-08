package com.estudio.dtos;

public class TatuajesDTO {
	
    private Integer idTatuajes;
    private String descripcion;
    private Integer color;
    
	public TatuajesDTO() {
		super();
	}

	public TatuajesDTO(Integer idTatuajes, String descripcion, Integer color) {
		super();
		this.idTatuajes = idTatuajes;
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

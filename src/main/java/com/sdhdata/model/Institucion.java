package com.sdhdata.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="institucion")
public class Institucion implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	//@Column(name = "idregistro")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idinstitucion;
	private String nombre;
	
	public Long getIdinstitucion() {
		return idinstitucion;
	}
	public void setIdinstitucion(Long idinstitucion) {
		this.idinstitucion = idinstitucion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	@Override
	public String toString() {
		return "Institucion [idinstitucion=" + idinstitucion + ", nombre=" + nombre + "]";
	}
	
	
	

}

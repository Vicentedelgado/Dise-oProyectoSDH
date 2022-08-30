package com.sdhdata.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="unidad")
public class Unidad implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idunidad;
	private String nombre;
	
	public Long getIdunidad() {
		return idunidad;
	}
	public void setIdunidad(Long idunidad) {
		this.idunidad = idunidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "Unidad [idunidad=" + idunidad + ", nombre=" + nombre + "]";
	}
	
	

}

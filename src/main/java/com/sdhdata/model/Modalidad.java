package com.sdhdata.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="modalidad")
public class Modalidad implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idmodalidad;
	private String nombre;
	
	public Long getIdmodalidad() {
		return idmodalidad;
	}
	public void setIdmodalidad(Long idmodalidad) {
		this.idmodalidad = idmodalidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "Modalidad [idmodalidad=" + idmodalidad + ", nombre=" + nombre + "]";
	}
	
	

}

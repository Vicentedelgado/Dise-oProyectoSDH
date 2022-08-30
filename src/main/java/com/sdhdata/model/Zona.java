package com.sdhdata.model;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="zona")
public class Zona implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	//@Column(name = "idregistro")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idzona;
	private String nombre;
	

	public Long getIdzona() {
		return idzona;
	}

	public void setIdzona(Long idzona) {
		this.idzona = idzona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Zona [idzona=" + idzona + ", nombre=" + nombre + "]";
	}

	

	
	
	
	
	
	
	
	

}

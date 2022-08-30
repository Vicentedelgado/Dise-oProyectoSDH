package com.sdhdata.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="activo")
public class Activo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	//@Column(name = "idregistro")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idactivo;
	@NotEmpty
	@Size(min = 3, message = "Tiene que tener minimo 3 caracteres")
	@Column(name= "nombre", nullable= false, length =70)
	private String nombre;
	@ManyToOne
	@JoinColumn(name="idtipo")
	private Tipo idtipo;
	@NotEmpty
	private String descripcion;
	
	
	public Long getIdactivo() {
		return idactivo;
	}
	public void setIdactivo(Long idactivo) {
		this.idactivo = idactivo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Tipo getIdtipo() {
		return idtipo;
	}
	public void setIdtipo(Tipo idtipo) {
		this.idtipo = idtipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Activo [idactivo=" + idactivo + ", nombre=" + nombre + ", idtipo=" + idtipo + ", descripcion="
				+ descripcion + "]";
	}
	
	
	

}

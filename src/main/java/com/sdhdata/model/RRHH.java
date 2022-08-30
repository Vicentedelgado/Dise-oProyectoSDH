package com.sdhdata.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="funcionario")
public class RRHH implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	//@Column(name = "idregistro")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idusuario;
	@ManyToOne
	@JoinColumn(name="idspi")
	private SpiDatos idspi;
	@ManyToOne
	@JoinColumn(name="idzona")
	private Zona idzona;
	@ManyToOne
	@JoinColumn(name="idunidad")
	private Unidad idunidad;
	@ManyToOne
	@JoinColumn(name="idmodalidad")
	private Modalidad idmodalidad;
	@NotEmpty
	private String cargo;
	@NotEmpty
	private String nombres;
	@NotEmpty
	private String apellidos;
	@NotEmpty
	private String cedula;
	@NotEmpty
	private String telefono;
	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	private String direccion;
	@NotEmpty
	private String estado;
	
	
	public Long getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
	}
	public SpiDatos getIdspi() {
		return idspi;
	}
	public void setIdspi(SpiDatos idspi) {
		this.idspi = idspi;
	}
	public Zona getIdzona() {
		return idzona;
	}
	public void setIdzona(Zona idzona) {
		this.idzona = idzona;
	}
	public Unidad getIdunidad() {
		return idunidad;
	}
	public void setIdunidad(Unidad idunidad) {
		this.idunidad = idunidad;
	}
	public Modalidad getIdmodalidad() {
		return idmodalidad;
	}
	public void setIdmodalidad(Modalidad idmodalidad) {
		this.idmodalidad = idmodalidad;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	@Override
	public String toString() {
		return "RRHH [idusuario=" + idusuario + ", idspi=" + idspi + ", idzona=" + idzona + ", idunidad=" + idunidad
				+ ", idmodalidad=" + idmodalidad + ", cargo=" + cargo + ", nombres=" + nombres + ", apellidos="
				+ apellidos + ", cedula=" + cedula + ", telefono=" + telefono + ", email=" + email + ", direccion="
				+ direccion + ", estado=" + estado + "]";
	}
	
	
	
	
	
	
	
	
	
	
		
	

}

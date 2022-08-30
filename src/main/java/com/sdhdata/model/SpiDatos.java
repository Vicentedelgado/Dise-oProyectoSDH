package com.sdhdata.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="spi_datos")
public class SpiDatos implements Serializable,Comparable<SpiDatos>{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	//@Column(name = "idspi")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idspi;
	@ManyToOne
	@JoinColumn(name="idinstitucion")
	private Institucion idinstitucion;
	@ManyToOne
	@JoinColumn(name="idzona")
	private Zona idzona;
	@NotEmpty
	private String nombre;
	@NotEmpty
	private String daservicioa;
	@NotEmpty
	private String direccion;
	@NotEmpty
	private String telefono;
	@NotNull
	private int numerodeoficina;
	@NotEmpty
	private String convenio;
	@NotEmpty
	private String observaciones;
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private Date fechafinconvenio;
	private String archivo;
	
	public Long getIdspi() {
		return idspi;
	}
	public void setIdspi(Long idspi) {
		this.idspi = idspi;
	}
	public Institucion getIdinstitucion() {
		return idinstitucion;
	}
	public void setIdinstitucion(Institucion idinstitucion) {
		this.idinstitucion = idinstitucion;
	}
	public Zona getIdzona() {
		return idzona;
	}
	public void setIdzona(Zona idzona) {
		this.idzona = idzona;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDaservicioa() {
		return daservicioa;
	}
	public void setDaservicioa(String daservicioa) {
		this.daservicioa = daservicioa;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public int getNumerodeoficina() {
		return numerodeoficina;
	}
	public void setNumerodeoficina(int numerodeoficina) {
		this.numerodeoficina = numerodeoficina;
	}
	public String getConvenio() {
		return convenio;
	}
	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	public Date getFechafinconvenio() {
		return fechafinconvenio;
	}
	public void setFechafinconvenio(Date fechafinconvenio) {
		this.fechafinconvenio = fechafinconvenio;
	}
	public String getArchivo() {
		return archivo;
	}
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
	
	@Override
	public String toString() {
		return "SpiDatos [idspi=" + idspi + ", idinstitucion=" + idinstitucion + ", idzona=" + idzona + ", nombre="
				+ nombre + ", daservicioa=" + daservicioa + ", direccion=" + direccion + ", telefono=" + telefono
				+ ", numerodeoficina=" + numerodeoficina + ", convenio=" + convenio + ", observaciones=" + observaciones
				+ ", fechafinconvenio=" + fechafinconvenio + "]";
	}
	
	@Override
	public int compareTo(SpiDatos o) {
		return idspi.compareTo(o.getIdspi());
	}
	
	
	
	
	
	

}

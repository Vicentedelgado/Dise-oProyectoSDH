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

@Entity
@Table(name="roles")
public class Roles  implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "idrol")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idrol;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private Users iduser;
	@NotEmpty
	@Column(name= "rol", nullable= true, length =60)
	private String rol;
	public Long getIdrol() {
		return idrol;
	}
	public void setIdrol(Long idrol) {
		this.idrol = idrol;
	}
	
	public Users getIduser() {
		return iduser;
	}
	public void setIduser(Users iduser) {
		this.iduser = iduser;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	@Override
	public String toString() {
		return "Roles [idrol=" + idrol + ", user_id=" + iduser + ", rol=" + rol + "]";
	}
	
	
}

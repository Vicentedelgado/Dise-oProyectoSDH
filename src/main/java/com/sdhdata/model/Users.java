package com.sdhdata.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="users")
public class Users  implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "iduser")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long iduser;
	@NotEmpty
	@Column(name= "username", nullable= false, length =45)
	private String username;
	@NotEmpty
	@Column(name= "password", nullable= true, length =60)
	private String password;
	@NotEmpty
	@Column(name= "enabled", nullable= false, length =2)
	private String enabled;
	
	public Long getIduser() {
		return iduser;
	}
	public void setIduser(Long iduser) {
		this.iduser = iduser;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "Users [iduser=" + iduser + ", username=" + username + ", password=" + password + ", enabled=" + enabled
				+ "]";
	}
	
	
	
	
	

}

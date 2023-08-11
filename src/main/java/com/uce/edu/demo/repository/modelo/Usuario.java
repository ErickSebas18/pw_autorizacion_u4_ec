package com.uce.edu.demo.repository.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usua_seq_id")
	@SequenceGenerator(name = "usua_seq_id", sequenceName = "usua_seq_id", allocationSize = 1)
	@Column(name = "user_id")
	private Integer id;
	@Column(name = "user_user_name")
	private String userName;
	@Column(name = "user_password")
	private String password;
	
	//GETTERS Y SETTERS 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

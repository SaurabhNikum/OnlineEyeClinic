package com.cg.onlineeyeclinic.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//************************************Admin Entity Class**************************************//

@Entity
public class Admin 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Admin_Id")
	private int id;
	
	
	@Column(name="Username")
	private String username;
	
	
	@Column(name="Password")
	private String password;
	

	//constructors
	public Admin() {
		super();
	}
	
	public Admin(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}



	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	
}

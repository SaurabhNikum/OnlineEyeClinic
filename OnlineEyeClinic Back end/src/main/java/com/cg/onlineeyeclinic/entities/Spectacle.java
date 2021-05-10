package com.cg.onlineeyeclinic.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//************************************Spectacle Entity Class**************************************//

@Entity
public class Spectacle 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Spectacle_Id")
	private int id;
	
	@Column(name="Model")
	private String model;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="Cost")
	private double cost;
	
	//constructors
	public Spectacle() {
		super();
	}
	
	public Spectacle(int id, String model, String description, double cost) {
		super();
		this.id = id;
		this.model = model;
		this.description = description;
		this.cost = cost;
	}
	
	//getters and setters
	public int getId() {
		return id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
	
}

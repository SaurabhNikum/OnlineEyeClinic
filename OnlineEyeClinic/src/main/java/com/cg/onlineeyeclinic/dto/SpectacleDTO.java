package com.cg.onlineeyeclinic.dto;

import javax.validation.constraints.NotNull;

//************************************Spectacle DTO Class**************************************//

public class SpectacleDTO 
{
	long id;
	
	@NotNull
	private String model;
	
	@NotNull
	private String description;
	
	@NotNull
	private double cost;
	
	//getters and setters
	
	
	public String getModel() {
		return model;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

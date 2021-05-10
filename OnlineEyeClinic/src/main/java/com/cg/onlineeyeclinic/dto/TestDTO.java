package com.cg.onlineeyeclinic.dto;

import javax.validation.constraints.NotNull;

//************************************Tests DTO Class**************************************//

public class TestDTO 
{		
		@NotNull
		private String name;
		
		@NotNull
		private String type;
		
		@NotNull
		private String description;
		
		@NotNull
		private double cost;
		
		//getters and setters
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
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

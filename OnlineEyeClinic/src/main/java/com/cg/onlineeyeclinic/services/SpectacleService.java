package com.cg.onlineeyeclinic.services;

import java.util.List;
import com.cg.onlineeyeclinic.entities.Spectacle;
import com.cg.onlineeyeclinic.exceptions.IdNotFoundException;
import com.cg.onlineeyeclinic.exceptions.SpectacleNotFoundException;

//******************************Spectacle Service Interface***************************//

public interface SpectacleService {

	//add spectacle
	Spectacle addSpectacle(Spectacle spectacle);

	//remove spectacle
	String removeSpectacle(int spectacleId) throws IdNotFoundException;

	//update spectacle
	Spectacle updateSpectacle(int id,Spectacle spectacle) throws IdNotFoundException;

	//get spectacle
	Spectacle getSpectacle(int spectacleId) throws IdNotFoundException;

	//get spectacle list
	List<Spectacle> getAllSpectacle() throws SpectacleNotFoundException;
	
	//get spectacle list by spectacle name
	List<Spectacle> getAllSpectacleByModel(String model);

}
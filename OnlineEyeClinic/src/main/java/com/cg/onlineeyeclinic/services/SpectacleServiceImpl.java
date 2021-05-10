package com.cg.onlineeyeclinic.services;

import java.util.List;
import java.util.function.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.onlineeyeclinic.entities.Spectacle;
import com.cg.onlineeyeclinic.exceptions.IdNotFoundException;
import com.cg.onlineeyeclinic.exceptions.SpectacleNotFoundException;
import com.cg.onlineeyeclinic.repositories.SpectacleRepository;

//******************************Spectacle Service Implementation Class***************************//

@Service
public class SpectacleServiceImpl implements SpectacleService 
{
	@Autowired
	private SpectacleRepository spectacleRepository;
	
	String detail="no spectacle is available with given id : ";
	
	//add spectacle
	@Override
	public Spectacle addSpectacle(Spectacle spectacle)
	{
		return spectacleRepository.save(spectacle);
	}
	
	//remove spectacle
	@Override
	public String removeSpectacle(int spectacleId) throws IdNotFoundException
	{
		Supplier<IdNotFoundException> supplier=()->new IdNotFoundException(detail+spectacleId);
		Spectacle spectacle=spectacleRepository.findById(spectacleId).orElseThrow(supplier);
		spectacleRepository.delete(spectacle);
		return("spectacle is removed successfully");
	}
	
	//update spectacle
	@Override
	public Spectacle updateSpectacle(int id,Spectacle spectacle) throws IdNotFoundException
	{
		Supplier<IdNotFoundException> supplier=()->new IdNotFoundException(detail+id);
		Spectacle updatedSpectacle=spectacleRepository.findById(id).orElseThrow(supplier);
		updatedSpectacle.setCost(spectacle.getCost());
		updatedSpectacle.setDescription(spectacle.getDescription());
		updatedSpectacle.setModel(spectacle.getModel());
		return spectacleRepository.save(updatedSpectacle);
	}
	
	//get spectacle
	@Override
	public Spectacle getSpectacle(int spectacleId) throws IdNotFoundException
	{
		Supplier<IdNotFoundException> supplier=()->new IdNotFoundException(detail+spectacleId);
		return spectacleRepository.findById(spectacleId).orElseThrow(supplier);
	}
	
	//get spectacle list
	@Override
	public List<Spectacle> getAllSpectacle() throws SpectacleNotFoundException
	{
		if(spectacleRepository.findAll().isEmpty())
		{
			throw new SpectacleNotFoundException("no spectacle is available currently");
		}
		return spectacleRepository.findAll();
	}
	
	//get spectacle list by name
	@Override
	public List<Spectacle> getAllSpectacleByModel(String model) {
		return spectacleRepository.findAllByModel(model);
	}
}

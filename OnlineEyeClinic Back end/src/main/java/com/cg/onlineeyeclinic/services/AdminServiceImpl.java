package com.cg.onlineeyeclinic.services;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.onlineeyeclinic.entities.Admin;
import com.cg.onlineeyeclinic.exceptions.AdminNotFoundException;
import com.cg.onlineeyeclinic.exceptions.IdNotFoundException;
import com.cg.onlineeyeclinic.exceptions.UserNameAlreadyExistException;
import com.cg.onlineeyeclinic.repositories.AdminRepository;

//******************************Admin Service Implementation Class***************************//

@Service
public class AdminServiceImpl implements AdminService 
{
	@Autowired
	private AdminRepository adminRepository;
	
	//add an admin method
	@Override
	public Admin addAdmin(Admin admin) throws UserNameAlreadyExistException
	{
		List<Admin> admins=adminRepository.findAll();
		for(Admin ad:admins)
		{
			if(ad.getUsername().equals(admin.getUsername()))
			{
				throw new UserNameAlreadyExistException("username already exist.....Please modify your username !");
			}
		}
		return adminRepository.save(admin);
	}
	
	// remove an admin method
	@Override
	public String removeAdmin(int adminId) throws IdNotFoundException
	{
		Supplier<IdNotFoundException> supplier=()->new IdNotFoundException("no admin found with this id");
		Admin admin=adminRepository.findById(adminId).orElseThrow(supplier);
		adminRepository.delete(admin);
		return "admin removed successfully";
	}
	
	//get all admin's username method
	@Override
	public List<String> getAdminsUsername() throws AdminNotFoundException
	{
		List<String> usernameList=new ArrayList<>();
		List<Admin> adminList=adminRepository.findAll();
		for(Admin admin:adminList)
		{
			usernameList.add(admin.getUsername());
		}
		if(usernameList.isEmpty())
		{
			throw new AdminNotFoundException("no admin is available so cannot show username");
		}
		return usernameList;
	}

	//get all admins method
	@Override
	public List<Admin> getAllAdmins() throws AdminNotFoundException {
		if(adminRepository.findAll().isEmpty())
		{
			throw new AdminNotFoundException("currently no admin is available");
		}
		return adminRepository.findAll();
	}
	
	//get admin with id
	@Override
	public Admin getAdmin(int adminId) throws IdNotFoundException
	{
		Supplier<IdNotFoundException> supplier=()->new IdNotFoundException("no admin found with this id");
		return adminRepository.findById(adminId).orElseThrow(supplier);
	}

	//update password for admin
	@Override
	public String updatePassword(int adminId,String password) throws IdNotFoundException 
	{
		Admin admin=this.getAdmin(adminId);
		admin.setPassword(password);
		adminRepository.save(admin);
		return "password updated successfully";
	}
	
}

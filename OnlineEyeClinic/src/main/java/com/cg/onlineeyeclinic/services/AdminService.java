package com.cg.onlineeyeclinic.services;

import java.util.List;

import com.cg.onlineeyeclinic.entities.Admin;
import com.cg.onlineeyeclinic.exceptions.AdminNotFoundException;
import com.cg.onlineeyeclinic.exceptions.IdNotFoundException;
import com.cg.onlineeyeclinic.exceptions.UserNameAlreadyExistException;

//******************************Admin Service Interface***************************//

public interface AdminService {

	//add an admin
	Admin addAdmin(Admin admin) throws UserNameAlreadyExistException;

	// remove an admin
	String removeAdmin(int adminId) throws IdNotFoundException;

	//get all admins username
	List<String> getAdminsUsername() throws AdminNotFoundException;
	
	//get all admins
	List<Admin> getAllAdmins() throws AdminNotFoundException;
	
	//update password for an admin
	String updatePassword(int adminId,String password) throws IdNotFoundException;

	//get an admin with id
	Admin getAdmin(int adminId) throws IdNotFoundException;

}
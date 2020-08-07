package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.CreatePotluckDTO;
import com.techelevator.model.Potluck;

public interface PotluckDAO {
	
	boolean create(CreatePotluckDTO newPotluck, Long user_id);
	
	List<Potluck> getAllPotlucksByUserId(Long userId);
	
	Potluck getPotluckDetails(int potluck_id);
	
}

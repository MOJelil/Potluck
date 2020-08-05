package com.techelevator.dao;

import com.techelevator.model.CreatePotluckDTO;

public interface PotluckDAO {
	
	boolean create(CreatePotluckDTO newPotluck);
	
}

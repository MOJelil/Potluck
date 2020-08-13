package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.CreatePotluckDTO;
import com.techelevator.model.Guest;
import com.techelevator.model.Invite;
import com.techelevator.model.Potluck;

public interface PotluckDAO {

	boolean create(CreatePotluckDTO newPotluck, Long user_id);

	List<Potluck> getAllPotlucksByUserId(Long userId);

	Potluck getPotluckDetails(int potluck_id);

	boolean update(Potluck potluck, int potluck_id);

	boolean addGuests(Guest guest);

	List<Invite> getGuestDetails();
	


}

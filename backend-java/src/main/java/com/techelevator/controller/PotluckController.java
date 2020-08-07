package com.techelevator.controller;

import java.security.Principal;

import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.techelevator.dao.PotluckDAO;
import com.techelevator.dao.UserDAO;
import com.techelevator.model.CreatePotluckDTO;

@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin
public class PotluckController {
	
	private PotluckDAO potluckDAO;
	private UserDAO userDAO;
	
	public PotluckController(PotluckDAO potluckDAO, UserDAO userDAO) {
		this.potluckDAO = potluckDAO;
		this.userDAO = userDAO;
	}

	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/createpotluck", method = RequestMethod.POST)
	public void register(@Valid @RequestBody CreatePotluckDTO newPotluck, Principal principal) {
		long user_id = getCurrentUserId(principal);
		int user_id_int = (int)user_id;
		newPotluck.setUser_id(user_id_int);
		potluckDAO.create(newPotluck, user_id);
	}
	
	public Long getCurrentUserId(Principal principal) {
		return userDAO.findByUsername(principal.getName()).getId();
	}
	
}

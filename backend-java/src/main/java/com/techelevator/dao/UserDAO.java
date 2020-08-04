package com.techelevator.dao;

import com.techelevator.model.RegisterUserDTO;
import com.techelevator.model.User;

public interface UserDAO {

	User findByUsername(String username);

	boolean usernameExists(String username);

	boolean create(RegisterUserDTO newUser);
}

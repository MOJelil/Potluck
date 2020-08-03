package com.techelevator.dao;

import com.techelevator.model.User;

public interface UserDAO {

    User findByUsername(String username);

    boolean usernameExists(String username);

    boolean create(String username, String firstName, String lastName, String email, String phone, String password, String role);
}

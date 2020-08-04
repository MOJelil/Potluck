package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;

public class RegisterUserDTO {

	@NotEmpty
	private String username;
	@NotEmpty
	private String firstName;
	@NotEmpty
	private String lastName;
	@NotEmpty
	private String email;
	@NotEmpty
	private String phone;
	@NotEmpty
	private String password;
	@NotEmpty
	private String confirmPassword;
	@NotEmpty(message = "Please select a role for this user.")
	private String role;

	private List<String> diet = new ArrayList<>();

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<String> getDiet() {
		return diet;
	}

	public void setDiet(List<String> diet) {
		this.diet = diet;
	}

}

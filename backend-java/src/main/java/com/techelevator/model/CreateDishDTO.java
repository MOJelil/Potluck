package com.techelevator.model;

import java.util.ArrayList;
import java.util.List;

public class CreateDishDTO {
	private String dish_name;
	private String category;
	private int servings;
	private int potluck_id;
	private String recipe;
	private int user_id;
	private String firstname;
	private String lastname;

	private List<String> diet = new ArrayList<>();
	
	public String getDish_name() {
		return dish_name;
	}
	public void setDish_name(String dish_name) {
		this.dish_name = dish_name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getServings() {
		return servings;
	}
	public void setServings(int servings) {
		this.servings = servings;
	}
	public int getPotluck_id() {
		return potluck_id;
	}
	public void setPotluck_id(int potluck_id) {
		this.potluck_id = potluck_id;
	}
	public String getRecipe() {
		return recipe;
	}
	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public List<String> getDiet() {
		return diet;
	}
	public void setDiet(List<String> diet) {
		this.diet = diet;
	}
	public String getfirstname() {
		return firstname;
	}
	public void setfirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getlastname() {
		return lastname;
	}
	public void setLlastname(String lastname) {
		this.lastname = lastname;
	}
}

package com.techelevator.model;

public class CreateDishDTO {
	private String dish_name;
	private String category;
	private int servings;
	private int dietary_id;
	private int potluck_id;
	private String recipe;
	private int user_id;

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
	public int getDietary_id() {
		return dietary_id;
	}
	public void setDietary_id(int dietary_id) {
		this.dietary_id = dietary_id;
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
}

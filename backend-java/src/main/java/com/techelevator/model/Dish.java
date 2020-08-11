package com.techelevator.model;

public class Dish {

	private Long potluck_id;
	private Long dish_id;
	private String name;
	private String category;
	private int serving_number;
	private int dietary_id;
	private String recipe;
	private int guests;
	
	public Long getPotluck_id() {
		return potluck_id;
	}
	public void setPotluck_id(Long potluck_id) {
		this.potluck_id = potluck_id;
	}
	public Long getDish_id() {
		return dish_id;
	}
	public void setDish_id(Long dish_id) {
		this.dish_id = dish_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getServing_number() {
		return serving_number;
	}
	public void setServing_number(int serving_number) {
		this.serving_number = serving_number;
	}
	public int getDietary_id() {
		return dietary_id;
	}
	public void setDietary_id(int dietary_id) {
		this.dietary_id = dietary_id;
	}
	public String getRecipe() {
		return recipe;
	}
	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}
	public int getGuests() {
		return guests;
	}
	public void setGuests(int guests) {
		this.guests = guests;
	}

}

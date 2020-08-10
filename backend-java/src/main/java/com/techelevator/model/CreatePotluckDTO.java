package com.techelevator.model;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CreatePotluckDTO {

	private String location;
	private String name;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate potluck_date;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private LocalTime potluck_time;
	private int user_id;
	private String description;
	private int guests;
	private int appetizers;

	private int entrees;
	private int side_dishes;
	private int desserts;
	private int alcohol;
	private int non_alcohol;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getPotluck_Date() {
		return potluck_date;
	}

	public void setPotluck_Date(LocalDate potluck_date) {
		this.potluck_date = potluck_date;
	}

	public LocalTime getPotluck_Time() {
		return potluck_time;
	}

	public void setPotluck_Time(LocalTime potluck_time) {
		this.potluck_time = potluck_time;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getGuests() {
		return guests;
	}

	public void setGuests(int guests) {
		this.guests = guests;
	}

	public int getAppetizers() {
		return appetizers;
	}

	public void setAppetizers(int appetizers) {
		this.appetizers = appetizers;
	}

	public int getEntrees() {
		return entrees;
	}

	public void setEntrees(int entrees) {
		this.entrees = entrees;
	}

	public int getSide_dishes() {
		return side_dishes;
	}

	public void setSide_dishes(int side_dishes) {
		this.side_dishes = side_dishes;
	}

	public int getDesserts() {
		return desserts;
	}

	public void setDesserts(int desserts) {
		this.desserts = desserts;
	}

	public int getAlcohol() {
		return alcohol;
	}

	public void setAlcohol(int alcohol) {
		this.alcohol = alcohol;
	}

	public int getNon_alcohol() {
		return non_alcohol;
	}

	public void setNon_alcohol(int non_alcohol) {
		this.non_alcohol = non_alcohol;
	}

}

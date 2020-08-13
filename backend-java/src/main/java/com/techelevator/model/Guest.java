package com.techelevator.model;

public class Guest {

	private User[] guests;

	private int potluck_id;

	public Guest(User[] guests, int potluck_id) {
		super();
		this.guests = guests;
		this.potluck_id = potluck_id;

	}

	public User[] getGuests() {
		return guests;
	}

	public void setGuests(User[] guests) {
		this.guests = guests;
	}

	public int getPotluck_id() {
		return potluck_id;
	}

	public void setPotluck_id(int potluck_id) {
		this.potluck_id = potluck_id;
	}
}

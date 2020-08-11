package com.techelevator.model;

public class GuestDTO {
	private int[] guests;

	private int potluck_id;

	public GuestDTO(int[] guests, int potluck_id) {
		super();
		this.guests = guests;
		this.potluck_id = potluck_id;

	}

	public int[] getGuests() {
		return guests;
	}

	public void setGuests(int[] guests) {
		this.guests = guests;
	}

	public int getPotluck_id() {
		return potluck_id;
	}

	public void setPotluck_id(int potluck_id) {
		this.potluck_id = potluck_id;
	}
}
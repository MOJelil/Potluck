package com.techelevator.dao;

import com.techelevator.model.CreateDishDTO;

public interface DishDAO {

	boolean create(CreateDishDTO newDish, Long user_id);

}

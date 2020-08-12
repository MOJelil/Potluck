package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.CreateDishDTO;
import com.techelevator.model.Dish;

public interface DishDAO {

	boolean create(CreateDishDTO newDish, Long user_id);
	
	List<Dish> getDishes(int potluck_id);

}

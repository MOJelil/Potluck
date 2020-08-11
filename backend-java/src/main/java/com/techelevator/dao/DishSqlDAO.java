package com.techelevator.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.techelevator.model.CreateDishDTO;
import com.techelevator.model.CreatePotluckDTO;
import com.techelevator.model.Dish;
import com.techelevator.model.Potluck;

@Service
public class DishSqlDAO implements DishDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public DishSqlDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public boolean create(CreateDishDTO newDish, Long user_id) {
		boolean dishCreated = false;
		String sql = "INSERT INTO dish (dish_name, category, servings, potluck_id, recipe, user_id) VALUES (?,?,?,?,?,?)";

		try {
			int count = jdbcTemplate.update(sql, newDish.getDish_name(), newDish.getCategory(),
					newDish.getServings(), newDish.getPotluck_id(),
					newDish.getRecipe(), newDish.getUser_id());
			dishCreated = (count == 1);
			//Insert diet restriction information
			for (String restriction : newDish.getDiet()) {
				String sqlDietaryRestrictions = "INSERT INTO dish_restriction VALUES ((SELECT dish_id FROM dish ORDER BY dish_id DESC LIMIT 1),(SELECT dietary_id from dietary_restrictions where restriction_name = ?));";
				int rs = jdbcTemplate.update(sqlDietaryRestrictions, restriction);
			}
		} catch (DataAccessException e) {
			System.out.print(e);
		}
		return dishCreated;
	}
	
	private Dish mapRowToDish(SqlRowSet rs) {
		Dish dish = new Dish();
		dish.setDish_name(rs.getString("dish_name"));
		dish.setCategory(rs.getString("category"));
		dish.setServings(rs.getInt("servings"));
		dish.setPotluck_id(rs.getInt("potluck_id"));
		dish.setRecipe(rs.getString("recipe"));
		dish.setUser_id(rs.getInt("user_id"));
		return dish;
	}
}

package com.techelevator.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.techelevator.model.CreatePotluckDTO;
import com.techelevator.model.Potluck;

@Service
public class PotluckSqlDAO implements PotluckDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	private static final String ALL_FIELDS = "potluck_id, location, user_id, description, guests, appetizer, entree, side_dishes, alcohol, non_alcohol";
	
	public PotluckSqlDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean create(CreatePotluckDTO newPotluck) {
		boolean potluckCreated = false;
		String sql = "INSERT INTO potluck (location, user_id, description, guests, appetizers, entrees, side_dishes, desserts, alcohol, non_alcohol) VALUES (?,?,?,?,?,?,?,?,?,?)";
		
		try {
			int count = jdbcTemplate.update(sql, newPotluck.getLocation(), newPotluck.getUser_id(), newPotluck.getDescription(), newPotluck.getGuests(), newPotluck.getAppetizers(), newPotluck.getEntrees(), newPotluck.getSide_dishes(), newPotluck.getDesserts(), newPotluck.getAlcohol(), newPotluck.getNon_alcohol());
			potluckCreated = (count == 1);
		} catch (DataAccessException e) {
			System.out.print(e);
		}
		return potluckCreated;
	}
	
	private Potluck mapRowToPotluck(SqlRowSet rs) {
		Potluck potluck = new Potluck();
		potluck.setPotluck_id(rs.getLong("potluck_id"));
		potluck.setLocation(rs.getString("location"));
		potluck.setUser_id(rs.getInt("user_id"));
		potluck.setDescription(rs.getString("description"));
		potluck.setGuests(rs.getInt("guests"));
		potluck.setAppetizers(rs.getInt("appetizers"));
		potluck.setEntrees(rs.getInt("entrees"));
		potluck.setSide_dishes(rs.getInt("side_dishes"));
		potluck.setDesserts(rs.getInt("desserts"));
		potluck.setAlcohol(rs.getInt("alcohol"));
		potluck.setNon_alcohol(rs.getInt("non_alcohol"));
		return potluck;
	}

}

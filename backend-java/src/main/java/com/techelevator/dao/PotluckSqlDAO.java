package com.techelevator.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import com.techelevator.model.CreatePotluckDTO;
import com.techelevator.model.Guest;
import com.techelevator.model.Invite;
import com.techelevator.model.Potluck;
import com.techelevator.model.User;

@Service
public class PotluckSqlDAO implements PotluckDAO {

	private JdbcTemplate jdbcTemplate;

	// private static final String ALL_FIELDS = "potluck_id, location, name,
	// user_id, description, guests, appetizers, entree, side_dishes, alcohol,
	// non_alcohol";

	public PotluckSqlDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean create(CreatePotluckDTO newPotluck, Long user_id) {
		boolean potluckCreated = false;
		String sql = "INSERT INTO potluck (location, name, potluck_date, potluck_time, user_id, description, guests, appetizers, entrees, side_dishes, desserts, alcohol, non_alcohol) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			int count = jdbcTemplate.update(sql, newPotluck.getLocation(), newPotluck.getName(),
					newPotluck.getPotluck_Date(), newPotluck.getPotluck_Time(), newPotluck.getUser_id(),
					newPotluck.getDescription(), newPotluck.getGuests(), newPotluck.getAppetizers(),
					newPotluck.getEntrees(), newPotluck.getSide_dishes(), newPotluck.getDesserts(),
					newPotluck.getAlcohol(), newPotluck.getNon_alcohol());
			potluckCreated = (count == 1);
		} catch (DataAccessException e) {
			System.out.print(e);
		}
		return potluckCreated;
	}

	@Override
	public List<Potluck> getAllPotlucksByUserId(Long userId) {
		Potluck potluck = null;
		List<Potluck> potluckList = new ArrayList<>();
		String sql = "SELECT * FROM potluck WHERE user_id = ?";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
		while (results.next()) {
			potluck = mapRowToPotluck(results);
			potluckList.add(potluck);
		}
		return potluckList;
	}

	@Override
	public Potluck getPotluckDetails(int potluck_id) {
		Potluck potluck = null;
		String sql = "SELECT * FROM potluck WHERE potluck_id = ?";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, potluck_id);
		while (results.next()) {
			potluck = mapRowToPotluck(results);
		}
		return potluck;
	}

	@Override
	public boolean update(Potluck potluck, int potluck_id) {
		boolean potluckUpdated = false;
		String sql = "UPDATE potluck SET name = ?, location = ?, potluck_date = ?, potluck_time = ?, "
				+ "description = ?, guests = ?, appetizers = ?, entrees = ?, side_dishes = ?, desserts = ?, alcohol = ?, non_alcohol = ? WHERE potluck_id = ?";

		try {
			int count = jdbcTemplate.update(sql, potluck.getName(), potluck.getLocation(), potluck.getPotluck_Date(),
					potluck.getPotluck_Time(), potluck.getDescription(), potluck.getGuests(), potluck.getAppetizers(),
					potluck.getEntrees(), potluck.getSide_dishes(), potluck.getDesserts(), potluck.getAlcohol(),
					potluck.getNon_alcohol(), potluck_id);
			potluckUpdated = (count == 1);
		} catch (DataAccessException e) {
			System.out.print(e);
		}
		return potluckUpdated;

	}

	@Override
	public boolean addGuests(Guest newGuest) {
		boolean guestCreated = false;
		String sql = "INSERT INTO guests (user_id, potluck_id) VALUES (?,?)";
		User[] guest = newGuest.getGuests();

		try {
			for (int i = 0; i < guest.length; i++) {
				int count = jdbcTemplate.update(sql, guest[i].getId(), newGuest.getPotluck_id());
				guestCreated = (count == 1);
			}
		} catch (DataAccessException e) {
			System.out.print(e);
		}
		return guestCreated;
	}

	@Override
	public List<Invite> getGuestDetails() {
		List<Invite> invite = new ArrayList<Invite>();
		String sql = "SELECT user_id, firstname, lastname, email FROM users WHERE user_id NOT IN (1,2)";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			invite.add(mapRowToGuest(results));
		}
		return invite;
	}

	private Invite mapRowToGuest(SqlRowSet rs) {
		Invite invite = new Invite();
		invite.setId(rs.getLong("user_id"));
		invite.setFirstName(rs.getString("firstname"));
		invite.setLastName(rs.getString("lastname"));
		invite.setEmail(rs.getString("email"));
		return invite;
	}

	private Potluck mapRowToPotluck(SqlRowSet rs) {
		Potluck potluck = new Potluck();
		potluck.setPotluck_id(rs.getLong("potluck_id"));
		potluck.setName(rs.getString("name"));
		potluck.setPotluck_Date(rs.getDate("potluck_date").toLocalDate());
		potluck.setPotluck_Time(rs.getTime("potluck_time").toLocalTime());
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

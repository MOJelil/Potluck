package com.techelevator.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.techelevator.model.RegisterUserDTO;
import com.techelevator.model.User;

@Service
public class UserSqlDAO implements UserDAO {

	private JdbcTemplate jdbcTemplate;

	private static final String ALL_FIELDS = "user_id, username, firstName, lastName, email, phone, password_hash, role";

	public UserSqlDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public User findByUsername(String username) throws UsernameNotFoundException {
		String sql = "SELECT " + ALL_FIELDS + " FROM users WHERE username = ?";
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, username);
		if (rs.next()) {
			return mapRowToUser(rs);
		} else {
			throw new UsernameNotFoundException("User " + username + " was not found.");
		}
	}

	@Override
	public boolean usernameExists(String username) {
		String sql = "SELECT 1 FROM users WHERE username = ?";
		SqlRowSet rs = jdbcTemplate.queryForRowSet(sql, username);
		return rs.next();
	}

	@Override
	public boolean create(RegisterUserDTO newUser) {
		boolean userCreated = false;
		String sql = "INSERT INTO users (username, firstName, lastName, email, phone, password_hash, role) VALUES (?,?,?,?,?,?,?)";

		String password_hash = new BCryptPasswordEncoder().encode(newUser.getPassword());
		String ssRole = "ROLE_" + newUser.getRole().toUpperCase();

		try {
			int count = jdbcTemplate.update(sql, newUser.getUsername(), newUser.getFirstName(), newUser.getLastName(),
					newUser.getEmail(), newUser.getPhone(), password_hash, ssRole);
			userCreated = (count == 1);
			// insert diet information
			for (String restriction : newUser.getDiet()) {
				String sqlDietaryRestrictions = "INSERT INTO user_diet VALUES ((SELECT user_id From users where username = ?),(SELECT dietary_id from dietary_restrictions where restriction_name =?))";
				int rs = jdbcTemplate.update(sqlDietaryRestrictions, newUser.getUsername(), restriction);
			}

		} catch (DataAccessException e) {
			// userCreated remains false
			System.out.print(e);
		}
		return userCreated;
	}

	private User mapRowToUser(SqlRowSet rs) {
		User user = new User();
		user.setId(rs.getLong("user_id"));
		user.setUsername(rs.getString("username"));
		user.setFirstName(rs.getString("firstName"));
		user.setLastName(rs.getString("lastName"));
		user.setEmail(rs.getString("email"));
		user.setPhone(rs.getString("phone"));
		user.setPassword(rs.getString("password_hash"));
		user.setAuthorities(rs.getString("role"));
		user.setActivated(true);
		return user;
	}
}

package com.itsqmet.todo.controller;

import com.itsqmet.todo.config.CDB;
import com.itsqmet.todo.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class LoginDAOImplement implements LoginDAO<User> {
	static Connection con = CDB.getConnection();
	PreparedStatement ps = null;
	

	@Override
	public User validate(User user) {
		User userLogin = new User();
		try {
			String query = "SELECT * FROM user where email=? and password=MD5(?)";

			ps = con.prepareStatement(query);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				userLogin.setIdUser(rs.getInt(1));
				userLogin.setFirstname(rs.getString(2));
				userLogin.setLastname(rs.getString(3));
				userLogin.setEmail(rs.getString(4));
				return userLogin;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	PreparedStatement stmt = null;

	@Override
	public User register() {
		User userLogin = new User();
		try {
			String query = "SELECT LAST_INSERT_ID()";
			stmt = (PreparedStatement) con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			Integer idUser = null;
			while (rs.next()) {
				idUser = rs.getInt(1);
			}
			query = "SELECT * FROM user where id_user=(?)";
			ps = con.prepareStatement(query);
			ps.setInt(1, idUser);
			rs = ps.executeQuery();
			if (rs.next()) {
				userLogin.setIdUser(rs.getInt(1));
				userLogin.setFirstname(rs.getString(2));
				userLogin.setLastname(rs.getString(3));
				userLogin.setEmail(rs.getString(4));
				return userLogin;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
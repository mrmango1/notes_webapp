package com.itsqmet.todo.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.itsqmet.todo.config.CDB;
import com.itsqmet.todo.model.User;
import com.mysql.cj.xdevapi.Statement;

public class UserDAOImplement implements DAO<User> {

	static Connection con = CDB.getConnection();
	CallableStatement cs = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	Statement st = null;

	@Override
	public boolean create(User user) {
		try {
			cs = con.prepareCall("{call Register(?,?,?,?)}");
			cs.setString(1, user.getFirstname());
			cs.setString(2, user.getLastname());
			cs.setString(3, user.getEmail());
			cs.setString(4, user.getPassword());
			return cs.executeUpdate() != 0;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public List<User> read(int idUser) {
		List<User> listUser = new ArrayList<>();
		try {
			String query = "SELECT * FROM user";
			rs = con.createStatement().executeQuery(query);
			while (rs.next()) {
				User user = new User();
				user.setIdUser(rs.getInt(1));
				user.setFirstname(rs.getString(2));
				user.setLastname(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setEmail(rs.getString(5));
				listUser.add(user);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return listUser;
	}

	@Override
	public boolean update(User user) {
		try {
			String query = "UPDATE user SET firstname=?,lastname=?,email=?,password=? where id_user=?";
			ps = con.prepareStatement(query);
			ps.setString(1, user.getFirstname());
			ps.setString(2, user.getLastname());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			ps.setInt(5, user.getIdUser());
			return ps.executeUpdate() != 0;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(User user) {
		try {
			String query = "DELETE FROM user where id_user=?";
			ps = con.prepareStatement(query);
			ps.setInt(1, user.getIdUser());
			return ps.executeUpdate() != 0;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
}

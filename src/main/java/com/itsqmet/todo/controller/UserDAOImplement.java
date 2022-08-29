package com.itsqmet.todo.controller;

import com.itsqmet.todo.config.CDB;
import com.itsqmet.todo.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImplement implements DAO<User> {

  static Connection con = CDB.getConnection();

  @Override
  public boolean create(User user) {
    try {
      String query = "INSERT INTO user(firstname, lastname, email, password) values(?,?,?,MD5(?))";
      PreparedStatement ps = con.prepareStatement(query);
      ps.setString(1, user.getFirstname());
      ps.setString(2, user.getLastname());
      ps.setString(3, user.getEmail());
      ps.setString(4, user.getPassword());
      return ps.executeUpdate() != 0;
    } catch (Exception ex) {
      ex.printStackTrace(System.out);
    }
    return false;
  }

  @Override
  public List<User> read(int id_user) {
    List<User> listUser = new ArrayList<>();
    try {
      String query = "SELECT * FROM user";
      ResultSet rs = con.createStatement().executeQuery(query);
      while (rs.next()) {
        User user = new User();
        user.setId_user(rs.getInt(1));
        user.setFirstname(rs.getString(2));
        user.setLastname(rs.getString(3));
        user.setPassword(rs.getString(4));
        user.setEmail(rs.getString(5));
        listUser.add(user);
      }
    } catch (Exception ex) {
      ex.printStackTrace(System.out);
    }
    return listUser;
  }

  @Override
  public boolean update(User user) {
    try {
      String query = "UPDATE user SET firstname=?,lastname=?,email=?,password=? where id_user=?";
      PreparedStatement ps = con.prepareStatement(query);
      ps.setString(1, user.getFirstname());
      ps.setString(2, user.getLastname());
      ps.setString(3, user.getEmail());
      ps.setString(4, user.getPassword());
      ps.setInt(5, user.getId_user());
      return ps.executeUpdate() != 0;
    } catch (Exception ex) {
      ex.printStackTrace(System.out);
    }
    return false;
  }

  @Override
  public boolean delete(User user) {
    try {
      String query = "DELETE FROM user where id_user=?";
      PreparedStatement ps = con.prepareStatement(query);
      ps.setInt(1, user.getId_user());
      return ps.executeUpdate() != 0;
    } catch (Exception ex) {
      ex.printStackTrace(System.out);
    }
    return false;
  }
}


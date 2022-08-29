package com.itsqmet.todo.controller;

import com.itsqmet.todo.config.CDB;
import com.itsqmet.todo.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDAOImplement implements LoginDAO<User> {
  static Connection con = CDB.getConnection();

  @Override
  public User validate(User user) {
    User userLogin = new User();
    try {
      String query = "SELECT * FROM user where email=? and password=MD5(?)";
      PreparedStatement ps = con.prepareStatement(query);
      ps.setString(1, user.getEmail());
      ps.setString(2, user.getPassword());
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        userLogin.setId_user(rs.getInt(1));
        userLogin.setFirstname(rs.getString(2));
        userLogin.setLastname(rs.getString(3));
        userLogin.setEmail(rs.getString(4));
        return userLogin;
      }
    } catch (Exception ex) {
      ex.printStackTrace(System.out);
    }
    return null;
  }

  @Override
  public User register() {
    User userLogin = new User();
    try {
      String query = "SELECT LAST_INSERT_ID()";
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery(query);
      Integer id_user = null;
      while (rs.next()) {
        id_user = rs.getInt(1);
      }
      query = "SELECT * FROM user where id_user=(?)";
      PreparedStatement ps = con.prepareStatement(query);
      ps.setInt(1, id_user);
      rs = ps.executeQuery();
      if (rs.next()) {
        userLogin.setId_user(rs.getInt(1));
        userLogin.setFirstname(rs.getString(2));
        userLogin.setLastname(rs.getString(3));
        userLogin.setEmail(rs.getString(4));
        return userLogin;
      }
    } catch (Exception ex) {
      ex.printStackTrace(System.out);
    }
    return null;
  }
}
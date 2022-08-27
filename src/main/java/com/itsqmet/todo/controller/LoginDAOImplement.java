package com.itsqmet.todo.controller;

import com.itsqmet.todo.config.CDB;
import com.itsqmet.todo.model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDAOImplement implements LoginDAO<Person> {
  static Connection con = CDB.getConnection();

  @Override
  public Person validate(Person person) {
    Person userLogin = new Person();
    try {
      String query = "SELECT * FROM person where email=? and password=MD5(?)";
      PreparedStatement ps = con.prepareStatement(query);
      ps.setString(1, person.getEmail());
      ps.setString(2, person.getPassword());
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        userLogin.setId_person(rs.getInt(1));
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
  public Person register() {
    Person userLogin = new Person();
    try {
      String query = "SELECT LAST_INSERT_ID()";
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery(query);
      Integer id_person = null;
      while (rs.next()) {
        id_person = rs.getInt(1);
      }
      query = "SELECT * FROM person where id_person=(?)";
      PreparedStatement ps = con.prepareStatement(query);
      ps.setInt(1, id_person);
      rs = ps.executeQuery();
      if (rs.next()) {
        userLogin.setId_person(rs.getInt(1));
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
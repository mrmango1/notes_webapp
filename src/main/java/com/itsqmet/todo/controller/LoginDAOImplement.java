package com.itsqmet.todo.controller;

import com.itsqmet.todo.config.CDB;
import com.itsqmet.todo.model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAOImplement implements LoginDAO<Person>{
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
}

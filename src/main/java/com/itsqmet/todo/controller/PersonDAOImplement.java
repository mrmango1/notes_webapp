package com.itsqmet.todo.controller;

import com.itsqmet.todo.config.CDB;
import com.itsqmet.todo.model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonDAOImplement implements DAO<Person> {

  static Connection con = CDB.getConnection();

  @Override
  public boolean create(Person person) {
    try {
      String query = "INSERT INTO person(firstname, lastname, email, password) values(?,?,?,MD5(?))";
      PreparedStatement ps = con.prepareStatement(query);
      ps.setString(1, person.getFirstname());
      ps.setString(2, person.getLastname());
      ps.setString(3, person.getEmail());
      ps.setString(4, person.getPassword());
      return ps.executeUpdate() != 0;
    } catch (Exception ex) {
      ex.printStackTrace(System.out);
    }
    return false;
  }

  @Override
  public List<Person> read(int id_person) {
    List<Person> listPerson = new ArrayList<>();
    try {
      String query = "SELECT * FROM person";
      ResultSet rs = con.createStatement().executeQuery(query);
      while (rs.next()) {
        Person person = new Person();
        person.setId_person(rs.getInt(1));
        person.setFirstname(rs.getString(2));
        person.setLastname(rs.getString(3));
        person.setPassword(rs.getString(4));
        person.setEmail(rs.getString(5));
        listPerson.add(person);
      }
    } catch (Exception ex) {
      ex.printStackTrace(System.out);
    }
    return listPerson;
  }

  @Override
  public boolean update(Person person) {
    try {
      String query = "UPDATE person SET firstname=?,lastname=?,email=?,password=? where id_person=?";
      PreparedStatement ps = con.prepareStatement(query);
      ps.setString(1, person.getFirstname());
      ps.setString(2, person.getLastname());
      ps.setString(3, person.getEmail());
      ps.setString(4, person.getPassword());
      ps.setInt(5, person.getId_person());
      return ps.executeUpdate() != 0;
    } catch (Exception ex) {
      ex.printStackTrace(System.out);
    }
    return false;
  }

  @Override
  public boolean delete(Person person) {
    try {
      String query = "DELETE FROM person where id_person=?";
      PreparedStatement ps = con.prepareStatement(query);
      ps.setInt(1, person.getId_person());
      return ps.executeUpdate() != 0;
    } catch (Exception ex) {
      ex.printStackTrace(System.out);
    }
    return false;
  }
}


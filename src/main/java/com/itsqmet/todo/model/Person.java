package com.itsqmet.todo.model;

public class Person {
  private int id_person;
  private String firstname;
  private String lastname;
  private String email;
  private String password;

  public int getId_person() {
    return id_person;
  }

  public void setId_person(int id_person) {
    this.id_person = id_person;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}

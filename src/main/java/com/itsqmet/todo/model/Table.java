package com.itsqmet.todo.model;

public class Table {
  private int id_table;
  private int id_user;
  private String title;
  private String description;
  private String color;

  public int getId_table() {
    return id_table;
  }

  public void setId_table(int id_table) {
    this.id_table = id_table;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getId_user() {
    return id_user;
  }

  public void setId_user(int id_user) {
    this.id_user = id_user;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }
}

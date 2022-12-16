package com.itsqmet.todo.model;

public class Table {
  private int idTable;
  private int idUser;
  private String title;
  private String description;
  private String color;

  public int getIdTable() {
    return idTable;
  }

  public void setIdTable(int idTable) {
    this.idTable = idTable;
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

  public int getIdUser() {
    return idUser;
  }

  public void setIdUser(int idUser) {
    this.idUser = idUser;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }
}

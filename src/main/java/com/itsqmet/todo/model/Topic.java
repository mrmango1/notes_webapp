package com.itsqmet.todo.model;

public class Topic {
  private int idTopic;
  private int idTable;
  private String name;
  private String description;

  public int getIdTopic() {
    return idTopic;
  }

  public void setIdTopic(int idTopic) {
    this.idTopic = idTopic;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getIdTable() {
    return idTable;
  }
  public void setIdTable(int idTable) {
    this.idTable = idTable;
  }
}

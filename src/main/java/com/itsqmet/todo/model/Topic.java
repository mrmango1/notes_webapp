package com.itsqmet.todo.model;

public class Topic {
  private int id_topic;
  private String name;
  private String description;

  public int getId_topic() {
    return id_topic;
  }

  public void setId_topic(int id_topic) {
    this.id_topic = id_topic;
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
}

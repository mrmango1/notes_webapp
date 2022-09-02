package com.itsqmet.todo.model;

import java.sql.Date;
import java.sql.Timestamp;

public class Task {
  private int id_task;
  private int id_table;
  private String importance;
  private String title;
  private String description;
  private String name;
  private Timestamp created_at;
  private Date limit_date;
  private boolean done;

  public int getId_task() {
    return id_task;
  }

  public void setId_task(int id_task) {
    this.id_task = id_task;
  }

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

  public Timestamp getCreated_at() {
    return created_at;
  }

  public void setCreated_at(Timestamp created_at) {
    this.created_at = created_at;
  }

  public Date getLimit_date() {
    return limit_date;
  }

  public void setLimit_date(Date limit_date) {
    this.limit_date = limit_date;
  }

  public boolean isDone() {
    return done;
  }

  public void setDone(boolean done) {
    this.done = done;
  }

  public String getImportance() {
    return importance;
  }

  public void setImportance(String importance) {
    this.importance = importance;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
}

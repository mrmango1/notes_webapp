package com.itsqmet.todo.model;

import java.sql.Date;
import java.sql.Timestamp;

public class Task {
  private int idTask;
  private int idTable;
  private String importance;
  private String title;
  private String description;
  private String name;
  private Timestamp createdAt;
  private Date limitDate;
  private boolean done;

  public int getIdTask() {
    return idTask;
  }

  public void setIdTask(int idTask) {
    this.idTask = idTask;
  }

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

  public Timestamp getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Timestamp createdAt) {
    this.createdAt = createdAt;
  }

  public Date getLimitDate() {
    return limitDate;
  }

  public void setLimitDate(Date limitDate) {
    this.limitDate = limitDate;
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

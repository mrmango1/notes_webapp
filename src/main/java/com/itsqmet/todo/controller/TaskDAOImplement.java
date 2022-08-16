package com.itsqmet.todo.controller;

import com.itsqmet.todo.config.CDB;
import com.itsqmet.todo.model.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TaskDAOImplement implements DAO<Task> {
  static Connection con = CDB.getConnection();

  @Override
  public boolean create(Task task) {
    try {
      String query = "INSERT INTO task(id_table, title, description, importance, " +
        "created_at, update_at, limit_date, done) values(?,?,?,?,?,?,?,?)";
      PreparedStatement ps = con.prepareStatement(query);
      ps.setInt(1, task.getId_table());
      ps.setString(2, task.getTitle());
      ps.setString(3, task.getDescription());
      ps.setInt(4, task.getImportance());
      ps.setTimestamp(5,task.getCreated_at());
      ps.setTimestamp(6,task.getUpdate_at());
      ps.setTimestamp(7,task.getLimit_date());
      ps.setBoolean(8, task.isDone());
      return ps.executeUpdate() != 0;
    } catch (Exception ex) {
      ex.printStackTrace(System.out);
    }
    return false;
  }

  @Override
  public List<Task> read() {
    List<Task> listTask = new ArrayList<>();
    try {
      String query = "SELECT * FROM task";
      ResultSet rs = con.createStatement().executeQuery(query);
      while (rs.next()) {
        Task task = new Task();
        task.setId_task(rs.getInt(1));
        task.setId_table(rs.getInt(2));
        task.setTitle(rs.getString(3));
        task.setDescription(rs.getString(4));
        task.setImportance(rs.getInt(5));
        task.setCreated_at(rs.getTimestamp(6));
        task.setUpdate_at(rs.getTimestamp(7));
        task.setLimit_date(rs.getTimestamp(8));
        task.setDone(rs.getBoolean(9));
        listTask.add(task);
      }
    } catch (Exception ex) {
      ex.printStackTrace(System.out);
    }
    return listTask;
  }

  @Override
  public boolean update(Task task) {
    try {
      String query = "UPDATE `task` SET title=?,description=?, importance=?," +
        "created_at=?,update_at=?,limit_date=?,done=? where id_task=?";
      PreparedStatement ps = con.prepareStatement(query);
      ps.setString(1, task.getTitle());
      ps.setString(2, task.getDescription());
      ps.setInt(3, task.getImportance());
      ps.setTimestamp(4,task.getCreated_at());
      ps.setTimestamp(5,task.getUpdate_at());
      ps.setTimestamp(6,task.getLimit_date());
      ps.setBoolean(7, task.isDone());
      ps.setInt(8, task.getId_task());
      return ps.executeUpdate() != 0;
    } catch (Exception ex) {
      ex.printStackTrace(System.out);
    }
    return false;
  }

  @Override
  public boolean delete(Task task) {
    try {
      String query = "DELETE FROM `task` where id_task=?";
      PreparedStatement ps = con.prepareStatement(query);
      ps.setInt(1, task.getId_task());
      return ps.executeUpdate() != 0;
    } catch (Exception ex) {
      ex.printStackTrace(System.out);
    }
    return false;
  }
}

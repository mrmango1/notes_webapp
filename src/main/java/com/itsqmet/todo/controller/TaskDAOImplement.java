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
        "limit_date) values(?,?,?,?,?)";
      PreparedStatement ps = con.prepareStatement(query);
      ps.setInt(1, task.getId_table());
      ps.setString(2, task.getTitle());
      ps.setString(3, task.getDescription());
      ps.setInt(4, task.getImportance());
      ps.setTimestamp(5,task.getLimit_date());
      return ps.executeUpdate() != 0;
    } catch (Exception ex) {
      ex.printStackTrace(System.out);
    }
    return false;
  }

  @Override
  public List<Task> read(int id_table) {
    List<Task> listTask = new ArrayList<>();
    try {
      String query = "SELECT * FROM task where id_table=?";
      PreparedStatement ps = con.prepareStatement(query);
      ps.setInt(1, id_table);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        Task task = new Task();
        task.setId_task(rs.getInt(1));
        task.setId_table(rs.getInt(2));
        task.setTitle(rs.getString(3));
        task.setDescription(rs.getString(4));
        task.setImportance(rs.getInt(5));
        task.setCreated_at(rs.getTimestamp(6));
        task.setLimit_date(rs.getTimestamp(7));
        task.setDone(rs.getBoolean(8));
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
        "limit_date=?,done=? where id_task=?";
      PreparedStatement ps = con.prepareStatement(query);
      ps.setString(1, task.getTitle());
      ps.setString(2, task.getDescription());
      ps.setInt(3, task.getImportance());
      ps.setTimestamp(4,task.getLimit_date());
      ps.setBoolean(5, task.isDone());
      ps.setInt(6, task.getId_task());
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

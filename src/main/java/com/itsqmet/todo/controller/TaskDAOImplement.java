package com.itsqmet.todo.controller;

import com.itsqmet.todo.config.CDB;
import com.itsqmet.todo.model.Task;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TaskDAOImplement implements DAO<Task> {
  static Connection con = CDB.getConnection();
  PreparedStatement ps = null; 
  CallableStatement cs =null;
  @Override
  public boolean create(Task task) {
    try {
      String query = "INSERT INTO task(id_table, title, description, importance, " +
          "limit_date) values(?,?,?,intImportance(?),?)";
      ps = con.prepareStatement(query);
      ps.setInt(1, task.getIdTable());
      ps.setString(2, task.getTitle());
      ps.setString(3, task.getDescription());
      ps.setString(4, task.getImportance());
      ps.setDate(5, task.getLimitDate());
      return ps.executeUpdate() != 0;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return false;
  }

  @Override
  public List<Task> read(int idTable) {
    List<Task> listTask = new ArrayList<>();
    try {
      cs = con.prepareCall("{call notesDetail(?)}");
      cs.setInt(1, idTable);
      ResultSet rs = cs.executeQuery();
      while (rs.next()) {
        Task task = new Task();
        task.setIdTask(rs.getInt(1));
        task.setTitle(rs.getString(2));
        task.setDescription(rs.getString(3));
        task.setImportance(rs.getString(4));
        task.setLimitDate(rs.getDate(5));
        task.setDone(rs.getBoolean(6));
        task.setName(rs.getString(7));
        listTask.add(task);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return listTask;
  }

  @Override
  public boolean update(Task task) {
    try {
      String query = "UPDATE `task` SET title=?,description=?,importance=intImportance(?)," +
          "limit_date=?,done=? where id_task=?";
      ps = con.prepareStatement(query);
      ps.setString(1, task.getTitle());
      ps.setString(2, task.getDescription());
      ps.setString(3, task.getImportance());
      ps.setDate(4, task.getLimitDate());
      ps.setBoolean(5, task.isDone());
      ps.setInt(6, task.getIdTask());
      return ps.executeUpdate() != 0;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return false;
  }

  @Override
  public boolean delete(Task task) {
    try {
      String query = "DELETE FROM `task` where id_task=?";
      ps = con.prepareStatement(query);
      ps.setInt(1, task.getIdTask());
      return ps.executeUpdate() != 0;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return false;
  }

  public String importance(String importance) {
    switch (importance) {
      case "0":
        return "Tomate tu tiempo";
      case "1":
        return "No es importante";
      case "2":
        return "Regular";
      case "3":
        return "Es importante";
      case "4":
        return "Urgente";
      default:
        return "";
    }
  }
}

package com.itsqmet.todo.controller;

import com.itsqmet.todo.config.CDB;
import com.itsqmet.todo.model.TaskTopic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class TaskTopicDAOImplement implements DAO<TaskTopic>{
  static Connection con = CDB.getConnection();
  PreparedStatement stmt = null; 
  PreparedStatement ps = null;
  ResultSet rs =null;
  @Override
  public boolean create(TaskTopic taskTopic) {
    try {
      String query1 = "SELECT LAST_INSERT_ID()";
      stmt = (PreparedStatement) con.createStatement();
      rs = stmt.executeQuery(query1);
      Integer idTopic = null;
      while (rs.next()) {
        idTopic = rs.getInt(1);
      }
      String query2 = "INSERT INTO topic_has_task(id_task, id_topic) values(?,?)";
      ps = con.prepareStatement(query2);
      ps.setInt(2, taskTopic.getIdTask());
      ps.setInt(1, idTopic);
      return ps.executeUpdate() != 0;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return false;
  }

  @Override
  public List<TaskTopic> read(int id) {
    List<TaskTopic> listTaskTopic = new ArrayList<>();
    try {
      String query = "SELECT * FROM task_has_topic";
      rs = con.createStatement().executeQuery(query);
      while (rs.next()) {
        TaskTopic topic = new TaskTopic();
        topic.setIdTask(rs.getInt(1));
        topic.setIdTable(rs.getInt(2));
        topic.setIdTopic(rs.getInt(3));
        listTaskTopic.add(topic);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return listTaskTopic;
  }

  @Override
  public boolean update(TaskTopic taskTopic) {
    try {
      String query = "UPDATE task_has_topic SET id_table=?,id_topic=? where id_task=?";
      ps = con.prepareStatement(query);
      ps.setInt(1, taskTopic.getIdTable());
      ps.setInt(2, taskTopic.getIdTopic());
      ps.setInt(3, taskTopic.getIdTable());
      return ps.executeUpdate() != 0;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return false;
  }

  @Override
  public boolean delete(TaskTopic topic) {
    try {
      String query = "DELETE FROM task_has_topic where id_task=? and id_topic=?";
      ps = con.prepareStatement(query);
      ps.setInt(1, topic.getIdTopic());
      ps.setInt(2, topic.getIdTopic());
      return ps.executeUpdate() != 0;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return false;
  }
}

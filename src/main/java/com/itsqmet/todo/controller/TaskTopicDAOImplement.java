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
      ps.setInt(2, taskTopic.getId_task());
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
        topic.setId_task(rs.getInt(1));
        topic.setId_table(rs.getInt(2));
        topic.setId_topic(rs.getInt(3));
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
      ps.setInt(1, taskTopic.getId_table());
      ps.setInt(2, taskTopic.getId_topic());
      ps.setInt(3, taskTopic.getId_table());
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
      ps.setInt(1, topic.getId_topic());
      ps.setInt(2, topic.getId_topic());
      return ps.executeUpdate() != 0;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return false;
  }
}

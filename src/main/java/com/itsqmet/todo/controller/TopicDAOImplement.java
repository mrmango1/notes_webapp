package com.itsqmet.todo.controller;

import com.itsqmet.todo.config.CDB;
import com.itsqmet.todo.model.Topic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TopicDAOImplement implements DAO<Topic> {
  static Connection con = CDB.getConnection();
  PreparedStatement ps = null; 
  @Override
  public boolean create(Topic task) {
    try {
      String query = "INSERT INTO topic(id_table, name, description) values(?,?,?)";
      ps = con.prepareStatement(query);
      ps.setInt(1, task.getIdTable());
      ps.setString(2, task.getName());
      ps.setString(3, task.getDescription());
      return ps.executeUpdate() != 0;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return false;
  }

  @Override
  public List<Topic> read(int idTable) {
    List<Topic> listTopic = new ArrayList<>();
    try {
      String query = "SELECT id_topic, name , description FROM topic where id_table = ?";
      ps = con.prepareStatement(query);
      ps.setInt(1, idTable);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        Topic topic = new Topic();
        topic.setIdTopic(rs.getInt(1));
        topic.setName(rs.getString(2));
        topic.setDescription(rs.getString(3));
        listTopic.add(topic);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return listTopic;
  }

  @Override
  public boolean update(Topic task) {
    try {
      String query = "UPDATE topic SET name=?,description=? where id_topic=?";
      ps = con.prepareStatement(query);
      ps.setString(1, task.getName());
      ps.setString(2, task.getDescription());
      ps.setInt(3, task.getIdTopic());
      return ps.executeUpdate() != 0;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return false;
  }

  @Override
  public boolean delete(Topic topic) {
    try {
      String query = "DELETE FROM topic where id_topic=?";
      ps = con.prepareStatement(query);
      ps.setInt(1, topic.getIdTopic());
      return ps.executeUpdate() != 0;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return false;
  }
}

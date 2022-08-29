package com.itsqmet.todo.controller;

import com.itsqmet.todo.config.CDB;
import com.itsqmet.todo.model.Table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TableDAOImplement implements DAO<Table>{
  static Connection con = CDB.getConnection();

  @Override
  public boolean create(Table table) {
    try {
      String query = "INSERT INTO `table`(id_user, title, description, color) values(?,?,?,?)";
      PreparedStatement ps = con.prepareStatement(query);
      ps.setInt(1, table.getId_user());
      ps.setString(2, table.getTitle());
      ps.setString(3, table.getDescription());
      ps.setString(4, table.getColor());
      return ps.executeUpdate() != 0;
    } catch (Exception ex) {
      ex.printStackTrace(System.out);
    }
    return false;
  }

  @Override
  public List<Table> read(int id_user) {
    List<Table> listTable = new ArrayList<>();
    try {
      String query = "SELECT * FROM `table` where id_user=?";
      PreparedStatement ps = con.prepareStatement(query);
      ps.setInt(1, id_user);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        Table table = new Table();
        table.setId_table(rs.getInt(1));
        table.setTitle(rs.getString(3));
        table.setDescription(rs.getString(4));
        table.setColor(rs.getString(5));
        listTable.add(table);
      }
    } catch (Exception ex) {
      ex.printStackTrace(System.out);
    }
    return listTable;
  }

  @Override
  public boolean update(Table table) {
    try {
      String query = "UPDATE `table` SET title=?,description=?,color=? where id_table=?";
      PreparedStatement ps = con.prepareStatement(query);
      ps.setString(1, table.getTitle());
      ps.setString(2, table.getDescription());
      ps.setString(3, table.getColor());
      ps.setInt(4, table.getId_table());
      return ps.executeUpdate() != 0;
    } catch (Exception ex) {
      ex.printStackTrace(System.out);
    }
    return false;
  }

  @Override
  public boolean delete(Table table) {
    try {
      String query = "DELETE FROM `table` where id_table=?";
      PreparedStatement ps = con.prepareStatement(query);
      ps.setInt(1, table.getId_table());
      return ps.executeUpdate() != 0;
    } catch (Exception ex) {
      ex.printStackTrace(System.out);
    }
    return false;
  }
}

package com.itsqmet.todo.controller;

import com.itsqmet.todo.config.CDB;
import com.itsqmet.todo.model.Table;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TableDAOImplement implements DAO<Table>{
  static Connection con = CDB.getConnection();
  PreparedStatement ps = null;
  CallableStatement cs =null;

  @Override
  public boolean create(Table table) {
    try {
      String query = "INSERT INTO `table`(id_user, title, description, color) values(?,?,?,?)";
      ps = con.prepareStatement(query);
      ps.setInt(1, table.getIdUser());
      ps.setString(2, table.getTitle());
      ps.setString(3, table.getDescription());
      ps.setString(4, table.getColor());
      return ps.executeUpdate() != 0;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return false;
  }

  @Override
  public List<Table> read(int idUser) {
    List<Table> listTable = new ArrayList<>();
    try {
      cs = con.prepareCall("{call userTables(?)}");
      cs.setInt(1, idUser);
      ResultSet rs = cs.executeQuery();
      while (rs.next()) {
        Table table = new Table();
        table.setIdTable(rs.getInt(1));
        table.setTitle(rs.getString(2));
        table.setDescription(rs.getString(3));
        table.setColor(rs.getString(4));
        listTable.add(table);
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return listTable;
  }

  @Override
  public boolean update(Table table) {
    try {
      String query = "UPDATE `table` SET title=?,description=?,color=? where id_table=?";
      ps = con.prepareStatement(query);
      ps.setString(1, table.getTitle());
      ps.setString(2, table.getDescription());
      ps.setString(3, table.getColor());
      ps.setInt(4, table.getIdTable());
      return ps.executeUpdate() != 0;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return false;
  }

  @Override
  public boolean delete(Table table) {
    try {
      String query = "DELETE FROM `table` where id_table=?";
      ps = con.prepareStatement(query);
      ps.setInt(1, table.getIdTable());
      return ps.executeUpdate() != 0;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return false;
  }
}

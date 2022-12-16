package com.itsqmet.todo.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.itsqmet.todo.config.CDB;
import com.itsqmet.todo.model.Table;

public class CurrentDAOImplement implements CurrentDAO<Table> {
  static Connection con = CDB.getConnection();
  
  PreparedStatement ps = null; 

  @Override
  public Table currentTable(int idTable) {
    Table table = new Table();
    try {
      String query = "SELECT * FROM `table` where id_table=?";
      ps = con.prepareStatement(query);
      ps.setInt(1, idTable);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        table.setIdTable(rs.getInt(1));
        table.setTitle(rs.getString(3));
        table.setDescription(rs.getString(4));
        table.setColor(rs.getString(5));
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return table;
  }

}

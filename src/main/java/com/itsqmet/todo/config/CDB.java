package com.itsqmet.todo.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class CDB {
  private static Connection con;

  static {
    String databaseName = "to-do";
    String url = "jdbc:mysql://localhost:3306/" + databaseName;
    String user = "demo_java";
    String password = "1234";
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      con = DriverManager.getConnection(url, user, password);
    } catch (Exception ex) {
      ex.printStackTrace(System.out);
    }
  } 

  public static Connection getConnection() {
    return con;
  }

}

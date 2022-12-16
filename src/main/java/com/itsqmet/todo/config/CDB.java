package com.itsqmet.todo.config;

import java.sql.Connection;
import java.sql.DriverManager;

//@Slf4j
public class CDB {
	private CDB() {

	}

	private static Connection con;

	static {
		String databaseName = "to-do";
		String url = "jdbc:mysql://localhost:3306/" + databaseName;
		String user = "root";
		String password = "PAU534297OK";
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

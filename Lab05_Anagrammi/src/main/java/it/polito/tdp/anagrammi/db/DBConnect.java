package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariDataSource;

public class DBConnect {
	static private final String jdbcUrl = "jdbc:mysql://localhost/dizionario?user=root&password=Ciao!123";
	static private HikariDataSource ds=null;
	public static Connection getConnection() {
		if(ds==null) {
			ds= new HikariDataSource();
			ds.setJdbcUrl(jdbcUrl);
			
		}
		try {
				Connection connection = DriverManager.getConnection(jdbcUrl);
				return connection;

		} catch (SQLException e) {

			e.printStackTrace();
			throw new RuntimeException("Cannot get a connection " + jdbcUrl, e);
		}
	}
}

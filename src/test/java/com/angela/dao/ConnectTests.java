package com.angela.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectTests {

//	@Test
//	public void test1() {
//		int v1 = 10;
//		int v2 = 10;
//		
//		Assertions.assertEquals(v1, v2);
//	}

	@Test
	public void testConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/webdb", "root", "1234");

		Assertions.assertNotNull(connection);
		
		System.out.println("connection: " + connection);
		//반드시 connection은 close() 해야함.
		connection.close();
	}
	
	
	@Test
	public void testHikariCP() throws Exception{
		
		HikariConfig config =  new HikariConfig();
		config.setDriverClassName("com.mysql.cj.jdbc.Driver");
		config.setJdbcUrl("jdbc:mysql://localhost:3306/webdb");
		config.setUsername("root");
		config.setPassword("1234");
		config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

		
		HikariDataSource ds = new HikariDataSource(config);
		Connection connection = ds.getConnection();
		
		System.out.println(connection);
		connection.close();
		
	}
}

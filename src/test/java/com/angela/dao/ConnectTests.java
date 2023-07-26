package com.angela.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConnectTests {

	@Test
	public void test1() {
		int v1 = 10;
		int v2 = 10;
		
		Assertions.assertEquals(v1, v2);

	}

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
}

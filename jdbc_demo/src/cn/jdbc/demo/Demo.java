package cn.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class Demo {
	@Test
	public void fun1() throws ClassNotFoundException, SQLException {
		/*
		 * Four configuration parameters
		 * driveClassName: com.mysql.cj.jdbc.Driver
		 * url: jdbc.mysql:localhost:3306/jdbcdb
		 * username: root
		 * password: 123456
		 */
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/jdbcdb";
		String username = "root";
		String password = "123456";
		
		Connection connection = DriverManager.getConnection(url, username, password);
		System.out.println(connection);
		
	}
}

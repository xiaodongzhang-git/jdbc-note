package cn.jdbc.demo4;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*
 * JdbcUtils v1.0
 */
public class JdbcUtils {
	private static Properties props = null;
	// ここに置くと、一度だけ実行されます
	static {
		try {
			// loader properties file
			InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("dbconfig.properties");
			props = new Properties();
			props.load(in);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
		try {
			Class.forName(props.getProperty("driverClassName"));
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Connection getConnection() throws SQLException {
		// get Connection object
		return DriverManager.getConnection(props.getProperty("url"),
				props.getProperty("username"),
				props.getProperty("password"));
	}
}

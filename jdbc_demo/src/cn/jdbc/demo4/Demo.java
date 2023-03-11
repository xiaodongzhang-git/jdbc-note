package cn.jdbc.demo4;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Demo {
	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		Connection con = JdbcUtils.getConnection();
		System.out.println(con);
	}
}

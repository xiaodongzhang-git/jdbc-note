package cn.jdbc.demo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 定義パラメータ
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		// trye catch finnally
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbcdb";
			String username = "root";
			String password = "123456";
			
			con = DriverManager.getConnection(url, username, password);
			stmt = con.createStatement();
			
			String queryString = "select * from student";
			rs = stmt.executeQuery(queryString);
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String email = rs.getString("email");
				System.out.println(id + ": " + email);
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			// 判定空
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}
	}
}

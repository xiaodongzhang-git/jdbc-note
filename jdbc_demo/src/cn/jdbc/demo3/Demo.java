package cn.jdbc.demo3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo {
	// アンチ SQL インジェクション攻撃 demo
	public static boolean login1(String uname, String pwd) throws Exception {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbcdb";
			String username = "root";
			String password = "123456";
			
			con = DriverManager.getConnection(url, username, password);
			stmt = con.createStatement();
			
			String queryString = "select * from login_user where username='" + uname + "' and password='" + pwd + "'";
			System.out.println(queryString);
			rs = stmt.executeQuery(queryString);
			
			return rs.next();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(con != null) con.close();
		}
	}
	
	// PreparedStatementの書き方
	public static boolean login2(String uname, String pwd) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbcdb";
			String username = "root";
			String password = "123456";
			
			con = DriverManager.getConnection(url, username, password);

			// 1. SQL テンプレートを提供する
			String sql = "select * from login_user where username=? and password=?";
			// 2. get PreparedStatement
			pstmt = con.prepareStatement(sql);
			// 3. テンプレートの?に値を割り当てます
			pstmt.setString(1, uname);
			pstmt.setString(2, pwd);
			// 3. execute
			rs = pstmt.executeQuery();
			
			System.out.println(sql);
			return rs.next();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		}
	}
	
	public static void main(String[] args) throws Exception {
		String uname = "a' or 'a'='a";
		String pwd = "a' or 'a'='a";
//		System.out.println(login1(uname, pwd));
		System.out.println(login2(uname, pwd));
	}
}

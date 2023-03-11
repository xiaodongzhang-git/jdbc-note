package cn.jdbc.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/jdbcdb";
		String username = "root";
		String password = "123456";
		
		Connection con = DriverManager.getConnection(url, username, password);
		
		// 1. Statementオブジェクトを取得
		Statement stmt = con.createStatement();
		// 2. SQL文を定義
		// create
//		String sql = "INSERT INTO student (name, email, age, gender) VALUES\n"
//				+ "('John Smith', 'john.smith@example.com', 20, 'Male'),\n"
//				+ "('Jane Doe', 'jane.doe@example.com', 22, 'Female'),\n"
//				+ "('Bob Johnson', 'bob.johnson@example.com', 18, 'Male'),\n"
//				+ "('Sara Williams', 'sara.williams@example.com', 21, 'Female')";
		// update
//		String sql = "UPDATE student SET name='Sara Sun', email='sara.sun@example.com' where id=4";
		// delete
//		String sql = "DELETE FROM student where id=1";
		// 3. SQL文を実行
//		int res = stmt.executeUpdate(sql);
//		System.out.println(res);
		
		// query!!!!
		String queryString = "select * from student";
		ResultSet rs = stmt.executeQuery(queryString);
		// rsの解析
		while(rs.next()) { // カーソルが 1 行下に移動し、存在するかどうかを判断
			int id = rs.getInt(1); // 列数で
			String name = rs.getString("name"); //列名で
			System.out.println(id + ": " + name);
		}
		
		/*
		 * リソースを閉じる
		 * 前後逆に
		 */
		rs.close();
		stmt.close();
		con.close();
	}
}

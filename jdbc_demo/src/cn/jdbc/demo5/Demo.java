package cn.jdbc.demo5;

import java.sql.SQLException;
import java.util.List;

public class Demo {
	public static void main(String[] args) throws SQLException {
		EmployeeDAO dao = new EmployeeDAO();
		List<Employee> es = dao.getAllEmployees();
		for (Employee e : es) {
            System.out.println(e.getId() + ": " + e.getName() + ": " + e.getAge());
        }
	}
}

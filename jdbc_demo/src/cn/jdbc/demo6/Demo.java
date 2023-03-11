package cn.jdbc.demo6;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.jdbc.demo4.JdbcUtils;

public class Demo {
    public static void main(String[] args) {

        try (Connection conn = JdbcUtils.getConnection();) {
            conn.setAutoCommit(false); // disable auto-commit mode

            // Create a PreparedStatement to insert new employees into the database
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO employees (name, age, salary) VALUES (?, ?, ?)");

            // Add multiple employees to the batch
            pstmt.setString(1, "Alice");
            pstmt.setInt(2, 30);
            pstmt.setDouble(3, 50000);
            pstmt.addBatch();

            pstmt.setString(1, "Bob");
            pstmt.setInt(2, 25);
            pstmt.setDouble(3, 40000);
            pstmt.addBatch();

            pstmt.setString(1, "Charlie");
            pstmt.setInt(2, 35);
            pstmt.setDouble(3, 60000);
            pstmt.addBatch();

            // Execute the batch update
            int[] batchResult = pstmt.executeBatch();

            // Commit the changes
            conn.commit();

            System.out.println("Successfully added " + batchResult.length + " employees to the database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

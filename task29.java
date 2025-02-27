import java.sql.*;

public class StudentDatabase {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;

        try {
            String url = "jdbc:mysql://localhost:3306/your_database";
            String user = "your_username";
            String password = "your_password";
            conn = DriverManager.getConnection(url, user, password);

            // Insert Student
            String insertQuery = "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";
            pstmt = conn.prepareStatement(insertQuery);
            pstmt.setInt(1, 1);
            pstmt.setString(2, "John Doe");
            pstmt.setInt(3, 20);
            pstmt.executeUpdate();

            // Update Student
            String updateQuery = "UPDATE students SET age = ? WHERE id = ?";
            pstmt = conn.prepareStatement(updateQuery);
            pstmt.setInt(1, 21);
            pstmt.setInt(2, 1);
            pstmt.executeUpdate();

            // Delete Student
            String deleteQuery = "DELETE FROM students WHERE id = ?";
            pstmt = conn.prepareStatement(deleteQuery);
            pstmt.setInt(1, 1);
            pstmt.executeUpdate();

            // Retrieve Student Records
            String selectQuery = "SELECT * FROM students";
            pstmt = conn.prepareStatement(selectQuery);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println(id + ": " + name + ", " + age);
            }


            String storedProcedureQuery = "{CALL getEmployeeDetails(?)}";
            cstmt = conn.prepareCall(storedProcedureQuery);
            cstmt.setInt(1, 1);
            rs = cstmt.executeQuery();
            while (rs.next()) {
                int empId = rs.getInt("emp_id");
                String empName = rs.getString("emp_name");
                String empPosition = rs.getString("emp_position");
                System.out.println(empId + ": " + empName + ", " + empPosition);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (cstmt != null) cstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

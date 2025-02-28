import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BankingSystem {

    private static final String URL = "jdbc:mysql://localhost:3306/bank";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            conn.setAutoCommit(false);

            String insertTransaction = "INSERT INTO transactions (account_from, account_to, amount) VALUES (?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertTransaction)) {
                pstmt.setString(1, "ACC001");
                pstmt.setString(2, "ACC002");
                pstmt.setDouble(3, 500.00);
                pstmt.addBatch();

                pstmt.setString(1, "ACC002");
                pstmt.setString(2, "ACC003");
                pstmt.setDouble(3, 300.00);
                pstmt.addBatch();

                pstmt.setString(1, "ACC003");
                pstmt.setString(2, "ACC004");
                pstmt.setDouble(3, 100.00);
                pstmt.addBatch();

                int[] result = pstmt.executeBatch();
                conn.commit();
                System.out.println("Transactions committed successfully");
            } catch (SQLException e) {
                conn.rollback();
                System.out.println("Transaction failed, rollback executed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

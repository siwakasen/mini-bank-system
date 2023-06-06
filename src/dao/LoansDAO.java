
package dao;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.Statement;


public class LoansDAO {
    private DbConnection DbCon = new DbConnection();
    private Connection conn;

    public void insertLoan(String loan_id, String loan_type, double amount, float interest_rate, String loan_start_date, String loan_end_date){
        try {
            conn = DbCon.makeConnection();
            String sql = "INSERT INTO loans (loan_id, loan_type, amount, interest_rate, loan_start_date, loan_end_date) VALUES ('" + loan_id + "', '" + loan_type + "', " + amount + ", '" + interest_rate + "', '" + loan_start_date + "', '" + loan_end_date + "')";
            Statement stmt = conn.createStatement();
            int result = stmt.executeUpdate(sql);
            System.out.println("Rows affected: " + result);
            stmt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


package dao;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.Statement;

import model.*;


public class LoansDAO {
    private DbConnection DbCon = new DbConnection();
    private Connection conn;

    public void insertLoan(Loans l){
        try {
            conn = DbCon.makeConnection();
            String sql = "INSERT INTO loans (loan_id, loan_type, amount, interest_rate, loan_start_date, loan_end_date) VALUES ('" +l.getLoan_id()+ "', '" +l.getLoan_type()+ "', " +l.getAmount()+ ", '" +l.getInterest_rate()+ "', '" +l.getLoan_start_date()+ "', '" +l.getLoan_end_date()+ "')";
            Statement stmt = conn.createStatement();
            int result = stmt.executeUpdate(sql);
            System.out.println("Rows affected: " + result);
            stmt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

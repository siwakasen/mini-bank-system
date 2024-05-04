
package dao;

import connection.DbConnection;
import model.Loans;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;



public class LoansDAO {
    private DbConnection DbCon = new DbConnection();
    private Connection conn;

    public void insertLoan(Loans loan){
        try {
            conn = DbCon.makeConnection();
            String sql = "INSERT INTO loans (loan_id, loan_type, amount, interest_rate, loan_start_date, loan_end_date, interest_rate_type, end_amount_pay, confirm) VALUES ('"+loan.getLoan_id()+"', '"+loan.getLoan_type()+"', '"+loan.getAmount()+"', '"+loan.getInterest_rate()+"', '"+loan.getLoan_start_date()+"', '"+loan.getLoan_end_date()+"', '"+loan.getInterest_rate_type()+"', '"+loan.getEnd_amount_pay()+"', '"+loan.getConfirm()+"')";
            Statement stmt = conn.createStatement();
            int result = stmt.executeUpdate(sql);
            System.out.println("Rows affected: " + result);
            stmt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateLoan(Loans loan){
        try {
            conn = DbCon.makeConnection();
            String sql = "UPDATE loans SET confirm = '"+loan.getConfirm()+"' WHERE loan_id = '"+loan.getLoan_id()+"'";
            Statement stmt = conn.createStatement();
            int result = stmt.executeUpdate(sql);
            System.out.println("Rows affected: " + result);
            stmt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteLoan(Loans loan){
        try {
            conn = DbCon.makeConnection();
            String sql = "DELETE FROM loans WHERE loan_id = '"+loan.getLoan_id()+"'";
            Statement stmt = conn.createStatement();
            int result = stmt.executeUpdate(sql);
            System.out.println("Rows affected: " + result);
            stmt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Loans getLoan(String loan_id, String status){
        if(!status.equals("")){
            try {
                conn = DbCon.makeConnection();
                // select just one row and sort by ascending
                String sql = "SELECT * FROM loans WHERE loan_id = '"+loan_id+"' && confirm = '"+status+"' LIMIT 1";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if(rs.next()){
                    Loans loan = new Loans(rs.getString("loan_id"), rs.getString("loan_type"), rs.getString("loan_start_date"), rs.getString("loan_end_date"), rs.getDouble("amount"), rs.getFloat("interest_rate"), rs.getString("interest_rate_type"), rs.getDouble("end_amount_pay"), rs.getString("confirm"));
                    return loan;
                }
                stmt.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
            return null;
        }else{
            try {
                conn = DbCon.makeConnection();
                // select just one row and sort by ascending
                String sql = "SELECT * FROM loans WHERE loan_id = '"+loan_id+"'";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if(rs.next()){
                    Loans loan = new Loans(rs.getString("loan_id"), rs.getString("loan_type"), rs.getString("loan_start_date"), rs.getString("loan_end_date"), rs.getDouble("amount"), rs.getFloat("interest_rate"), rs.getString("interest_rate_type"), rs.getDouble("end_amount_pay"), rs.getString("confirm"));
                    DbCon.closeConnection();
                    return loan;
                }
                stmt.close();
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            DbCon.closeConnection();
            return null;
        }
    }
}

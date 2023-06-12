
package dao;

import model.*;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class TransactionsDAO {
    private DbConnection DbCon = new DbConnection();
    private Connection conn;

    public void insertTransaction(Transactions transaction){
        try {
            conn = DbCon.makeConnection();
            String sql = "INSERT INTO transactions (transaction_id, account_id, transaction_fk, transaction_date) VALUES ('"+transaction.getTransaction_id() + "', " + transaction.getAccount_id() + ", '" + transaction.getTransaction_fk() + "', '" + transaction.getTransaction_date() + "')";
            Statement stmt = conn.createStatement();
            int result = stmt.executeUpdate(sql);
            System.out.println("Rows affected: " + result);
            stmt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Transactions> getTransactions(int account_id, String type){
        List<Transactions> transactions = new ArrayList<Transactions>();
        try {
            conn = DbCon.makeConnection();
            Statement stmt = conn.createStatement();
            if(type == "LOA"){
                String sql = "SELECT * FROM transactions WHERE account_id = " + account_id + " AND transaction_fk LIKE 'LOA-%'";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    String transaction_id = rs.getString("transaction_id");
                    String transaction_fk = rs.getString("transaction_fk");
                    String transaction_date = rs.getString("transaction_date");
                    Transactions transaction = new Transactions(transaction_id, account_id, transaction_fk, transaction_date);
                    transactions.add(transaction);
                }
                stmt.close();
                rs.close();
                return transactions;
            }else if(type == "TN"){
                String sql = "SELECT * FROM transactions WHERE account_id = " + account_id + " AND transaction_fk LIKE 'TN-%'";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    String transaction_id = rs.getString("transaction_id");
                    String transaction_fk = rs.getString("transaction_fk");
                    String transaction_date = rs.getString("transaction_date");
                    Transactions transaction = new Transactions(transaction_id, account_id, transaction_fk, transaction_date);
                    transactions.add(transaction);
                }
                stmt.close();
                rs.close();
                return transactions;
            } else {
                String sql = "SELECT * FROM transactions WHERE account_id = " + account_id;
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    String transaction_id = rs.getString("transaction_id");
                    String transaction_fk = rs.getString("transaction_fk");
                    String transaction_date = rs.getString("transaction_date");
                    Transactions transaction = new Transactions(transaction_id, account_id, transaction_fk, transaction_date);
                    transactions.add(transaction);
                }
                stmt.close();
                rs.close();
                return transactions;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return transactions;
    }
    
    public List<TransactionsJoins> showAllTransactions(String type, String status1, String status2){
        conn = DbCon.makeConnection();
        
        try {
            System.out.println("Collecting all datas....");
            List<TransactionsJoins> tJoins = new ArrayList<TransactionsJoins>();
            Statement statement = conn.createStatement();
            if (type=="LOA") {
                String sql = "SELECT t.*, l.* FROM transactions as t JOIN loans as l ON (t.transaction_fk = l.loan_id)"
                        + "WHERE t.transaction_fk LIKE 'LOA-%' AND (l.confirm = '"+status1+"' OR l.confirm = '"+status2+"') ORDER BY l.confirm DESC";
                ResultSet rs = statement.executeQuery(sql);
                System.out.println("Success collecting loan datas...");
                if (rs!=null) {
                    while (rs.next()) {                        
                        TransactionsJoins t = new TransactionsJoins(new Transactions(rs.getString("t.transaction_id"), rs.getInt("t.account_id"), 
                                rs.getString("t.transaction_fk"), rs.getString("t.transaction_date")), null
                                , new Loans(rs.getString("l.loan_id"), rs.getString("l.loan_type"), rs.getString("l.loan_start_date")
                                , rs.getString("l.loan_end_date"), rs.getDouble("l.amount"), rs.getFloat("l.interest_rate")
                                , rs.getString("l.interest_rate_type"), rs.getDouble("l.end_amount_pay"), rs.getString("l.confirm")));
                        
                        t.getL().setLoan_start_date(t.getL().getLoan_start_date().substring(8, 10)+
                                t.getL().getLoan_start_date().substring(4, 8)+
                                t.getL().getLoan_start_date().substring(0, 4));
                        t.getL().setLoan_end_date(t.getL().getLoan_end_date().substring(8, 10)+
                                t.getL().getLoan_end_date().substring(4, 8)+
                                t.getL().getLoan_end_date().substring(0, 4));
                        
                        tJoins.add(t);
                    }
                }
                statement.close();
                rs.close();
                return tJoins;
            }else{
                String sql = "SELECT t.*, tf.* FROM transactions as t JOIN transfers as tf ON (t.transaction_fk = tf.transfer_id)"
                        + "WHERE t.transaction_fk LIKE 'TN-%'";
                ResultSet rs = statement.executeQuery(sql);
                System.out.println("Success collecting loan datas...");
                if (rs!=null) {
                    while (rs.next()) {                        
                        TransactionsJoins t = new TransactionsJoins(new Transactions(rs.getString("t.transaction_id"), rs.getInt("t.account_id"), 
                        rs.getString("t.transaction_fk"), rs.getString("t.transaction_date")), new Transfers(rs.getString("tf.transfer_id"), 
                                        rs.getInt("tf.from_account_id"),rs.getInt("tf.to_account_id"), rs.getDouble("tf.amount"))
                                , null);
                        
                        t.getTn().setTransaction_date(t.getTn().getTransaction_date().substring(8, 10)+
                                t.getTn().getTransaction_date().substring(4, 8)+
                                t.getTn().getTransaction_date().substring(0, 4));
                        
                        tJoins.add(t);
                    }
                }
                statement.close();
                rs.close();
                return tJoins;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        DbCon.closeConnection();
        return null;
    }
    
    public Transactions singleTransaction(int account_id, String transaction_id, String type){
        if(!transaction_id.isEmpty()){
            try {
                conn = DbCon.makeConnection();
                String sql = "SELECT * FROM transactions WHERE account_id = "+account_id+" && transaction_id = '"+transaction_id+"'";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    return new Transactions(rs.getString("transaction_id"), account_id, rs.getString("transaction_fk"), rs.getString("transaction_date"));
                }
                stmt.close();
                rs.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return null;
        }else{
            try {
                conn = DbCon.makeConnection();
                String sql = "SELECT * FROM transactions WHERE account_id = " + account_id + " AND transaction_fk LIKE '" + type + "-%'";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    return new Transactions(rs.getString("transaction_id"), account_id, rs.getString("transaction_fk"), rs.getString("transaction_date"));
                }
                stmt.close();
                rs.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return null;
        }
    }
}

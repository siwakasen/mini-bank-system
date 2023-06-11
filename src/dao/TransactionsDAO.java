
package dao;

import model.*;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
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

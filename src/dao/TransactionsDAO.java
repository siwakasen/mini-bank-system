
package dao;

import model.*;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class TransactionsDAO {
    private DbConnection DbCon = new DbConnection();
    private Connection conn;

    public void insertTransaction(int account_id, String transaction_type, String transaction_date){
        try {
            conn = DbCon.makeConnection();
            int transaction_id = ThreadLocalRandom.current().nextInt(); 
            String sql = "INSERT INTO transactions (transaction_id, account_id, transaction_type, transaction_date) VALUES ('" + "TR-" + transaction_id + "', " + account_id + ", '" + transaction_type + "', '" + transaction_date + "')";
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
                String sql = "SELECT * FROM transactions WHERE account_id = " + account_id + " AND transaction_type LIKE 'LOA-%'";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    String transaction_id = rs.getString("transaction_id");
                    String transaction_type = rs.getString("transaction_type");
                    String transaction_date = rs.getString("transaction_date");
                    Transactions transaction = new Transactions(transaction_id, transaction_type, transaction_date, account_id);
                    transactions.add(transaction);
                }
                stmt.close();
                rs.close();
                return transactions;
            }else if(type == "TN"){
                String sql = "SELECT * FROM transactions WHERE account_id = " + account_id + " AND transaction_type LIKE 'TN-%'";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    String transaction_id = rs.getString("transaction_id");
                    String transaction_type = rs.getString("transaction_type");
                    String transaction_date = rs.getString("transaction_date");
                    Transactions transaction = new Transactions(transaction_id, transaction_type, transaction_date, account_id);
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
                    String transaction_type = rs.getString("transaction_type");
                    String transaction_date = rs.getString("transaction_date");
                    Transactions transaction = new Transactions(transaction_id, transaction_type, transaction_date, account_id);
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
    
    
}

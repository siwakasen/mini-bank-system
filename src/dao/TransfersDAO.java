
package dao;

import model.*;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class TransfersDAO {
    private DbConnection DbCon = new DbConnection();
    private Connection conn;

    public void insertTransfer(Transfers transfer){
        try {
            conn = DbCon.makeConnection();
            String sql = "INSERT INTO transfers (transfer_id, from_account_id, to_account_id, amount) VALUES ('" + transfer.getTransfer_id() + "', '" + transfer.getFrom_account_id() + "', '" + transfer.getTo_account_id() + "', " + transfer.getAmount() + ")";
            String sql_update = "UPDATE accounts SET balance = balance - " + transfer.getAmount() + " WHERE account_id = '" + transfer.getFrom_account_id() + "'";
            String sql_update2 = "UPDATE accounts SET balance = balance + " + transfer.getAmount() + " WHERE account_id = '" + transfer.getTo_account_id() + "'";
            Statement stmt = conn.createStatement();
            System.out.println("a");
            int result = stmt.executeUpdate(sql);
            System.out.println("b");
            int result2 = stmt.executeUpdate(sql_update);
            System.out.println("c");
            int result3 = stmt.executeUpdate(sql_update2);
            System.out.println("Rows affected: " + result + ", " + result2 + ", " + result3);
            stmt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
        public List<Transfers> showListTransfer() {
        conn = DbCon.makeConnection();
        
        String sql = "SELECT * FROM transfers";
        System.out.println("Mengambil data Transfer...");
        
        List<Transfers> list = new ArrayList<>();
        
        try {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs!=null){
                while(rs.next()){
                    Transfers t = new Transfers(rs.getString("transfer_id"), rs.getInt("from_account_id"),
                            rs.getInt("to_account_id"), rs.getDouble("amount"));
                    list.add(t);
                }
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error reading database...");
            System.out.println(e);
        }
        DbCon.closeConnection();
        
        return list;
    }
    
    
    public boolean checkAccount(int account_id){
        try {
            conn = DbCon.makeConnection();
            String sql = "SELECT * FROM accounts WHERE account_id = " + account_id;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                stmt.close();
                rs.close();
                return true;
            } else {
                stmt.close();
                rs.close();
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean checkBalance(int account_id, double amount){
        try {
            conn = DbCon.makeConnection();
            String sql = "SELECT * FROM accounts WHERE account_id = " + account_id;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                if(rs.getDouble("balance") >= amount){
                    stmt.close();
                    rs.close();
                    return true;
                }else{
                    stmt.close();
                    rs.close();
                    return false;
                }
            } else {
                stmt.close();
                rs.close();
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public List<Accounts> getAccounts(int account_id){
        List<Accounts> accounts = new ArrayList<Accounts>();
        try {
            conn = DbCon.makeConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT DISTINCT * FROM transfers JOIN accounts ON transfers.to_account_id = accounts.account_id JOIN customers ON accounts.customer_id = customers.customer_id WHERE from_account_id = " + account_id + " AND to_account_id != " + account_id + " LIMIT 5";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Accounts account = (new Accounts(rs.getInt("account_id"), rs.getString("account_type"), rs.getDouble("balance"), 
                        new Customers(rs.getInt("customers.customer_id"), rs.getString("customers.first_name"), rs.getString("customers.last_name"), rs.getString("customers.email"), rs.getString("phone_number"), rs.getString("address")), rs.getString("username"), rs.getString("password")));
                accounts.add(account);
            }
            stmt.close();
            rs.close();
            return accounts;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}

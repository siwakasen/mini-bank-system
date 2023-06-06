
package dao;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class TransfersDAO {
    private DbConnection DbCon = new DbConnection();
    private Connection conn;

    public void insertTransfer(String transfer_id, int from_account_id, int to_account_id, double amount){
        try {
            conn = DbCon.makeConnection();
            String sql = "INSERT INTO transfers (transfer_id, from_account_id, to_account_id, amount) VALUES ('" + transfer_id + "', '" + from_account_id + "', '" + to_account_id + "', " + amount + ")";
            String sql_update = "UPDATE accounts SET balance = balance - " + amount + " WHERE account_id = '" + from_account_id + "'";
            String sql_update2 = "UPDATE accounts SET balance = balance + " + amount + " WHERE account_id = '" + to_account_id + "'";
            Statement stmt = conn.createStatement();
            int result = stmt.executeUpdate(sql);
            int result2 = stmt.executeUpdate(sql_update);
            int result3 = stmt.executeUpdate(sql_update2);
            System.out.println("Rows affected: " + result + ", " + result2 + ", " + result3);
            stmt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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

}

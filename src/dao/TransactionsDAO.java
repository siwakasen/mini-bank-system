package dao;

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

    public void insertTransaction(int account_id, String transaction_fk, String transaction_date){
        try {
            conn = DbCon.makeConnection();
            int transaction_id = ThreadLocalRandom.current().nextInt(); 
            String sql = "INSERT INTO transactions (transaction_id, account_id, transaction_fk, transaction_date) VALUES ('" + "TR-" + transaction_id + "', " + account_id + ", '" + transaction_fk + "', '" + transaction_date + "')";
            Statement stmt = conn.createStatement();
            int result = stmt.executeUpdate(sql);
            System.out.println("Rows affected: " + result);
            stmt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    
}

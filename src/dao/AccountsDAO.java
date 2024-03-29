
package dao;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Customers;
import model.Accounts;
import control.CustomersControl;


public class AccountsDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    private CustomersControl c = new CustomersControl();
    
    public void insertAccounts(Accounts a){
        con = dbCon.makeConnection();
       
        String sql = "INSERT INTO accounts (account_id, customer_id, account_type, balance, username, password) VALUES ('" 
                + a.getAccount_id()+ "', '"+ a.getCustomer().getCustomer_id()+ "', '" 
                + a.getAccount_type() + "', '" + a.getBalance() + "', '" 
                + a.getUsername() + "', '" + a.getPassword() + "')";
        
        System.out.println("Adding Accounts...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Accounts");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error adding Accounts...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public List<Accounts> showAccounts(String query) {
        con = dbCon.makeConnection();
        
        String sql = "SELECT a.*, c.* FROM accounts as a JOIN customers as c ON (a.customer_id = c.customer_id) "
                + "WHERE (c.first_name LIKE '%"+ query +"%'"
                + "OR c.last_name LIKE '%"+ query +"%'"
                + "OR c.email LIKE '%"+ query +"%'"
                + "OR c.phone_number LIKE '%"+ query + "%'"
                + "OR c.address LIKE '%" + query + "%'"
                + "OR a.account_type LIKE '%" + query + "%'"
                + "OR a.balance LIKE '%" + query + "%'"
                + "OR a.username LIKE '%" + query + "%'"
                + "OR a.password LIKE '%" + query + "%'"
                + "OR a.customer_id LIKE '%" + query + "%')";
        System.out.println("Mengambil data Accounts...");       
        List<Accounts> list = new ArrayList<>();
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs!=null){
                while(rs.next()){
                    Customers c = new Customers(
                            Integer.parseInt(rs.getString("c.customer_id")),
                            rs.getString("c.first_name"),
                            rs.getString("c.last_name"),
                            rs.getString("c.email"),
                            rs.getString("c.phone_number"),
                            rs.getString("c.address")
                    );

                    Accounts a = new Accounts(Integer.parseInt(rs.getString("a.account_id")),
                            rs.getString("a.account_type"), Double.parseDouble(rs.getString("a.balance")),
                            c, rs.getString("a.username"), rs.getString("a.password"));
                    
                    list.add(a);
                }
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error reading database...");
            System.out.println(e);
        }
        dbCon.closeConnection();
        
        return list;
    }
    
    public void updateAccounts(Accounts a){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE accounts SET  account_type = '" + a.getAccount_type()
                + "', balance = '" + a.getBalance() + "', username = '" +a.getUsername()
                + "', password = '" +a.getPassword()+ "' WHERE account_id = '" + a.getAccount_id() + "'";
        System.out.println("Editing Accounts...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " Accounts "+ a.getAccount_id());
            statement.close();
        } catch (Exception e) {
            System.out.println("Error editing accounts...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public void deleteAccounts(int account_id){
        con = dbCon.makeConnection();
        
        String sql = "DELETE FROM accounts WHERE account_id = " + account_id;
        System.out.println("Deleting Accounts...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Delete " + result + " Accounts " + account_id);
            statement.close();
        } catch (Exception e) {
            System.out.println("Error deleting accounts...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public Accounts searchAccounts(int account_id){
        con = dbCon.makeConnection();
        String sql = "SELECT * FROM accounts WHERE account_id = '"+account_id+"'";
        System.out.println("Searching Accounts...");
        Accounts a = null;
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if(rs!=null){
                while(rs.next()){
                    a = new Accounts(rs.getInt("account_id"), rs.getString("account_type"), 
                        rs.getDouble("balance"), c.searchCustomer(rs.getInt("customer_id")), rs.getString("username"), 
                        rs.getString("password"));
                }
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error checking search account");
            System.out.println(e.toString());
        }
        dbCon.closeConnection();
        return a;
    }
    public Accounts selectAccount(int account_id){
        con = dbCon.makeConnection();
        String sql = "SELECT * FROM accounts JOIN customers ON accounts.customer_id = customers.customer_id WHERE account_id = "+account_id ;
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                return new Accounts(Integer.parseInt(rs.getString("accounts.account_id")),
                            rs.getString("accounts.account_type"), Double.parseDouble(rs.getString("accounts.balance")),
                            new Customers(Integer.parseInt(rs.getString("customers.customer_id")),rs.getString("customers.first_name"),rs.getString("customers.last_name"),rs.getString("customers.email"),rs.getString("customers.phone_number"),rs.getString("customers.address")), rs.getString("accounts.username"), rs.getString("accounts.password"));
            }
        } catch (Exception e){
            dbCon.closeConnection();
            System.out.println("Error checking select account");
            System.out.println(e.toString());
            return null;
        }
        dbCon.closeConnection();
        return null;
    }
    
    public boolean checkAccountAvail(int account_id){
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM accounts WHERE account_id = "+account_id;
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                return true;
            }
            rs.close();
            stmt.close();
        } catch (Exception e){
            System.out.println("Error checking availabel account");
            System.out.println(e.toString());
            return false;
        }
        dbCon.closeConnection();
        return false;
    }
    public Accounts checkLogin(String user, String pass){
        con= dbCon.makeConnection();
        Accounts a=null;
        String sql = "SELECT a.*,c.* FROM accounts as a JOIN customers as c ON a.customer_id = c.customer_id WHERE a.username = '"+user+"' AND a.password = '"+pass+"'";
        try{
             Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs!=null){
                while(rs.next()){
                    Customers c = new Customers(
                            Integer.parseInt(rs.getString("c.customer_id")),
                            rs.getString("c.first_name"),
                            rs.getString("c.last_name"),
                            rs.getString("c.email"),
                            rs.getString("c.phone_number"),
                            rs.getString("c.address")
                    );

                    a = new Accounts(Integer.parseInt(rs.getString("a.account_id")),
                            rs.getString("a.account_type"), Double.parseDouble(rs.getString("a.balance")),
                            c, rs.getString("a.username"), rs.getString("a.password"));
                }
            }
            rs.close();
            statement.close();
        }catch(Exception e){
            System.out.println("Error to logged in...");
            System.out.println(e.toString());
        }
         dbCon.closeConnection();
        return a;
    }
}

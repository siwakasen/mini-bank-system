/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Customer;
import model.Account;

public class AccountDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    public void insertAccount(Account a){
        con = dbCon.makeConnection();
        
        String sql = "INSERT INTO account (account_id, account_type, balance, customer_id) VALUES ('" 
                + a.getAccount_id()+ "', '" + a.getAccount_type() + "', '" + a.getBalance() + "', '"
                + a.getCustomer_id()+ "')";
        
        System.out.println("Adding Account...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Account");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error adding Account...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public List<Account> showAccount(String query) {
        con = dbCon.makeConnection();
        
        String sql = "SELECT a.*, c.* FROM account as a JOIN customer as c ON c.customer_id = a.customer_id "
                + "WHERE (c.first_name LIKE '%" + query + "%'"
                + "OR c.last_name LIKE '%" + query + "%'"
                + "OR c.email LIKE '%" + query + "%'"
                + "OR c.phone_number LIKE '%" + query + "%'"
                + "OR c.address LIKE '%" + query + "%'"
                + "OR a.account_type LIKE '%" + query + "%'"
                + "OR a.balance '%" + query + "%'";
        System.out.println("Mengambil data Account...");       
        List<Account> list = new ArrayList<>();
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs!=null){
                while(rs.next()){
                    Customer c = new Customer(
                            Integer.parseInt(rs.getString("c.customer_id")),
                            rs.getString("c.first_name"),
                            rs.getString("c.last_name"),
                            rs.getString("c.email"),
                            rs.getString("c.username"),
                            rs.getString("c.password"),
                            rs.getString("c.phone_number"),
                            rs.getString("c.address")
                    );
                    
                    Account a = new Account(
                            Integer.parseInt(rs.getString("a.account_id")),
                            rs.getString("a.account_type"),
                            Double.parseDouble(rs.getString("a.balance")),
                            c
                    );
                    
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
    
    public void updateAccount(Account a){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE account SET  account_type = '" + a.getAccount_type()
                + "', balance = '" + a.getBalance()
                + "' WHERE account_id = '" + a.getAccount_id() + "'";
        System.out.println("Editing Account...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Edited" + result + " Account "+ a.getAccount_id());
            statement.close();
        } catch (Exception e) {
            System.out.println("Error editing account...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public void deleteAccount(int account_id){
        con = dbCon.makeConnection();
        
        String sql = "DELETE FROM account WHERE account_id = " + account_id + "";
        System.out.println("Deleting Account...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Delete " + result + " Account " + account_id);
            statement.close();
        } catch (Exception e) {
            System.out.println("Error deleting account...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
}

package dao;

import connection.DbConnection;
import model.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    DbConnection dbcon = new DbConnection();
    private Connection con;
    
    public void insertEmployee(Employee em){
        con = dbcon.makeConnection();
        
        String sql = "";
        
        System.out.println("Insert data employee...");
        
        try {
            Statement statement = con.createStatement();
            int rs = statement.executeUpdate(sql);
            System.out.println("Success insert "+rs+" data employee...");
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error insert data employee...");
        }
        
        dbcon.closeConnection();
    }
    
    public void deleteEmployee(int id){
        con = dbcon.makeConnection();
        
        String sql = "DELETE FROM employee WHERE id = "+id+"";
        
        System.out.println("Deleting data employee...");
        
        try {
            Statement statement = con.createStatement();
            int rs = statement.executeUpdate(sql);
            System.out.println("Success deleting "+rs+" data employee...");
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error deleting data employee...");
        }
        dbcon.closeConnection();
    }
    
    public void updateEmployee(Employee em){
        con = dbcon.makeConnection();
        
        String sql = "";
        
        System.out.println("Updating data employee...");
        
        try {
            Statement statement = con.createStatement();
            int rs = statement.executeUpdate(sql);
            System.out.println("Success updating"+rs+" data employee...");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error updating data employee...");
        }
        dbcon.closeConnection();
    }
    
    public List<Employee> showListCustomer(){
        con = dbcon.makeConnection();
        
        String sql = "SELECT * FROM employee";
        
        System.out.println("Collecting data employee...");
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs!=null) {
                while (rs.next()) {                    
                    // Minus create object kalo dia teller or customer service
                }
            }
            
            rs.close();
            statement.close();
            System.out.println("Success collecting data employee...");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error colleting data employee...");
        }
        
        dbcon.closeConnection();
    }
    
}

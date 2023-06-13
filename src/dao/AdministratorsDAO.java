
package dao;

import connection.DbConnection;
import model.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

public class AdministratorsDAO {
    DbConnection dbcon = new DbConnection();
    private Connection con;
    
    public void insertAdministrator(Administrators a){
        con = dbcon.makeConnection();
        
        String sql = "INSERT INTO administrators(administrator_id, username, password) "
                + " VALUES("+a.getAdministrator_id()+", '"+a.getUsername()+"', '"+a.getPassword()+"')";
        
        System.out.println("Insert data administrator...");     
        
        try {
            Statement statement = con.createStatement();
            int rs = statement.executeUpdate(sql);
            System.out.println("Success insert "+rs+" data administrator...");
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error insert data administrator...");
        }
        
        dbcon.closeConnection();
    }
    
    public void deleteAdministrator(int id){
        con = dbcon.makeConnection();
        
        String sql = "DELETE FROM administrators WHERE administrator_id = "+id;
        
        System.out.println("Deleting data administrator...");
        
        try {
            Statement statement = con.createStatement();
            int rs = statement.executeUpdate(sql);
            System.out.println("Success deleting "+rs+" data administrator...");
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error deleting data administrator...");
        }
        dbcon.closeConnection();
    }
    
    public void updateAdministrator(Administrators a){
        con = dbcon.makeConnection();
        
        String sql = "UPDATE administrators SET username = '"+a.getUsername()+"', password = '"+a.getPassword()+"'"
                + " WHERE administrator_id = '"+a.getAdministrator_id()+"'";
        
        System.out.println("Updating data administrator...");
        
        try {
            Statement statement = con.createStatement();
            int rs = statement.executeUpdate(sql);
            System.out.println("Success updating"+rs+" data administrator...");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error updating data administrator...");
        }
        dbcon.closeConnection();
    }
    
    public List<Administrators> showListAdministrator(){
        con = dbcon.makeConnection();
        
        String sql = "SELECT * FROM administrators";
        
        List<Administrators> list = new ArrayList<Administrators>();
        System.out.println("Collecting data administrator...");
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs!=null) {
                while (rs.next()) {                    
                    Administrators a = new Administrators(rs.getInt("administrator_id"),
                            rs.getString("username"), rs.getString("password"));
                    
                    String conv = "";
                    for (int i = 0; i < a.getPassword().length(); i++) {
                         conv += "*";
                    }
                    
                    a.setPassword(conv);
                    list.add(a);
                }
            }
            
            rs.close();
            statement.close();
            System.out.println("Success collecting data administrator...");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error colleting data administrator...");
        }
        dbcon.closeConnection();
        return list;
    }
    
    
    public Administrators searchAdmin(Administrators admin){
        con = dbcon.makeConnection();
        
        String sql = "SELECT * from administrators WHERE username = '" +admin.getUsername()+ "' "+"AND password = '"+admin.getPassword()+"'";
        System.out.println("Searching administrators...");
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs!=null) {
                while (rs.next()) {                    
                    Administrators a = new Administrators(rs.getInt("administrator_id"),
                            rs.getString("username"), rs.getString("password"));
                            
                    if(a.getUsername().equals(admin.getUsername()) && a.getPassword().equals(admin.getPassword())){
                        return a;
                    }
                }
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error searching administrators...");
            System.out.println(e);
        }
        dbcon.closeConnection();
        return null;
    }
    public Administrators searchByUsername(String username){
        con = dbcon.makeConnection();
        
        String sql = "SELECT * from administrators WHERE username = '" +username+"'";
        System.out.println("Searching administrators...");
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs!=null) {
                while (rs.next()) {                    
                    Administrators a = new Administrators(
                            rs.getInt("administrator_id"),
                            rs.getString("username"), 
                            rs.getString("password"));
                    
                    dbcon.closeConnection();        
                    return a;
                }
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error searching administrators...");
            System.out.println(e);
        }
        dbcon.closeConnection();
        return null;
    }
    
    public List<Administrators> showAdministrators(String query) {
        con = dbcon.makeConnection();
        
        String sql = "SELECT * FROM administrators "
                + "WHERE ( username LIKE '%" + query + "%'"
                + " OR password LIKE '%" + query + "%')";
        System.out.println("Mengambil data Admins...");       
        List<Administrators> list = new ArrayList<>();
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs!=null){
                while(rs.next()){
                    Administrators a = new Administrators(
                            rs.getInt("administrator_id"),
                            rs.getString("username"), 
                            rs.getString("password"));
                    list.add(a);
                }
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error reading database...");
            System.out.println(e);
        }
        dbcon.closeConnection();
        
        return list;
    }

}

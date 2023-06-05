package dao;

import connection.DbConnection;
import model.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

public class AdministratorDAO {
    DbConnection dbcon = new DbConnection();
    private Connection con;
    
    public void insertAdministrator(Administrator a){
        con = dbcon.makeConnection();
        
        String sql = "INSERT INTO administrators(administrator_id, username, password) "
<<<<<<< HEAD
                + " VALUES("+a.getAdministrator_id()+", '"+a.getUsername()+"', '"+a.getPassword()+"')";
=======
                + " VALUES("+a.getAdministrator_id()+", '"+a.getUsername()+"', '"+a.getPassword+"')";
>>>>>>> 21b49525ee8fc2585f08582a8659ae89f0c94d6b
        
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
        
<<<<<<< HEAD
        String sql = "DELETE FROM administrators WHERE administrator_id = "+id+"";
=======
        String sql = "DELETE FROM administrators WHERE id = "+id+"";
>>>>>>> 21b49525ee8fc2585f08582a8659ae89f0c94d6b
        
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
    
    public void updateAdministrator(Administrator a){
        con = dbcon.makeConnection();
        
<<<<<<< HEAD
        String sql = "UPDATE administrators SET username = '"+a.getUsername()+"', password = '"+a.getPassword()+"'"
                + " WHERE administrator_id = '"+a.getAdministrator_id()+"'";
=======
        String sql = "UPDATE administrator SET username = '"+a.getUsername+"', password = '"+a.getPassword+"'"
                + " WHERE administrator_id = '"+a.getAdiminstrator_id+"'";
>>>>>>> 21b49525ee8fc2585f08582a8659ae89f0c94d6b
        
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
    
    public List<Administrator> showListAdministrator(){
        con = dbcon.makeConnection();
        
        String sql = "SELECT * FROM administrators";
        
        List<Administrator> list = new ArrayList<Administrator>();
        System.out.println("Collecting data administrator...");
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs!=null) {
                while (rs.next()) {                    
                    Administrator a = new Administrator(rs.getInt("administrator_id"),
                            rs.getString("username"), rs.getString("password"));
                    
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
}

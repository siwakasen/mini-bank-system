
package dao;

import connection.DbConnection;
import model.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

public class EmployeesDAO {
    DbConnection dbcon = new DbConnection();
    private Connection con;
    
    public void insertEmployee(Employees em){
        con = dbcon.makeConnection();
        
        String sql = "INSERT INTO employees(employee_id, first_name, last_name, username, password, start_work_date,"
                + " end_work_date, role_id, station_number, office_number) VALUES ('"+em.getEmployee_id()+"','"+em.getFirst_name()+"', "
                + "'"+em.getLast_name()+"', '"+em.getUsername()+"', '"+em.getPassword()+"', '"+em.getStart_work_date()+"', '"+em.getEnd_work_date()+"', '"+em.getRole_id()+"',"
                + "'"+em.getStation_number()+"', '"+em.getOffice_number()+"')";
        
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
        
        String sql = "DELETE FROM employees WHERE employee_id = "+id+"";
        
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
    
    public void updateEmployee(Employees em){
        con = dbcon.makeConnection();
        
        String sql = "UPDATE employees SET first_name = '"+em.getFirst_name()+"',"
                + " last_name = '"+em.getLast_name()+"',"
                + " username = '"+em.getUsername()+"',"
                + " password = '"+em.getPassword()+"',"
                + " end_work_date = '"+em.getEnd_work_date()+"',"
                + " station_number = '"+em.getStation_number()+"',"
                + " office_number = '"+em.getOffice_number()+"' "
                + " WHERE employee_id = '"+em.getEmployee_id()+"'";
        
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
    public Employees searchByUsername(String user){
        con = dbcon.makeConnection();
        
        String sql = "SELECT * from employees WHERE username = '" +user+"'";
        System.out.println("Searching employees...");
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs!=null) {
                while (rs.next()) {
                    Employees e = new Employees(rs.getInt("employee_id"),
                            rs.getString("first_name"), rs.getString("last_name"),
                            rs.getString("username"), rs.getString("password"), 
                            rs.getString("start_work_date"), rs.getString("end_work_date"),
                            rs.getInt("role_id"), rs.getString("office_number"), 
                            rs.getString("station_number"));
                    
                    e.setStart_work_date(e.getStart_work_date().substring(8, 10)+e.getStart_work_date().substring(4, 8)+
                            e.getStart_work_date().substring(0, 4));
                    
                    e.setEnd_work_date(e.getEnd_work_date().substring(8, 10)+e.getEnd_work_date().substring(4, 8)+
                            e.getEnd_work_date().substring(0, 4));
                    
                    dbcon.closeConnection();
                    return e;
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
    public List<Employees> showListEmployees(){
        con = dbcon.makeConnection();
        
        String sql = "SELECT * FROM employees ORDER BY role_id asc";
        
        System.out.println("Collecting data employee...");
        
        List<Employees> list = new ArrayList<Employees>();
        System.out.println("Collecting data employeea...");
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs!=null) {
                while (rs.next()) {
                    Employees e = new Employees(rs.getInt("employee_id"),
                            rs.getString("first_name"), rs.getString("last_name"),
                            rs.getString("username"), rs.getString("password"), 
                            rs.getString("start_work_date"), rs.getString("end_work_date"),
                            rs.getInt("role_id"), rs.getString("office_number"), 
                            rs.getString("station_number"));
                    
                    e.setStart_work_date(e.getStart_work_date().substring(8, 10)+e.getStart_work_date().substring(4, 8)+
                            e.getStart_work_date().substring(0, 4));
                    
                    e.setEnd_work_date(e.getEnd_work_date().substring(8, 10)+e.getEnd_work_date().substring(4, 8)+
                            e.getEnd_work_date().substring(0, 4));
                    
                    
                    list.add(e);
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
        return list;
    }
        public Employees searchEmployee(Employees emp){
        con = dbcon.makeConnection();
         String sql = "SELECT * FROM employees where username = '"+emp.getUsername()+"' AND password ='"+emp.getPassword()+"'";
        
        System.out.println("Searching data employee...");
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            System.out.println(emp.getUsername()+" "+emp.getPassword());
            if (rs!=null) {
                while (rs.next()) {
                    Employees e = new Employees(rs.getInt("employee_id"),
                            rs.getString("first_name"), rs.getString("last_name"),
                            rs.getString("username"), rs.getString("password"), 
                            rs.getString("start_work_date"), rs.getString("end_work_date"),
                            rs.getInt("role_id"), rs.getString("office_number"), 
                            rs.getString("station_number"));
                   
                    if(e.getUsername().equals(emp.getUsername()) && e.getPassword().equals(emp.getPassword())){
                        dbcon.closeConnection();
                        return e;
                    }
                    
                }
            }
            
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error colleting data employee...");
        }
        dbcon.closeConnection();
          return null;
    }
        
      public List<Employees> searchShowEmp(String query) {
        con = dbcon.makeConnection();
        
        String sql = "SELECT e.*,r.* FROM employees as e JOIN roles as r ON (e.role_id = r.role_id) "
                + "WHERE ( e.employee_id LIKE '%" + query + "%'"
                + " OR e.first_name LIKE '%" + query + "%'"
                + " OR e.last_name LIKE '%" + query + "%'"
                + " OR e.username LIKE '%" + query + "%'"
                + " OR e.password LIKE '%" + query + "%'"
                + " OR e.start_work_date LIKE '%" + query + "%'"
                + " OR e.end_work_date LIKE '%" + query + "%'"
                + " OR r.role_name LIKE '%" + query + "%'"
                + " OR e.station_number LIKE '%" + query + "%'"
                + " OR e.office_number LIKE '%" + query + "%')";
        System.out.println("Mengambil data Admins...");       
        List<Employees> list = new ArrayList<>();
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs!=null){
                while(rs.next()){
                    Employees e = new Employees(rs.getInt("employee_id"),
                            rs.getString("first_name"), rs.getString("last_name"),
                            rs.getString("username"), rs.getString("password"), 
                            rs.getString("start_work_date"), rs.getString("end_work_date"),
                            rs.getInt("role_id"), rs.getString("office_number"), 
                            rs.getString("station_number"));
                    list.add(e);
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

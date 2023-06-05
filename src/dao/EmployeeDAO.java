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
        
<<<<<<< HEAD
        String sql = "INSERT INTO employees(employee_id, first_name, last_name, username, password, start_work_date,"
                + " end_work_date, role_id, station_number, office_number) VALUES ('"+em.getEmployee_id()+"','"+em.getFirst_name()+"', "
                + "'"+em.getLast_name()+"', '"+em.getUsername()+"', '"+em.getPassword()+"', '"+em.getStart_work_date()+"', '"+em.getEnd_work_date()+"', '"+em.getRole_id()+"',"
=======
        String sql = "INSERT INTO employees(first_name, last_name, username, password, start_work_date,"
                + " end_work_date, role_id, station_number, office_number) VALUES ('"+em.getFirst_name()+"', "
                + "'"+em.getLast_name()+"', '"+em.getStart_work_date()+"', '"+em.getEnd_work_date()+"', '"+em.getRole_id()+"',"
>>>>>>> 21b49525ee8fc2585f08582a8659ae89f0c94d6b
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
    
    public void updateEmployee(Employee em){
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
    
    public List<Employee> showListCustomer(){
        con = dbcon.makeConnection();
        
        String sql = "SELECT * FROM employees";
        
        System.out.println("Collecting data employee...");
        
        List<Employee> list = new ArrayList<Employee>();
        System.out.println("Collecting data employeea...");
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs!=null) {
                while (rs.next()) {
                    Employee e = new Employee(rs.getInt("employee_id"),
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
            System.out.println("Success collecting data employee...");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error colleting data employee...");
        }
        dbcon.closeConnection();
        return list;
    }
    
}

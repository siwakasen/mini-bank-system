
package dao;

import connection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Customers;

public class CustomersDAO {
    private DbConnection dbCon = new DbConnection();
    private Connection con;
    
    public void insertCustomers(Customers c){
        con = dbCon.makeConnection();
       
<<<<<<< HEAD
        String sql = "INSERT INTO customers(first_name, last_name, email,"
                + "username, password, phone_number, address) "
                + "VALUES ('" + c.getFirst_name()+ "','" + c.getLast_name()+ "', '"
                + c.getEmail()+ "', '" + c.getUsername()+ "', '" + c.getPassword()+ "', '" 
                + c.getPhone_number()+ "', '" + c.getAddress()+ "')";
=======
        String sql = "INSERT INTO customers(customer_id, first_name, last_name, email, phone_number, address) "
                + "VALUES ('" + c.getCustomer_id()+ "', '" + c.getFirst_name()+ "', '" + c.getLast_name()+ "', '"
                + c.getEmail()+ "', '"+ c.getPhone_number()+ "', '" + c.getAddress()+ "')";
>>>>>>> devMain
     
        System.out.println("Adding Customers...");
       
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Customers");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error adding Customers...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public List<Customers> showListCustomers() {
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM customers";
        System.out.println("Mengambil data Customers...");
        
        List<Customers> list = new ArrayList<>();
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs!=null){
                while(rs.next()){
                    Customers c = new Customers(
                            Integer.parseInt(rs.getString("customer_id")),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("email"),
                            rs.getString("phone_number"),
                            rs.getString("address")
                    );
                    list.add(c);
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
    
    
    public List <Customers> showCustomersBySearch(String query){
        con = dbCon.makeConnection();
       
        String sql = "SELECT * FROM customers as c WHERE (c.customer_id LIKE '%" + query + "%' "
                + " OR c.first_name LIKE '%" + query + "%' "
                + " OR c.last_name LIKE '%" + query + "%' "
                + " OR c.email LIKE '%" + query + "%' "
                + " OR c.phone_number LIKE '%" + query + "%' "
                + " OR c.address LIKE '%" + query + "%')";
        System.out.println("Mengambil data Customers by Search...");
        Customers c = null;
        List <Customers> listCustomers = new ArrayList<>();
       
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
           
            if(rs!=null){
                while(rs.next()){
                    c = new Customers(
                            Integer.parseInt(rs.getString("customer_id")),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("email"),
                            rs.getString("phone_number"),
                            rs.getString("address")
                    );
                    listCustomers.add(c);
                }
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error reading database...");
            System.out.println(e);
        }
        dbCon.closeConnection();
       
        return listCustomers;
    }
    
    public void updateCustomers(Customers c){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE customers SET  first_name = '" + c.getFirst_name()
                + "', last_name = '" + c.getLast_name()
                + "', email = '" + c.getEmail()
                + "', phone_number = '" + c.getPhone_number()
                + "', address = '" + c.getAddress()
                + "' WHERE customer_id = '" + c.getCustomer_id()+ "'";
        System.out.println("Editing Customers...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Emdited" + result + " Customers "+ c.getCustomer_id());
            statement.close();
        } catch (Exception e) {
            System.out.println("Error editing Customers...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    } 
    
    public void deleteCustomers(int customer_id){
        con = dbCon.makeConnection();
       
        String sql = "DELETE FROM customers WHERE customer_id = '" + customer_id + "'";
        System.out.println("Deleting Customers...");
       
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Delete " + result + " Customers " + customer_id);
            statement.close();
        } catch (Exception e) {
            System.out.println("Error deleting customers...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
}

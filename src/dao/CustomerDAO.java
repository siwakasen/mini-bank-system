/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;
import connection.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Customer;
/*
    Nama  : Ryan Pratama Wijaya
    Kelas : C
    NPM   : 210711008
*/
public class CustomerDAO {
    private DBConnection dbCon = new DBConnection();
    private Connection con;
    
    public void insertCustomer(Customer c){
        con = dbCon.makeConnection();
       
        String sql = "INSERT INTO customer(customer_id, first_name, last_name, email,"
                + "username, password, phone_number, address) "
                + "VALUES ('" + c.getCustomer_id()+ "', '" + c.getFirst_name()+ "', '"
                + c.getEmail()+ "', '" + c.getUsername()+ "', '" + c.getPassword()+ "', '" 
                + c.getPhone_number()+ "', '" + c.getAddress()+ "')";
     
        System.out.println("Adding Customer...");
       
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Added " + result + " Customer");
            statement.close();
        } catch (Exception e) {
            System.out.println("Error adding Customer...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
    public List<Customer> showListCustomer() {
        con = dbCon.makeConnection();
        
        String sql = "SELECT * FROM customer";
        System.out.println("Mengambil data Customer...");
        
        List<Customer> list = new ArrayList();
        
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            
            if (rs!=null){
                while(rs.next()){
                    Customer c = new Customer(
                            Integer.parseInt(rs.getString("customer_id")),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("email"),
                            rs.getString("user_name"),
                            rs.getString("password"),
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
    
    
    public List <Customer> showCustomerBySearch(String query){
        con = dbCon.makeConnection();
       
        String sql = "SELECT * FROM customer as c WHERE (c.customer_id LIKE '%" + query + "%' "
                + " OR c.first_name LIKE '%" + query + "%' "
                + " OR c.last_name LIKE '%" + query + "%' "
                + " OR c.email LIKE '%" + query + "%' "
                + " OR c.username LIKE '%" + query + "%' "
                + " OR c.password LIKE '%" + query + "%' "
                + " OR c.phone_number LIKE '%" + query + "%' "
                + " OR c.address LIKE '%" + query + "%')";
        System.out.println("Mengambil data Customer by Search...");
        Customer c = null;
        List <Customer> listCustomer = new ArrayList();
       
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
           
            if(rs!=null){
                while(rs.next()){
                    c = new Customer(
                            Integer.parseInt(rs.getString("customer_id")),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("email"),
                            rs.getString("user_name"),
                            rs.getString("password"),
                            rs.getString("phone_number"),
                            rs.getString("address")
                    );
                    listCustomer.add(c);
                }
            }
            rs.close();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error reading database...");
            System.out.println(e);
        }
        dbCon.closeConnection();
       
        return listCustomer;
    }
    
    public void updateCustomer(Customer c){
        con = dbCon.makeConnection();
        
        String sql = "UPDATE customer SET  first_name = '" + c.getFirst_name()
                + "', last_name = '" + c.getLast_name()
                + "', email = '" + c.getEmail()
                + "', username = '" + c.getUsername()
                + "', password = '" + c.getPassword()
                + "', phone_number = '" + c.getPhone_number()
                + "', address = '" + c.getAddress()
                + "' WHERE customer_id = '" + c.getCustomer_id()+ "'";
        System.out.println("Editing Customer...");
        
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Emdited" + result + " Customer "+ c.getCustomer_id());
            statement.close();
        } catch (Exception e) {
            System.out.println("Error editing Customer...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    } 
    
    public void deleteCustomer(Integer customer_id){
        con = dbCon.makeConnection();
       
        String sql = "DELETE FROM customer WHERE customer_id = '" + customer_id + "'";
        System.out.println("Deleting Customer...");
       
        try {
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(sql);
            System.out.println("Delete " + result + " Customer " + customer_id);
            statement.close();
        } catch (Exception e) {
            System.out.println("Error deleting customer...");
            System.out.println(e);
        }
        dbCon.closeConnection();
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package control;
import dao.CustomersDAO;
import java.util.List;
import model.Customers;
import table.TableCustomers;
/**
 * @author 
 * Made Riksi Purnama Sadnya Agung / 210711396
 * Pemrograman Berorientasi Obyek C
 */
public class CustomersControl {
    private CustomersDAO customerDAO = new CustomersDAO();
    public List<Customers> getAllCustomer(){
        List<Customers> customers = customerDAO.showListCustomers();
        return customers;
    }
    public TableCustomers showCustomer(String query){
        List<Customers> listCustomer = customerDAO.showCustomersBySearch(query);
        TableCustomers tableCustomer = new TableCustomers(listCustomer);
        return tableCustomer;
    }

    public void insertCustomer(Customers customer){
        customerDAO.insertCustomers(customer);
    }

    public void updateCustomer(Customers customer){
        customerDAO.updateCustomers(customer);
    }

    public void deleteCustomer(int id){
        customerDAO.deleteCustomers(id);
    }
}
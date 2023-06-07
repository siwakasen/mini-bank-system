/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package control;

import dao.CustomersDAO;
import model.Customers;
import table.TableCustomers;
import java.util.List;

public class CustomersControl {
    private CustomersDAO cDao = new CustomersDAO();
    
    public void insertCustomer(Customers c){
        insertCustomer(c);
    }
    
    public TableCustomers showCustomers(String query){
        List<Customers> list = cDao.showCustomersBySearch(query);
        TableCustomers tableCustomers = new TableCustomers(list);
        
        return tableCustomers;
    }
    
    
}

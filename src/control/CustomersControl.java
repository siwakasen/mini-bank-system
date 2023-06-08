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
         cDao.insertCustomers(c);
     }
     
     public TableCustomers showCustomers(String query){
         List<Customers> list = cDao.showCustomersBySearch(query);
         TableCustomers tableCustomers = new TableCustomers(list);
         
         return tableCustomers;
     }
     
     public int lastCostumer(){
         List<Customers> list = cDao.showListCustomers();
         int last = 0;
         for (Customers customers : list) {
             if (customers.getCustomer_id() > last) {
                 last = customers.getCustomer_id();
             }
         }
         return last;
     }
     
     public void updateCustomer(Customers c){
         cDao.updateCustomers(c);
     }
     
     public void deleteCustomer(int customer_id){
         cDao.deleteCustomers(customer_id);
     }
     
 }

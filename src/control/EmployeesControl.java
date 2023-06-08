/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package control;
import dao.EmployeesDAO;
import model.Employees;
import table.TableEmployees;
import java.util.List;
/**
 *
 * @author riksi
 */
public class EmployeesControl {
    private EmployeesDAO employDao = new EmployeesDAO();
    
    public TableEmployees showEmployees(String query){
        List<Employees> listEmploye = employDao.showListCustomer();
        TableEmployees tabelemploye = new TableEmployees(listEmploye);
        return tabelemploye;
    }
    public void insertEmployees(Employees employees){
        employDao.insertEmployee(employees);
    }
    public void updateEmployees(Employees employees){
        employDao.updateEmployee(employees);
    }
    public void deleteEmployees(int id){
        employDao.deleteEmployee(id);
    }
    /**
     * @param args the command line arguments
     */
    
}

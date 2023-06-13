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
        List<Employees> listEmploye = employDao.showListEmployees();
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
    public Employees searchEmployees(Employees e){
        return employDao.searchEmployee(e);
    }
    public Employees searchByUsername(String user){ 
        return employDao.searchByUsername(user);
    }
    
    public int countEmployee(){
        return showEmployees("").getRowCount();
    }
    public int autoGenerateID(){
        List<Employees> listEmp = employDao.showListEmployees();
        int max=0;
        for(int i=0;i<listEmp.size();i++){
            if(max<listEmp.get(i).getEmployee_id())
                 max=listEmp.get(i).getEmployee_id();
        }
        return max+1;
    }
    public TableEmployees showTableEmp(String query){
        List<Employees> list = employDao.searchShowEmp(query);
        TableEmployees table = new TableEmployees(list);
        return table;
    }
}


package testing;
import model.*;
import dao.*;
import connection.DbConnection;
import java.util.List;


public class testingDB {
    
    public static void main(String[] args) {
       AdministratorsDAO cDao = new AdministratorsDAO();
//       Administrators a = new Administrators(4, "Riksi ", "123");
//       
//       cDao.insertAdministrator(a);
//        cDao.deleteAdministrator(4);
//          cDao.updateAdministrator(a);
         List<Administrators> list = cDao.showListAdministrator();
         String dosenString = "";
           for (int i = 0; i < list.size(); i++) {
               dosenString = dosenString + list.get(i).getUsername()+ list.get(i).getPassword()+ "\n";
           }
           
           System.out.println(dosenString);

        // EmployeesDAO eDao = new EmployeesDAO();
        //     Employees e = new Employees(2, "1", "1", "1", "1", "2022/12/12", "2023-12-12", 1, "2", "");
                
        //    eDao.insertEmployee(e);
        //    eDao.deleteEmployee(1);

        //    eDao.updateEmployee(e);
        //               List<Employees> list = eDao.showListCustomer();
        //   String dosenString = "";
        //     for (int i = 0; i < list.size(); i++) {
        //         dosenString = dosenString + list.get(i).getFirst_name() +" | "+ list.get(i).getLast_name()+ "\n";
        //     }
            
            System.out.println(dosenString);
    }
    
    
}

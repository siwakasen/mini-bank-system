package table;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import model.Employees;

public class TableEmployees extends AbstractTableModel{
    private List<Employees> employees;

    public TableEmployees(List<Employees> employees){
        this.employees=employees;
    }

    @Override
    public int getRowCount(){
        return employees.size();
    }

    @Override
    public int getColumnCount(){
        return 10;
    }

    @Override
    public Object getValueAt(int row, int col){
        switch(col){
            case 0: 
                return employees.get(row).getEmployee_id();
            case 1: 
                return employees.get(row).getUsername();
            case 2: 
                return employees.get(row).getPassword();
            case 3: 
                return employees.get(row).getFirst_name();
            case 4:
                return employees.get(row).getLast_name();
            case 5:
                return employees.get(row).getStart_work_date();
            case 6:
                return employees.get(row).getEnd_work_date();
            case 7:
                if(employees.get(row).getRole_id()==1){
                    return "Teller";
                }else{
                    return "Customer Services";
                }
            case 8:
                if(employees.get(row).getRole_id()==1){
                    return employees.get(row).getStation_number();
                }else{
                    return "";
                }
            case 9:
                if(employees.get(row).getRole_id()==2){
                    return employees.get(row).getOffice_number();
                }else{
                    return "";
                }
            default: 
                return null;
        }
    }

    @Override
    public String getColumnName(int col){
        switch (col) {
            case 0: 
                return "Employee ID";
            case 1: 
                return "Username";
            case 2: 
                return "Password";
            case 3:
                return "First Name";
            case 4:
                return "Last Name";
            case 5:
                return "Start Work Date";
            case 6:
                return "End Work Date";
            case 7:
                return "Role";
            case 8:
                return "Station Number";
            case 9:
                return "Office Number";
            default: 
                return null;
        }
    }
}

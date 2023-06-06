package table;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import model.Customers;
public class TableCustomers extends AbstractTableModel{
    private List<Customers> customers;

    public TableCustomers(List<Customers> customers){
        this.customers=customers;
    }

    @Override
    public int getRowCount(){
        return customers.size();
    }

    @Override
    public int getColumnCount(){
        return 8;
    }

    @Override
    public Object getValueAt(int row, int col){
        switch(col){
            case 0: 
                return customers.get(row).getCustomer_id();
            case 1: 
                return customers.get(row).getUsername();
            case 2: 
                return customers.get(row).getPassword();
            case 3: 
                return customers.get(row).getFirst_name();
            case 4:
                return customers.get(row).getLast_name();
            case 5:
                return customers.get(row).getEmail();
            case 6:
                return customers.get(row).getPhone_number();
            case 7:
                return customers.get(row).getAddress();
            default: 
                return null;
        }
    }

    @Override
    public String getColumnName(int col){
        switch (col) {
            case 0: 
                return "Customer ID";
            case 1: 
                return "Username";
            case 2: 
                return "Password";
            case 3:
                return "First Name";
            case 4:
                return "Last Name";
            case 5:
                return "Email";
            case 6:
                return "Phone Number";
            case 7:
                return "Address";
            default: 
                return null;
        }
    }
}
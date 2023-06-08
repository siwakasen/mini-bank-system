package table;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import model.Customers;
import model.Accounts;

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
        return 6;
    }

    @Override
    public Object getValueAt(int row, int col){
        switch(col){
            case 0: 
                return customers.get(row).getCustomer_id();
            case 1: 
                return customers.get(row).getFirst_name();
            case 2:
                return customers.get(row).getLast_name();
            case 3:
                return customers.get(row).getEmail();
            case 4:
                return customers.get(row).getPhone_number();
            case 5:
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
                return "First Name";
            case 2:
                return "Last Name";
            case 3:
                return "Email";
            case 4:
                return "Phone Number";
            case 5:
                return "Address";
            default: 
                return null;
        }
    }
}

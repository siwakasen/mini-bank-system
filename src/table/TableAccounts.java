package table;

import javax.swing.table.AbstractTableModel;
import model.Accounts;
import java.util.List;

public class TableAccounts extends AbstractTableModel{
    private List<Accounts> accounts;

    public TableAccounts(List<Accounts> accounts){
        this.accounts = accounts;
    }

    @Override
    public int getRowCount(){
        return accounts.size();
    }

    @Override
    public int getColumnCount(){
        return 4;
    }

    @Override
    public Object getValueAt(int row, int col){
        switch(col){
            case 0: 
                return accounts.get(row).getAccount_id();
            case 1: 
                return accounts.get(row).getCustomer_id();
            case 2: 
                return accounts.get(row).getAccount_type();
            case 3: 
                return accounts.get(row).getBalance();
            default: 
                return null;
        }
    }

    @Override
    public String getColumnName(int col){
        switch (col) {
            case 0: 
                return "Account ID";
            case 1: 
                return "Customer ID";
            case 2: 
                return "Account Type";
            case 3:
                return "Balance";
            default: 
                return null;
        }
    }

}

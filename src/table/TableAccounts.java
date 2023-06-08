/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import javax.swing.table.AbstractTableModel;
import model.Accounts;
import java.util.List;

/**
 *
 * @author personal7
 */
public class TableAccounts extends AbstractTableModel {
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
        return 9;
    }

    @Override
    public Object getValueAt(int row, int col){
        switch(col){
            case 0: 
                return accounts.get(row).getAccount_id();
            case 1: 
                return accounts.get(row).getCustomer().getCustomer_id();
            case 2: 
                return accounts.get(row).getCustomer().getFirst_name();
            case 3: 
                return accounts.get(row).getCustomer().getLast_name();
            case 4: 
                return accounts.get(row).getAccount_type();
            case 5: 
                return accounts.get(row).getBalance();
            case 6: 
                return accounts.get(row).getCustomer().getEmail();
            case 7: 
                return accounts.get(row).getCustomer().getPhone_number();
            case 8: 
                return accounts.get(row).getCustomer().getAddress();
            case 9: 
                return accounts.get(row).getUsername();
            case 10: 
                return accounts.get(row).getPassword();
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
                return "First Name";
            case 3:
                return "Last Name";
            case 4: 
                return "Account Type";
            case 5:
                return "Balance";
            case 6: 
                return "Email";
            case 7:
                return "Phone Number";
            case 8: 
                return "Address";
            default: 
                return null;
        }
    }
}

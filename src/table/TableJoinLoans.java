/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.TransactionsJoins;

/**
 *
 * @author panji
 */
public class TableJoinLoans extends AbstractTableModel{
    private List<TransactionsJoins> loans;

    public TableJoinLoans(List<TransactionsJoins> loans) {
        this.loans = loans;
    }

    @Override
    public int getRowCount(){
        return loans.size();
    }

    @Override
    public int getColumnCount(){
        return 7;
    }

    @Override
    public Object getValueAt(int row, int col){
        switch(col){
            case 0: 
                return loans.get(row).getL().getLoan_id();
            case 1: 
                return loans.get(row).getTn().getAccount_id();
            case 2: 
                return loans.get(row).getL().getLoan_type();
            case 3: 
                return loans.get(row).getL().getAmount();
            case 4:
                return loans.get(row).getL().getInterest_rate();
            case 5:
                return loans.get(row).getL().getLoan_start_date();
            case 6:
                return loans.get(row).getL().getConfirm();
            case 7:
                return loans.get(row).getTn().getTransaction_id();
            case 8:
                return loans.get(row).getL().getInterest_rate_type();
            case 9:
                return loans.get(row).getL().getLoan_end_date();
            case 10:
                return loans.get(row).getL().getEnd_amount_pay();
            default: 
                return null;
        }
    }

    @Override
    public String getColumnName(int col){
        switch (col) {
            case 0: 
                return "Loans ID";
            case 1: 
                return "Account ID";
            case 2: 
                return "Loan Type";
            case 3:
                return "Amount";
            case 4:
                return "Interest Rate";
            case 5:
                return "Start Date";
            case 6:
                return "Status";
            default: 
                return null;
        }
    }
}

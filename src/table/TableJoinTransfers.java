/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package table;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import model.TransactionsJoins;

public class TableJoinTransfers extends AbstractTableModel{
    private List<TransactionsJoins> transfers;

    public TableJoinTransfers(List<TransactionsJoins> transfers) {
        this.transfers = transfers;
    }
    
    @Override
    public int getRowCount(){
        return transfers.size() ;
    }

    @Override
    public int getColumnCount(){
        return 6;
    }

    @Override
    public Object getValueAt(int row, int col){
        switch(col){
            case 0: 
                return transfers.get(row).getTn().getTransaction_id();
            case 1: 
                return transfers.get(row).getTf().getTransfer_id();
            case 2: 
                return transfers.get(row).getTf().getFrom_account_id();
            case 3: 
                return transfers.get(row).getTf().getTo_account_id();
            case 4: 
                return transfers.get(row).getTf().getAmount();
            case 5:
                return transfers.get(row).getTn().getTransaction_date();
            default: 
                return null;
        }
    }

    @Override
    public String getColumnName(int col){
        switch (col) {
            case 0:
                return "Transcation ID";
            case 1: 
                return "Transfer ID";
            case 2: 
                return "From Account ID";
            case 3: 
                return "To Account ID";
            case 4:
                return "Amount";
            case 5:
                return "Date";
            default: 
                return null;
        }
    }
}

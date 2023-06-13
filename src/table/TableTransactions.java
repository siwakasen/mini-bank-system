package table;

import javax.swing.table.AbstractTableModel;
import model.Transactions;
import java.util.List;

public class TableTransactions extends AbstractTableModel{
    private List<Transactions> transactions;

    public TableTransactions(List<Transactions> transactions){
        this.transactions=transactions;
    }
    
    @Override
    public int getRowCount(){
        return transactions.size();
    }

    @Override
    public int getColumnCount(){
        return 4;
    }

    @Override
    public Object getValueAt(int row, int col){
        switch(col){
            case 0: 
                return transactions.get(row).getTransaction_id();
            case 1: 
                return transactions.get(row).getAccount_id();
            case 2: 
                return transactions.get(row).getTransaction_fk();
            case 3: 
                return transactions.get(row).getTransaction_date();
            default: 
                return null;
        }
    }

    @Override
    public String getColumnName(int col){
        switch (col) {
            case 0: 
                return "Transactions ID";
            case 1: 
                return "Accounts ID";
            case 2: 
                return "Transactions Type";
            case 3:
                return "Transactions Date";
            default: 
                return null;
        }
    }
}

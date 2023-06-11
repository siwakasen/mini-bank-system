package table;

import javax.swing.table.AbstractTableModel;
import model.Transfers;
import java.util.List;

public class TableTransfer extends AbstractTableModel{
    private List<Transfers> transfers;

    TableTransfer(List<Transfers> transfers){
        this.transfers=transfers;
    }
    
    @Override
    public int getRowCount(){
        return transfers.size();
    }

    @Override
    public int getColumnCount(){
        return 7;
    }

    @Override
    public Object getValueAt(int row, int col){
        switch(col){
            case 0: 
                return transfers.get(row).getTransfer_id();
            case 1: 
                return transfers.get(row).getFrom_account_id();
            case 2: 
                return transfers.get(row).getTo_account_id();
            case 3: 
                return transfers.get(row).getAmount();
            default: 
                return null;
        }
    }

    @Override
    public String getColumnName(int col){
        switch (col) {
            case 0: 
                return "Transfer ID";
            case 1: 
                return "From Account ID";
            case 2: 
                return "To Account ID";
            case 3:
                return "Amount";
            default: 
                return null;
        }
    }
}

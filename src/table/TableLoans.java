package table;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import model.Loans;

public class TableLoans extends AbstractTableModel{
    private List<Loans> loans;
    
    public TableLoans(List<Loans> loans){
        this.loans=loans;
    }

    @Override
    public int getRowCount(){
        return loans.size();
    }

    @Override
    public int getColumnCount(){
        return 6;
    }

    @Override
    public Object getValueAt(int row, int col){
        switch(col){
            case 0: 
                return loans.get(row).getLoan_id();
            case 1: 
                return loans.get(row).getLoantype();
            case 2: 
                return loans.get(row).getAmount();
            case 3:
                return loans.get(row).getInterest_rate();
            case 4:
                return loans.get(row).getLoan_start_date();
            case 5:
                return loans.get(row).getLoan_end_date();
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
                return "Loan Type";
            case 2:
                return "Amount";
            case 3:
                return "Interest Rate";
            case 4:
                return "Start Date";
            case 5:
                return "End Date";
            default: 
                return null;
        }
    }
}

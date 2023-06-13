/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package table;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Transactions;

/**
 *
 * @author personal7
 */
public class TableHistori extends AbstractTableModel {
    private List<Transactions> transactions;

    public TableHistori(List<Transactions> transactions){
        this.transactions=transactions;
    }
    
    @Override
    public int getRowCount(){
        return transactions.size();
    }

    @Override
    public int getColumnCount(){
        return 3;
    }

    @Override
    public Object getValueAt(int row, int col){
        switch(col){
            case 0: 
                return transactions.get(row).getTransaction_id();
            case 1:
                return transactions.get(row).getTransaction_fk().contains("LOA") ? "Peminjaman Uang" : "Transfers";
            case 2: 
                return transactions.get(row).getTransaction_date();
            case 3:
                return transactions.get(row).getTransaction_fk();
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
                return "Tipe Transaksi";
            case 2:
                return "Transactions Date";
            default: 
                return null;
        }
    }
}

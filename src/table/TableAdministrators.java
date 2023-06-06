
package table;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import model.Administrators;

public class TableAdministrators extends AbstractTableModel{
    private List<Administrators> admin;

    public TableAdministrators(List<Administrators> admin){
        this.admin = admin;
    }

    @Override
    public int getRowCount(){
        return admin.size();
    }

    @Override
    public int getColumnCount(){
        return 3;
    }

    @Override
    public Object getValueAt(int row, int col){
        switch(col){
            case 0: 
                return admin.get(row).getAdministrator_id();
            case 1: 
                return admin.get(row).getUsername();
            case 2: 
                return admin.get(row).getPassword();
            default: 
                return null;
        }
    }

    @Override
    public String getColumnName(int col){
        switch (col) {
            case 0: 
                return "ID";
            case 1: 
                return "Username";
            case 2: 
                return "Password";
            default: 
                return null;
        }
    }

}

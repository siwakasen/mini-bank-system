

package control;

import dao.AccountsDAO;
import model.Accounts;
import table.TableAccounts;
import java.util.List;

public class AccountsControl {
    private AccountsDAO aDao = new AccountsDAO();
    
    public void insertAccounts(Accounts a){
        aDao.insertAccounts(a);
    }
    
    public TableAccounts showAccounts(String query){
        List<Accounts> list = aDao.showAccounts(query);
        TableAccounts tableAccounts = new TableAccounts(list);
        
        return tableAccounts;
    }
    
    
}

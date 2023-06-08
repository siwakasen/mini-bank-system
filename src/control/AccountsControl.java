

package control;

import dao.AccountsDAO;
import model.Accounts;
import table.TableAccounts;
import java.util.List;

public class AccountsControl {
    private AccountsDAO accDao = new AccountsDAO();
    
    public TableAccounts showAccounts(String query){
        List<Accounts> listAccount = accDao.showAccounts(query);
        TableAccounts tabelAccounts = new TableAccounts(listAccount);
        return tabelAccounts;
    }
    public void insertAccounts(Accounts accounts){
        accDao.insertAccounts(accounts);
    }
    public void updateAccounts(Accounts accounts){
        accDao.updateAccounts(accounts);
    }
    public void deleteAccounts(int id){
        accDao.deleteAccounts(id);
    }
}

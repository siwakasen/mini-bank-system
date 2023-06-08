

package control;

import dao.AccountsDAO;
import model.Accounts;
import table.TableAccounts;
import java.util.List;

public class AccountsControl {
<<<<<<< HEAD
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
=======
    private AccountsDAO aDao = new AccountsDAO();
    
    public void insertAccounts(Accounts a){
        aDao.insertAccounts(a);
    }
    
    public TableAccounts showAccounts(String query){
        List<Accounts> list = aDao.showAccounts(query);
        TableAccounts tableAccounts = new TableAccounts(list);
        
        return tableAccounts;
    }
    
    public void updateAccount(Accounts a){
        aDao.updateAccounts(a);
    }
    
    public void deleteAccount(int account_id){
        aDao.deleteAccounts(account_id);
>>>>>>> devMain
    }
}

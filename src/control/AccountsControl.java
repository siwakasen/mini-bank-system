
package control;

import dao.AccountsDAO;
import java.util.List;
import model.Accounts;
import table.TableAccounts;
import java.util.List;

public class AccountsControl {
    private static AccountsDAO AccountsDAO = new AccountsDAO();
    
    public void insertAccounts(Accounts a){
        AccountsDAO.insertAccounts(a);
    }
    
    public List<Accounts> showAccounts(String query){
        return AccountsDAO.showAccounts(query);
    }
    
    public void updateAccounts(Accounts a){
        AccountsDAO.updateAccounts(a);
    }
    
    public void deleteAccounts(int account_id){
        AccountsDAO.deleteAccounts(account_id);
    }
    
    public boolean checkAccountAvail(int account_id){
        return AccountsDAO.checkAccountAvail(account_id);
    }
    
    public Accounts selectAccount(int account_id){
        return AccountsDAO.selectAccount(account_id);
    }
    
    public TableAccounts showTableAccounts(String query){
        List<Accounts> list = AccountsDAO.showAccounts(query);
        TableAccounts tableAccounts = new TableAccounts(list);
        
        return tableAccounts;
    }

    public Accounts searchAccount(int account_id){
            return AccountsDAO.searchAccounts(account_id);
        }
}

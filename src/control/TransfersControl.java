/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package control;

import dao.TransfersDAO;
import java.util.List;
import model.Transfers;
import model.Accounts;
import table.TableTransfer;
import table.TableDaftarTransfer;

public class TransfersControl {
    private TransfersDAO transfersDAO = new TransfersDAO();

    public void insertTransfer(Transfers transfer){
        transfersDAO.insertTransfer(transfer);
    }

    public boolean checkAccount(int account_id){
        return transfersDAO.checkAccount(account_id);
    }

    public boolean checkBalance(int account_id, double amount){
        return transfersDAO.checkBalance(account_id, amount);
    }

    public TableDaftarTransfer getAccounts(int account_id){
        List<Accounts> accounts = transfersDAO.getAccounts(account_id);
        TableDaftarTransfer table = new TableDaftarTransfer(accounts);
        return table;
    }
    
    public TableDaftarTransfer getSearchList(int account_id, String search_id){
        List<Accounts> accounts = transfersDAO.searchTransferList(account_id, search_id);
        TableDaftarTransfer search = new TableDaftarTransfer(accounts);
        return search;
    }
    
    public Transfers singleTransfers(String search_id){
        return transfersDAO.singleTransfers(search_id);
    }
    
}

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

/**
 * @author 
 * Made Riksi Purnama Sadnya Agung / 210711396
 * Pemrograman Berorientasi Obyek C
 */
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

    public TableDaftarTransfer getAccounts(int customer_id){
        List<Accounts> accounts = transfersDAO.getAccounts(customer_id);
        TableDaftarTransfer table = new TableDaftarTransfer(accounts);
        return table;
    }
    
}

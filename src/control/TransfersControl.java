/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package control;
<<<<<<< HEAD
import dao.TransfersDAO;
import model.Transfers;
import java.util.List;
=======

import dao.TransfersDAO;
import java.util.List;
import model.Transfers;
import model.Accounts;
import table.TableTransfer;
import table.TableDaftarTransfer;

>>>>>>> viewFerdy
/**
 * @author 
 * Made Riksi Purnama Sadnya Agung / 210711396
 * Pemrograman Berorientasi Obyek C
 */
public class TransfersControl {
<<<<<<< HEAD
    private TransfersDAO transferDao = new TransfersDAO();
    
    public void insertTransfer(String transfer_id, int from_account_id, int to_account_id, double amount){
        transferDao.insertTransfer(transfer_id, from_account_id, to_account_id, amount);
    }
    public boolean checkAccount(int account_id){
       return transferDao.checkAccount(account_id);
    }
    public boolean checkBalance(int account_id, double amount){
        return transferDao.checkBalance(account_id, amount);
    }
=======
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
    
>>>>>>> viewFerdy
}

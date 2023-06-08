/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package control;
import dao.TransfersDAO;
import model.Transfers;
import java.util.List;
/**
 * @author 
 * Made Riksi Purnama Sadnya Agung / 210711396
 * Pemrograman Berorientasi Obyek C
 */
public class TransfersControl {
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
}

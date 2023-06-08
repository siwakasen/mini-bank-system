/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package control;
import dao.TransactionsDAO;
import model.Transactions;
import table.TableTransactions;
import java.util.List;
/**
 * @author 
 * Made Riksi Purnama Sadnya Agung / 210711396
 * Pemrograman Berorientasi Obyek C
 */
public class TransactionsControl {
    private TransactionsDAO transactionDao = new TransactionsDAO();
    
    public TableTransactions showTransaction(int account_id, String type){
        List<Transactions> listTransaction = transactionDao.getTransactions(account_id, type);
        TableTransactions tabelTransaction = new TableTransactions(listTransaction);
        return tabelTransaction;
    }
    public void inserTransaction(int account_id, String transaction_type, String transaction_date){
        transactionDao.insertTransaction(account_id, transaction_type, transaction_date);
    }
}

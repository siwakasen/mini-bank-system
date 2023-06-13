/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package control;

import dao.TransactionsDAO;
import java.util.List;
import model.Transactions;
import table.TableTransactions;
import table.TableHistori;

public class TransactionsControl {
    private TransactionsDAO TransactionsDAO = new TransactionsDAO();
    
    public void insertTransaction(Transactions transaction){
        TransactionsDAO.insertTransaction(transaction);
    }
    
    public TableHistori getTransaction(int account_id, String type){
        List<Transactions> tr = TransactionsDAO.getTransactions(account_id, type);
        TableHistori table = new TableHistori(tr);
        return table;
    }

    public Transactions singleTransaction(int account_id, String transaction_id, String type){
        return TransactionsDAO.singleTransaction(account_id, transaction_id, type);
    }
    public Transactions searchByStatusLoan(int account_id){
        Transactions tr = null;
        if(TransactionsDAO.singleOnGoingLoans(account_id, "Menunggu Konfirmasi")!=null){
            System.out.println("MENUNGGU KONFIRMASI ===================");
            tr = TransactionsDAO.singleOnGoingLoans(account_id, "Menunggu Konfirmasi");
        }else if(TransactionsDAO.singleOnGoingLoans(account_id, "Dikonfirmasi")!=null){
             System.out.println("DIKONFIRMASI ===================");
            tr=TransactionsDAO.singleOnGoingLoans(account_id, "Dikonfirmasi");
        }
        return tr;
    }

    public TableTransactions showTransaction(int account_id, String type){
        List<Transactions> listTransaction = TransactionsDAO.getTransactions(account_id, type);
        TableTransactions tabelTransaction = new TableTransactions(listTransaction);
        return tabelTransaction;
    }
}

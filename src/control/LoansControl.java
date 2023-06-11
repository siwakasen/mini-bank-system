/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package control;
import dao.LoansDAO;
import dao.TransactionsDAO;
import model.Loans;
import java.util.List;
import model.TransactionsJoins;
import table.TableJoinLoans;
import table.TableLoans;
/**
 * @author 
 * Made Riksi Purnama Sadnya Agung / 210711396
 * Pemrograman Berorientasi Obyek C
 */
public class LoansControl {
    private LoansDAO loansDao = new LoansDAO();
    private TransactionsDAO transactionDao = new TransactionsDAO();
    public void insertLoans(Loans l){
        loansDao.insertLoan(l);
    }
    
    public TableJoinLoans showAllJoinLoans(String type){
        List<TransactionsJoins> tf = transactionDao.showAllTransactions(type);
        TableJoinLoans table = new TableJoinLoans(tf);
        return table;
    }
}

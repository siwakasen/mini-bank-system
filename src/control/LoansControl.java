/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package control;
import dao.LoansDAO;
import model.Loans;
import java.util.List;
/**
 * @author 
 * Made Riksi Purnama Sadnya Agung / 210711396
 * Pemrograman Berorientasi Obyek C
 */
public class LoansControl {
    private LoansDAO loansDao = new LoansDAO();
    public void insertLoans(String loan_id, String loan_type, double amount, float interest_rate, String loan_start_date, String loan_end_date){
        loansDao.insertLoan(loan_id, loan_type, amount, interest_rate, loan_start_date, loan_end_date);
    }
    
}

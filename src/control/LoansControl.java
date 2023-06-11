/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package control;

import dao.LoansDAO;
import model.Loans;

/**
 * @author 
 * Made Riksi Purnama Sadnya Agung / 210711396
 * Pemrograman Berorientasi Obyek C
 */
public class LoansControl {
    private static LoansDAO LoansDAO = new LoansDAO();

    public void insertLoan(Loans loan){
        LoansDAO.insertLoan(loan);
    }

    public void updateLoan(Loans loan){
        LoansDAO.updateLoan(loan);
    }

    public void deleteLoan(Loans loan){
        LoansDAO.deleteLoan(loan);
    }

    public Loans getLoan(String loan_id, String status){
        return LoansDAO.getLoan(loan_id, status);
    }
}

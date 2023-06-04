/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

/**
 *
 * @author USER
 * Fathur Rosi 210711562
 */
public class Transaction {
    private String transaction_id,transaction_fk,transaction_date;
    private Account account_id;

    public Transaction(String transaction_id, String transaction_fk, String transaction_date, Account account_id) {
        this.transaction_id = transaction_id;
        this.transaction_fk = transaction_fk;
        this.transaction_date = transaction_date;
        this.account_id = account_id;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getTransaction_type() {
        return transaction_fk;
    }

    public void setTransaction_type(String transaction_fk) {
        this.transaction_fk = transaction_fk;
    }

    public String getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }

    public Account getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Account account_id) {
        this.account_id = account_id;
    }
    
    @Override
    public String toString() {
        return transaction_fk;
    }
}

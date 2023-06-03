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
public class Loans {
    private String loan_id,loan_type,loan_start_date,loan_end_date;
    private Customer customer;
    private double amount;
    private float interest_date;

    public Loans(String loan_id, String loan_type, String loan_start_date, String loan_end_date, Customer customer, double amount, float interest_date) {
        this.loan_id = loan_id;
        this.loan_type = loan_type;
        this.loan_start_date = loan_start_date;
        this.loan_end_date = loan_end_date;
        this.customer = customer;
        this.amount = amount;
        this.interest_date = interest_date;
    }

    public String getLoan_id() {
        return loan_id;
    }

    public void setLoan_id(String loan_id) {
        this.loan_id = loan_id;
    }

    public String getLoantype() {
        return loan_type;
    }

    public void setLoantype(String loan_type) {
        this.loan_type = loan_type;
    }

    public String getLoan_start_date() {
        return loan_start_date;
    }

    public void setLoan_start_date(String loan_start_date) {
        this.loan_start_date = loan_start_date;
    }

    public String getLoan_end_date() {
        return loan_end_date;
    }

    public void setLoan_end_date(String loan_end_date) {
        this.loan_end_date = loan_end_date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public float getInterest_date() {
        return interest_date;
    }

    public void setInterest_date(float interest_date) {
        this.interest_date = interest_date;
    }
    @Override
    public String toString() {
        return loan_type;
    }

}

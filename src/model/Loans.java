package model;

public class Loans {
    private String loan_id,loan_type,loan_start_date,loan_end_date;
    private int customer_id;
    private double amount;
    private float interest_rate;

    public Loans(String loan_id, String loan_type, String loan_start_date, String loan_end_date, int customer_id, double amount, float interest_rate) {
        this.loan_id = loan_id;
        this.loan_type = loan_type;
        this.loan_start_date = loan_start_date;
        this.loan_end_date = loan_end_date;
        this.customer_id = customer_id;
        this.amount = amount;
        this.interest_rate = interest_rate;
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

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public float getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(float interest_rate) {
        this.interest_rate = interest_rate;
    }
    @Override
    public String toString() {
        return loan_type;
    }

}

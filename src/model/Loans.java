package model;

public class Loans {
    private String loan_id,loan_type,loan_start_date,loan_end_date, interest_rate_type, confirm;
    private double amount, end_amount_pay;
    private float interest_rate;

    public Loans(String loan_id, String loan_type, String loan_start_date, String loan_end_date, double amount, float interest_rate, String interest_rate_type, double end_amount_pay, String confirm){
        this.loan_id = loan_id;
        this.loan_type = loan_type;
        this.loan_start_date = loan_start_date;
        this.loan_end_date = loan_end_date;
        this.amount = amount;
        this.interest_rate = interest_rate;
        this.interest_rate_type = interest_rate_type;
        this.end_amount_pay = end_amount_pay;
        this.confirm = confirm;
    }

    public String getLoan_id() {
        return loan_id;
    }

    public void setLoan_id(String loan_id) {
        this.loan_id = loan_id;
    }

    public String getLoan_type() {
        return loan_type;
    }

    public void setLoan_type(String loan_type) {
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public float getInterest_rate() {
        return interest_rate;
    }
    
    public String getInterest_rate_type(){
        return interest_rate_type;
    }
    
    public void setInterest_rate_type(String interest_rate_type){
        this.interest_rate_type = interest_rate_type;
    }
    
    public double getEnd_amount_pay(){
        return end_amount_pay;
    }
    
    public void setEnd_amount_pay(double end_amount_pay){
        this.end_amount_pay = end_amount_pay;
    }
    
    public String getConfirm(){
        return confirm;
    }
    
    public void setConfirm(String confirm){
        this.confirm = confirm;
    }

    public void setInterest_rate(float interest_rate) {
        this.interest_rate = interest_rate;
    }

    
    
    @Override
    public String toString() {
        return loan_type;
    }

}

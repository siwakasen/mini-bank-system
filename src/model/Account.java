package model;

public class Account {
    private int account_id;
    private String account_type;
    private double balance;
    private Customer customer_id;

    public Account(int account_id, String account_type, double balance, Customer customer_id) {
        this.account_id = account_id;
        this.account_type = account_type;
        this.balance = balance;
        this.customer_id = customer_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public Customer getCustomer_id() {
        return customer_id;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

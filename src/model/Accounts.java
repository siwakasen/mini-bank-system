

package model;

public class Accounts {
    private int account_id;
    private String account_type;
    private double balance;
    private Customers customer_id;

    public Accounts(int account_id, String account_type, double balance, Customers customer_id) {
        this.account_id = account_id;
        this.account_type = account_type;
        this.balance = balance;
        this.customer_id = customer_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public Customers getCustomer_id() {
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

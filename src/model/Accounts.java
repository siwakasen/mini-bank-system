

package model;

public class Accounts {
    private int account_id;
    private String account_type;
    private double balance;
    private Customers customer;
    private String username;
    private String password;

    public Accounts(int account_id, String account_type, double balance, Customers customer, String username, String password) {
        this.account_id = account_id;
        this.account_type = account_type;
        this.balance = balance;
        this.customer = customer;
        this.username = username;
        this.password = password;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
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

    public Customers getCustomer() {
        return customer;
    }

    public void setCustomer(Customers customer) {
        this.customer = customer;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

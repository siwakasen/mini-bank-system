package model;

public class Transactions {
    private String transaction_id,transaction_fk,transaction_date;
    private int account_id;

    public Transactions(String transaction_id, int account_id, String transaction_fk, String transaction_date) {
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

    public String getTransaction_fk() {
        return transaction_fk;
    }

    public void setTransaction_fk(String transaction_fk) {
        this.transaction_fk = transaction_fk;
    }

    public String getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount(int account_id) {
        this.account_id = account_id;
    }
    
    @Override
    public String toString() {
        return transaction_fk;
    }
}

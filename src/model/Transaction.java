package model;

public class Transaction {
    private String transaction_id,transaction_type,transaction_date;
    private Accounts account_id;

    public Transaction(String transaction_id, String transaction_type, String transaction_date, Accounts account_id) {
        this.transaction_id = transaction_id;
        this.transaction_type = transaction_type;
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
        return transaction_type;
    }

    public void setTransaction_type(String transaction_type) {
        this.transaction_type = transaction_type;
    }

    public String getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }

    public Accounts getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Accounts account_id) {
        this.account_id = account_id;
    }
    
    @Override
    public String toString() {
        return transaction_type;
    }
}

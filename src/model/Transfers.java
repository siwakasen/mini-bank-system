package model;

public class Transfers {
    private String transfer_id;
    private int from_account_id,to_account_id;
    private double amount;

    public Transfers(String transfer_id, int from_account_id, int to_account_id, double amount) {
        this.transfer_id = transfer_id;
        this.from_account_id = from_account_id;
        this.to_account_id = to_account_id;
        this.amount = amount;
    }

    public String getTransfer_id() {
        return transfer_id;
    }

    public void setTransfer_id(String transfer_id) {
        this.transfer_id = transfer_id;
    }

    public int getFrom_account_id() {
        return from_account_id;
    }

    public void setFrom_account_id(int from_account_id) {
        this.from_account_id = from_account_id;
    }

    public int getTo_account_id() {
        return to_account_id;
    }

    public void setTo_account_id(int to_account_id) {
        this.to_account_id = to_account_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    
}

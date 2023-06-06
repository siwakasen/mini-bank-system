package model;

public class Transfers {
    private String transfer_id,transfer_date;
    private int from_account_id,to_account_id;
    private double amount;

    public Transfers(String transfer_id, String transfer_date, int from_account_id, int to_account_id, double amount) {
        this.transfer_id = transfer_id;
        this.transfer_date = transfer_date;
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

    public String getTransfer_date() {
        return transfer_date;
    }

    public void setTransfer_date(String transfer_date) {
        this.transfer_date = transfer_date;
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

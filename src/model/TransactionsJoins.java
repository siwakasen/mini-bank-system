/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class TransactionsJoins {
    Transactions tn;
    Transfers tf;
    Loans l;

    public TransactionsJoins() {
    }

    public TransactionsJoins(Transactions tn, Transfers tf, Loans l) {
        this.tn = tn;
        this.tf = tf;
        this.l = l;
    }

    public Transactions getTn() {
        return tn;
    }

    public void setTn(Transactions tn) {
        this.tn = tn;
    }

    public Transfers getTf() {
        return tf;
    }

    public void setTf(Transfers tf) {
        this.tf = tf;
    }

    public Loans getL() {
        return l;
    }

    public void setL(Loans l) {
        this.l = l;
    }
    
    
}

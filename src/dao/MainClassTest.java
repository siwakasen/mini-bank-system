/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
/**
 *
 * @author personal7
 */
public class MainClassTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        dao.TransactionsDAO t = new dao.TransactionsDAO();
        t.insertTransaction(1, "LOA-123", "2020-01-01");
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import model.*;
import connection.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.Scanner;

import java.util.concurrent.ThreadLocalRandom;


/**
 *
 * @author personal7
 */
public class MainClassTest {

    public static int randomize(){
        return ThreadLocalRandom.current().nextInt(10000000);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Masukkan username: ");
        String username = sc.nextLine();
        System.out.println("Masukkan password: ");
        String password = sc.nextLine();

        // check in database
        DbConnection DbCon = new DbConnection();
        Connection conn = DbCon.makeConnection();
        try {
            String sql = "SELECT * FROM customers WHERE username = '" + username + "' AND password = '" + password + "'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                System.out.println("Login berhasil");
                Customer customer = new Customer(rs.getInt("customer_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getString("username"), rs.getString("password"), rs.getString("phone_number"), rs.getString("address"));
                sql = "SELECT * FROM accounts WHERE customer_id = " + rs.getInt("customer_id");
                stmt = conn.createStatement();
                rs = stmt.executeQuery(sql);
                if (rs.next()) {
                    Account account = new Account(rs.getInt("account_id"), rs.getString("account_type"), rs.getDouble("balance"), customer);
                    System.out.println("Pilih Jenis Transaksi: ");
                    System.out.println("1. Transfer");
                    System.out.println("2. Loan");

                    int choice = sc.nextInt();
                    dao.TransactionsDAO t = new dao.TransactionsDAO();
                    if(choice == 1){
                        dao.TransfersDAO tr = new dao.TransfersDAO();
                        System.out.println("Masukkan nomor rekening tujuan: ");
                        int to_account_id = sc.nextInt();
                        if(tr.checkAccount(to_account_id)){
                            System.out.println("Masukkan jumlah uang yang akan ditransfer: ");
                            double amount = sc.nextDouble();
                            if(tr.checkBalance(rs.getInt("account_id"), amount)){
                                int transfer_id = randomize();
                                t.insertTransaction(rs.getInt("account_id"), "TN-"+transfer_id, "2020-01-01");
                                tr.insertTransfer("TN-"+transfer_id, rs.getInt("account_id"), Integer.valueOf(to_account_id), amount);

                                System.out.println("Apakah anda ingin melihat daftar transaksi? (1/0)");
                                int answer = sc.nextInt();
                                if(answer == 1){
                                    System.out.println("Dafter transaksi: ");
                                    for (Transaction transaction : t.getTransactions(account, "TN")) {
                                        System.out.println(transaction.getTransaction_type() + " " + transaction.getTransaction_date());
                                    }
                                } else {
                                    System.out.println("Terima kasih");
                                }
                            } else {
                                System.out.println("Saldo tidak cukup");
                            }
                        }else{
                            System.out.println("Account tidak ditemukan");
                        }
                    }else{
                        dao.LoansDAO l = new dao.LoansDAO();
                        int loan_id = randomize();
                        t.insertTransaction(rs.getInt("account_id"), "LOA - "+loan_id, "2020-01-01");
                        l.insertLoan("LOA-"+loan_id, "KPR", 100000000, 10, "2021-01-01", "2020-01-01");

                        System.out.println("Apakah anda ingin melihat daftar transaksi? (1/0)");
                        int answer = sc.nextInt();
                        if(answer == 1){
                            System.out.println("Dafter transaksi: ");
                            for (Transaction transaction : t.getTransactions(account, "LOA")) {
                                System.out.println(transaction.getTransaction_type() + " " + transaction.getTransaction_date());
                            }
                        } else {
                            System.out.println("Terima kasih");
                        }
                    }
                }else{
                    System.out.println("Account tidak ditemukan");
                }
                
            } else {
                System.out.println("Login gagal");
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
}

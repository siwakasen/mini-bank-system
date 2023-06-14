/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.customer.histori;

import view.customer.peminjaman.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import model.Accounts;
import model.Customers;
import model.Loans;
import model.Transactions;
import view.customer.CustomerView;

/**
 *
 * @author personal7
 */
public class HistoriPeminjaman extends javax.swing.JFrame {
    private Accounts account;
    private Loans loan;
    private Transactions transaction;
    /**
     * Creates new form CompletePeminjaman
     */
    public HistoriPeminjaman(Accounts account, Transactions transaction, Loans loan) {
        this.account = account;
        this.loan = loan;
        this.transaction = transaction;
        initComponents();
        date_idtrans.setText(create_date(transaction.getTransaction_date())+" ∙ No. Transaksi : "+transaction.getTransaction_id());
        nama_penerima.setText(account.getCustomer().getFirst_name() + " " + account.getCustomer().getLast_name());
        tipe_peminjaman.setText(loan.getLoan_type());
        BigDecimal total = new BigDecimal(loan.getAmount()).setScale(0, RoundingMode.HALF_EVEN);
        total_peminjaman.setText("Rp. "+formatNominal(total));
        tanggal_peminjaman.setText(create_date_loan(loan.getLoan_start_date()));
        tanggal_kembali.setText(create_date_loan(loan.getLoan_end_date()));
        bunga.setText(loan.getInterest_rate()+"%");
        BigDecimal bayar = new BigDecimal(loan.getEnd_amount_pay()).setScale(0, RoundingMode.HALF_EVEN);
        total_bayar.setText("Rp. "+formatNominal(bayar));
        status.setText(loan.getConfirm());
        metode_pembayaran.setText(loan.getInterest_rate_type()); 
    }
    
    public String formatNominal(BigDecimal nominal){
        DecimalFormat df = new DecimalFormat("#,##0.00");
        df.setRoundingMode(RoundingMode.HALF_EVEN);
        return df.format(nominal);
    }
    
    public String create_date(String date_send){
        if(date_send.contains("T")){
            String[] date = date_send.split("T");
            String[] date2 = date[0].split("-");
            String[] time = date[1].split("\\.");
            String[] time2 = time[0].split(":");
            switch (date2[1]){
                case "01":
                    date2[1] = "Januari";
                    break;
                case "02":
                    date2[1] = "Februari";
                    break;
                case "03":
                    date2[1] = "Maret";
                    break;
                case "04":
                    date2[1] = "April";
                    break;
                case "05":
                    date2[1] = "Mei";
                    break;
                case "06":
                    date2[1] = "Juni";
                    break;
                case "07":
                    date2[1] = "Juli";
                    break;
                case "08":
                    date2[1] = "Agustus";
                    break;
                case "09":
                    date2[1] = "September";
                    break;
                case "10":
                    date2[1] = "Oktober";
                    break;
                case "11":
                    date2[1] = "November";
                    break;
                case "12":
                    date2[1] = "Desember";
                    break;
            }
            String new_date = date2[2] + " " + date2[1] + " " + date2[0] + " ∙ " + time2[0] + ":" + time2[1] + ":" + time2[2];
            return new_date;
        }else{
            String[] date = date_send.split(" ");
            String[] date2 = date[0].split("-");
            String[] time = date[1].split("\\.");
            String[] time2 = time[0].split(":");
            switch (date2[1]){
                case "01":
                    date2[1] = "Januari";
                    break;
                case "02":
                    date2[1] = "Februari";
                    break;
                case "03":
                    date2[1] = "Maret";
                    break;
                case "04":
                    date2[1] = "April";
                    break;
                case "05":
                    date2[1] = "Mei";
                    break;
                case "06":
                    date2[1] = "Juni";
                    break;
                case "07":
                    date2[1] = "Juli";
                    break;
                case "08":
                    date2[1] = "Agustus";
                    break;
                case "09":
                    date2[1] = "September";
                    break;
                case "10":
                    date2[1] = "Oktober";
                    break;
                case "11":
                    date2[1] = "November";
                    break;
                case "12":
                    date2[1] = "Desember";
                    break;
            }
            String new_date = date2[2] + " " + date2[1] + " " + date2[0] + " ∙ " + time2[0] + ":" + time2[1] + ":" + time2[2];
            return new_date;
        }
    }
    
    public String create_date_loan(String date_send){
        String[] date = date_send.split("-");
        switch (date[1]){
            case "01":
                date[1] = "Januari";
                break;
            case "02":
                date[1] = "Februari";
                break;
            case "03":
                date[1] = "Maret";
                break;
            case "04":
                date[1] = "April";
                break;
            case "05":
                date[1] = "Mei";
                break;
            case "06":
                date[1] = "Juni";
                break;
            case "07":
                date[1] = "Juli";
                break;
            case "08":
                date[1] = "Agustus";
                break;
            case "09":
                date[1] = "September";
                break;
            case "10":
                date[1] = "Oktober";
                break;
            case "11":
                date[1] = "November";
                break;
            case "12":
                date[1] = "Desember";
                break;
        }
        String new_date = date[2] + " " + date[1] + " " + date[0];
        return new_date;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        date_idtrans = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nama_penerima = new javax.swing.JLabel();
        to_accid = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        total_peminjaman = new javax.swing.JLabel();
        back = new view.PanelRound();
        jLabel13 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tanggal_peminjaman = new javax.swing.JLabel();
        tanggal_kembali = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        bunga = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        total_bayar = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        tipe_peminjaman = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        metode_pembayaran = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Peminjaman Berhasil diajukan!");

        date_idtrans.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        date_idtrans.setForeground(new java.awt.Color(153, 153, 153));
        date_idtrans.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        date_idtrans.setText("11 Mei 2023 - 14:08:49 - No. Transaksi : TR-222222222");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Penerima");

        nama_penerima.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nama_penerima.setText("Nama");

        to_accid.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        to_accid.setForeground(new java.awt.Color(102, 102, 102));
        to_accid.setText("Account ID - 210711111");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel4.setPreferredSize(new java.awt.Dimension(100, 4));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Detail Transaksi");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Total Peminjaman");

        total_peminjaman.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        total_peminjaman.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        total_peminjaman.setText("Rp. 1.000.000");

        back.setBackground(new java.awt.Color(73, 105, 166));
        back.setRoundBottomLeft(50);
        back.setRoundBottomRight(50);
        back.setRoundTopLeft(50);
        back.setRoundTopRight(50);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Kembali ke Dashboard");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout backLayout = new javax.swing.GroupLayout(back);
        back.setLayout(backLayout);
        backLayout.setHorizontalGroup(
            backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        backLayout.setVerticalGroup(
            backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
        );

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Tanggal Peminjaman");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Tipe Peminjaman");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Tanggal Kembali");

        tanggal_peminjaman.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tanggal_peminjaman.setText("Tanggal");

        tanggal_kembali.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tanggal_kembali.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tanggal_kembali.setText("Tanggal");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Suku Bunga Peminjaman");

        bunga.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bunga.setText("Bunga Peminjaman");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Total Yang Harus Dibayar");

        total_bayar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        total_bayar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        total_bayar.setText("Rp. 1.000.000");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Status Peminjaman");

        status.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        status.setText("Status");

        tipe_peminjaman.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tipe_peminjaman.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tipe_peminjaman.setText("Tipe Peminjaman");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Metode Pembayar");

        metode_pembayaran.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        metode_pembayaran.setText("Metode");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(to_accid)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(total_peminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9)
                                        .addComponent(tanggal_peminjaman)
                                        .addComponent(jLabel11)
                                        .addComponent(bunga)
                                        .addComponent(jLabel12)
                                        .addComponent(total_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel14)
                                        .addComponent(status)
                                        .addComponent(jLabel15)
                                        .addComponent(metode_pembayaran))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(tanggal_kembali, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(nama_penerima))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tipe_peminjaman, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(date_idtrans, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date_idtrans)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nama_penerima)
                    .addComponent(tipe_peminjaman))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(to_accid)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(total_peminjaman))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tanggal_peminjaman)
                    .addComponent(tanggal_kembali))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(metode_pembayaran)
                .addGap(12, 12, 12)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bunga)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(total_bayar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(status)
                .addGap(42, 42, 42)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        // TODO add your handling code here:
        this.dispose();
        new HistoriView(account).setVisible(true);
    }//GEN-LAST:event_jLabel13MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HistoriPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistoriPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistoriPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistoriPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HistoriPeminjaman(new Accounts(0, "", 0, new Customers(0, "", "", "", "", ""), "", ""), new Transactions("",0,"",""), new Loans("", "", "", "", 0.0, 0, "", 0, "")).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.PanelRound back;
    private javax.swing.JLabel bunga;
    private javax.swing.JLabel date_idtrans;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel metode_pembayaran;
    private javax.swing.JLabel nama_penerima;
    private javax.swing.JLabel status;
    private javax.swing.JLabel tanggal_kembali;
    private javax.swing.JLabel tanggal_peminjaman;
    private javax.swing.JLabel tipe_peminjaman;
    private javax.swing.JLabel to_accid;
    private javax.swing.JLabel total_bayar;
    private javax.swing.JLabel total_peminjaman;
    // End of variables declaration//GEN-END:variables
}

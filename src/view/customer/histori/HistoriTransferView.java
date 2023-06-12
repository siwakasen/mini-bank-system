/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.customer.histori;

import view.customer.transfer.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import model.Accounts;
import model.Customers;
import model.Transactions;
import model.Transfers;
import view.customer.CustomerView;

/**
 *
 * @author personal7
 */
public class HistoriTransferView extends javax.swing.JFrame {
    private Accounts account;
    private Accounts get;
    private Transactions transaction;
    private Transfers transfer;
    
    /**
     * Creates new form CompleteTransferView
     */
    public HistoriTransferView(Accounts account, Transactions transaction, Transfers transfer, Accounts get) {
        this.account = account;
        this.transaction = transaction;
        this.transfer = transfer;
        this.get = get;
        initComponents();
        
        date_idtrans.setText(create_date(transaction.getTransaction_date())+" ∙ No. Transaksi : "+transaction.getTransaction_id());
        nama_penerima.setText(get.getCustomer().getFirst_name() + " " + get.getCustomer().getLast_name());
        to_accid.setText("Account ID - "+transfer.getTo_account_id());
        BigDecimal total = new BigDecimal(transfer.getAmount()).setScale(0, RoundingMode.HALF_EVEN);
        total_transfer.setText("Rp. "+formatNominal(total));
        nama_pengirim.setText(account.getCustomer().getFirst_name()+" "+account.getCustomer().getLast_name());
        from_accid.setText("Account ID - "+account.getAccount_id());
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
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
        total_transfer = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        nama_pengirim = new javax.swing.JLabel();
        from_accid = new javax.swing.JLabel();
        nextButton1 = new view.PanelRound();
        jLabel13 = new javax.swing.JLabel();

        jLabel6.setText("jLabel6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Transfer Berhasil!");

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
        jLabel8.setText("Total Transaksi");

        total_transfer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        total_transfer.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        total_transfer.setText("Rp. 1.000.000");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Rekening Sumber");

        nama_pengirim.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nama_pengirim.setText("Nama");

        from_accid.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        from_accid.setForeground(new java.awt.Color(102, 102, 102));
        from_accid.setText("Account ID - 210711111");

        nextButton1.setBackground(new java.awt.Color(73, 105, 166));
        nextButton1.setRoundBottomLeft(50);
        nextButton1.setRoundBottomRight(50);
        nextButton1.setRoundTopLeft(50);
        nextButton1.setRoundTopRight(50);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Kembali ke Dashboard");
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout nextButton1Layout = new javax.swing.GroupLayout(nextButton1);
        nextButton1.setLayout(nextButton1Layout);
        nextButton1Layout.setHorizontalGroup(
            nextButton1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        nextButton1Layout.setVerticalGroup(
            nextButton1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(from_accid)
                    .addComponent(nama_pengirim)
                    .addComponent(jLabel10)
                    .addComponent(jLabel7)
                    .addComponent(to_accid)
                    .addComponent(nama_penerima)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(total_transfer, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nextButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nama_penerima)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(to_accid)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(total_transfer))
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nama_pengirim)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(from_accid)
                .addGap(98, 98, 98)
                .addComponent(nextButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(HistoriTransferView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistoriTransferView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistoriTransferView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistoriTransferView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HistoriTransferView(new Accounts(0, "", 0, new Customers(0, "", "", "", "", ""), "", ""), new Transactions("",0,"",""), new Transfers("", 0, 0, 0.0), new Accounts(0, "", 0, new Customers(0, "", "", "", "", ""), "", "")).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel date_idtrans;
    private javax.swing.JLabel from_accid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel nama_penerima;
    private javax.swing.JLabel nama_pengirim;
    private view.PanelRound nextButton1;
    private javax.swing.JLabel to_accid;
    private javax.swing.JLabel total_transfer;
    // End of variables declaration//GEN-END:variables
}

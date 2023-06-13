/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.customer.histori;

import control.AccountsControl;
import control.LoansControl;
import control.TransactionsControl;
import control.TransfersControl;
import java.awt.Color;
import javax.swing.table.TableModel;
import model.Accounts;
import model.Customers;
import view.customer.CustomerView;

/**
 *
 * @author personal7
 */
public class HistoriView extends javax.swing.JFrame {
    private Accounts account;
    private static TransactionsControl TransactionsControl = new TransactionsControl();
    private static TransfersControl TransfersControl = new TransfersControl();
    private static AccountsControl AccountsControl = new AccountsControl();
    private static LoansControl LoansControl = new LoansControl();
    private String selectedTransactionFK = "";
    private String selectedTransactionID = "";
    private String selectedTipePeminjaman = "";
    
    /**
     * Creates new form HistoriView
     */
    public HistoriView(Accounts account) {
        this.account = account;
        initComponents();
        setDefault();
        showDaftarTransfers();
    }
    
    public void setDefault(){
        nextButton2.setBackground(Color.gray);
    }
    
    public void setDetailEnable(){
        nextButton2.setBackground(new java.awt.Color(73,105,166));
    }
    
    public void showDaftarTransfers(){
        tabelHistori.setModel(TransactionsControl.getTransaction(account.getAccount_id(), ""));
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelHistori = new javax.swing.JTable();
        nextButton2 = new view.PanelRound();
        jLabel5 = new javax.swing.JLabel();
        nextButton5 = new view.PanelRound();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Histori Transaksi");

        tabelHistori.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelHistori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelHistoriMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelHistori);

        nextButton2.setBackground(new java.awt.Color(73, 105, 166));
        nextButton2.setRoundBottomLeft(50);
        nextButton2.setRoundBottomRight(50);
        nextButton2.setRoundTopLeft(50);
        nextButton2.setRoundTopRight(50);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Detail Transaksi");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout nextButton2Layout = new javax.swing.GroupLayout(nextButton2);
        nextButton2.setLayout(nextButton2Layout);
        nextButton2Layout.setHorizontalGroup(
            nextButton2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        nextButton2Layout.setVerticalGroup(
            nextButton2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
        );

        nextButton5.setBackground(java.awt.Color.gray);
        nextButton5.setRoundBottomLeft(50);
        nextButton5.setRoundBottomRight(50);
        nextButton5.setRoundTopLeft(50);
        nextButton5.setRoundTopRight(50);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Kembali");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout nextButton5Layout = new javax.swing.GroupLayout(nextButton5);
        nextButton5.setLayout(nextButton5Layout);
        nextButton5Layout.setHorizontalGroup(
            nextButton5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        nextButton5Layout.setVerticalGroup(
            nextButton5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(nextButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nextButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(nextButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nextButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
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

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        if(selectedTipePeminjaman.equals("Peminjaman Uang")){
            this.dispose();
            new HistoriPeminjaman(
                    account, 
                    TransactionsControl.singleTransaction(account.getAccount_id(), selectedTransactionID, ""), 
                    LoansControl.getLoan(selectedTransactionFK, "")
            ).setVisible(true);
        } else if(selectedTipePeminjaman.equals("Transfers")){
            this.dispose();
            new HistoriTransferView(
                    account, 
                    TransactionsControl.singleTransaction(account.getAccount_id(), selectedTransactionID, ""), 
                    TransfersControl.singleTransfers(selectedTransactionFK), 
                    AccountsControl.selectAccount(210700001)).setVisible(true);
        }
       
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        this.dispose();
        new CustomerView(account).setVisible(true);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void tabelHistoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelHistoriMouseClicked
        // TODO add your handling code here:
        setDetailEnable();
        int clickedRow = tabelHistori.getSelectedRow();
        TableModel tableModel = tabelHistori.getModel();
        
        selectedTransactionID = tableModel.getValueAt(clickedRow, 0).toString();
        selectedTipePeminjaman = tableModel.getValueAt(clickedRow, 1).toString();
        selectedTransactionFK = tableModel.getValueAt(clickedRow,3).toString();
    }//GEN-LAST:event_tabelHistoriMouseClicked

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
            java.util.logging.Logger.getLogger(HistoriView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistoriView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistoriView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistoriView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HistoriView(new Accounts(0, "", 0, new Customers(0, "", "", "", "", ""), "", "")).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private view.PanelRound nextButton2;
    private view.PanelRound nextButton5;
    private javax.swing.JTable tabelHistori;
    // End of variables declaration//GEN-END:variables
}
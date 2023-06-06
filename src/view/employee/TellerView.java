/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.employee;

/**
 *
 * @author riksi
 */
public class TellerView extends javax.swing.JFrame {

    /**
     * Creates new form TellerView
     */
    public TellerView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        base = new javax.swing.JPanel();
        tellerLabel = new javax.swing.JLabel();
        logoutBtn = new javax.swing.JButton();
        loansPanel = new view.PanelRound();
        loansLabel = new javax.swing.JLabel();
        transferPanel = new view.PanelRound();
        transferLabel = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        base.setBackground(new java.awt.Color(232, 249, 253));

        tellerLabel.setBackground(new java.awt.Color(0, 0, 0));
        tellerLabel.setFont(new java.awt.Font("Poppins Medium", 0, 48)); // NOI18N
        tellerLabel.setForeground(new java.awt.Color(0, 0, 0));
        tellerLabel.setText("Teller");

        logoutBtn.setBackground(new java.awt.Color(194, 16, 16));
        logoutBtn.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        logoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        logoutBtn.setText("Log out");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        loansPanel.setBackground(new java.awt.Color(208, 232, 242));
        loansPanel.setPreferredSize(new java.awt.Dimension(250, 80));
        loansPanel.setRoundBottomLeft(20);
        loansPanel.setRoundBottomRight(20);
        loansPanel.setRoundTopLeft(20);
        loansPanel.setRoundTopRight(20);
        loansPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loansPanelMouseClicked(evt);
            }
        });

        loansLabel.setFont(new java.awt.Font("Poppins Medium", 0, 24)); // NOI18N
        loansLabel.setForeground(new java.awt.Color(0, 0, 0));
        loansLabel.setText("Loans");

        javax.swing.GroupLayout loansPanelLayout = new javax.swing.GroupLayout(loansPanel);
        loansPanel.setLayout(loansPanelLayout);
        loansPanelLayout.setHorizontalGroup(
            loansPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loansPanelLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(loansLabel)
                .addContainerGap(93, Short.MAX_VALUE))
        );
        loansPanelLayout.setVerticalGroup(
            loansPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loansPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(loansLabel)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        transferPanel.setBackground(new java.awt.Color(182, 227, 136));
        transferPanel.setPreferredSize(new java.awt.Dimension(250, 80));
        transferPanel.setRoundBottomLeft(20);
        transferPanel.setRoundBottomRight(20);
        transferPanel.setRoundTopLeft(20);
        transferPanel.setRoundTopRight(20);
        transferPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transferPanelMouseClicked(evt);
            }
        });

        transferLabel.setFont(new java.awt.Font("Poppins Medium", 0, 24)); // NOI18N
        transferLabel.setForeground(new java.awt.Color(0, 0, 0));
        transferLabel.setText("Transfer");

        javax.swing.GroupLayout transferPanelLayout = new javax.swing.GroupLayout(transferPanel);
        transferPanel.setLayout(transferPanelLayout);
        transferPanelLayout.setHorizontalGroup(
            transferPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transferPanelLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(transferLabel)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        transferPanelLayout.setVerticalGroup(
            transferPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transferPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(transferLabel)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout baseLayout = new javax.swing.GroupLayout(base);
        base.setLayout(baseLayout);
        baseLayout.setHorizontalGroup(
            baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(baseLayout.createSequentialGroup()
                .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(baseLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(logoutBtn))
                    .addGroup(baseLayout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(transferPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(loansPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, baseLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tellerLabel)
                                .addGap(63, 63, 63)))))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        baseLayout.setVerticalGroup(
            baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(baseLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(tellerLabel)
                .addGap(49, 49, 49)
                .addComponent(loansPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(transferPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
                .addComponent(logoutBtn)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(base, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(base, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void transferPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transferPanelMouseClicked
        TellerTransferView tf = new TellerTransferView();
        this.dispose();
        tf.setVisible(true);
    }//GEN-LAST:event_transferPanelMouseClicked

    private void loansPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loansPanelMouseClicked
        TellerLoansView tl = new TellerLoansView();
        this.dispose();
        tl.setVisible(true);
    }//GEN-LAST:event_loansPanelMouseClicked

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
            java.util.logging.Logger.getLogger(TellerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TellerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TellerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TellerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TellerView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel base;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel loansLabel;
    private view.PanelRound loansPanel;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JLabel tellerLabel;
    private javax.swing.JLabel transferLabel;
    private view.PanelRound transferPanel;
    // End of variables declaration//GEN-END:variables
}
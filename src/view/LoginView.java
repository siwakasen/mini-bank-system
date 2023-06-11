
package view;

public class LoginView extends javax.swing.JFrame {
    /**
     * Creates new form LoginView
     */
    public LoginView() {
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

        base = new javax.swing.JPanel();
        gambar = new javax.swing.JLabel();
        rightPanel = new javax.swing.JPanel();
        userInput = new javax.swing.JTextField();
        loginBtn = new javax.swing.JButton();
        userlabel = new javax.swing.JLabel();
        passlabel = new javax.swing.JLabel();
        loginlabel = new javax.swing.JLabel();
        passwordInput = new javax.swing.JPasswordField();
        minibankLabel = new javax.swing.JLabel();
        welcomeLabel = new javax.swing.JLabel();
        katakataPanel = new view.PanelRound();
        baris1 = new javax.swing.JLabel();
        baris2 = new javax.swing.JLabel();
        baris3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        base.setBackground(new java.awt.Color(255, 255, 255));
        base.setPreferredSize(new java.awt.Dimension(1650, 1080));

        gambar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/login/login.jpg"))); // NOI18N

        rightPanel.setBackground(new java.awt.Color(235, 235, 255));

        userInput.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        userInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userInputActionPerformed(evt);
            }
        });

        loginBtn.setBackground(new java.awt.Color(102, 153, 255));
        loginBtn.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        loginBtn.setText("Login");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        userlabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        userlabel.setText("Username");

        passlabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        passlabel.setText("Password");

        loginlabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        loginlabel.setText("Login");

        passwordInput.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        passwordInput.setPreferredSize(new java.awt.Dimension(64, 27));

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userlabel)
                    .addComponent(userInput, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passlabel)
                    .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rightPanelLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(loginlabel))
                    .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(1333, Short.MAX_VALUE))
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(loginlabel)
                .addGap(26, 26, 26)
                .addComponent(userlabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userInput, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passlabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(466, Short.MAX_VALUE))
        );

        minibankLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 48)); // NOI18N
        minibankLabel.setText("MiniBank");

        welcomeLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 44)); // NOI18N

        katakataPanel.setBackground(new java.awt.Color(235, 235, 255));
        katakataPanel.setRoundBottomLeft(70);
        katakataPanel.setRoundBottomRight(70);
        katakataPanel.setRoundTopRight(70);

        baris1.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        baris1.setText("Welcome to MiniBank, your trusted financial companion!");

        baris2.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        baris2.setText("Unlock a world of possibilities and take control of your banking journey.");

        baris3.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        baris3.setText("Login now and experience banking made simple and secure.");

        javax.swing.GroupLayout katakataPanelLayout = new javax.swing.GroupLayout(katakataPanel);
        katakataPanel.setLayout(katakataPanelLayout);
        katakataPanelLayout.setHorizontalGroup(
            katakataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(katakataPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(katakataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(katakataPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(baris3))
                    .addComponent(baris2)
                    .addComponent(baris1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        katakataPanelLayout.setVerticalGroup(
            katakataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(katakataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(baris1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(baris2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(baris3)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout baseLayout = new javax.swing.GroupLayout(base);
        base.setLayout(baseLayout);
        baseLayout.setHorizontalGroup(
            baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(baseLayout.createSequentialGroup()
                .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(baseLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(gambar, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(baseLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(katakataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(baseLayout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(welcomeLabel)
                        .addGap(67, 67, 67)
                        .addComponent(minibankLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
        );
        baseLayout.setVerticalGroup(
            baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(baseLayout.createSequentialGroup()
                .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(baseLayout.createSequentialGroup()
                        .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(baseLayout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(welcomeLabel)
                                .addGap(70, 70, 70))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, baseLayout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(minibankLabel)
                                .addGap(35, 35, 35)))
                        .addComponent(katakataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(gambar, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(134, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(base, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(base, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginBtnActionPerformed

    private void userInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userInputActionPerformed

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
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel baris1;
    private javax.swing.JLabel baris2;
    private javax.swing.JLabel baris3;
    private javax.swing.JPanel base;
    private javax.swing.JLabel gambar;
    private view.PanelRound katakataPanel;
    private javax.swing.JButton loginBtn;
    private javax.swing.JLabel loginlabel;
    private javax.swing.JLabel minibankLabel;
    private javax.swing.JLabel passlabel;
    private javax.swing.JPasswordField passwordInput;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JTextField userInput;
    private javax.swing.JLabel userlabel;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}

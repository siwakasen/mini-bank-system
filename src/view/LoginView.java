
package view;

import control.AdministratorsControl;
import control.EmployeesControl;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JOptionPane;
import model.Administrators;
import model.Employees;
import view.admin.*;
import view.employee.*;

public class LoginView extends javax.swing.JFrame {
    private AdministratorsControl adminControl;
    private EmployeesControl empControl;
    private Administrators admin;
    private Employees emp;
    private DasboardView dasView;
    public LoginView() {
        
        initComponents();
        init();
        initJFrame();
    }
    
        
    public void initJFrame(){
        setLocationRelativeTo(null);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
    }
    
    public void init(){
        titleBar.initJFram(this);
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
        panelRound1 = new view.PanelRound();
        loginlabel = new javax.swing.JLabel();
        passlabel = new javax.swing.JLabel();
        userlabel = new javax.swing.JLabel();
        loginBtn = new javax.swing.JButton();
        userInput = new javax.swing.JTextField();
        passwordInput = new javax.swing.JPasswordField();
        minibankLabel = new javax.swing.JLabel();
        welcomeLabel = new javax.swing.JLabel();
        katakataPanel = new view.PanelRound();
        baris1 = new javax.swing.JLabel();
        baris2 = new javax.swing.JLabel();
        baris3 = new javax.swing.JLabel();
        titleBar = new javaswingdev.swing.titlebar.TitleBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1366, 720));

        base.setBackground(new java.awt.Color(255, 255, 255));
        base.setPreferredSize(new java.awt.Dimension(1650, 1080));

        gambar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/login/login.jpg"))); // NOI18N

        rightPanel.setBackground(new java.awt.Color(235, 235, 255));
        rightPanel.setPreferredSize(new java.awt.Dimension(600, 720));

        panelRound1.setBackground(new java.awt.Color(224, 224, 255));
        panelRound1.setPreferredSize(new java.awt.Dimension(428, 339));
        panelRound1.setRoundBottomLeft(70);
        panelRound1.setRoundBottomRight(70);
        panelRound1.setRoundTopLeft(70);
        panelRound1.setRoundTopRight(70);

        loginlabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        loginlabel.setForeground(new java.awt.Color(0, 0, 0));
        loginlabel.setText("Login");

        passlabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        passlabel.setForeground(new java.awt.Color(0, 0, 0));
        passlabel.setText("Password");

        userlabel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        userlabel.setForeground(new java.awt.Color(0, 0, 0));
        userlabel.setText("Username");

        loginBtn.setBackground(new java.awt.Color(102, 153, 255));
        loginBtn.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 24)); // NOI18N
        loginBtn.setForeground(new java.awt.Color(245, 245, 245));
        loginBtn.setText("Login");
        loginBtn.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                loginBtnFocusGained(evt);
            }
        });
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });
        loginBtn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                loginBtnKeyPressed(evt);
            }
        });

        userInput.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        userInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userInputActionPerformed(evt);
            }
        });

        passwordInput.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        passwordInput.setNextFocusableComponent(loginBtn);
        passwordInput.setPreferredSize(new java.awt.Dimension(64, 27));

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginlabel)
                    .addComponent(userlabel)
                    .addComponent(userInput, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passlabel)
                    .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(loginlabel)
                .addGap(18, 18, 18)
                .addComponent(userlabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userInput, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passlabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightPanelLayout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rightPanelLayout.createSequentialGroup()
                .addContainerGap(183, Short.MAX_VALUE)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(182, 182, 182))
        );

        minibankLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 48)); // NOI18N
        minibankLabel.setForeground(new java.awt.Color(0, 0, 0));
        minibankLabel.setText("MiniBank");

        welcomeLabel.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 44)); // NOI18N

        katakataPanel.setBackground(new java.awt.Color(235, 235, 255));
        katakataPanel.setRoundBottomLeft(70);
        katakataPanel.setRoundBottomRight(70);
        katakataPanel.setRoundTopRight(70);

        baris1.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        baris1.setForeground(new java.awt.Color(0, 0, 0));
        baris1.setText("Welcome to MiniBank, your trusted financial companion!");

        baris2.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        baris2.setForeground(new java.awt.Color(0, 0, 0));
        baris2.setText("Unlock a world of possibilities and take control of your banking journey.");

        baris3.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        baris3.setForeground(new java.awt.Color(0, 0, 0));
        baris3.setText("Login now and experience banking made simple and secure.");

        javax.swing.GroupLayout katakataPanelLayout = new javax.swing.GroupLayout(katakataPanel);
        katakataPanel.setLayout(katakataPanelLayout);
        katakataPanelLayout.setHorizontalGroup(
            katakataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(katakataPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(katakataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(baris2, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(baris3, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(baris1, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
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
                    .addComponent(gambar, javax.swing.GroupLayout.PREFERRED_SIZE, 775, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(baseLayout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(welcomeLabel))
                    .addGroup(baseLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(katakataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(baseLayout.createSequentialGroup()
                        .addGap(272, 272, 272)
                        .addComponent(minibankLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(baseLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titleBar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(rightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        baseLayout.setVerticalGroup(
            baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(baseLayout.createSequentialGroup()
                .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(baseLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titleBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(minibankLabel)
                        .addGap(17, 17, 17)
                        .addComponent(welcomeLabel)
                        .addGap(18, 18, 18)
                        .addComponent(katakataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(gambar, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(base, javax.swing.GroupLayout.DEFAULT_SIZE, 1415, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(base, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
       adminControl= new AdministratorsControl();
       empControl=new EmployeesControl();
       
        admin = new Administrators(0, userInput.getText(), String.valueOf(passwordInput.getPassword()));
       emp= new Employees(0,"", "",userInput.getText(), String.valueOf(passwordInput.getPassword()), "", "", 0, "", "");
       
      if(adminControl.searchAdministrators(admin)!=null){
          this.admin=adminControl.searchAdministrators(admin);
           dasView = new DasboardView(admin);
           this.dispose();
           dasView.setVisible(true);
       }else if(empControl.searchEmployees(emp)!=null){
           emp=empControl.searchEmployees(emp);
           if(emp.getRole_id()==1){
               TellerView tv = new TellerView();
               this.dispose();
               tv.setVisible(true);
           }else{
               CustomerServiceView csv = new CustomerServiceView();
               this.dispose();
               csv.setVisible(true);
           }
       }else{
           JOptionPane.showMessageDialog(this,"Username or Password was Incorrect!");
       }
    }//GEN-LAST:event_loginBtnActionPerformed

    private void userInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userInputActionPerformed

    private void loginBtnFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_loginBtnFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_loginBtnFocusGained

    private void loginBtnKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loginBtnKeyPressed
        adminControl= new AdministratorsControl();
       empControl=new EmployeesControl();
       
        admin = new Administrators(0, userInput.getText(), String.valueOf(passwordInput.getPassword()));
       emp= new Employees(0,"", "",userInput.getText(), String.valueOf(passwordInput.getPassword()), "", "", 0, "", "");
       
      if(adminControl.searchAdministrators(admin)!=null){
          this.admin=adminControl.searchAdministrators(admin);
           dasView = new DasboardView(admin);
           this.dispose();
           dasView.setVisible(true);
       }else if(empControl.searchEmployees(emp)!=null){
           emp=empControl.searchEmployees(emp);
           if(emp.getRole_id()==1){
               TellerView tv = new TellerView();
               this.dispose();
               tv.setVisible(true);
           }else{
               CustomerServiceView csv = new CustomerServiceView();
               this.dispose();
               csv.setVisible(true);
           }
       }else{
           JOptionPane.showMessageDialog(this,"Username or Password was Incorrect!");
       }
    }//GEN-LAST:event_loginBtnKeyPressed

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
    private view.PanelRound panelRound1;
    private javax.swing.JLabel passlabel;
    private javax.swing.JPasswordField passwordInput;
    private javax.swing.JPanel rightPanel;
    private javaswingdev.swing.titlebar.TitleBar titleBar;
    private javax.swing.JTextField userInput;
    private javax.swing.JLabel userlabel;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
}

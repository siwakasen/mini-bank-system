
package view.admin;

import control.AdministratorsControl;
import exception.BlankInputException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import model.Administrators;
import table.TableAdministrators;
import view.LoginView;


public class AdminManageView extends javax.swing.JFrame {
    private AdministratorsControl administratorsControl;
    private Administrators admin;
    String action = null;
    List<Administrators> listAdministrators;
    int selectedId = 0;
    /**
     * Creates new form AdminManageView
     */
    public AdminManageView(Administrators admin) {
        initComponents();
        this.admin=admin;
        administratorsControl = new AdministratorsControl();
        setComponent(false);
        setEditDeleteBtn(false);
        showAdministrators();
        
    }
    
    public void setComponent(boolean value){
        
        inputPane.setEnabled(value);
        idInput.setEnabled(value);
        passInput.setEnabled(value);
        userInput.setEnabled(value);
        idlabel.setEnabled(value);
        passlabel.setEnabled(value);
        userlabel.setEnabled(value);
        
  
        saveBtn.setEnabled(value);
        cancelBtn.setEnabled(value);
    }
    
    public void setEditDeleteBtn(boolean value){
        editBtn.setEnabled(value);
        deleteBtn.setEnabled(value);
    }
   
    
    public void showAdministrators(){
        adminTable.setModel(administratorsControl.showAdministrator(""));
    }
    
    public void clearText(){
       idInput.setText("");
       passInput.setText("");
       userInput.setText("");
    }
    
    public void blankInputException() throws BlankInputException{
        if(idInput.getText().isEmpty() || passInput.getText().isEmpty() || userInput.getText().isEmpty()){
            throw new BlankInputException();
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

        base = new javax.swing.JPanel();
        adminBase = new javax.swing.JPanel();
        adminLabel = new javax.swing.JLabel();
        leftSidePane = new javax.swing.JPanel();
        homePane = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        adminPane = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        EmployeePane = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        inputPane = new javax.swing.JPanel();
        passlabel = new javax.swing.JLabel();
        idlabel = new javax.swing.JLabel();
        passInput = new javax.swing.JTextField();
        userInput = new javax.swing.JTextField();
        idInput = new javax.swing.JTextField();
        userlabel = new javax.swing.JLabel();
        btnPanel = new javax.swing.JPanel();
        addBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        saveCancelPane = new javax.swing.JPanel();
        saveBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        adminTable = new javax.swing.JTable();
        logoutBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        base.setBackground(new java.awt.Color(12, 19, 79));

        adminBase.setBackground(new java.awt.Color(29, 38, 125));

        adminLabel.setFont(new java.awt.Font("Poppins Medium", 1, 40)); // NOI18N
        adminLabel.setForeground(new java.awt.Color(246, 241, 241));
        adminLabel.setText("Administrator");

        javax.swing.GroupLayout adminBaseLayout = new javax.swing.GroupLayout(adminBase);
        adminBase.setLayout(adminBaseLayout);
        adminBaseLayout.setHorizontalGroup(
            adminBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminBaseLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(adminLabel)
                .addContainerGap(1309, Short.MAX_VALUE))
        );
        adminBaseLayout.setVerticalGroup(
            adminBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminBaseLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(adminLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        leftSidePane.setBackground(new java.awt.Color(29, 38, 125));
        leftSidePane.setPreferredSize(new java.awt.Dimension(100, 1080));

        homePane.setBackground(new java.awt.Color(255, 255, 255));
        homePane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homePaneMouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/admin/icons8-home-48.png"))); // NOI18N

        javax.swing.GroupLayout homePaneLayout = new javax.swing.GroupLayout(homePane);
        homePane.setLayout(homePaneLayout);
        homePaneLayout.setHorizontalGroup(
            homePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePaneLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        homePaneLayout.setVerticalGroup(
            homePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePaneLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        adminPane.setBackground(new java.awt.Color(255, 255, 255));
        adminPane.setPreferredSize(new java.awt.Dimension(100, 92));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/admin/icons8-admin-64.png"))); // NOI18N

        jPanel4.setBackground(new java.awt.Color(26, 119, 223));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 6, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout adminPaneLayout = new javax.swing.GroupLayout(adminPane);
        adminPane.setLayout(adminPaneLayout);
        adminPaneLayout.setHorizontalGroup(
            adminPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminPaneLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(17, 17, 17))
        );
        adminPaneLayout.setVerticalGroup(
            adminPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminPaneLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addContainerGap(14, Short.MAX_VALUE))
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        EmployeePane.setBackground(new java.awt.Color(255, 255, 255));
        EmployeePane.setPreferredSize(new java.awt.Dimension(100, 92));
        EmployeePane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EmployeePaneMouseClicked(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/admin/icons8-user-64.png"))); // NOI18N

        javax.swing.GroupLayout EmployeePaneLayout = new javax.swing.GroupLayout(EmployeePane);
        EmployeePane.setLayout(EmployeePaneLayout);
        EmployeePaneLayout.setHorizontalGroup(
            EmployeePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EmployeePaneLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(17, 17, 17))
        );
        EmployeePaneLayout.setVerticalGroup(
            EmployeePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EmployeePaneLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout leftSidePaneLayout = new javax.swing.GroupLayout(leftSidePane);
        leftSidePane.setLayout(leftSidePaneLayout);
        leftSidePaneLayout.setHorizontalGroup(
            leftSidePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(homePane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(leftSidePaneLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(adminPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(leftSidePaneLayout.createSequentialGroup()
                .addComponent(EmployeePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        leftSidePaneLayout.setVerticalGroup(
            leftSidePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftSidePaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(homePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adminPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmployeePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 786, Short.MAX_VALUE))
        );

        inputPane.setBackground(new java.awt.Color(12, 19, 79));

        passlabel.setBackground(new java.awt.Color(255, 255, 255));
        passlabel.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        passlabel.setForeground(new java.awt.Color(246, 241, 241));
        passlabel.setText("Password");

        idlabel.setBackground(new java.awt.Color(255, 255, 255));
        idlabel.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        idlabel.setForeground(new java.awt.Color(246, 241, 241));
        idlabel.setText("ID Admin");

        passInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passInputActionPerformed(evt);
            }
        });

        userInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userInputActionPerformed(evt);
            }
        });

        idInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idInputActionPerformed(evt);
            }
        });

        userlabel.setBackground(new java.awt.Color(255, 255, 255));
        userlabel.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        userlabel.setForeground(new java.awt.Color(246, 241, 241));
        userlabel.setText("Username");

        javax.swing.GroupLayout inputPaneLayout = new javax.swing.GroupLayout(inputPane);
        inputPane.setLayout(inputPaneLayout);
        inputPaneLayout.setHorizontalGroup(
            inputPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(passlabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(userlabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(idlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(inputPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(passInput, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(userInput, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(idInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        inputPaneLayout.setVerticalGroup(
            inputPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(idlabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idInput, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(userlabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userInput, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(passlabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passInput, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnPanel.setBackground(new java.awt.Color(12, 19, 79));

        addBtn.setBackground(new java.awt.Color(25, 135, 84));
        addBtn.setFont(new java.awt.Font("Century Gothic", 1, 17)); // NOI18N
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/buttons/icon-add.png"))); // NOI18N
        addBtn.setText("Tambah");
        addBtn.setBorder(null);
        addBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        deleteBtn.setBackground(new java.awt.Color(220, 53, 69));
        deleteBtn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/buttons/icon-delete.png"))); // NOI18N
        deleteBtn.setText("Hapus");
        deleteBtn.setBorder(null);
        deleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        editBtn.setBackground(new java.awt.Color(241, 196, 15));
        editBtn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        editBtn.setForeground(new java.awt.Color(255, 255, 255));
        editBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/buttons/icon-edit.png"))); // NOI18N
        editBtn.setText("Ubah");
        editBtn.setBorder(null);
        editBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout btnPanelLayout = new javax.swing.GroupLayout(btnPanel);
        btnPanel.setLayout(btnPanelLayout);
        btnPanelLayout.setHorizontalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnPanelLayout.setVerticalGroup(
            btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        saveCancelPane.setBackground(new java.awt.Color(12, 19, 79));

        saveBtn.setBackground(new java.awt.Color(13, 110, 253));
        saveBtn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/buttons/icon-save.png"))); // NOI18N
        saveBtn.setText("Simpan");
        saveBtn.setBorder(null);
        saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        cancelBtn.setBackground(new java.awt.Color(220, 53, 69));
        cancelBtn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        cancelBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/buttons/icon-cancel.png"))); // NOI18N
        cancelBtn.setText("Batal");
        cancelBtn.setBorder(null);
        cancelBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout saveCancelPaneLayout = new javax.swing.GroupLayout(saveCancelPane);
        saveCancelPane.setLayout(saveCancelPaneLayout);
        saveCancelPaneLayout.setHorizontalGroup(
            saveCancelPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(saveCancelPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        saveCancelPaneLayout.setVerticalGroup(
            saveCancelPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(saveCancelPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(saveCancelPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        adminTable.setBackground(new java.awt.Color(29, 38, 125));
        adminTable.setForeground(new java.awt.Color(255, 255, 255));
        adminTable.setModel(new javax.swing.table.DefaultTableModel(
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
        adminTable.setSelectionForeground(new java.awt.Color(92, 70, 156));
        adminTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminTableMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                adminTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(adminTable);

        logoutBtn.setBackground(new java.awt.Color(174, 74, 241));
        logoutBtn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        logoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        logoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/buttons/icon-logout.png"))); // NOI18N
        logoutBtn.setText("Logout");
        logoutBtn.setBorder(null);
        logoutBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout baseLayout = new javax.swing.GroupLayout(base);
        base.setLayout(baseLayout);
        baseLayout.setHorizontalGroup(
            baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(baseLayout.createSequentialGroup()
                .addComponent(leftSidePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(baseLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(adminBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(baseLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(baseLayout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(saveCancelPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(inputPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(98, 98, 98)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 802, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(baseLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        baseLayout.setVerticalGroup(
            baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(baseLayout.createSequentialGroup()
                .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(leftSidePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(baseLayout.createSequentialGroup()
                        .addComponent(adminBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(baseLayout.createSequentialGroup()
                                .addComponent(btnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(inputPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(saveCancelPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73)
                        .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(base, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(base, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
          
    
    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        if(admin.getAdministrator_id()!=1){
            JOptionPane.showMessageDialog(this, "You don't have permissions to add new Administrators");
            return;
        }
        setEditDeleteBtn(false);
        setComponent(true);
        clearText();
        action = "Add";
    }//GEN-LAST:event_addBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        System.out.println("This admin ID : "+admin.getAdministrator_id());
        if(admin.getAdministrator_id()!=1){
            JOptionPane.showMessageDialog(this, "You don't have permissions to delete another Administrators");
            return;
        }
        int getAnswer = JOptionPane.showConfirmDialog(rootPane, "Are you sure want to delete data?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if(getAnswer == 0){
            try{
                administratorsControl.deleteAdministrator(Integer.parseInt(idInput.getText()));
                clearText();
                setComponent(false);
                setEditDeleteBtn(false);
                addBtn.setEnabled(true);
                showAdministrators();
                JOptionPane.showMessageDialog(this, "Successfully delete administrators data");
            } catch(Exception e){
                System.out.println("Error deleting data...");
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        if(admin.getAdministrator_id()!=1){
            JOptionPane.showMessageDialog(this, "You don't have permissions to edit another Administrators");
            return;
        }
        addBtn.setEnabled(false);
        deleteBtn.setEnabled(false);
        setComponent(true);
        idInput.setEnabled(false);
        action = "Change";
    }//GEN-LAST:event_editBtnActionPerformed

    private void passInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passInputActionPerformed

    private void idInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idInputActionPerformed

    private void userInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userInputActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
//        // TODO add your handling code here:
        try{
            blankInputException();

            if(action.equals("Add")){
                int getAnswer = JOptionPane.showConfirmDialog(rootPane, "Are you sure want to add administrators?","Confirmation", JOptionPane.YES_NO_OPTION);
                if(getAnswer == JOptionPane.YES_OPTION){
                    Administrators a = new Administrators (Integer.parseInt(idInput.getText()), userInput.getText(), passInput.getText());
                    administratorsControl.insertAdministrator(a);
                    JOptionPane.showMessageDialog(this, "Success to add administrators");
                }else {
                    JOptionPane.showMessageDialog(this, "Failed to add administrators");
                }
            }else{
                int getAnswer = JOptionPane.showConfirmDialog(rootPane, "Are you sure want to change administrators?","Confirmation", JOptionPane.YES_NO_OPTION);
                if(getAnswer == JOptionPane.YES_OPTION){
                    Administrators a = new Administrators (Integer.parseInt(idInput.getText()), userInput.getText(), passInput.getText());
                    administratorsControl.updateAdministrator(a);
                    JOptionPane.showMessageDialog(this, "Success to change administrators");
                }else {
                    JOptionPane.showMessageDialog(this, "Failed to change administrators");
                }
            }
            clearText();
            setComponent(false);
            setEditDeleteBtn(false);
            showAdministrators();
        } catch(BlankInputException e){
            JOptionPane.showConfirmDialog(null, "Input cannot be empty", "Warning", JOptionPane.DEFAULT_OPTION);
            System.out.println("Error: " + e.toString());
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        // TODO add your handling code here:
        setComponent(false);
        setEditDeleteBtn(false);
        showAdministrators();
        addBtn.setEnabled(true);
        clearText();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void homePaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homePaneMouseClicked
       DasboardView ds = new DasboardView(admin);
       this.dispose();
       ds.setVisible(true);
    }//GEN-LAST:event_homePaneMouseClicked

    private void EmployeePaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EmployeePaneMouseClicked
        EmployeeManageView ep = new EmployeeManageView(admin);
        this.dispose();
        ep.setVisible(true);
    }//GEN-LAST:event_EmployeePaneMouseClicked

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
       LoginView lv = new LoginView();
        this.dispose();
        lv.setVisible(true);
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void adminTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminTableMouseClicked
        
        setComponent(false);
        setEditDeleteBtn(true);
        cancelBtn.setEnabled(true);
        addBtn.setEnabled(false);
        int clickedRow = adminTable.getSelectedRow();
        TableModel tableModel = adminTable.getModel();

        idInput.setText(tableModel.getValueAt(clickedRow, 0).toString());
        userInput.setText(tableModel.getValueAt(clickedRow, 1).toString());
        if(this.admin.getUsername().equals(tableModel.getValueAt(clickedRow, 1).toString())){
            passInput.setText(this.admin.getPassword());
        }else{
            System.out.println(tableModel.getValueAt(clickedRow, 1).toString());
            System.out.println("masuk");
           passInput.setText(tableModel.getValueAt(clickedRow, 2).toString());
            
        }
        
    }//GEN-LAST:event_adminTableMouseClicked

    private void adminTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminTableMouseReleased
        
    }//GEN-LAST:event_adminTableMouseReleased

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
            java.util.logging.Logger.getLogger(AdminManageView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminManageView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminManageView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminManageView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminManageView(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel EmployeePane;
    private javax.swing.JButton addBtn;
    private javax.swing.JPanel adminBase;
    private javax.swing.JLabel adminLabel;
    private javax.swing.JPanel adminPane;
    private javax.swing.JTable adminTable;
    private javax.swing.JPanel base;
    private javax.swing.JPanel btnPanel;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JPanel homePane;
    private javax.swing.JTextField idInput;
    private javax.swing.JLabel idlabel;
    private javax.swing.JPanel inputPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel leftSidePane;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JTextField passInput;
    private javax.swing.JLabel passlabel;
    private javax.swing.JButton saveBtn;
    private javax.swing.JPanel saveCancelPane;
    private javax.swing.JTextField userInput;
    private javax.swing.JLabel userlabel;
    // End of variables declaration//GEN-END:variables
}

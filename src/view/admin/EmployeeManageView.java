
package view.admin;

import control.EmployeesControl;
import exception.*;
import java.awt.geom.RoundRectangle2D;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import model.Employees;
import model.Administrators;
import table.TableEmployees;
import view.LoginView;


public class EmployeeManageView extends javax.swing.JFrame {
    private EmployeesControl employeesControl;
    private Administrators admin;
    String action = null;
    List<Employees> listEmployees;
    int selectedId = 0;
    
    /**
     * Creates new form EmployeeManageView
     */
    public EmployeeManageView(Administrators admin) {
        initComponents();
        this.admin=admin;
        employeesControl = new EmployeesControl();
        setComponent(false);
        setEditDeleteBtn(false);
        showEmployees();
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
    
    
    public void setComponent(boolean value){
        
//        inputPane.setEnabled(value);
//        rolePane.setEnabled(value);
        idInput.setEnabled(value);
        firstInput.setEnabled(value);
        lastInput.setEnabled(value);
        idLabel.setEnabled(value);
        firstLabel.setEnabled(value);
        lastLabel.setEnabled(value);
        
        
//        userpassPane.setEnabled(value);
        passInput.setEnabled(value);
        userInput.setEnabled(value);
        passLabel.setEnabled(value);
        userLabel.setEnabled(value);
        
//        startendPane.setEnabled(value);
        startWorkDate.setEnabled(value);
        endWorkDate.setEnabled(value);
        startLabel.setEnabled(value);
        endLabel.setEnabled(value);
        
//        rolePane.setEnabled(value);
        tellerRadio.setEnabled(value);
        custumerRadio.setEnabled(value);
        roleLabel.setEnabled(value);
        
        
//        stationOfficePane.setEnabled(value);
        stationInput.setEnabled(value);
        officeInput.setEnabled(value);
        stationLabel.setEnabled(value);
        officeLabel.setEnabled(value);
        
        saveBtn.setEnabled(value);
        cancelBtn.setEnabled(value);
    }
    
    public void setEditDeleteBtn(boolean value){
        editBtn.setEnabled(value);
        deleteBtn.setEnabled(value);
    }
    
    public void showEmployees(){
        employeeTable.setModel(employeesControl.showEmployees(""));
    }
    
    public void clearText(){
       idInput.setText("");
       firstInput.setText("");
       lastInput.setText("");
       passInput.setText("");
       userInput.setText("");
       startWorkDate.setCalendar(null);
       endWorkDate.setCalendar(null);
       stationInput.setText("");
       officeInput.setText("");
       tellerRadio.setSelected(false);
       custumerRadio.setSelected(false);
    }
    
    public void blankInputException() throws BlankInputException{
        if(tellerRadio.isSelected()){
            if(idInput.getText().isEmpty() || firstInput.getText().isEmpty() || lastInput.getText().isEmpty()
                || userInput.getText().isEmpty() || passInput.getText().isEmpty()
                || stationInput.getText().isEmpty()){
                throw new BlankInputException();
            }
        }else{
            if(idInput.getText().isEmpty() || firstInput.getText().isEmpty() || lastInput.getText().isEmpty()
                || userInput.getText().isEmpty() || passInput.getText().isEmpty()
                || officeInput.getText().isEmpty()){
                throw new BlankInputException();
            }
        }
    }
    public String convDateSql(Date input){
        String dateSql = null;
        Date fromView = input;    
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");   
        Date date = new Date(fromView.getTime());
                try {
                    dateSql = format.format(date);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
        
        return dateSql;
    }
    
    public void blankRadioInputException() throws BlankInputException{
        if(tellerRadio.isSelected() || custumerRadio.isSelected()){
            throw new BlankInputException();
        }
    }
    private void invalidCalendarException() throws InvalidCalendarException{
        if(startWorkDate.getCalendar()==null || endWorkDate.getCalendar()==null){
            throw new InvalidCalendarException();
        }else if(startWorkDate.getCalendar().compareTo(endWorkDate.getCalendar())>0){
            throw new InvalidCalendarException();
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

        roleBtnGroup = new javax.swing.ButtonGroup();
        base = new javax.swing.JPanel();
        backgroundInput = new view.PanelRound();
        lastInput = new javax.swing.JTextField();
        lastLabel = new javax.swing.JLabel();
        firstInput = new javax.swing.JTextField();
        firstLabel = new javax.swing.JLabel();
        idInput = new javax.swing.JTextField();
        idLabel = new javax.swing.JLabel();
        leftSidePane = new javax.swing.JPanel();
        panelHome = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelAdmin = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        panelEmployee = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        logoutBtn = new javax.swing.JButton();
        searchBtn = new javax.swing.JButton();
        searchInput = new javax.swing.JTextField();
        addBtn = new javax.swing.JButton();
        editBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        backgroundTable = new view.PanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        employeeTable = new javax.swing.JTable();
        backgroundInput2 = new view.PanelRound();
        endLabel = new javax.swing.JLabel();
        startLabel = new javax.swing.JLabel();
        startWorkDate = new com.toedter.calendar.JDateChooser();
        endWorkDate = new com.toedter.calendar.JDateChooser();
        saveBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        backgroundPane1 = new view.PanelRound();
        officeInput = new javax.swing.JTextField();
        officeLabel = new javax.swing.JLabel();
        stationInput = new javax.swing.JTextField();
        stationLabel = new javax.swing.JLabel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        labelPane = new javax.swing.JLabel();
        titleBar = new javaswingdev.swing.titlebar.TitleBar();
        jLabel3 = new javax.swing.JLabel();
        backgroundPane2 = new view.PanelRound();
        userLabel = new javax.swing.JLabel();
        userInput = new javax.swing.JTextField();
        passLabel = new javax.swing.JLabel();
        passInput = new javax.swing.JTextField();
        roleLabel = new javax.swing.JLabel();
        tellerRadio = new javax.swing.JRadioButton();
        custumerRadio = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        base.setBackground(new java.awt.Color(245, 245, 245));
        base.setPreferredSize(new java.awt.Dimension(1366, 720));

        backgroundInput.setBackground(new java.awt.Color(255, 255, 255));
        backgroundInput.setPreferredSize(new java.awt.Dimension(285, 100));
        backgroundInput.setRoundBottomLeft(20);
        backgroundInput.setRoundBottomRight(20);
        backgroundInput.setRoundTopLeft(20);
        backgroundInput.setRoundTopRight(20);
        backgroundInput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backgroundInputMouseClicked(evt);
            }
        });

        lastInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastInputActionPerformed(evt);
            }
        });

        lastLabel.setBackground(new java.awt.Color(0, 0, 0));
        lastLabel.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lastLabel.setForeground(new java.awt.Color(0, 0, 0));
        lastLabel.setText("Last Name");

        firstInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstInputActionPerformed(evt);
            }
        });

        firstLabel.setBackground(new java.awt.Color(0, 0, 0));
        firstLabel.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        firstLabel.setForeground(new java.awt.Color(0, 0, 0));
        firstLabel.setText("First Name");

        idInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idInputActionPerformed(evt);
            }
        });

        idLabel.setBackground(new java.awt.Color(0, 0, 0));
        idLabel.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        idLabel.setForeground(new java.awt.Color(0, 0, 0));
        idLabel.setText("ID Employee");

        javax.swing.GroupLayout backgroundInputLayout = new javax.swing.GroupLayout(backgroundInput);
        backgroundInput.setLayout(backgroundInputLayout);
        backgroundInputLayout.setHorizontalGroup(
            backgroundInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundInputLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(backgroundInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lastLabel)
                    .addGroup(backgroundInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lastInput, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(idLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(firstLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(firstInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(idInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        backgroundInputLayout.setVerticalGroup(
            backgroundInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundInputLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(idLabel)
                .addGap(5, 5, 5)
                .addComponent(idInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(firstLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(firstInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lastLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lastInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        leftSidePane.setBackground(new java.awt.Color(255, 255, 255));
        leftSidePane.setPreferredSize(new java.awt.Dimension(100, 1080));

        panelHome.setBackground(new java.awt.Color(255, 255, 255));
        panelHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelHomeMouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/admin/dashboard.png"))); // NOI18N

        javax.swing.GroupLayout panelHomeLayout = new javax.swing.GroupLayout(panelHome);
        panelHome.setLayout(panelHomeLayout);
        panelHomeLayout.setHorizontalGroup(
            panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelHomeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(25, 25, 25))
        );
        panelHomeLayout.setVerticalGroup(
            panelHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelHomeLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        panelAdmin.setBackground(new java.awt.Color(255, 255, 255));
        panelAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelAdminMouseClicked(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/admin/businessman.png"))); // NOI18N

        javax.swing.GroupLayout panelAdminLayout = new javax.swing.GroupLayout(panelAdmin);
        panelAdmin.setLayout(panelAdminLayout);
        panelAdminLayout.setHorizontalGroup(
            panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAdminLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(25, 25, 25))
        );
        panelAdminLayout.setVerticalGroup(
            panelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAdminLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel4)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        panelEmployee.setBackground(new java.awt.Color(245, 245, 245));
        panelEmployee.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 5, 1, 0, new java.awt.Color(255, 183, 0)));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/admin/manager.png"))); // NOI18N

        javax.swing.GroupLayout panelEmployeeLayout = new javax.swing.GroupLayout(panelEmployee);
        panelEmployee.setLayout(panelEmployeeLayout);
        panelEmployeeLayout.setHorizontalGroup(
            panelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEmployeeLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelEmployeeLayout.setVerticalGroup(
            panelEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEmployeeLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        logoutBtn.setBackground(new java.awt.Color(255, 0, 0));
        logoutBtn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        logoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        logoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/buttons/icon-logout.png"))); // NOI18N
        logoutBtn.setText("Logout");
        logoutBtn.setBorder(null);
        logoutBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutBtn.setMaximumSize(new java.awt.Dimension(85, 23));
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout leftSidePaneLayout = new javax.swing.GroupLayout(leftSidePane);
        leftSidePane.setLayout(leftSidePaneLayout);
        leftSidePaneLayout.setHorizontalGroup(
            leftSidePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(leftSidePaneLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );
        leftSidePaneLayout.setVerticalGroup(
            leftSidePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftSidePaneLayout.createSequentialGroup()
                .addComponent(panelHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 215, Short.MAX_VALUE)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        searchBtn.setBackground(new java.awt.Color(13, 110, 253));
        searchBtn.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        searchBtn.setForeground(new java.awt.Color(255, 255, 255));
        searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/buttons/icon-search.png"))); // NOI18N
        searchBtn.setText("Search");
        searchBtn.setBorder(null);
        searchBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        searchInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchInputActionPerformed(evt);
            }
        });

        addBtn.setBackground(new java.awt.Color(25, 135, 84));
        addBtn.setFont(new java.awt.Font("Century Gothic", 1, 17)); // NOI18N
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/buttons/icon-add.png"))); // NOI18N
        addBtn.setText("Add");
        addBtn.setBorder(null);
        addBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        editBtn.setBackground(new java.awt.Color(241, 196, 15));
        editBtn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        editBtn.setForeground(new java.awt.Color(255, 255, 255));
        editBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/buttons/icon-edit.png"))); // NOI18N
        editBtn.setText("Edit");
        editBtn.setBorder(null);
        editBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtnActionPerformed(evt);
            }
        });

        deleteBtn.setBackground(new java.awt.Color(220, 53, 69));
        deleteBtn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/buttons/icon-delete.png"))); // NOI18N
        deleteBtn.setText("Delete");
        deleteBtn.setBorder(null);
        deleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        backgroundTable.setBackground(new java.awt.Color(255, 255, 255));
        backgroundTable.setPreferredSize(new java.awt.Dimension(285, 100));
        backgroundTable.setRoundBottomLeft(20);
        backgroundTable.setRoundBottomRight(20);
        backgroundTable.setRoundTopLeft(20);
        backgroundTable.setRoundTopRight(20);
        backgroundTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backgroundTableMouseClicked(evt);
            }
        });

        employeeTable.setModel(new javax.swing.table.DefaultTableModel(
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
        employeeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employeeTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(employeeTable);

        javax.swing.GroupLayout backgroundTableLayout = new javax.swing.GroupLayout(backgroundTable);
        backgroundTable.setLayout(backgroundTableLayout);
        backgroundTableLayout.setHorizontalGroup(
            backgroundTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundTableLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        backgroundTableLayout.setVerticalGroup(
            backgroundTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundTableLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        backgroundInput2.setBackground(new java.awt.Color(255, 255, 255));
        backgroundInput2.setPreferredSize(new java.awt.Dimension(285, 100));
        backgroundInput2.setRoundBottomLeft(20);
        backgroundInput2.setRoundBottomRight(20);
        backgroundInput2.setRoundTopLeft(20);
        backgroundInput2.setRoundTopRight(20);
        backgroundInput2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backgroundInput2MouseClicked(evt);
            }
        });

        endLabel.setBackground(new java.awt.Color(0, 0, 0));
        endLabel.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        endLabel.setForeground(new java.awt.Color(0, 0, 0));
        endLabel.setText("End Work Date");

        startLabel.setBackground(new java.awt.Color(0, 0, 0));
        startLabel.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        startLabel.setForeground(new java.awt.Color(0, 0, 0));
        startLabel.setText("Start Work Date");

        javax.swing.GroupLayout backgroundInput2Layout = new javax.swing.GroupLayout(backgroundInput2);
        backgroundInput2.setLayout(backgroundInput2Layout);
        backgroundInput2Layout.setHorizontalGroup(
            backgroundInput2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundInput2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(backgroundInput2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(endLabel)
                    .addComponent(startLabel)
                    .addComponent(startWorkDate, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endWorkDate, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        backgroundInput2Layout.setVerticalGroup(
            backgroundInput2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundInput2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(startLabel)
                .addGap(5, 5, 5)
                .addComponent(startWorkDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(endLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(endWorkDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        saveBtn.setBackground(new java.awt.Color(13, 110, 253));
        saveBtn.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/buttons/icon-save.png"))); // NOI18N
        saveBtn.setText("Save");
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

        backgroundPane1.setBackground(new java.awt.Color(255, 255, 255));
        backgroundPane1.setPreferredSize(new java.awt.Dimension(285, 100));
        backgroundPane1.setRoundBottomLeft(20);
        backgroundPane1.setRoundBottomRight(20);
        backgroundPane1.setRoundTopLeft(20);
        backgroundPane1.setRoundTopRight(20);
        backgroundPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backgroundPane1MouseClicked(evt);
            }
        });

        officeInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                officeInputActionPerformed(evt);
            }
        });

        officeLabel.setBackground(new java.awt.Color(0, 0, 0));
        officeLabel.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        officeLabel.setForeground(new java.awt.Color(0, 0, 0));
        officeLabel.setText("Office Number");

        stationInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stationInputActionPerformed(evt);
            }
        });

        stationLabel.setBackground(new java.awt.Color(0, 0, 0));
        stationLabel.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        stationLabel.setForeground(new java.awt.Color(0, 0, 0));
        stationLabel.setText("Station Number");

        javax.swing.GroupLayout backgroundPane1Layout = new javax.swing.GroupLayout(backgroundPane1);
        backgroundPane1.setLayout(backgroundPane1Layout);
        backgroundPane1Layout.setHorizontalGroup(
            backgroundPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPane1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(backgroundPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(stationInput, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(officeInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(officeLabel, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(stationLabel))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        backgroundPane1Layout.setVerticalGroup(
            backgroundPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPane1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(stationLabel)
                .addGap(5, 5, 5)
                .addComponent(stationInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(officeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(officeInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 73, 178));
        kGradientPanel1.setkGradientFocus(1000);
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 149, 182));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(1440, 122));

        labelPane.setBackground(new java.awt.Color(255, 255, 255));
        labelPane.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 48)); // NOI18N
        labelPane.setForeground(new java.awt.Color(255, 255, 255));
        labelPane.setText("Administrator");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/admin/unauthorized-person.png"))); // NOI18N

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(titleBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(kGradientPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(labelPane)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(titleBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelPane)
                        .addGap(20, 20, 20))))
        );

        backgroundPane2.setBackground(new java.awt.Color(255, 255, 255));
        backgroundPane2.setPreferredSize(new java.awt.Dimension(285, 100));
        backgroundPane2.setRoundBottomLeft(20);
        backgroundPane2.setRoundBottomRight(20);
        backgroundPane2.setRoundTopLeft(20);
        backgroundPane2.setRoundTopRight(20);
        backgroundPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backgroundPane2MouseClicked(evt);
            }
        });

        userLabel.setBackground(new java.awt.Color(0, 0, 0));
        userLabel.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        userLabel.setForeground(new java.awt.Color(0, 0, 0));
        userLabel.setText("Username");

        userInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userInputActionPerformed(evt);
            }
        });

        passLabel.setBackground(new java.awt.Color(0, 0, 0));
        passLabel.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        passLabel.setForeground(new java.awt.Color(0, 0, 0));
        passLabel.setText("Password");

        passInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passInputActionPerformed(evt);
            }
        });

        roleLabel.setBackground(new java.awt.Color(0, 0, 0));
        roleLabel.setFont(new java.awt.Font("Poppins Medium", 1, 14)); // NOI18N
        roleLabel.setForeground(new java.awt.Color(0, 0, 0));
        roleLabel.setText("Role");

        roleBtnGroup.add(tellerRadio);
        tellerRadio.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        tellerRadio.setText("Teller");
        tellerRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tellerRadioActionPerformed(evt);
            }
        });

        roleBtnGroup.add(custumerRadio);
        custumerRadio.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        custumerRadio.setText("Customer Service");
        custumerRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custumerRadioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backgroundPane2Layout = new javax.swing.GroupLayout(backgroundPane2);
        backgroundPane2.setLayout(backgroundPane2Layout);
        backgroundPane2Layout.setHorizontalGroup(
            backgroundPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPane2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(backgroundPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roleLabel)
                    .addComponent(tellerRadio, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(custumerRadio)
                    .addGroup(backgroundPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(userLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(passLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(userInput, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(passInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        backgroundPane2Layout.setVerticalGroup(
            backgroundPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPane2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(userLabel)
                .addGap(5, 5, 5)
                .addComponent(userInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(passLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(roleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tellerRadio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(custumerRadio)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout baseLayout = new javax.swing.GroupLayout(base);
        base.setLayout(baseLayout);
        baseLayout.setHorizontalGroup(
            baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1366, Short.MAX_VALUE)
            .addGroup(baseLayout.createSequentialGroup()
                .addComponent(leftSidePane, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(backgroundTable, javax.swing.GroupLayout.PREFERRED_SIZE, 1208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(baseLayout.createSequentialGroup()
                        .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(baseLayout.createSequentialGroup()
                                .addComponent(backgroundInput, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(backgroundPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(backgroundInput2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(baseLayout.createSequentialGroup()
                                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(44, 44, 44)
                        .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, baseLayout.createSequentialGroup()
                                .addComponent(searchInput)
                                .addGap(18, 18, 18)
                                .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(backgroundPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, baseLayout.createSequentialGroup()
                                    .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        baseLayout.setVerticalGroup(
            baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(baseLayout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(baseLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(baseLayout.createSequentialGroup()
                                .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(backgroundPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(backgroundInput2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(saveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(backgroundPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                            .addComponent(backgroundInput, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(backgroundTable, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(leftSidePane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(base, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(base, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backgroundPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backgroundPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_backgroundPane1MouseClicked

    private void stationInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stationInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stationInputActionPerformed

    private void officeInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_officeInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_officeInputActionPerformed

    private void passInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passInputActionPerformed

    private void userInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userInputActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        //        // TODO add your handling code here:
        setComponent(false);
        setEditDeleteBtn(false);
        addBtn.setEnabled(true);
        showEmployees();
        clearText();
        roleBtnGroup.clearSelection();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:
        try{
            blankInputException();
            invalidCalendarException();
            if(action.equals("Add")){
                int getAnswer = JOptionPane.showConfirmDialog(rootPane, "Are you sure to add new Employee?","Confirmation", JOptionPane.YES_NO_OPTION);
                if(getAnswer == JOptionPane.YES_OPTION){
                    if(tellerRadio.isSelected()){
                        Employees e = new Employees (Integer.parseInt(idInput.getText()), firstInput.getText(), lastInput.getText(), userInput.getText(), passInput.getText(),
                            convDateSql(startWorkDate.getDate()), convDateSql(endWorkDate.getDate()), 1, officeInput.getText(), stationInput.getText());
                        employeesControl.insertEmployees(e);
                        JOptionPane.showMessageDialog(this, "Success add new Employee");
                    }else{
                        Employees e = new Employees (Integer.parseInt(idInput.getText()), firstInput.getText(), lastInput.getText(), userInput.getText(), passInput.getText(),
                            convDateSql(startWorkDate.getDate()), convDateSql(endWorkDate.getDate()), 2, officeInput.getText(), stationInput.getText());
                        employeesControl.insertEmployees(e);
                        JOptionPane.showMessageDialog(this, "Success add new Employee");
                    }
                }else {
                    JOptionPane.showMessageDialog(this, "Adding new Employee is canceled");
                }
            }else{
                int getAnswer = JOptionPane.showConfirmDialog(rootPane, "Are you sure to edit this Employee?","Confirmation", JOptionPane.YES_NO_OPTION);
                if(getAnswer == JOptionPane.YES_OPTION){
                    if(tellerRadio.isSelected()){
                        Employees e = new Employees (Integer.parseInt(idInput.getText()), firstInput.getText(), lastInput.getText(), userInput.getText(), passInput.getText(),
                            convDateSql(startWorkDate.getDate()), convDateSql(endWorkDate.getDate()), 1, officeInput.getText(), stationInput.getText());
                        employeesControl.updateEmployees(e);
                        JOptionPane.showMessageDialog(this, "Success editing Employee");
                    }else{
                        Employees e = new Employees (Integer.parseInt(idInput.getText()), firstInput.getText(), lastInput.getText(), userInput.getText(), passInput.getText(),
                            convDateSql(startWorkDate.getDate()), convDateSql(endWorkDate.getDate()), 2, officeInput.getText(), stationInput.getText());
                        employeesControl.updateEmployees(e);
                        JOptionPane.showMessageDialog(this, "Success editing Employee");
                    }
                }else {
                    JOptionPane.showMessageDialog(this, "Editing employee is canceled");
                }
            }
            clearText();
            setComponent(false);
            setEditDeleteBtn(false);
            roleBtnGroup.clearSelection();
            showEmployees();
        } catch(BlankInputException e){
            JOptionPane.showConfirmDialog(null, e.message(), "Warning", JOptionPane.DEFAULT_OPTION);
            System.out.println("Error: " + e.toString());
        }catch(InvalidCalendarException e1){
            JOptionPane.showConfirmDialog(null, e1.message(), "Warning", JOptionPane.DEFAULT_OPTION);
            System.out.println("Error: " + e1.toString());
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void backgroundInput2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backgroundInput2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_backgroundInput2MouseClicked

    private void custumerRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custumerRadioActionPerformed
        // TODO add your handling code here:
        officeLabel.setEnabled(true);
        officeInput.setEnabled(true);
        stationInput.setEnabled(false);
        stationInput.setText("");
    }//GEN-LAST:event_custumerRadioActionPerformed

    private void tellerRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tellerRadioActionPerformed
        // TODO add your handling code here:
        officeInput.setEnabled(false);
        officeInput.setText("");
        stationInput.setEnabled(true);
        stationLabel.setEnabled(true);
    }//GEN-LAST:event_tellerRadioActionPerformed

    private void backgroundTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backgroundTableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_backgroundTableMouseClicked

    private void employeeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeTableMouseClicked
        // TODO add your handling code here:
        setComponent(false);
        setEditDeleteBtn(true);
        cancelBtn.setEnabled(true);
        int clickedRow = employeeTable.getSelectedRow();
        TableModel tableModel = employeeTable.getModel();

        idInput.setText(tableModel.getValueAt(clickedRow, 0).toString());
        firstInput.setText(tableModel.getValueAt(clickedRow, 3).toString());
        lastInput.setText(tableModel.getValueAt(clickedRow, 4).toString());
        passInput.setText(tableModel.getValueAt(clickedRow, 2).toString());
        userInput.setText(tableModel.getValueAt(clickedRow, 1).toString());
        Calendar c = Calendar.getInstance();
        c.set(Integer.parseInt(tableModel.getValueAt(clickedRow,5).toString().substring(6, 10)),
            Integer.parseInt(tableModel.getValueAt(clickedRow,5).toString().substring(3, 5))-1,
            Integer.parseInt(tableModel.getValueAt(clickedRow,5).toString().substring(0, 2)));
        startWorkDate.setCalendar(c);
        c.set(Integer.parseInt(tableModel.getValueAt(clickedRow,6).toString().substring(6, 10)),
            Integer.parseInt(tableModel.getValueAt(clickedRow,6).toString().substring(3, 5))-1,
            Integer.parseInt(tableModel.getValueAt(clickedRow,6).toString().substring(0, 2)));
        endWorkDate.setCalendar(c);
        if(tableModel.getValueAt(clickedRow, 7).toString().equals("Teller")){
            tellerRadio.setSelected(true);
        }else if(tableModel.getValueAt(clickedRow, 7).toString().equals("Customer Services")){
            custumerRadio.setSelected(true);
        }

        if(tellerRadio.isSelected()){
            stationInput.setText(tableModel.getValueAt(clickedRow, 8).toString());
            officeInput.setText("");
        }else{
            officeInput.setText(tableModel.getValueAt(clickedRow, 9).toString());
            stationInput.setText("");
        }
    }//GEN-LAST:event_employeeTableMouseClicked

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:
        int getAnswer = JOptionPane.showConfirmDialog(rootPane, "Are you sure to delete this Employee?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if(getAnswer == 0){
            try{
                employeesControl.deleteEmployees(Integer.parseInt(idInput.getText()));
                clearText();
                setComponent(false);
                setEditDeleteBtn(false);
                addBtn.setEnabled(true);
                showEmployees();
                JOptionPane.showMessageDialog(this, "Success deleting employee");
            } catch(Exception e){
                System.out.println("Error deleting data...");
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtnActionPerformed
        // TODO add your handling code here:
        addBtn.setEnabled(false);
        deleteBtn.setEnabled(false);
        setComponent(true);
        stationInput.setEnabled(false);
        officeInput.setEnabled(false);
        stationLabel.setEnabled(false);
        officeLabel.setEnabled(false);
        idInput.setEnabled(false);
        action = "Change";
    }//GEN-LAST:event_editBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        setEditDeleteBtn(false);
        setComponent(true);
        stationInput.setEnabled(false);
        officeInput.setEnabled(false);
        stationLabel.setEnabled(false);
        officeLabel.setEnabled(false);
        clearText();
        roleBtnGroup.clearSelection();
        idInput.setEditable(false);
        idInput.setText(String.valueOf(employeesControl.autoGenerateID()));
        action = "Add";
    }//GEN-LAST:event_addBtnActionPerformed

    private void searchInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchInputActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        setComponent(false);
        setEditDeleteBtn(false);
        try{
            TableEmployees empTab = employeesControl.showTableEmp(searchInput.getText());
            if(empTab.getRowCount()==0){
                clearText();
                searchInput.setText("");
                JOptionPane.showMessageDialog(this, "Employee not found");
            }else{
                employeeTable.setModel(empTab);
            }
            clearText();
            searchInput.setText("");
        }catch (Exception e) {
            System.out.println("Eror : "+e.getMessage());
        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        LoginView lv = new LoginView();
        this.dispose();
        lv.setVisible(true);
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void backgroundInputMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backgroundInputMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_backgroundInputMouseClicked

    private void idInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idInputActionPerformed

    private void firstInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstInputActionPerformed

    private void lastInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastInputActionPerformed

    private void backgroundPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backgroundPane2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_backgroundPane2MouseClicked

    private void panelAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAdminMouseClicked
        AdminManageView amv = new AdminManageView(admin);
        this.dispose();
        amv.setVisible(true);
    }//GEN-LAST:event_panelAdminMouseClicked

    private void panelHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelHomeMouseClicked
       DasboardView dv = new DasboardView(admin);
       this.dispose();
       dv.setVisible(true);
    }//GEN-LAST:event_panelHomeMouseClicked

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
            java.util.logging.Logger.getLogger(EmployeeManageView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeManageView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeManageView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeManageView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeManageView(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private view.PanelRound backgroundInput;
    private view.PanelRound backgroundInput2;
    private view.PanelRound backgroundPane1;
    private view.PanelRound backgroundPane2;
    private view.PanelRound backgroundTable;
    private javax.swing.JPanel base;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JRadioButton custumerRadio;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JTable employeeTable;
    private javax.swing.JLabel endLabel;
    private com.toedter.calendar.JDateChooser endWorkDate;
    private javax.swing.JTextField firstInput;
    private javax.swing.JLabel firstLabel;
    private javax.swing.JTextField idInput;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel labelPane;
    private javax.swing.JTextField lastInput;
    private javax.swing.JLabel lastLabel;
    private javax.swing.JPanel leftSidePane;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JTextField officeInput;
    private javax.swing.JLabel officeLabel;
    private javax.swing.JPanel panelAdmin;
    private javax.swing.JPanel panelEmployee;
    private javax.swing.JPanel panelHome;
    private javax.swing.JTextField passInput;
    private javax.swing.JLabel passLabel;
    private javax.swing.ButtonGroup roleBtnGroup;
    private javax.swing.JLabel roleLabel;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchInput;
    private javax.swing.JLabel startLabel;
    private com.toedter.calendar.JDateChooser startWorkDate;
    private javax.swing.JTextField stationInput;
    private javax.swing.JLabel stationLabel;
    private javax.swing.JRadioButton tellerRadio;
    private javaswingdev.swing.titlebar.TitleBar titleBar;
    private javax.swing.JTextField userInput;
    private javax.swing.JLabel userLabel;
    // End of variables declaration//GEN-END:variables
}

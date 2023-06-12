package view.employee;

import model.Accounts;
import model.Transactions;
import model.Loans;

import control.AccountsControl;
import control.TransactionsControl;
import control.LoansControl;
import java.awt.Color;
import java.awt.geom.RoundRectangle2D;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.TableModel;
import table.TableTransactions;
import table.TableLoans;

import java.util.concurrent.ThreadLocalRandom;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class TellerLoanView extends javax.swing.JFrame {
    AccountsControl aControl;
    LoansControl lControl;
    TransactionsControl tControl;
    String type = null;
    Accounts peminjam = null;
    String newFormat;
    float rate;
    String split;
    
    String idLoan = null;
    String idAcc = null;
    
    
    public TellerLoanView() {
        initComponents();
        setComponent(false);
        generateIdLOA();
        aControl = new AccountsControl();
        tControl = new TransactionsControl();
        lControl = new LoansControl();
        initJFrame();
        showDataCurrently();
        showDataHistory();
        init();
        runUpdate();
    }
    
    public void generateIdLOA(){
        tampilIdPinjaman.setText("LOA-"+String.valueOf(ThreadLocalRandom.current().nextInt(0, 99999)));
    }
    
    public void initJFrame(){
        setLocationRelativeTo(null);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
    }
    
    public void init(){
        titleBar.initJFram(this);
    }
    
    public void setComponent(boolean value){
        tampilIdPinjaman.setEnabled(value);
        tampilInterestRate.setEnabled(value);
        tampilNamaNasabah.setEnabled(value);
        cancelPeminjamBtn.setEnabled(value);
        cbStatus.setEnabled(value);
        batalkanPinjamanBtn.setEnabled(value);
        tampilBiayaBulan.setEnabled(value);
        tampilBiayaTahun.setEnabled(value);
    }
    
    public void setDetailPeminjamanArea(boolean value){
        inputIdNasabah.setEnabled(value);
        cekPeminjamBtn.setEnabled(value);
        if (value==true) {
            inputIdNasabah.setText("");
            tampilNamaNasabah.setText("");
        }
    }
    
    public void clearText(){
        tampilIdPinjaman.setText("");
        tampilNamaNasabah.setText("");
        inputIdNasabah.setText("");
        inputJumlahPinjaman.setText("");
        tampilBiayaBulan.setText("");
        tampilBiayaTahun.setText("");
        cbJenisBunga.setSelectedIndex(0);
        cbStatus.setSelectedIndex(0);
        cbTipePinjaman.setSelectedIndex(0);
        tampilInterestRate.setText("");
        dateStartPicker.setCalendar(null);
        dateEndPicker.setCalendar(null);
    }
    
    public void setEditComponent(boolean value){
        inputIdNasabah.setEnabled(value);
        inputJumlahPinjaman.setEnabled(value);
        dateStartPicker.setEnabled(value);
        dateEndPicker.setEnabled(value);
        cbJenisBunga.setEnabled(value);
        cbTipePinjaman.setEnabled(value);
        tampilBiayaTahun.setEnabled(value);
        tampilBiayaBulan.setEnabled(value);
        batalkanPinjamanBtn.setEnabled(!value);
    }
    
    private void hideColumnHistory(){
        loanTable.getColumnModel().getColumn(7).setWidth(0);
        loanTable.getColumnModel().getColumn(7).setMinWidth(0);
        loanTable.getColumnModel().getColumn(7).setMaxWidth(0); 
        
        loanTable.getColumnModel().getColumn(8).setWidth(0);
        loanTable.getColumnModel().getColumn(8).setMinWidth(0);
        loanTable.getColumnModel().getColumn(8).setMaxWidth(0); 
        
        loanTable.getColumnModel().getColumn(9).setWidth(0);
        loanTable.getColumnModel().getColumn(9).setMinWidth(0);
        loanTable.getColumnModel().getColumn(9).setMaxWidth(0); 
        
        loanTable.getColumnModel().getColumn(10).setWidth(0);
        loanTable.getColumnModel().getColumn(10).setMinWidth(0);
        loanTable.getColumnModel().getColumn(10).setMaxWidth(0); 
    }
    public void showDataHistory(){
        loanTable.getTableHeader().setOpaque(false);
        loanTable.getTableHeader().setForeground(new Color(0, 61, 121));
        loanTable.setRowHeight(25);
        loanTable.setModel(lControl.showAllJoinLoans("LOA", "Lunas", "Dibatalkan"));
        hideColumnHistory();
    }
    
    private void hideColumnCurrently(){
        confirmLoanTable.getColumnModel().getColumn(7).setWidth(0);
        confirmLoanTable.getColumnModel().getColumn(7).setMinWidth(0);
        confirmLoanTable.getColumnModel().getColumn(7).setMaxWidth(0); 
        
        confirmLoanTable.getColumnModel().getColumn(8).setWidth(0);
        confirmLoanTable.getColumnModel().getColumn(8).setMinWidth(0);
        confirmLoanTable.getColumnModel().getColumn(8).setMaxWidth(0); 
        
        confirmLoanTable.getColumnModel().getColumn(9).setWidth(0);
        confirmLoanTable.getColumnModel().getColumn(9).setMinWidth(0);
        confirmLoanTable.getColumnModel().getColumn(9).setMaxWidth(0); 
        
        confirmLoanTable.getColumnModel().getColumn(10).setWidth(0);
        confirmLoanTable.getColumnModel().getColumn(10).setMinWidth(0);
        confirmLoanTable.getColumnModel().getColumn(10).setMaxWidth(0); 
    }
    public void showDataCurrently(){
        confirmLoanTable.getTableHeader().setOpaque(false);
        confirmLoanTable.getTableHeader().setForeground(new Color(0, 61, 121));
        confirmLoanTable.setRowHeight(25);
        confirmLoanTable.setModel(lControl.showAllJoinLoans("LOA", "Dikonfirmasi", "Menunggu Konfirmasi"));
        hideColumnCurrently();
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
    
    public void setRate(){
        if (cbTipePinjaman.getSelectedIndex()==1){
            type = "Kredit Usaha Rakyat";
            rate = (float) 0.07;
        }else if(cbTipePinjaman.getSelectedIndex()==2){
            type = "Kredit Modal Kerja";
            rate = (float) 0.08;
        }else{
            type = "Kredit Investasi";
            rate = (float) 0.1;
        }
    }
    
    public String formatNominal(BigDecimal nominal){
        DecimalFormat df = new DecimalFormat("#,##0.00");
        df.setRoundingMode(RoundingMode.HALF_EVEN);
        return df.format(nominal);
    }
    
    public void runUpdate(){
        inputJumlahPinjaman.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                warn();
                double kalkulasi_perbulan = ((Double.parseDouble(inputJumlahPinjaman.getText()) * rate)/100)/12;
                double kalkulasi_pertahun = ((Double.parseDouble(inputJumlahPinjaman.getText()) * rate)/100);
                BigDecimal bcBulan = new BigDecimal(kalkulasi_perbulan).setScale(0, RoundingMode.HALF_EVEN);
                BigDecimal bcTahun = new BigDecimal(kalkulasi_pertahun).setScale(0, RoundingMode.HALF_EVEN);
                tampilBiayaBulan.setText(formatNominal(bcBulan));
                tampilBiayaTahun.setText(formatNominal(bcTahun));
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
              try{
                double kalkulasi_perbulan = ((Double.parseDouble(inputJumlahPinjaman.getText()) * rate)/100)/12;
                double kalkulasi_pertahun = ((Double.parseDouble(inputJumlahPinjaman.getText()) * rate)/100);
                BigDecimal bcBulan = new BigDecimal(kalkulasi_perbulan).setScale(0, RoundingMode.HALF_EVEN);
                BigDecimal bcTahun = new BigDecimal(kalkulasi_pertahun).setScale(0, RoundingMode.HALF_EVEN);
                tampilBiayaBulan.setText(formatNominal(bcBulan));
                tampilBiayaTahun.setText(formatNominal(bcTahun));
              } catch(Exception handling){
//                  pass
              }
            }
            @Override
            public void insertUpdate(DocumentEvent e) {
                warn();
                double kalkulasi_perbulan = ((Double.parseDouble(inputJumlahPinjaman.getText()) * rate)/100)/12;
                double kalkulasi_pertahun = ((Double.parseDouble(inputJumlahPinjaman.getText()) * rate)/100);
                BigDecimal bcBulan = new BigDecimal(kalkulasi_perbulan).setScale(0, RoundingMode.HALF_EVEN);
                BigDecimal bcTahun = new BigDecimal(kalkulasi_pertahun).setScale(0, RoundingMode.HALF_EVEN);
                tampilBiayaBulan.setText(formatNominal(bcBulan));
                tampilBiayaTahun.setText(formatNominal(bcTahun));
            }

            public void warn() {
                try{
                    if (Double.parseDouble(inputJumlahPinjaman.getText())<=0){
                      JOptionPane.showMessageDialog(null,
                         "Nominal harus lebih dari 0!", "Error Message",
                         JOptionPane.ERROR_MESSAGE);
                    }
                }catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(null,
                         "Nominal tidak valid!", "Error Message",
                         JOptionPane.ERROR_MESSAGE);
                }
            }
        });
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
        header = new javax.swing.JPanel();
        labelPane = new javax.swing.JLabel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        labelPane1 = new javax.swing.JLabel();
        titleBar = new javaswingdev.swing.titlebar.TitleBar();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        panelDetailPeminjaman = new view.PanelRound();
        tampilNamaNasabah = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cekPeminjamBtn = new javax.swing.JButton();
        inputIdNasabah = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cancelPeminjamBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tampilIdPinjaman = new javax.swing.JTextField();
        panelTipePeminjaman = new view.PanelRound();
        tampilInterestRate = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        cbTipePinjaman = new javax.swing.JComboBox<>();
        panelRound3 = new view.PanelRound();
        dateStartPicker = new com.toedter.calendar.JDateChooser();
        dateEndPicker = new com.toedter.calendar.JDateChooser();
        jPanel5 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        panelTableHistory = new view.PanelRound();
        jPanel8 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        confirmLoanTable = new javax.swing.JTable();
        panelJumlahPinjaman = new view.PanelRound();
        jPanel4 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        cbStatus = new javax.swing.JComboBox<>();
        ajukanPinjamanBtn = new javax.swing.JButton();
        panelTableKonfirmasi = new view.PanelRound();
        jPanel9 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        loanTable = new javax.swing.JTable();
        panelRound6 = new view.PanelRound();
        tampilBiayaBulan = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        cbJenisBunga = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        tampilBiayaTahun = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        batalkanPinjamanBtn = new javax.swing.JButton();
        panelJumlahPinjaman1 = new view.PanelRound();
        inputJumlahPinjaman = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        base.setBackground(new java.awt.Color(245, 245, 245));

        header.setBackground(new java.awt.Color(208, 232, 242));
        header.setPreferredSize(new java.awt.Dimension(1920, 113));

        labelPane.setFont(new java.awt.Font("Poppins Medium", 0, 48)); // NOI18N
        labelPane.setForeground(new java.awt.Color(0, 0, 0));
        labelPane.setText("Loans Transaction");

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 73, 178));
        kGradientPanel1.setkGradientFocus(1000);
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 149, 182));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(1440, 122));

        labelPane1.setBackground(new java.awt.Color(255, 255, 255));
        labelPane1.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 48)); // NOI18N
        labelPane1.setForeground(new java.awt.Color(255, 255, 255));
        labelPane1.setText("Teller Loans");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/admin/teller.png"))); // NOI18N

        jButton1.setBackground(new java.awt.Color(194, 16, 16));
        jButton1.setFont(new java.awt.Font("Montserrat SemiBold", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

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
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(labelPane1)))
                .addGap(343, 343, 343)
                .addComponent(jButton1)
                .addContainerGap(532, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(titleBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelPane1)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(24, 24, 24))))
        );

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addComponent(labelPane)
                .addContainerGap(789, Short.MAX_VALUE))
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1368, Short.MAX_VALUE)
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelPane)
                .addGap(19, 19, 19))
        );

        panelDetailPeminjaman.setBackground(new java.awt.Color(255, 255, 255));
        panelDetailPeminjaman.setRoundBottomLeft(20);
        panelDetailPeminjaman.setRoundBottomRight(20);
        panelDetailPeminjaman.setRoundTopLeft(20);
        panelDetailPeminjaman.setRoundTopRight(20);

        tampilNamaNasabah.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        tampilNamaNasabah.setForeground(new java.awt.Color(0, 0, 0));
        tampilNamaNasabah.setPreferredSize(new java.awt.Dimension(64, 27));
        tampilNamaNasabah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tampilNamaNasabahActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Nama Nasabah");

        cekPeminjamBtn.setBackground(new java.awt.Color(13, 110, 253));
        cekPeminjamBtn.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        cekPeminjamBtn.setForeground(new java.awt.Color(255, 255, 255));
        cekPeminjamBtn.setText("OK");
        cekPeminjamBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekPeminjamBtnActionPerformed(evt);
            }
        });

        inputIdNasabah.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        inputIdNasabah.setForeground(new java.awt.Color(0, 0, 0));
        inputIdNasabah.setPreferredSize(new java.awt.Dimension(64, 27));

        jLabel15.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 61, 121));
        jLabel15.setText("Detail Peminjam");

        jLabel16.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("ID Nasabah");

        cancelPeminjamBtn.setBackground(new java.awt.Color(194, 16, 16));
        cancelPeminjamBtn.setFont(new java.awt.Font("Montserrat", 0, 12)); // NOI18N
        cancelPeminjamBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelPeminjamBtn.setText("Cancel");
        cancelPeminjamBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelPeminjamBtnActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 183, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(18, 2));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 183, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 61, 121));
        jLabel2.setText("ID Pinjaman");

        tampilIdPinjaman.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        tampilIdPinjaman.setForeground(new java.awt.Color(0, 0, 0));
        tampilIdPinjaman.setPreferredSize(new java.awt.Dimension(64, 27));

        javax.swing.GroupLayout panelDetailPeminjamanLayout = new javax.swing.GroupLayout(panelDetailPeminjaman);
        panelDetailPeminjaman.setLayout(panelDetailPeminjamanLayout);
        panelDetailPeminjamanLayout.setHorizontalGroup(
            panelDetailPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetailPeminjamanLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelDetailPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(tampilIdPinjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(cancelPeminjamBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelDetailPeminjamanLayout.createSequentialGroup()
                        .addGroup(panelDetailPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tampilNamaNasabah, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                            .addComponent(inputIdNasabah, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cekPeminjamBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelDetailPeminjamanLayout.setVerticalGroup(
            panelDetailPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDetailPeminjamanLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addGap(2, 2, 2)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(tampilIdPinjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(2, 2, 2)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addGap(4, 4, 4)
                .addGroup(panelDetailPeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputIdNasabah, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cekPeminjamBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addGap(4, 4, 4)
                .addComponent(tampilNamaNasabah, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(cancelPeminjamBtn)
                .addGap(15, 15, 15))
        );

        panelTipePeminjaman.setBackground(new java.awt.Color(255, 255, 255));
        panelTipePeminjaman.setRoundBottomLeft(20);
        panelTipePeminjaman.setRoundBottomRight(20);
        panelTipePeminjaman.setRoundTopLeft(20);
        panelTipePeminjaman.setRoundTopRight(20);

        tampilInterestRate.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        tampilInterestRate.setForeground(new java.awt.Color(0, 0, 0));
        tampilInterestRate.setPreferredSize(new java.awt.Dimension(64, 27));

        jPanel6.setBackground(new java.awt.Color(255, 183, 0));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jLabel20.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 61, 121));
        jLabel20.setText("Tipe Pinjaman");

        jPanel7.setBackground(new java.awt.Color(255, 183, 0));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jLabel21.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 61, 121));
        jLabel21.setText("Interest Rate");

        cbTipePinjaman.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Tipe Pinjaman", "Kredit Usaha Rakyat", "Kredit Modal Kerja", "Kredit Investasi" }));
        cbTipePinjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipePinjamanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTipePeminjamanLayout = new javax.swing.GroupLayout(panelTipePeminjaman);
        panelTipePeminjaman.setLayout(panelTipePeminjamanLayout);
        panelTipePeminjamanLayout.setHorizontalGroup(
            panelTipePeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTipePeminjamanLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelTipePeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(cbTipePinjaman, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tampilInterestRate, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        panelTipePeminjamanLayout.setVerticalGroup(
            panelTipePeminjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTipePeminjamanLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel20)
                .addGap(2, 2, 2)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(cbTipePinjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel21)
                .addGap(2, 2, 2)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(tampilInterestRate, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        panelRound3.setBackground(new java.awt.Color(255, 255, 255));
        panelRound3.setRoundBottomLeft(20);
        panelRound3.setRoundBottomRight(20);
        panelRound3.setRoundTopLeft(20);
        panelRound3.setRoundTopRight(20);

        jPanel5.setBackground(new java.awt.Color(255, 183, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jLabel19.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 61, 121));
        jLabel19.setText("Tanggal Mulai Pinjaman");

        jPanel3.setBackground(new java.awt.Color(255, 183, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jLabel17.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 61, 121));
        jLabel17.setText("Tanggal Jatuh Tempo");

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(dateEndPicker, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dateStartPicker, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel19)
                .addGap(2, 2, 2)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateStartPicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel17)
                .addGap(2, 2, 2)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateEndPicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        panelTableHistory.setBackground(new java.awt.Color(255, 255, 255));
        panelTableHistory.setPreferredSize(new java.awt.Dimension(285, 100));
        panelTableHistory.setRoundBottomLeft(20);
        panelTableHistory.setRoundBottomRight(20);
        panelTableHistory.setRoundTopLeft(20);
        panelTableHistory.setRoundTopRight(20);

        jPanel8.setBackground(new java.awt.Color(255, 183, 0));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jLabel22.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 61, 121));
        jLabel22.setText("Waiting & On Going Loans");

        confirmLoanTable.setBackground(new java.awt.Color(208, 232, 242));
        confirmLoanTable.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        confirmLoanTable.setForeground(new java.awt.Color(0, 0, 0));
        confirmLoanTable.setModel(new javax.swing.table.DefaultTableModel(
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
        confirmLoanTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmLoanTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(confirmLoanTable);

        javax.swing.GroupLayout panelTableHistoryLayout = new javax.swing.GroupLayout(panelTableHistory);
        panelTableHistory.setLayout(panelTableHistoryLayout);
        panelTableHistoryLayout.setHorizontalGroup(
            panelTableHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTableHistoryLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelTableHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        panelTableHistoryLayout.setVerticalGroup(
            panelTableHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTableHistoryLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel22)
                .addGap(2, 2, 2)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        panelJumlahPinjaman.setBackground(new java.awt.Color(255, 255, 255));
        panelJumlahPinjaman.setRoundBottomLeft(20);
        panelJumlahPinjaman.setRoundBottomRight(20);
        panelJumlahPinjaman.setRoundTopLeft(20);
        panelJumlahPinjaman.setRoundTopRight(20);

        jPanel4.setBackground(new java.awt.Color(255, 183, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jLabel18.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 61, 121));
        jLabel18.setText("Status Pinjaman");

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Status Peminjaman", "Menunggu Konfirmasi", "Dikonfirmasi", "Lunas", "Dibatalkan" }));

        javax.swing.GroupLayout panelJumlahPinjamanLayout = new javax.swing.GroupLayout(panelJumlahPinjaman);
        panelJumlahPinjaman.setLayout(panelJumlahPinjamanLayout);
        panelJumlahPinjamanLayout.setHorizontalGroup(
            panelJumlahPinjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJumlahPinjamanLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelJumlahPinjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        panelJumlahPinjamanLayout.setVerticalGroup(
            panelJumlahPinjamanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJumlahPinjamanLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel18)
                .addGap(2, 2, 2)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        ajukanPinjamanBtn.setBackground(new java.awt.Color(25, 135, 84));
        ajukanPinjamanBtn.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        ajukanPinjamanBtn.setForeground(new java.awt.Color(255, 255, 255));
        ajukanPinjamanBtn.setText("Accept");
        ajukanPinjamanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajukanPinjamanBtnActionPerformed(evt);
            }
        });

        panelTableKonfirmasi.setBackground(new java.awt.Color(255, 255, 255));
        panelTableKonfirmasi.setPreferredSize(new java.awt.Dimension(285, 100));
        panelTableKonfirmasi.setRoundBottomLeft(20);
        panelTableKonfirmasi.setRoundBottomRight(20);
        panelTableKonfirmasi.setRoundTopLeft(20);
        panelTableKonfirmasi.setRoundTopRight(20);

        jPanel9.setBackground(new java.awt.Color(255, 183, 0));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jLabel23.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 61, 121));
        jLabel23.setText("History Loans");

        loanTable.setBackground(new java.awt.Color(208, 232, 242));
        loanTable.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        loanTable.setForeground(new java.awt.Color(0, 0, 0));
        loanTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(loanTable);

        javax.swing.GroupLayout panelTableKonfirmasiLayout = new javax.swing.GroupLayout(panelTableKonfirmasi);
        panelTableKonfirmasi.setLayout(panelTableKonfirmasiLayout);
        panelTableKonfirmasiLayout.setHorizontalGroup(
            panelTableKonfirmasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTableKonfirmasiLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelTableKonfirmasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTableKonfirmasiLayout.setVerticalGroup(
            panelTableKonfirmasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTableKonfirmasiLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel23)
                .addGap(2, 2, 2)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        panelRound6.setBackground(new java.awt.Color(255, 255, 255));
        panelRound6.setRoundBottomLeft(20);
        panelRound6.setRoundBottomRight(20);
        panelRound6.setRoundTopLeft(20);
        panelRound6.setRoundTopRight(20);

        tampilBiayaBulan.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        tampilBiayaBulan.setForeground(new java.awt.Color(0, 0, 0));

        jPanel10.setBackground(new java.awt.Color(255, 183, 0));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jLabel24.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 61, 121));
        jLabel24.setText("Jenis Bunga");

        cbJenisBunga.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Jenis Bunga", "Perbulan", "Pertahun" }));

        jLabel4.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Biaya Per Bulan");

        tampilBiayaTahun.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        tampilBiayaTahun.setForeground(new java.awt.Color(0, 0, 0));

        jLabel5.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Biaya Per Tahun");

        javax.swing.GroupLayout panelRound6Layout = new javax.swing.GroupLayout(panelRound6);
        panelRound6.setLayout(panelRound6Layout);
        panelRound6Layout.setHorizontalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(tampilBiayaBulan)
                    .addComponent(cbJenisBunga, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tampilBiayaTahun, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound6Layout.setVerticalGroup(
            panelRound6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel24)
                .addGap(2, 2, 2)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(cbJenisBunga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tampilBiayaBulan, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tampilBiayaTahun, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        batalkanPinjamanBtn.setBackground(new java.awt.Color(194, 16, 16));
        batalkanPinjamanBtn.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        batalkanPinjamanBtn.setForeground(new java.awt.Color(255, 255, 255));
        batalkanPinjamanBtn.setText("Batal");
        batalkanPinjamanBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalkanPinjamanBtnActionPerformed(evt);
            }
        });

        panelJumlahPinjaman1.setBackground(new java.awt.Color(255, 255, 255));
        panelJumlahPinjaman1.setRoundBottomLeft(20);
        panelJumlahPinjaman1.setRoundBottomRight(20);
        panelJumlahPinjaman1.setRoundTopLeft(20);
        panelJumlahPinjaman1.setRoundTopRight(20);

        inputJumlahPinjaman.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        inputJumlahPinjaman.setForeground(new java.awt.Color(0, 0, 0));

        jPanel11.setBackground(new java.awt.Color(255, 183, 0));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2, Short.MAX_VALUE)
        );

        jLabel25.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 61, 121));
        jLabel25.setText("Jumlah Pinjaman");

        javax.swing.GroupLayout panelJumlahPinjaman1Layout = new javax.swing.GroupLayout(panelJumlahPinjaman1);
        panelJumlahPinjaman1.setLayout(panelJumlahPinjaman1Layout);
        panelJumlahPinjaman1Layout.setHorizontalGroup(
            panelJumlahPinjaman1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJumlahPinjaman1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelJumlahPinjaman1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(inputJumlahPinjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        panelJumlahPinjaman1Layout.setVerticalGroup(
            panelJumlahPinjaman1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJumlahPinjaman1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel25)
                .addGap(2, 2, 2)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputJumlahPinjaman, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout baseLayout = new javax.swing.GroupLayout(base);
        base.setLayout(baseLayout);
        baseLayout.setHorizontalGroup(
            baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(baseLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelJumlahPinjaman1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(panelDetailPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(panelRound6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelTipePeminjaman, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelJumlahPinjaman, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(baseLayout.createSequentialGroup()
                        .addComponent(batalkanPinjamanBtn)
                        .addGap(18, 18, 18)
                        .addComponent(ajukanPinjamanBtn)))
                .addGap(31, 31, 31)
                .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelTableKonfirmasi, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)
                    .addComponent(panelTableHistory, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(baseLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 1368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        baseLayout.setVerticalGroup(
            baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(baseLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(baseLayout.createSequentialGroup()
                        .addComponent(panelTableHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelTableKonfirmasi, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(baseLayout.createSequentialGroup()
                        .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(baseLayout.createSequentialGroup()
                                .addComponent(panelTipePeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(panelRound6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(panelJumlahPinjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(batalkanPinjamanBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ajukanPinjamanBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(baseLayout.createSequentialGroup()
                                .addComponent(panelDetailPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(panelJumlahPinjaman1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(61, 61, 61))))
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
                .addComponent(base, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TellerView tv = new TellerView();
       this.dispose();
       tv.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tampilNamaNasabahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tampilNamaNasabahActionPerformed

    }//GEN-LAST:event_tampilNamaNasabahActionPerformed

    private void cekPeminjamBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekPeminjamBtnActionPerformed
        try {
            peminjam = aControl.searchAccount(Integer.parseInt(inputIdNasabah.getText()));
            if(peminjam!=null){
                tampilNamaNasabah.setText(peminjam.getCustomer().getFirst_name()+" "+peminjam.getCustomer().getLast_name());
                setDetailPeminjamanArea(false);
                cancelPeminjamBtn.setEnabled(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Data tidak ditemukan","Konfirmasi", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_cekPeminjamBtnActionPerformed

    private void cancelPeminjamBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelPeminjamBtnActionPerformed
        setDetailPeminjamanArea(true);
        cancelPeminjamBtn.setEnabled(false);
    }//GEN-LAST:event_cancelPeminjamBtnActionPerformed

    private void cbTipePinjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTipePinjamanActionPerformed
        if (cbTipePinjaman.getSelectedIndex()==1){
            tampilInterestRate.setText("7%");
        }else if(cbTipePinjaman.getSelectedIndex()==2){
            tampilInterestRate.setText("8%");
        }else{
            tampilInterestRate.setText("10%");
        }
        setRate();
    }//GEN-LAST:event_cbTipePinjamanActionPerformed

    private void confirmLoanTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmLoanTableMouseClicked
        cbStatus.setEnabled(true);
        setEditComponent(false);
        int clickedRow = confirmLoanTable.getSelectedRow();
        TableModel tableModel = confirmLoanTable.getModel();
        idLoan = confirmLoanTable.getValueAt(clickedRow,0).toString();
        tampilIdPinjaman.setText(idLoan);
        idAcc = confirmLoanTable.getValueAt(clickedRow,1).toString();
        inputIdNasabah.setText(idAcc);
        peminjam = aControl.searchAccount(Integer.parseInt(inputIdNasabah.getText()));
        tampilNamaNasabah.setText(peminjam.getCustomer().getFirst_name()+" "+peminjam.getCustomer().getLast_name());
        Calendar c = Calendar.getInstance();
        c.set(Integer.parseInt(confirmLoanTable.getValueAt(clickedRow,5).toString().substring(6, 10)),
                Integer.parseInt(confirmLoanTable.getValueAt(clickedRow,5).toString().substring(3, 5)),
                Integer.parseInt(confirmLoanTable.getValueAt(clickedRow,5).toString().substring(0, 2)));
        dateStartPicker.setCalendar(c);
        c.set(Integer.parseInt(confirmLoanTable.getValueAt(clickedRow,9).toString().substring(6, 10)),
                Integer.parseInt(confirmLoanTable.getValueAt(clickedRow,9).toString().substring(3, 5)),
                Integer.parseInt(confirmLoanTable.getValueAt(clickedRow,9).toString().substring(0, 2)));
        dateEndPicker.setCalendar(c);
        inputJumlahPinjaman.setText(confirmLoanTable.getValueAt(clickedRow,3).toString());
        cbTipePinjaman.setSelectedItem(confirmLoanTable.getValueAt(clickedRow,2).toString());
        cbJenisBunga.setSelectedItem(confirmLoanTable.getValueAt(clickedRow,8).toString());
        cbStatus.setSelectedItem(confirmLoanTable.getValueAt(clickedRow,6).toString());
        setRate();
        if (cbJenisBunga.getSelectedIndex()==1) tampilBiayaTahun.setText("");
        else tampilBiayaBulan.setText("");
    }//GEN-LAST:event_confirmLoanTableMouseClicked

    private void ajukanPinjamanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajukanPinjamanBtnActionPerformed
        String interest_type = null;
        setRate();
        if (cbJenisBunga.getSelectedIndex()==1) split = tampilBiayaBulan.getText().split(" ")[0];
        else split = tampilBiayaTahun.getText().split(" ")[0];
        
        split = split.replaceAll(",", "");
        split = split.replaceAll("\\.", "");
        
        if (tampilBiayaTahun.getText().equals("") || tampilBiayaBulan.getText().equals("")) {
            
            lControl.updateLoan(new Loans(tampilIdPinjaman.getText(), 
                            type, convDateSql(dateStartPicker.getDate()),
                            convDateSql(dateEndPicker.getDate()), 
                            Double.parseDouble(inputJumlahPinjaman.getText()), 
                            rate*100, cbJenisBunga.getSelectedItem().toString(), 
                            Double.parseDouble(split), cbStatus.getSelectedItem().toString()));
        }else{
            int getAnswer = JOptionPane.showConfirmDialog(rootPane, "Apakah menambah data pinjaman?", "Konfirmasi",JOptionPane.YES_NO_OPTION);
            switch (getAnswer) {
                case 0:

                    tControl.insertTransaction(new Transactions("TR-"+String.valueOf(ThreadLocalRandom.current().nextInt(0, 99999)), 
                            peminjam.getAccount_id(), tampilIdPinjaman.getText(), LocalDate.now().toString()));
                    lControl.insertLoan(new Loans(tampilIdPinjaman.getText(), 
                            type, convDateSql(dateStartPicker.getDate()),
                            convDateSql(dateEndPicker.getDate()), 
                            Double.parseDouble(inputJumlahPinjaman.getText()), 
                            rate*100, cbJenisBunga.getSelectedItem().toString(), 
                            Double.parseDouble(split), "Dikonfirmasi"));
                    break;
                case 1:
                    //do nothing
                    break;
                default:
                    throw new AssertionError();
            }
        }
        
        clearText();
        JOptionPane.showMessageDialog(null, " Data berhasil ditambah!");
        setDetailPeminjamanArea(true);
        showDataHistory();
        showDataCurrently();
        tampilInterestRate.setText("");
        generateIdLOA();
    }//GEN-LAST:event_ajukanPinjamanBtnActionPerformed

    private void batalkanPinjamanBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalkanPinjamanBtnActionPerformed
        cbStatus.setEnabled(false);
        setEditComponent(true);
        clearText();
        setComponent(false);
        generateIdLOA();
    }//GEN-LAST:event_batalkanPinjamanBtnActionPerformed

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
            java.util.logging.Logger.getLogger(TellerLoanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TellerLoanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TellerLoanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TellerLoanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TellerLoanView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ajukanPinjamanBtn;
    private javax.swing.JPanel base;
    private javax.swing.JButton batalkanPinjamanBtn;
    private javax.swing.JButton cancelPeminjamBtn;
    private javax.swing.JComboBox<String> cbJenisBunga;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JComboBox<String> cbTipePinjaman;
    private javax.swing.JButton cekPeminjamBtn;
    private javax.swing.JTable confirmLoanTable;
    private com.toedter.calendar.JDateChooser dateEndPicker;
    private com.toedter.calendar.JDateChooser dateStartPicker;
    private javax.swing.JPanel header;
    private javax.swing.JTextField inputIdNasabah;
    private javax.swing.JTextField inputJumlahPinjaman;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel labelPane;
    private javax.swing.JLabel labelPane1;
    private javax.swing.JTable loanTable;
    private view.PanelRound panelDetailPeminjaman;
    private view.PanelRound panelJumlahPinjaman;
    private view.PanelRound panelJumlahPinjaman1;
    private view.PanelRound panelRound3;
    private view.PanelRound panelRound6;
    private view.PanelRound panelTableHistory;
    private view.PanelRound panelTableKonfirmasi;
    private view.PanelRound panelTipePeminjaman;
    private javax.swing.JTextField tampilBiayaBulan;
    private javax.swing.JTextField tampilBiayaTahun;
    private javax.swing.JTextField tampilIdPinjaman;
    private javax.swing.JTextField tampilInterestRate;
    private javax.swing.JTextField tampilNamaNasabah;
    private javaswingdev.swing.titlebar.TitleBar titleBar;
    // End of variables declaration//GEN-END:variables
}

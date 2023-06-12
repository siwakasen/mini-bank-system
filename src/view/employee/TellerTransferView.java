
package view.employee;

import model.Accounts;
import model.Transactions;
import model.Transfers;

import control.AccountsControl;
import control.TransactionsControl;
import control.TransfersControl;
import java.awt.Color;
import java.awt.geom.RoundRectangle2D;
import java.util.List;
import javax.swing.table.TableModel;
import table.TableTransactions;
import table.TableTransfer;

import java.util.concurrent.ThreadLocalRandom;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class TellerTransferView extends javax.swing.JFrame {
    AccountsControl aControl;
    TransfersControl transferControl;
    TransactionsControl transactionControl;
    String action = null;
    Accounts pengirim = null;
    Accounts penerima = null;
    Transfers tr = null;
    public TellerTransferView() {
        initComponents();
        aControl = new AccountsControl();
        transactionControl = new TransactionsControl();
        transferControl = new TransfersControl();
        setComponent(false);
        showTransfer();
        initJFrame();
        init();
    }
    
    public void initJFrame(){
        setLocationRelativeTo(null);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
    }
    
    public void init(){
        titleBar.initJFram(this);
    }
    
    public void setComponent(boolean value){
        namaPengirimInput.setEnabled(value);
        cancelPengirimBtn.setEnabled(value);
        namaPenerimaInput.setEnabled(value);
        cancelPenerimaBtn.setEnabled(value);
        idTransferInput.setEnabled(value);
    }
    
    public void setPengirimArea(boolean value){
        noRekPengirimInput.setEnabled(value);
        okPengirimBtn.setEnabled(value);
        if(value==true){
            namaPengirimInput.setText("");
            noRekPengirimInput.setText("");
        }
    }
    
    public void setPenerimaArea(boolean value){
        okPenerimaBtn.setEnabled(value);
        noRekPenerimaInput.setEnabled(value);
        if(value==true){
            namaPenerimaInput.setText("");
            noRekPenerimaInput.setText("");
        }
    }
    
    public void clearText(){
        setPenerimaArea(true);
        setPengirimArea(true);
        cancelPenerimaBtn.setEnabled(false);
        cancelPengirimBtn.setEnabled(false);
        idTransferInput.setText("");
        jumlahTransferInput.setText("");
    }
    
    public void showTransfer(){
        transferTable.getTableHeader().setOpaque(false);
        transferTable.getTableHeader().setForeground(new Color(0, 61, 121));
        transferTable.setRowHeight(25);
        transferTable.setModel(transferControl.showTransfer("TN", "", ""));
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
        headerPane = new javax.swing.JPanel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        labelPane1 = new javax.swing.JLabel();
        titleBar = new javaswingdev.swing.titlebar.TitleBar();
        jLabel1 = new javax.swing.JLabel();
        penerimaPanel = new view.PanelRound();
        cancelPenerimaBtn = new javax.swing.JButton();
        namaPenerimaInput = new javax.swing.JTextField();
        namaPenerimaLabel = new javax.swing.JLabel();
        noRekPenerimaInput = new javax.swing.JTextField();
        rekPenerimaLabel = new javax.swing.JLabel();
        okPenerimaBtn = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        pengirimPanel = new view.PanelRound();
        cancelPengirimBtn = new javax.swing.JButton();
        namaPengirimInput = new javax.swing.JTextField();
        namaPengirimLabel = new javax.swing.JLabel();
        noRekPengirimInput = new javax.swing.JTextField();
        pengirimRekLabel = new javax.swing.JLabel();
        okPengirimBtn = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        transferPanel = new view.PanelRound();
        jumlahTransferInput = new javax.swing.JTextField();
        idTransferInput = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        panelTable = new view.PanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        transferTable = new javax.swing.JTable();
        transferBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        base.setBackground(new java.awt.Color(245, 245, 245));
        base.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        base.setPreferredSize(new java.awt.Dimension(1650, 1080));

        headerPane.setBackground(new java.awt.Color(182, 227, 136));
        headerPane.setPreferredSize(new java.awt.Dimension(1650, 113));

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 73, 178));
        kGradientPanel1.setkGradientFocus(1000);
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 149, 182));
        kGradientPanel1.setPreferredSize(new java.awt.Dimension(1440, 122));

        labelPane1.setBackground(new java.awt.Color(255, 255, 255));
        labelPane1.setFont(new java.awt.Font("Montserrat ExtraBold", 0, 48)); // NOI18N
        labelPane1.setForeground(new java.awt.Color(255, 255, 255));
        labelPane1.setText("Teller Transfers");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/admin/teller.png"))); // NOI18N

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
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(labelPane1)))
                .addContainerGap(876, Short.MAX_VALUE))
        );
        kGradientPanel1Layout.setVerticalGroup(
            kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                        .addComponent(titleBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelPane1)
                        .addGap(20, 20, 20))))
        );

        javax.swing.GroupLayout headerPaneLayout = new javax.swing.GroupLayout(headerPane);
        headerPane.setLayout(headerPaneLayout);
        headerPaneLayout.setHorizontalGroup(
            headerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1366, Short.MAX_VALUE)
        );
        headerPaneLayout.setVerticalGroup(
            headerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPaneLayout.createSequentialGroup()
                .addComponent(kGradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        penerimaPanel.setBackground(new java.awt.Color(255, 255, 255));
        penerimaPanel.setPreferredSize(new java.awt.Dimension(283, 194));
        penerimaPanel.setRoundBottomLeft(25);
        penerimaPanel.setRoundBottomRight(25);
        penerimaPanel.setRoundTopLeft(25);
        penerimaPanel.setRoundTopRight(25);

        cancelPenerimaBtn.setBackground(new java.awt.Color(194, 16, 16));
        cancelPenerimaBtn.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        cancelPenerimaBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelPenerimaBtn.setText("Cancel");
        cancelPenerimaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelPenerimaBtnActionPerformed(evt);
            }
        });

        namaPenerimaInput.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N

        namaPenerimaLabel.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        namaPenerimaLabel.setForeground(new java.awt.Color(0, 0, 0));
        namaPenerimaLabel.setText("Nama Penerima");

        noRekPenerimaInput.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N

        rekPenerimaLabel.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        rekPenerimaLabel.setForeground(new java.awt.Color(0, 0, 0));
        rekPenerimaLabel.setText("Nomor Rekening Penerima");

        okPenerimaBtn.setBackground(new java.awt.Color(13, 110, 253));
        okPenerimaBtn.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        okPenerimaBtn.setForeground(new java.awt.Color(255, 255, 255));
        okPenerimaBtn.setText("OK");
        okPenerimaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okPenerimaBtnActionPerformed(evt);
            }
        });

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

        jLabel22.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 61, 121));
        jLabel22.setText("Jumlah Pinjaman");

        javax.swing.GroupLayout penerimaPanelLayout = new javax.swing.GroupLayout(penerimaPanel);
        penerimaPanel.setLayout(penerimaPanelLayout);
        penerimaPanelLayout.setHorizontalGroup(
            penerimaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(penerimaPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(penerimaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(rekPenerimaLabel)
                    .addComponent(namaPenerimaLabel)
                    .addComponent(cancelPenerimaBtn)
                    .addComponent(namaPenerimaInput, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(penerimaPanelLayout.createSequentialGroup()
                        .addComponent(noRekPenerimaInput, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(okPenerimaBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        penerimaPanelLayout.setVerticalGroup(
            penerimaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(penerimaPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel22)
                .addGap(2, 2, 2)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rekPenerimaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(penerimaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okPenerimaBtn)
                    .addComponent(noRekPenerimaInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(namaPenerimaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namaPenerimaInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cancelPenerimaBtn)
                .addGap(37, 37, 37))
        );

        pengirimPanel.setBackground(new java.awt.Color(255, 255, 255));
        pengirimPanel.setPreferredSize(new java.awt.Dimension(303, 204));
        pengirimPanel.setRoundBottomLeft(25);
        pengirimPanel.setRoundBottomRight(25);
        pengirimPanel.setRoundTopLeft(25);
        pengirimPanel.setRoundTopRight(25);

        cancelPengirimBtn.setBackground(new java.awt.Color(194, 16, 16));
        cancelPengirimBtn.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        cancelPengirimBtn.setForeground(new java.awt.Color(255, 255, 255));
        cancelPengirimBtn.setText("Cancel");
        cancelPengirimBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelPengirimBtnActionPerformed(evt);
            }
        });

        namaPengirimInput.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N

        namaPengirimLabel.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        namaPengirimLabel.setForeground(new java.awt.Color(0, 0, 0));
        namaPengirimLabel.setText("Nama Pengirim");

        noRekPengirimInput.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N

        pengirimRekLabel.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        pengirimRekLabel.setForeground(new java.awt.Color(0, 0, 0));
        pengirimRekLabel.setText("Nomor Rekening Pengirim");

        okPengirimBtn.setBackground(new java.awt.Color(13, 110, 253));
        okPengirimBtn.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        okPengirimBtn.setForeground(new java.awt.Color(255, 255, 255));
        okPengirimBtn.setText("OK");
        okPengirimBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okPengirimBtnActionPerformed(evt);
            }
        });

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
        jLabel19.setText("Detail Pengirim");

        javax.swing.GroupLayout pengirimPanelLayout = new javax.swing.GroupLayout(pengirimPanel);
        pengirimPanel.setLayout(pengirimPanelLayout);
        pengirimPanelLayout.setHorizontalGroup(
            pengirimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pengirimPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pengirimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addGroup(pengirimPanelLayout.createSequentialGroup()
                        .addComponent(noRekPengirimInput, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(okPengirimBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pengirimRekLabel)
                    .addComponent(cancelPengirimBtn)
                    .addComponent(namaPengirimLabel)
                    .addComponent(namaPengirimInput, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        pengirimPanelLayout.setVerticalGroup(
            pengirimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pengirimPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel19)
                .addGap(2, 2, 2)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pengirimRekLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pengirimPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noRekPengirimInput, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(okPengirimBtn))
                .addGap(12, 12, 12)
                .addComponent(namaPengirimLabel)
                .addGap(3, 3, 3)
                .addComponent(namaPengirimInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cancelPengirimBtn)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jButton1.setBackground(new java.awt.Color(194, 16, 16));
        jButton1.setFont(new java.awt.Font("Poppins Medium", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        transferPanel.setBackground(new java.awt.Color(255, 255, 255));
        transferPanel.setPreferredSize(new java.awt.Dimension(210, 179));
        transferPanel.setRoundBottomLeft(20);
        transferPanel.setRoundBottomRight(20);
        transferPanel.setRoundTopLeft(20);
        transferPanel.setRoundTopRight(20);

        jumlahTransferInput.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        jumlahTransferInput.setHighlighter(null);

        idTransferInput.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 61, 121));
        jLabel20.setText("ID Transfer");

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

        jLabel21.setFont(new java.awt.Font("Montserrat ExtraBold", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 61, 121));
        jLabel21.setText("Jumlah Transfer");

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

        javax.swing.GroupLayout transferPanelLayout = new javax.swing.GroupLayout(transferPanel);
        transferPanel.setLayout(transferPanelLayout);
        transferPanelLayout.setHorizontalGroup(
            transferPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, transferPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(transferPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idTransferInput, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(jumlahTransferInput, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        transferPanelLayout.setVerticalGroup(
            transferPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transferPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel20)
                .addGap(2, 2, 2)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(idTransferInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel21)
                .addGap(2, 2, 2)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jumlahTransferInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelTable.setBackground(new java.awt.Color(255, 255, 255));
        panelTable.setPreferredSize(new java.awt.Dimension(210, 179));
        panelTable.setRoundBottomLeft(20);
        panelTable.setRoundBottomRight(20);
        panelTable.setRoundTopLeft(20);
        panelTable.setRoundTopRight(20);

        transferTable.setAutoCreateRowSorter(true);
        transferTable.setBackground(new java.awt.Color(0, 236, 217));
        transferTable.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        transferTable.setForeground(new java.awt.Color(0, 0, 0));
        transferTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(transferTable);

        javax.swing.GroupLayout panelTableLayout = new javax.swing.GroupLayout(panelTable);
        panelTable.setLayout(panelTableLayout);
        panelTableLayout.setHorizontalGroup(
            panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTableLayout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        panelTableLayout.setVerticalGroup(
            panelTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTableLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        transferBtn.setBackground(new java.awt.Color(25, 135, 84));
        transferBtn.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        transferBtn.setForeground(new java.awt.Color(255, 255, 255));
        transferBtn.setText("Transfer");
        transferBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transferBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout baseLayout = new javax.swing.GroupLayout(base);
        base.setLayout(baseLayout);
        baseLayout.setHorizontalGroup(
            baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(baseLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pengirimPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                    .addComponent(penerimaPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(transferPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(transferBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panelTable, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(baseLayout.createSequentialGroup()
                .addComponent(headerPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        baseLayout.setVerticalGroup(
            baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(baseLayout.createSequentialGroup()
                .addComponent(headerPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(baseLayout.createSequentialGroup()
                        .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pengirimPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                            .addComponent(transferPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(baseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(transferBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(penerimaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(baseLayout.createSequentialGroup()
                        .addComponent(panelTable, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 47, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(base, javax.swing.GroupLayout.PREFERRED_SIZE, 1366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       TellerView tv = new TellerView();
       this.dispose();
       tv.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void okPengirimBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okPengirimBtnActionPerformed
        
        if(!noRekPenerimaInput.getText().equalsIgnoreCase(noRekPengirimInput.getText())){
            pengirim = aControl.searchAccount(Integer.parseInt(noRekPengirimInput.getText()));
            if(pengirim!=null){
                namaPengirimInput.setText(pengirim.getCustomer().getFirst_name()+" "+pengirim.getCustomer().getLast_name());
                setPengirimArea(false);            
                cancelPengirimBtn.setEnabled(true);
                if(cancelPenerimaBtn.isEnabled()) idTransferInput.setText("TN-"+String.valueOf(ThreadLocalRandom.current().nextInt(0, 99999)));
            }
        }else{
           JOptionPane.showMessageDialog(null,"Data pengirim dan penerima sama!","Konfirmasi", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_okPengirimBtnActionPerformed

    private void cancelPengirimBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelPengirimBtnActionPerformed
        setPengirimArea(true);
        cancelPengirimBtn.setEnabled(false);
         System.out.println("halooo");
    }//GEN-LAST:event_cancelPengirimBtnActionPerformed

    private void okPenerimaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okPenerimaBtnActionPerformed
        if(!noRekPenerimaInput.getText().equalsIgnoreCase(noRekPengirimInput.getText())){
            penerima = aControl.searchAccount(Integer.parseInt(noRekPenerimaInput.getText()));
            if(penerima!=null){
                namaPenerimaInput.setText(penerima.getCustomer().getFirst_name()+" "+penerima.getCustomer().getLast_name());
                setPenerimaArea(false);            
                cancelPenerimaBtn.setEnabled(true);
                if(cancelPengirimBtn.isEnabled()) idTransferInput.setText("TN-"+String.valueOf(ThreadLocalRandom.current().nextInt(0, 99999)));
            }
        }else{
            JOptionPane.showMessageDialog(null,"Data pengirim dan penerima sama!","Konfirmasi", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_okPenerimaBtnActionPerformed

    private void cancelPenerimaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelPenerimaBtnActionPerformed
        setPenerimaArea(true);
        cancelPenerimaBtn.setEnabled(false);
    }//GEN-LAST:event_cancelPenerimaBtnActionPerformed

    private void transferBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transferBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_transferBtnActionPerformed

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
            java.util.logging.Logger.getLogger(TellerTransferView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TellerTransferView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TellerTransferView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TellerTransferView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TellerTransferView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel base;
    private javax.swing.JButton cancelPenerimaBtn;
    private javax.swing.JButton cancelPengirimBtn;
    private javax.swing.JPanel headerPane;
    private javax.swing.JTextField idTransferInput;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jumlahTransferInput;
    private keeptoo.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel labelPane1;
    private javax.swing.JTextField namaPenerimaInput;
    private javax.swing.JLabel namaPenerimaLabel;
    private javax.swing.JTextField namaPengirimInput;
    private javax.swing.JLabel namaPengirimLabel;
    private javax.swing.JTextField noRekPenerimaInput;
    private javax.swing.JTextField noRekPengirimInput;
    private javax.swing.JButton okPenerimaBtn;
    private javax.swing.JButton okPengirimBtn;
    private view.PanelRound panelTable;
    private view.PanelRound penerimaPanel;
    private view.PanelRound pengirimPanel;
    private javax.swing.JLabel pengirimRekLabel;
    private javax.swing.JLabel rekPenerimaLabel;
    private javaswingdev.swing.titlebar.TitleBar titleBar;
    private javax.swing.JButton transferBtn;
    private view.PanelRound transferPanel;
    private javax.swing.JTable transferTable;
    // End of variables declaration//GEN-END:variables
}

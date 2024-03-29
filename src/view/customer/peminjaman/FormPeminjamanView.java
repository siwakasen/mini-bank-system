/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.customer.peminjaman;
import java.awt.Color;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;

import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import model.Accounts;
import model.Customers;
import model.Loans;

/**
 *
 * @author personal7
 */
public class FormPeminjamanView extends javax.swing.JFrame {
    private Accounts account;
    private float sukuBunga = 0;
    /**
     * Creates new form FormPeminjaman
     */
    public FormPeminjamanView(Accounts account) {
        this.account = account;
        initComponents();
        interest_rate.setText(sukuBunga+"%");
        setDefault();
        runUpdate();
        syarat.setSelected(false);
    }
    
    public void setDefault(){
        amount.setEditable(false);
        nextButton.setBackground(Color.gray);
    }

    public String formatNominal(BigDecimal nominal){
        DecimalFormat df = new DecimalFormat("#,##0.00");
        df.setRoundingMode(RoundingMode.HALF_EVEN);
        return df.format(nominal);
    }
    
    public void runUpdate(){
        
        amount.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                warn();
                double kalkulasi_perbulan = ((Double.parseDouble(amount.getText()) * sukuBunga)/100)/12;
                double kalkulasi_pertahun = ((Double.parseDouble(amount.getText()) * sukuBunga)/100);
                BigDecimal bcBulan = new BigDecimal(kalkulasi_perbulan).setScale(0, RoundingMode.HALF_EVEN);
                BigDecimal bcTahun = new BigDecimal(kalkulasi_pertahun).setScale(0, RoundingMode.HALF_EVEN);
                perbulan.setText("Rp. "+formatNominal(bcBulan));
                pertahun.setText("Rp. "+formatNominal(bcTahun));

            }
            @Override
            public void removeUpdate(DocumentEvent e) {
              try{
                double kalkulasi_perbulan = ((Double.parseDouble(amount.getText()) * sukuBunga)/100)/12;
                double kalkulasi_pertahun = ((Double.parseDouble(amount.getText()) * sukuBunga)/100);
                BigDecimal bcBulan = new BigDecimal(kalkulasi_perbulan).setScale(0, RoundingMode.HALF_EVEN);
                BigDecimal bcTahun = new BigDecimal(kalkulasi_pertahun).setScale(0, RoundingMode.HALF_EVEN);
                perbulan.setText("Rp. "+formatNominal(bcBulan));
                pertahun.setText("Rp. "+formatNominal(bcTahun));
              } catch(Exception handling){
//                  pass
              }
            }
            @Override
            public void insertUpdate(DocumentEvent e) {
                try{
                    warn();
                    double kalkulasi_perbulan = ((Double.parseDouble(amount.getText()) * sukuBunga)/100)/12;
                    double kalkulasi_pertahun = ((Double.parseDouble(amount.getText()) * sukuBunga)/100);
                    BigDecimal bcBulan = new BigDecimal(kalkulasi_perbulan).setScale(0, RoundingMode.HALF_EVEN);
                    BigDecimal bcTahun = new BigDecimal(kalkulasi_pertahun).setScale(0, RoundingMode.HALF_EVEN);
                    perbulan.setText("Rp. "+formatNominal(bcBulan));
                    pertahun.setText("Rp. "+formatNominal(bcTahun));
               }catch(NumberFormatException e1){
                    System.out.println(e1.toString());
              }
            }

            public void warn() {
                try{
                    if (Integer.parseInt(amount.getText())<=0){
                      JOptionPane.showMessageDialog(null,
                         "Nominal harus lebih dari 0!", "Error Message",
                         JOptionPane.ERROR_MESSAGE);
                    }
                }catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(null,
                         "Nominal tidak valid!", "Error Message",
                         JOptionPane.ERROR_MESSAGE);
                    System.out.println(e.toString());
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tipePeminjaman = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        amount = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        interest_rate = new javax.swing.JTextField();
        syarat = new javax.swing.JCheckBox();
        nextButton = new view.PanelRound();
        jLabel9 = new javax.swing.JLabel();
        backBtn = new view.PanelRound();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        perbulan = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        pertahun = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jenis_bunga = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Formulir Peminjaman Uang");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Silahkan isi formulir dengan benar");

        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Tipe Peminjaman");

        tipePeminjaman.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tipePeminjaman.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Tipe Peminjaman", "Kredit Investasi", "Kredit Usaha Rakyat", "Kredit Modal Kerja" }));
        tipePeminjaman.setBorder(null);
        tipePeminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipePeminjamanActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Nominal");

        amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                amountActionPerformed(evt);
            }
        });

        jLabel5.setText("Rp.");

        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Suku Bunga");

        interest_rate.setEditable(false);

        syarat.setBackground(java.awt.Color.white);
        syarat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        syarat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                syaratMouseClicked(evt);
            }
        });
        syarat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                syaratActionPerformed(evt);
            }
        });

        nextButton.setBackground(new java.awt.Color(73, 105, 166));
        nextButton.setRoundBottomLeft(50);
        nextButton.setRoundBottomRight(50);
        nextButton.setRoundTopLeft(50);
        nextButton.setRoundTopRight(50);
        nextButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextButtonMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Kirim");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout nextButtonLayout = new javax.swing.GroupLayout(nextButton);
        nextButton.setLayout(nextButtonLayout);
        nextButtonLayout.setHorizontalGroup(
            nextButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        nextButtonLayout.setVerticalGroup(
            nextButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
        );

        backBtn.setBackground(java.awt.Color.gray);
        backBtn.setRoundBottomLeft(50);
        backBtn.setRoundBottomRight(50);
        backBtn.setRoundTopLeft(50);
        backBtn.setRoundTopRight(50);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Kembali");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout backBtnLayout = new javax.swing.GroupLayout(backBtn);
        backBtn.setLayout(backBtnLayout);
        backBtnLayout.setHorizontalGroup(
            backBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
        );
        backBtnLayout.setVerticalGroup(
            backBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Dengan ini saya setuju dengan semua");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("persyaratan yang ada.");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addContainerGap())
        );

        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Bunga Per Bulan");

        perbulan.setEditable(false);

        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Bunga Per Tahun");

        pertahun.setEditable(false);

        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Jenis Bunga");

        jenis_bunga.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Jenis Bunga", "Perbulan", "Pertahun" }));
        jenis_bunga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jenis_bungaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13)
                            .addComponent(pertahun)
                            .addComponent(perbulan)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12)
                                .addComponent(jLabel11)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(tipePeminjaman, 0, 284, Short.MAX_VALUE)
                                    .addComponent(amount, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(interest_rate)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(syarat)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jenis_bunga, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 13, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nextButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(backBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tipePeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(amount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(interest_rate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(perbulan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pertahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jenis_bunga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(syarat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void syaratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_syaratActionPerformed

    }//GEN-LAST:event_syaratActionPerformed

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        if(!syarat.isSelected()){
            JOptionPane.showMessageDialog(null, "Belum menyetujui Syarat"); return;
        }  
        if(amount.getText().length() <= 6){
            JOptionPane.showMessageDialog(null, "Nominal peminjaman harus lebih dari ratusan ribu");
        }else{
            this.dispose();
            if(jenis_bunga.getSelectedItem().equals("Perbulan")){
                String split = perbulan.getText().split(" ")[1];
                split = split.replaceAll(",", "");
                split = split.replaceAll("\\.", "");
                new ConfirmPeminjaman(account, new Loans("", tipePeminjaman.getSelectedItem().toString(),LocalDate.now().toString(), LocalDate.now().plusMonths(12).toString(), Double.parseDouble(amount.getText()), sukuBunga, jenis_bunga.getSelectedItem().toString(), Double.parseDouble(split), "Menunggu Konfirmasi")).setVisible(true);
            }else if(jenis_bunga.getSelectedItem().equals("Pertahun")){
                String split = pertahun.getText().split(" ")[1];
                split = split.replaceAll(",", "");
                split = split.replaceAll("\\.", "");
                new ConfirmPeminjaman(account, new Loans("", tipePeminjaman.getSelectedItem().toString(),LocalDate.now().toString(), LocalDate.now().plusMonths(12).toString(), Double.parseDouble(amount.getText()), sukuBunga, jenis_bunga.getSelectedItem().toString(), Double.parseDouble(split)+Double.parseDouble(amount.getText()), "Menunggu Konfirmasi")).setVisible(true);
            }
        }

    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        this.dispose();
        new DashPeminjamanView(account).setVisible(true);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void tipePeminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipePeminjamanActionPerformed
        // TODO add your handling code here:
        if(tipePeminjaman.getSelectedItem().equals("Kredit Investasi")){
            sukuBunga = (float) 10.0;
            interest_rate.setText(sukuBunga+"%");
            amount.setEditable(true);
            amount.setText("");
            perbulan.setText("");
            pertahun.setText("");
        } else if(tipePeminjaman.getSelectedItem().equals("Kredit Usaha Rakyat")){
            sukuBunga = (float) 7.0;
            interest_rate.setText(sukuBunga+"%");
            amount.setEditable(true);
            amount.setText("");
            perbulan.setText("");
            pertahun.setText("");
        } else if(tipePeminjaman.getSelectedItem().equals("Kredit Modal Kerja")){
            sukuBunga = (float) 8.0;
            interest_rate.setText(sukuBunga+"%");
            amount.setEditable(true);
            amount.setText("");
            perbulan.setText("");
            pertahun.setText("");
        } else{
            sukuBunga = (float) 0.0;
            interest_rate.setText(sukuBunga+"%");
            perbulan.setText("");
            pertahun.setText("");
            amount.setText("");
            amount.setEditable(false);
        }
    }//GEN-LAST:event_tipePeminjamanActionPerformed

    private void amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_amountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_amountActionPerformed

    private void syaratMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_syaratMouseClicked
        // TODO add your handling code here:
        if(syarat.isSelected()){
            if(!amount.getText().isEmpty() && jenis_bunga.getSelectedIndex() != 0){
                nextButton.setBackground(new java.awt.Color(73,105,166));
            }else{
                JOptionPane.showMessageDialog(null, "Silahkan mengisi formulir lebih lengkap terlebih dahulu!");
                syarat.setSelected(false);
            }
        }else{
            nextButton.setBackground(Color.gray);
        }
    }//GEN-LAST:event_syaratMouseClicked

    private void jenis_bungaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jenis_bungaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jenis_bungaActionPerformed

    private void nextButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextButtonMouseClicked
        if(!syarat.isSelected()){
            JOptionPane.showMessageDialog(null, "Belum menyetujui Syarat"); return;
        }  
        if(amount.getText().length() <= 6){
            JOptionPane.showMessageDialog(null, "Nominal peminjaman harus lebih dari ratusan ribu");
        }else{
            this.dispose();
            if(jenis_bunga.getSelectedItem().equals("Perbulan")){
                String split = perbulan.getText().split(" ")[1];
                split = split.replaceAll(",", "");
                split = split.replaceAll("\\.", "");
                new ConfirmPeminjaman(account, new Loans("", tipePeminjaman.getSelectedItem().toString(),LocalDate.now().toString(), LocalDate.now().plusMonths(12).toString(), Double.parseDouble(amount.getText()), sukuBunga, jenis_bunga.getSelectedItem().toString(), Double.parseDouble(split), "Menunggu Konfirmasi")).setVisible(true);
            }else if(jenis_bunga.getSelectedItem().equals("Pertahun")){
                String split = pertahun.getText().split(" ")[1];
                split = split.replaceAll(",", "");
                split = split.replaceAll("\\.", "");
                new ConfirmPeminjaman(account, new Loans("", tipePeminjaman.getSelectedItem().toString(),LocalDate.now().toString(), LocalDate.now().plusMonths(12).toString(), Double.parseDouble(amount.getText()), sukuBunga, jenis_bunga.getSelectedItem().toString(), Double.parseDouble(split)+Double.parseDouble(amount.getText()), "Menunggu Konfirmasi")).setVisible(true);
            }
        }
    }//GEN-LAST:event_nextButtonMouseClicked

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
            java.util.logging.Logger.getLogger(FormPeminjamanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPeminjamanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPeminjamanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPeminjamanView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPeminjamanView(new Accounts(0, "", 0, new Customers(0, "", "", "", "", ""), "", "")).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amount;
    private view.PanelRound backBtn;
    private javax.swing.JTextField interest_rate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox<String> jenis_bunga;
    private view.PanelRound nextButton;
    private javax.swing.JTextField perbulan;
    private javax.swing.JTextField pertahun;
    private javax.swing.JCheckBox syarat;
    private javax.swing.JComboBox<String> tipePeminjaman;
    // End of variables declaration//GEN-END:variables
}

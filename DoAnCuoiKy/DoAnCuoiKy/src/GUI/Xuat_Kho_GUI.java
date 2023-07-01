/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sun.security.krb5.internal.tools.Ktab;
import DAO.CSDL_DAO;
import DAO.Xuat_Kho_DAO;
import POJO.Xuat_Kho_POJO;
import java.util.ArrayList;
/**
 *
 * @author Admin
 */
public class Xuat_Kho_GUI extends javax.swing.JFrame {

    /**
     * Creates new form Xuat_Kho_GUI
     */
    DefaultTableModel dtm = new DefaultTableModel();
    Vector<String> tieuDe = new Vector<String>();
    Vector duLieu = new Vector();
    
    CSDL_DAO kn = new CSDL_DAO();
    public Xuat_Kho_GUI() {
        initComponents();
        this.setLocationRelativeTo(null);
         this.setLocationRelativeTo(null);
        tieuDe.add("Mã Nguyên Liệu");
        
        tieuDe.add("Tên Nguyên Liệu");
        tieuDe.add("Ngày Nhập");
        tieuDe.add("Số Lượng");
        tieuDe.add("Đơn Giá");
        dtm.setColumnIdentifiers(tieuDe);
        tb_tonKho.setModel(dtm);
        kn.open();
        
        
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
        txt_id = new javax.swing.JTextField();
        txt_soluong = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_tonKho = new javax.swing.JTable();
        btn_capNhat = new javax.swing.JButton();
        btn_xuatTonKho = new javax.swing.JButton();
        btnQuayLai = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cập Nhật Tồn Kho", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(51, 51, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel1.setText("Mã nguyên liệu");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel2.setText("Số lượng");

        txt_id.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        txt_soluong.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        tb_tonKho.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tb_tonKho);

        btn_capNhat.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        btn_capNhat.setText("Cập nhật");
        btn_capNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_capNhatActionPerformed(evt);
            }
        });

        btn_xuatTonKho.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        btn_xuatTonKho.setText("Hiển thị toàn bộ kho");
        btn_xuatTonKho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xuatTonKhoActionPerformed(evt);
            }
        });

        btnQuayLai.setText("Quay lại");
        btnQuayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuayLaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(txt_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_capNhat)
                        .addGap(102, 102, 102)
                        .addComponent(btn_xuatTonKho))
                    .addComponent(btnQuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_xuatTonKho)
                            .addComponent(btn_capNhat))
                        .addGap(123, 123, 123)
                        .addComponent(btnQuayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_capNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_capNhatActionPerformed
        float gia = 1000;
        int id = Integer.parseInt(txt_id.getText());
        int soLuong = Integer.parseInt(txt_soluong.getText());
         if(!txt_soluong.getText().matches("[0-9]+"))
        {
            JOptionPane.showMessageDialog(rootPane, "Giá trị số lượng sai");
            txt_soluong.requestFocus();
            return;
        }
         Xuat_Kho_POJO ba = new Xuat_Kho_POJO();
        ba.setId(id);
        ba.setSoluong(soLuong);
         boolean kq = Xuat_Kho_DAO.sua_NL_Kho(ba);
    if(kq) {
        JOptionPane.showMessageDialog(this, "Sửa nguyên liệu thành công!");
    } else {
        JOptionPane.showMessageDialog(this, "Sửa nguyên liệu thất bại!");
    }
    hienThiKho_new(id);
                
    }//GEN-LAST:event_btn_capNhatActionPerformed

    private void btn_xuatTonKhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xuatTonKhoActionPerformed
       hienThiKho();
    }//GEN-LAST:event_btn_xuatTonKhoActionPerformed

    private void btnQuayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuayLaiActionPerformed
        // TODO add your handling code here:
        Admin_GUI m=new  Admin_GUI();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnQuayLaiActionPerformed

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
            java.util.logging.Logger.getLogger(Xuat_Kho_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Xuat_Kho_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Xuat_Kho_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Xuat_Kho_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Xuat_Kho_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JButton btn_capNhat;
    private javax.swing.JButton btn_xuatTonKho;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_tonKho;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_soluong;
    // End of variables declaration//GEN-END:variables

      private void hienThiKho() {
        dtm.setRowCount(0);
        ArrayList<Xuat_Kho_POJO> dsPB = Xuat_Kho_DAO.layArrayList();
        dtm.setRowCount(0);
        for(Xuat_Kho_POJO pb:dsPB)
        {
            Vector<Object> v = new Vector<Object>();
            v.add(pb.getId());
            v.add(pb.getTenNguyenLieu());
            v.add(pb.getNgayNhap());
            v.add(pb.getSoluong());
            v.add(pb.getDongia());
            dtm.addRow(v);
        }
        tb_tonKho.setModel(dtm);
}
    private void hienThiKho_new(int id) {
    dtm.setRowCount(0);
    ArrayList<Xuat_Kho_POJO> dsPB = Xuat_Kho_DAO.layArrayList();
    dtm.setRowCount(0);
    for(Xuat_Kho_POJO pb:dsPB)
    {
        if(pb.getId() == id) {
            Vector<Object> v = new Vector<Object>();
            v.add(pb.getId());
            v.add(pb.getTenNguyenLieu());
            v.add(pb.getNgayNhap());
            v.add(pb.getSoluong());
            v.add(pb.getDongia());
            dtm.addRow(v);
        }
    }
    tb_tonKho.setModel(dtm);
}
}

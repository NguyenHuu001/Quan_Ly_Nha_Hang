/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import XuLy.CSDL;
import DAO.CSDL_DAO;
/**
 *
 * @author Admin
 */
public class QL_Nhap_Kho_GUI extends javax.swing.JFrame {

    /**
     * Creates new form QL_Nhap_Kho_GUI
     */
    DefaultTableModel dtm = new DefaultTableModel();
    Vector<String> tieuDe = new Vector<String>();
    Vector duLieu = new Vector();
    boolean them = false;
    boolean thayDoi = false;
    private float gia = 1000;
    //kết nối
    CSDL_DAO kn = new CSDL_DAO();
   
    public QL_Nhap_Kho_GUI() {
        initComponents();
        txt_maNguyenLieu.setEnabled(false);
        txt_donGia.setEnabled(false);
        this.setLocationRelativeTo(null);
        tieuDe.add("Mã Nguyên Liệu");
        tieuDe.add("Tên Nguyên Liệu");
        tieuDe.add("Số Lượng");
        tieuDe.add("Đơn Giá");
        
        dtm.setColumnIdentifiers(tieuDe);
        tb_thongTinNguyenLieu.setModel(dtm);
        kn.open();
        HienThiThucAn();
        
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_thongTinNguyenLieu = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_maNguyenLieu = new javax.swing.JTextField();
        txt_tenNguyenLieu = new javax.swing.JTextField();
        txt_soLuong = new javax.swing.JTextField();
        txt_donGia = new javax.swing.JTextField();
        btn_them = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_refesh = new javax.swing.JButton();
        btn_thoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhập Sản Phẩm Vào Kho", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 18), new java.awt.Color(51, 51, 255))); // NOI18N

        tb_thongTinNguyenLieu.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_thongTinNguyenLieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_thongTinNguyenLieuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_thongTinNguyenLieu);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin nguyên liệu", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 15), new java.awt.Color(102, 102, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel1.setText("Mã nguyên liệu");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel2.setText("Tên nguyên liệu");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel3.setText("Số lượng");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel4.setText("Đơn giá");

        txt_maNguyenLieu.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        txt_tenNguyenLieu.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        txt_soLuong.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        txt_donGia.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        btn_them.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_xoa.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        btn_sua.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_refesh.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btn_refesh.setText("Refesh");
        btn_refesh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refeshActionPerformed(evt);
            }
        });

        btn_thoat.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btn_thoat.setText("Thoát");
        btn_thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_donGia, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tenNguyenLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_maNguyenLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_refesh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_thoat, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 12, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_maNguyenLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_tenNguyenLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_donGia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_sua, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_refesh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_thoat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tb_thongTinNguyenLieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_thongTinNguyenLieuMouseClicked
       int row = tb_thongTinNguyenLieu.getSelectedRow();
       txt_maNguyenLieu.setText((String)tb_thongTinNguyenLieu.getValueAt(row, 0));
       txt_tenNguyenLieu.setText((String)tb_thongTinNguyenLieu.getValueAt(row, 1));
       txt_soLuong.setText(String.valueOf(tb_thongTinNguyenLieu.getValueAt(row, 2)));
       txt_donGia.setText(String.valueOf(tb_thongTinNguyenLieu.getValueAt(row, 3)));
    }//GEN-LAST:event_tb_thongTinNguyenLieuMouseClicked

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        
        String tenmon = txt_tenNguyenLieu.getText();
        int  soluong = Integer.parseInt(txt_soLuong.getText());
        Float dongia = (float)soluong * gia;
        try {
            kn.statement = kn.connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Admin_CateFood_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
         // String sqlInsert = "insert into khachhang values('"+makh+"',N' "+tenkh+"','"+namsinh+"','"+manhom+"')";
           String sqlInsert = "INSERT nhapkho  VALUES (N'" + tenmon + "',"+ soluong+","+dongia+" )";
           int x = kn.statement.executeUpdate(sqlInsert);
            if(x >= 1)
            {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                HienThiThucAn();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_CateFood_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_themActionPerformed
    private void refesh() {
        this.txt_maNguyenLieu.setText("");
        this.txt_tenNguyenLieu.setText("");
        this.txt_soLuong.setText("");
        this.txt_donGia.setText("");
    }
    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        String mamon = txt_maNguyenLieu.getText();
        try {
            kn.statement = kn.connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Admin_CateFood_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
         // String sqlInsert = "insert into khachhang values('"+makh+"',N' "+tenkh+"','"+namsinh+"','"+manhom+"')";
           String sqlDele = "delete from nhapkho where id= '"+ mamon + "'";
           int x = kn.statement.executeUpdate(sqlDele);
            if(x >= 1)
            {
                JOptionPane.showMessageDialog(this, "Xóa thành công");
                HienThiThucAn();
                refesh();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_CateFood_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        String tenmon = txt_tenNguyenLieu.getText();
        String id = txt_maNguyenLieu.getText();
        int soluong = Integer.parseInt(txt_soLuong.getText());
        Float dongia = (float)soluong * gia;
        try {
            kn.statement = kn.connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Admin_CateFood_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
         // String sqlInsert = "insert into khachhang values('"+makh+"',N' "+tenkh+"','"+namsinh+"','"+manhom+"')";
             String sqlUpdate = "UPDATE nhapKho SET tenNguyenLieu = N'"+tenmon+"', soLuong = '"+soluong+"',dongia = '"+dongia+"' WHERE id = '"+ id + "'";
           int x = kn.statement.executeUpdate(sqlUpdate);
            if(x >= 1)
            {
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                HienThiThucAn();
            }
                
            
        } catch (SQLException ex) {
            Logger.getLogger(Admin_CateFood_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_refeshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refeshActionPerformed
       refesh();
    }//GEN-LAST:event_btn_refeshActionPerformed

    private void btn_thoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thoatActionPerformed
        int n = JOptionPane.showConfirmDialog(this, "Bạn Muốn Thoát", "Thông báo!!!", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(n == JOptionPane.YES_OPTION)
        {
            System.exit(0);
        }
    }//GEN-LAST:event_btn_thoatActionPerformed

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
            java.util.logging.Logger.getLogger(QL_Nhap_Kho_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QL_Nhap_Kho_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QL_Nhap_Kho_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QL_Nhap_Kho_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QL_Nhap_Kho_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_refesh;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_thoat;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_thongTinNguyenLieu;
    private javax.swing.JTextField txt_donGia;
    private javax.swing.JTextField txt_maNguyenLieu;
    private javax.swing.JTextField txt_soLuong;
    private javax.swing.JTextField txt_tenNguyenLieu;
    // End of variables declaration//GEN-END:variables

   
    private void HienThiThucAn() {
         dtm.setRowCount(0);
        try{
            kn.statement= kn.connection.createStatement();
                
        }catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        String sqlSelect="select * from nhapkho ";
        try{
            kn.resultSet = kn.statement.executeQuery(sqlSelect);
            while(kn.resultSet.next())
            {
                String ma= kn.resultSet.getString("id");
                String ten=kn.resultSet.getString("tennguyenlieu");
                int soluong = kn.resultSet.getInt("soluong");
                float dongia = kn.resultSet.getFloat("dongia");
                Vector <Object> v = new Vector<Object>();
                v.add(ma);
                v.add(ten);
                v.add(soluong);
                v.add(dongia);
                dtm.addRow(v);
                   
            }
        }catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
}

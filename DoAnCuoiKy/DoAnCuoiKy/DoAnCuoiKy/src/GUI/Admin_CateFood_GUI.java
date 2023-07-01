/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Stack;
import java.util.StringTokenizer;
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
public class Admin_CateFood_GUI extends javax.swing.JFrame {

    /**
     * Creates new form Admin_GUI
     */
    DefaultTableModel dtm = new DefaultTableModel();
    Vector<String> tieuDe = new Vector<String>();
    Vector duLieu = new Vector();
    boolean them = false;
    boolean thayDoi = false;
    
    // KẾT NỐI
    CSDL_DAO kn = new CSDL_DAO();

    ////
    
    public Admin_CateFood_GUI() {
        initComponents();
        this.setLocationRelativeTo(null);
        tieuDe.add("Mã Món");
        tieuDe.add("Tên Món");
        dtm.setColumnIdentifiers(tieuDe);
        tb_thongTinThucAn.setModel(dtm);
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
        btn_Them = new javax.swing.JButton();
        btn_Xoa = new javax.swing.JButton();
        btn_Sua = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txt_maMon = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_tenMon = new javax.swing.JTextField();
        btn_xoaThongTin = new javax.swing.JButton();
        btn_quayLai = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txt_timKiemThucAn = new javax.swing.JTextField();
        btn_timKiem = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_thongTinThucAn = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_Them.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btn_Them.setText(" Thêm");
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });

        btn_Xoa.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btn_Xoa.setText("Xóa");
        btn_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaActionPerformed(evt);
            }
        });

        btn_Sua.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btn_Sua.setText("Sửa");
        btn_Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btn_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nhập Thông Tin Loại Món", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 15), new java.awt.Color(255, 51, 255))); // NOI18N

        txt_maMon.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        txt_maMon.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel1.setText("Mã loại món");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel2.setText("Tên loại món");

        txt_tenMon.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        btn_xoaThongTin.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btn_xoaThongTin.setText("Nhập lại");
        btn_xoaThongTin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaThongTinActionPerformed(evt);
            }
        });

        btn_quayLai.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btn_quayLai.setText("Quay lại");
        btn_quayLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_quayLaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txt_maMon))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_tenMon))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btn_quayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_xoaThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_maMon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_tenMon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_xoaThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_quayLai, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm Loại Món", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 15), new java.awt.Color(51, 51, 255))); // NOI18N

        txt_timKiemThucAn.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        btn_timKiem.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btn_timKiem.setText("Tìm Kiếm");
        btn_timKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_timKiemThucAn, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(btn_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_timKiemThucAn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Loại Món", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 15), new java.awt.Color(51, 51, 255))); // NOI18N

        tb_thongTinThucAn.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_thongTinThucAn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_thongTinThucAnMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_thongTinThucAn);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.getAccessibleContext().setAccessibleName("Tìm Kiếm Loại Món");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tb_thongTinThucAnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_thongTinThucAnMouseClicked
        int row = tb_thongTinThucAn.getSelectedRow();
       txt_maMon.setText((String)tb_thongTinThucAn.getValueAt(row, 0));
       txt_tenMon.setText((String)tb_thongTinThucAn.getValueAt(row, 1));
       
    }//GEN-LAST:event_tb_thongTinThucAnMouseClicked

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        String id = txt_maMon.getText();
        String tenmon = txt_tenMon.getText();
        try {
            kn.statement = kn.connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Admin_CateFood_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
         // String sqlInsert = "insert into khachhang values('"+makh+"',N' "+tenkh+"','"+namsinh+"','"+manhom+"')";
           String sqlInsert = "INSERT loaiMonAn  VALUES (N'" + tenmon + "' )";
           int x = kn.statement.executeUpdate(sqlInsert);
            if(x >= 1)
            {
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                HienThiThucAn();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_CateFood_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_ThemActionPerformed

    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed
        String mamon = txt_maMon.getText();
        try {
            kn.statement = kn.connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Admin_CateFood_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
         // String sqlInsert = "insert into khachhang values('"+makh+"',N' "+tenkh+"','"+namsinh+"','"+manhom+"')";
           String sqlDele = "delete from loaiMonAn where id= '"+ mamon + "'";
           int x = kn.statement.executeUpdate(sqlDele);
            if(x >= 1)
            {
                JOptionPane.showMessageDialog(this, "Xóa thành công");
                HienThiThucAn();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin_CateFood_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_XoaActionPerformed

    private void btn_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaActionPerformed
        String tenmon = txt_tenMon.getText();
        String id = txt_maMon.getText();
        try {
            kn.statement = kn.connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Admin_CateFood_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
         // String sqlInsert = "insert into khachhang values('"+makh+"',N' "+tenkh+"','"+namsinh+"','"+manhom+"')";
             String sqlUpdate= "update loaiMonAn set tenloai = N'" + tenmon + "' where id = "+id+"";
           int x = kn.statement.executeUpdate(sqlUpdate);
            if(x >= 1)
            {
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                HienThiThucAn();
            }
                
            
        } catch (SQLException ex) {
            Logger.getLogger(Admin_CateFood_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_SuaActionPerformed

    private void btn_xoaThongTinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaThongTinActionPerformed
        this.txt_tenMon.setText("");
        this.txt_timKiemThucAn.setText("");
        txt_tenMon.requestFocus();
        
    }//GEN-LAST:event_btn_xoaThongTinActionPerformed

    private void btn_timKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timKiemActionPerformed
      String timkiem = txt_timKiemThucAn.getText();

    try {
        PreparedStatement selectStatement = kn.connection.prepareStatement(
            "SELECT id,tenloai FROM loaiMonAn WHERE tenloai LIKE N'%" + timkiem + "%'"
        );
        ResultSet resultSet = selectStatement.executeQuery();

        // Khởi tạo model cho bảng
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Tên");

        // Thêm các bản ghi vào model
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("tenloai");
            model.addRow(new Object[] { id, name });
        }

        // Hiển thị model trên bảng
        tb_thongTinThucAn.setModel(model);
        resultSet.close();
        selectStatement.close();
    } catch (SQLException e) {
        System.out.println("Không thể thực hiện truy vấn: " + e.getMessage());
    }

    }//GEN-LAST:event_btn_timKiemActionPerformed

    private void btn_quayLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_quayLaiActionPerformed
        tb_thongTinThucAn.setModel(dtm);
        HienThiThucAn();
    }//GEN-LAST:event_btn_quayLaiActionPerformed

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
            java.util.logging.Logger.getLogger(Admin_CateFood_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_CateFood_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_CateFood_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_CateFood_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_CateFood_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Sua;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_Xoa;
    private javax.swing.JButton btn_quayLai;
    private javax.swing.JButton btn_timKiem;
    private javax.swing.JButton btn_xoaThongTin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tb_thongTinThucAn;
    private javax.swing.JTextField txt_maMon;
    private javax.swing.JTextField txt_tenMon;
    private javax.swing.JTextField txt_timKiemThucAn;
    // End of variables declaration//GEN-END:variables

//    private void KetNoiDuLieu() {
//      try {
//            String driver ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
//            Class.forName(driver);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Main_GUI.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        String connectionURL="jdbc:sqlserver://"+strServer
//                +":1433;databaseName="+strDatabase
//                +";user="+strUser
//                +";password="+strPassWord;
//              
//        
//        try {
//                connection=DriverManager.getConnection(connectionURL);
//                if(connection!=null)
//                {
//                    System.out.println("Kết nối thành công");
//                    
//                }else
//                {
//                    System.out.println("Không kết nối thành công");
//                }
//            } catch (SQLException ex) {
//            
//                Logger.getLogger(Main_GUI.class.getName()).log(Level.SEVERE,null,ex);
//            }
//    }

    private void HienThiThucAn() {
         dtm.setRowCount(0);
        try{
            kn.statement= kn.connection.createStatement();
                
        }catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        String sqlSelect="select * from loaiMonAn";
        try{
            kn.resultSet=kn.statement.executeQuery(sqlSelect);
            while(kn.resultSet.next())
            {
                String ma= kn.resultSet.getString("id");
                String ten= kn.resultSet.getString("tenLoai");
                Vector <Object> v = new Vector<Object>();
                v.add(ma);
                v.add(ten);
                dtm.addRow(v);
                   
            }
        }catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.CSDL_DAO;
import XuLy.CSDL;
import XuLy.xlMain;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dinht
 */
public class Main_GUI extends javax.swing.JFrame {

    /**
     * Creates new form Main_GUI
     */
    
    
    
    DefaultTableModel dtmMainTableFood= new DefaultTableModel();
    DefaultTableModel dtmRoom= new DefaultTableModel();
    DefaultTableModel dtmMainBill= new DefaultTableModel();
    
    CSDL_DAO kn=new CSDL_DAO();
    int IDTable;
    int IDRoom;
    int IDTONG;
    
    
    
    
    //XuLy.xlMain xlhamMain=new xlMain();
    
    public Main_GUI() {
        initComponents();
        this.setLocationRelativeTo(null);
        btnAdmin.setEnabled(false);
        
        
       
        
        
        
       String []tieuDeMainTableFood={"Mã bàn","Tên bàn","Trạng thái"};
        String []tieuDeMainBill={"Tên món","Số lượng","Giá","Thành tiền"};
        String []tieuDeRoom={"Mã phòng","Tên phòng","Trạng thái"};
        
        dtmMainTableFood.setColumnIdentifiers(tieuDeMainTableFood);
        dtmRoom.setColumnIdentifiers(tieuDeRoom);
        dtmMainBill.setColumnIdentifiers(tieuDeMainBill);
        
        tbMainBanAn.setModel(dtmMainTableFood);
        tbMainBill.setModel(dtmMainBill);
        tbPhongAn.setModel(dtmRoom);
        
        //ketNoiCSDL();
        kn.open();
       hienThiMainBanAn();
        LoadRoom();
        LoadMainCateFood();
        if(kiemTraTK(Login_GUI.tk, Login_GUI.mk1)==1)
        {
            btnAdmin.setEnabled(true);
        }
        else
        {
            btnAdmin.setEnabled(false);
        }
       
        
        
        
       
        
       // xlhamMain.loadMainTableFood(tbMainBanAn);
        
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
        tbMainBanAn = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbPhongAn = new javax.swing.JTable();
        btnAdmin = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        cbMainCate = new javax.swing.JComboBox<>();
        cbMainFood = new javax.swing.JComboBox<>();
        txtSoLuong = new javax.swing.JTextField();
        btnMainThemMon = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbMainBill = new javax.swing.JTable();
        btnThanhToan = new javax.swing.JButton();
        btnThemMonRoom = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbMainBanAn.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        tbMainBanAn.setModel(new javax.swing.table.DefaultTableModel(
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
        tbMainBanAn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMainBanAnMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbMainBanAn);

        tbPhongAn.setModel(new javax.swing.table.DefaultTableModel(
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
        tbPhongAn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPhongAnMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbPhongAn);

        btnAdmin.setText("Admin");
        btnAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminActionPerformed(evt);
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
                        .addComponent(btnAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(btnAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        cbMainCate.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cbMainCate.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                cbMainCateHierarchyChanged(evt);
            }
        });
        cbMainCate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbMainCateMouseClicked(evt);
            }
        });
        cbMainCate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMainCateActionPerformed(evt);
            }
        });

        cbMainFood.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cbMainFood.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbMainFoodMouseClicked(evt);
            }
        });

        btnMainThemMon.setText("Thêm món vào bàn");
        btnMainThemMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMainThemMonActionPerformed(evt);
            }
        });

        jLabel1.setText("Loại món");

        jLabel2.setText("Tên món");

        jLabel3.setText("Số lượng");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbMainCate, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbMainFood, 0, 184, Short.MAX_VALUE)))
                    .addComponent(jLabel2))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(btnMainThemMon, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btnMainThemMon, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbMainCate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbMainFood, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        tbMainBill.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tbMainBill.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbMainBill);

        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 745, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 31, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        btnThemMonRoom.setText("Thêm món vào phòng");
        btnThemMonRoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMonRoomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThemMonRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(btnThemMonRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbMainBanAnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMainBanAnMouseClicked
      int row=tbMainBanAn.getSelectedRow();
      IDTable=Integer.parseInt( tbMainBanAn.getValueAt(row, 0).toString());
      int idBan=Integer.parseInt( tbMainBanAn.getValueAt(row, 0).toString());
       IDTONG=Integer.parseInt( tbMainBanAn.getValueAt(row, 0).toString());
      showBillTable(idBan);
     
      
      
        //hienThiMainBill((String)tbMainBanAn.getValueAt(row, 0));
        
    }//GEN-LAST:event_tbMainBanAnMouseClicked

    private void cbMainCateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMainCateActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_cbMainCateActionPerformed

    private void cbMainCateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbMainCateMouseClicked
        // TODO add your handling code here:
        cbMainFood.removeAllItems();
        String select=(String) cbMainCate.getSelectedItem();
        cbMainFood.removeAllItems();
       LoadMainFood(select);
    }//GEN-LAST:event_cbMainCateMouseClicked

    private void cbMainFoodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbMainFoodMouseClicked
        
    }//GEN-LAST:event_cbMainFoodMouseClicked

    private void cbMainCateHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_cbMainCateHierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbMainCateHierarchyChanged

    private void tbPhongAnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPhongAnMouseClicked
        // TODO add your handling code here:
        int row=tbPhongAn.getSelectedRow();
      IDRoom=Integer.parseInt(  tbPhongAn.getValueAt(row, 0).toString());
      int idRoom=Integer.parseInt(  tbPhongAn.getValueAt(row, 0).toString());
      IDTONG=Integer.parseInt(  tbPhongAn.getValueAt(row, 0).toString());
      showBillRoom(idRoom);
      
    }//GEN-LAST:event_tbPhongAnMouseClicked

    private void btnMainThemMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMainThemMonActionPerformed

          
//          if(rowRom<0 || rowTable<0)
//          {
//              JOptionPane.showMessageDialog(this, "Vui lòng chọn bàn, phòng cần thêm món!");
//              return;
//          }
          String idFood=(String)cbMainFood.getSelectedItem();
          int soLuong=Integer.parseInt(txtSoLuong.getText());
         int idBillTable=kiemTraIdBan(IDTable);
        
         if(idBillTable==-1)
         {
             themMoiHoaDonBan(IDTable);
             themMoiCTHoaDon(billBanMoiNhat(), idFood, soLuong);
         }
         else
         {
             themMoiCTHoaDon(idBillTable, idFood, soLuong);
         }
         showBillTable(IDTable);
        hienThiMainBanAn();
    }//GEN-LAST:event_btnMainThemMonActionPerformed

    private void btnThemMonRoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMonRoomActionPerformed
        // TODO add your handling code here:
        String idFood=(String)cbMainFood.getSelectedItem();
          int soLuong=Integer.parseInt(txtSoLuong.getText());
         int idBillRoom=kiemTraIdPhong(IDRoom);
        
         if(idBillRoom==-1)
         {
             themMoiHoaDonPhong(IDRoom);
             themMoiCTHoaDon(billRoomMoiNhat(), idFood, soLuong);
         }
         else
         {
             themMoiCTHoaDon(idBillRoom, idFood, soLuong);
         }
        showBillRoom(IDRoom);
        LoadRoom();
    }//GEN-LAST:event_btnThemMonRoomActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        int n = tbMainBill.getRowCount();
        float sum = 0.0f;
        for (int i = 0; i < n; i++) {
            float value = (Float) tbMainBill.getValueAt(i, 3);
            sum += value;
        }
        int x=JOptionPane.showConfirmDialog(this, "Tổng số tiền cần thanh toán: \n"+sum+" VNĐ", "Thông báo", JOptionPane.YES_NO_CANCEL_OPTION);
        if(x==JOptionPane.YES_OPTION)
        {
           int idBillTable=kiemTraIdBan(IDTONG);
            upDateBill(sum, idBillTable);
            showBillTable(IDTable);
            int idBillRoom=kiemTraIdPhong(IDTONG);
            upDateBill(sum, idBillRoom);
            hienThiMainBanAn();
            LoadRoom();
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminActionPerformed
        // TODO add your handling code here:
        Admin_GUI ad=new Admin_GUI();
        
        ad.setVisible(true);
    }//GEN-LAST:event_btnAdminActionPerformed
    public int kiemTraIdBan(int id)
    {
        try {
            String sql="SELECT MAX(id) as id FROM dbo.hoaDon WHERE idBan ="+id+" AND status = 0";
            kn.resultSet=kn.statement.executeQuery(sql);
            if(kn.resultSet.next())
            {
                int maban=kn.resultSet.getInt("id");
                if(maban==0)
                    return -1;
                return maban;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Main_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    public int kiemTraIdPhong(int id)
    {
        try {
            String sql="SELECT MAX(id) as id from hoaDon WHERE idPhong="+id+"AND status = 0";
            kn.resultSet=kn.statement.executeQuery(sql);
            if(kn.resultSet.next())
            {
                int maPhong=kn.resultSet.getInt("id");
                if(maPhong==0)
                    return -1;
                return maPhong;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Main_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
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
            java.util.logging.Logger.getLogger(Main_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdmin;
    private javax.swing.JButton btnMainThemMon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThemMonRoom;
    private javax.swing.JComboBox<String> cbMainCate;
    private javax.swing.JComboBox<String> cbMainFood;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbMainBanAn;
    private javax.swing.JTable tbMainBill;
    private javax.swing.JTable tbPhongAn;
    private javax.swing.JTextField txtSoLuong;
    // End of variables declaration//GEN-END:variables

     


    private void hienThiMainBanAn() {
       dtmMainTableFood.setRowCount(0);
        try{
            kn.statement= kn.connection.createStatement();
                
        }catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        String sqlSelect="select *from banAn ";
        try{
            kn.resultSet=kn.statement.executeQuery(sqlSelect);
            while(kn.resultSet.next())
            {
                String ma= kn.resultSet.getString("id");
                String ten=kn.resultSet.getString("ten_Ban");
                String nam =kn. resultSet.getString("trang_Thai");
                Vector <Object> v = new Vector<Object>();
                v.add(ma);
                v.add(ten);
                v.add(nam);
                dtmMainTableFood.addRow(v);
                   
            }
        }catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    

    private void LoadMainCateFood() {
        try {
            kn.statement= kn.connection.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Main_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sqlSelect="select *from loaiMonAn";
       cbMainFood.removeAllItems();
        try {
            kn.resultSet=kn.statement.executeQuery(sqlSelect);
            while (kn.resultSet.next()) {
                int id=kn.resultSet.getInt("id");
                String name=kn.resultSet.getString("tenLoai");
                
                
                cbMainCate.addItem(kn.resultSet.getString("tenLoai"));
    }
        } catch (SQLException ex) {
            Logger.getLogger(Main_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    private void LoadMainFood(String idCateF) {
        try {
            kn.statement= kn.connection.createStatement();
            cbMainFood.removeAllItems();
        } catch (SQLException ex) {
            Logger.getLogger(Main_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String sqlSelect="SELECT * FROM MonAn INNER JOIN LoaiMonAn ON MonAn.idLoai = LoaiMonAn.id WHERE LoaiMonAn.tenLoai LIKE N'"+idCateF+"'";
        cbMainFood.removeAllItems();
        try {
            kn.resultSet=kn.statement.executeQuery(sqlSelect);
           
            while (kn.resultSet.next()) {
                int id=kn.resultSet.getInt("id");
                String name=kn.resultSet.getString("tenMon");
                
                float price=kn.resultSet.getFloat("gia");
                int idCate=kn.resultSet.getInt("idLoai");
                cbMainFood.addItem(kn.resultSet.getString("tenMon"));
                }
        } catch (SQLException ex) {
            Logger.getLogger(Main_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void LoadRoom() {
        dtmRoom.setRowCount(0);
        try{
            kn.statement= kn.connection.createStatement();
                
        }catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        String sqlSelect="select *from PhongAn";
        try{
            
            kn.resultSet=kn.statement.executeQuery(sqlSelect);
            while(kn.resultSet.next())
            {
                String ma= kn.resultSet.getString("id");
                String ten=kn.resultSet.getString("tenPhong");
                String nam = kn.resultSet.getString("trangThai");
                Vector <Object> v = new Vector<Object>();
                v.add(ma);
                v.add(ten);
                v.add(nam);
                dtmRoom.addRow(v);
                   
            }
        }catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    private void showBillTable(int idBan) {
        dtmMainBill.setRowCount(0);
        try{
            kn.statement= kn.connection.createStatement();
                
        }catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        String sqlSelect="exec USP_ShowBillTable "+idBan+"";
        try{
            
            kn.resultSet=kn.statement.executeQuery(sqlSelect);
            while(kn.resultSet.next())
            {
                String ten= kn.resultSet.getString("tenMon");
                int soLuong=kn.resultSet.getInt("soLuong");
                float gia = kn.resultSet.getFloat("gia");
                float tongTien = kn.resultSet.getFloat("totalPrice");
                Vector <Object> v = new Vector<Object>();
                v.add(ten);
                v.add(soLuong);
                v.add(gia);
                v.add(tongTien);
                dtmMainBill.addRow(v);
                   
            }
        }catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
     private void showBillRoom(int idRoom) {
        dtmMainBill.setRowCount(0);
        try{
            kn.statement= kn.connection.createStatement();
                
        }catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        String sqlSelect="exec USP_ShowBillRoom "+idRoom+"";
        try{
            
            kn.resultSet=kn.statement.executeQuery(sqlSelect);
            while(kn.resultSet.next())
            {
                String ten= kn.resultSet.getString("tenMon");
                int soLuong=kn.resultSet.getInt("soLuong");
                float gia = kn.resultSet.getFloat("gia");
                float tongTien = kn.resultSet.getFloat("totalPrice");
                Vector <Object> v = new Vector<Object>();
                v.add(ten);
                v.add(soLuong);
                v.add(gia);
                v.add(tongTien);
                dtmMainBill.addRow(v);
                   
            }
        }catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
     private void themMoiHoaDonBan(int idTable) {
       
        try{
            kn.statement= kn.connection.createStatement();
                
        }catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        String sqlSelect="exec USP_InsertBillTable "+idTable+"";
        try{
            
            kn.resultSet=kn.statement.executeQuery(sqlSelect);
           
            
        }catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
      private void themMoiHoaDonPhong(int idRoom) {
       
        try{
            kn.statement= kn.connection.createStatement();
                
        }catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        String sqlSelect="exec USP_InsertBillRoom "+idRoom+"";
        try{
            
            kn.resultSet=kn.statement.executeQuery(sqlSelect);
            
        }catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
      private void themMoiCTHoaDon(int idHD,String idMon,int soLuong) {
       
        try{
            kn.statement= kn.connection.createStatement();
                
        }catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        String sqlSelect="exec USP_InsertCTHoaDon "+idHD+",N'"+idMon+"',"+soLuong+"";
        try{
            
            int n=kn.statement.executeUpdate(sqlSelect);
            
        }catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
       public int billBanMoiNhat()
    {
        try {
           String sql = "SELECT TOP 1 id FROM hoaDon WHERE idBan = (SELECT MAX(idBan) FROM hoaDon)";
            kn.resultSet = kn.statement.executeQuery(sql);
            if (kn.resultSet.next()) {
                int maban = kn.resultSet.getInt("id");
                return maban;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Main_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }
        public int billRoomMoiNhat()
    {
        try {
           String sql = "SELECT TOP 1 id FROM hoaDon WHERE idPhong = (SELECT MAX(idPhong) FROM hoaDon)";
            kn.resultSet = kn.statement.executeQuery(sql);
            if (kn.resultSet.next()) {
                int maban = kn.resultSet.getInt("id");
                return maban;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Main_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }
        public int upDateBill(float tien,int id)
    {
        try {
           String sql = "  UPDATE hoaDon SET status = 1, tongTien = "+tien+" WHERE id = "+id+"";
            kn.resultSet = kn.statement.executeQuery(sql);
           
            
        } catch (SQLException ex) {
            Logger.getLogger(Main_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }
        public int kiemTraTK(String tk, String mk)
        {
           
           String sql = "select Type from Account where UserName='"+tk+"' and PassWord="+mk+"";
        try {
            kn.resultSet = kn.statement.executeQuery(sql);
            while(kn.resultSet.next())
            {
                int ma= kn.resultSet.getInt("Type");
                 if(ma==1){
                     return 1;
                 
                 }
                     
            }
                
        } catch (SQLException ex) {
            Logger.getLogger(Main_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }                   
                
        return 0;
        }
}

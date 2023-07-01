/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XuLy;

import GUI.Main_GUI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dinht
 */
public class xlMain {
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet= null;
    String strServer="LAPTOP-J2EVE03L\\SQLEXPRESS";
    String strDatabase="QuanLyQuanCafe";
    String strUser="sa";
    String strPassWord="123";
    
    DefaultTableModel dtmMainTableFood= new DefaultTableModel();
    JTable table = new JTable(dtmMainTableFood); 
    
    public  void loadMainTableFood(JTable tbMainBanAn )
    {
         String []tieuDeMainTableFood={"Mã bàn","Tên bàn","Trạng thái"};
        
        dtmMainTableFood.setColumnIdentifiers(tieuDeMainTableFood);
        tbMainBanAn.setModel(dtmMainTableFood);
        ketNoiCSDL();
        hienThiMainBanAn();
    }
    private void ketNoiCSDL() {
        try {
            String driver ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Main_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String connectionURL="jdbc:sqlserver://"+strServer
                +":1433;databaseName="+strDatabase
                +";user="+strUser
                +";password="+strPassWord;
              
        
        try {
                connection=DriverManager.getConnection(connectionURL);
                if(connection!=null)
                {
                    System.out.println("Kết nối thành công");
                    
                }else
                {
                    System.out.println("Không kết nối thành công");
                }
            } catch (SQLException ex) {
            
                Logger.getLogger(Main_GUI.class.getName()).log(Level.SEVERE,null,ex);
            }
}

    private void hienThiMainBanAn() {
       dtmMainTableFood.setRowCount(0);
        try{
            statement= connection.createStatement();
                
        }catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        String sqlSelect="select *from TableFood";
        try{
            resultSet=statement.executeQuery(sqlSelect);
            while(resultSet.next())
            {
                String ma= resultSet.getString("id");
                String ten=resultSet.getString("name");
                String nam = resultSet.getString("status");
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
}

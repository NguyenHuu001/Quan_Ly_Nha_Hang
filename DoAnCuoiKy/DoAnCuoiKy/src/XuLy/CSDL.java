/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XuLy;

import GUI.Main_GUI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dinht
 */
public  class CSDL {
     public static Connection connection = null;
   public static Statement statement = null;
   public static ResultSet resultSet= null;
   public static PreparedStatement preparedStatement = null;
   public static String strServer="LAPTOP-J2EVE03L\\SQLEXPRESS";
   public static String strDatabase="dbQLNH";
   public static String strUser="sa";
   public static String strPassWord="123";
    public static void ketNoiCSDL() {
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
}

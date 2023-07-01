package DAO;

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
public class CSDL_DAO {
    public Connection connection = null;
    public Statement statement = null;
    public ResultSet resultSet = null;
    public PreparedStatement preparedStatement = null;
    public void open()
    {
        String strServer="LAPTOP-J2EVE03L\\SQLEXPRESS";
    String strDatabase="dbQLNH";
    String strUser="sa";
    String strPass="123";
    
        try {
            String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
            Class.forName(driver);
            String connectionURL="jdbc:sqlserver://"+strServer
                +":1433;databaseName="+strDatabase
                +";user="+strUser
                +";password="+strPass;
            connection=DriverManager.getConnection(connectionURL);
            if(connection!=null)
                System.out.println("Ket noi thanh cong!");
            else
                System.out.println("Ket noi that bai");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void close()
    {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(CSDL_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ResultSet excuteQuery(String sql)
    {
        ResultSet rs=null;
        try {
            Statement sm=connection.createStatement();
            rs=sm.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
    public int excuteUpdate(String sql)
    {
        int n=1;
        try {
            Statement sm=connection.createStatement();
            n=sm.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return n;
    }

    
}
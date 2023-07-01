/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import POJO.Ban_An_POJO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Ban_An_DAO {
    public static ArrayList<Ban_An_POJO> layArrayList(){
        ArrayList<Ban_An_POJO> dsPB = new ArrayList<Ban_An_POJO>();
        try {
            String sql = "Select * from banAn";
            CSDL_DAO provider_dao = new CSDL_DAO();
            provider_dao.open();
            ResultSet resultSet = provider_dao.excuteQuery(sql);
            while(resultSet.next()){
                Ban_An_POJO pb = new Ban_An_POJO();
                pb.setId(resultSet.getInt("id"));
                pb.setTenban(resultSet.getString("ten_Ban"));
                pb.setTrangthai(resultSet.getString("trang_thai"));
                dsPB.add(pb);
            }
             provider_dao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsPB;
    }
    
    
    
    public static boolean themBanAn(Ban_An_POJO pb)
    {
        boolean kq = false;
        String sql = String.format("INSERT INTO banAn(ten_ban,trang_thai) VALUES(N'%s',N'%s');", pb.getTenban(), pb.getTrangthai());
        CSDL_DAO provider_dao = new CSDL_DAO();
        provider_dao.open();
        int n = provider_dao.excuteUpdate(sql);
        if( n == 1)
            kq = true;
        provider_dao.close();
        return kq;
    }
    public static boolean xoaBanAn (int pb)
    {
         boolean kq = false;
        String sql = String.format("Delete BanAn where id = '"+pb+"'");
        CSDL_DAO provider_dao = new CSDL_DAO();
        provider_dao.open();
        int n = provider_dao.excuteUpdate(sql);
        if( n == 1)
            kq = true;
        provider_dao.close();
        return kq;
    }
    
     public static boolean suaBanAn (int id, String tenban, String trangthai)
     {
         boolean kq = false;
        String sql = String.format( "UPDATE banan SET ten_ban = N'" + tenban + "', trang_thai = N'" + trangthai + "' WHERE id = " + id);
        CSDL_DAO provider_dao = new CSDL_DAO();
        provider_dao.open();
        int n = provider_dao.excuteUpdate(sql);
        if( n == 1)
            kq = true;
        provider_dao.close();
        return kq;
     }
    
}

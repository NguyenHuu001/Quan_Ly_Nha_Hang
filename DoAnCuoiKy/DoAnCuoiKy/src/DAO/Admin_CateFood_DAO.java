/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Admin_CateFood_POJO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import DAO.CSDL_DAO;

/**
 *
 * @author Admin
 */
public class Admin_CateFood_DAO {
    
    public static ArrayList<Admin_CateFood_POJO> layArrayList(){
        ArrayList<Admin_CateFood_POJO> dsPB = new ArrayList<Admin_CateFood_POJO>();
        try {
            String sql = "Select * from loaiMonAn";
            CSDL_DAO provider_dao = new CSDL_DAO();
            provider_dao.open();
            ResultSet resultSet = provider_dao.excuteQuery(sql);
            while(resultSet.next()){
                Admin_CateFood_POJO pb = new Admin_CateFood_POJO();
                pb.setId(resultSet.getInt("id"));
                pb.setTenLoai(resultSet.getString("tenLoai"));
                dsPB.add(pb);
            }
             provider_dao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsPB;
    }
    
    
    
    public static boolean themLoaiMonAn(Admin_CateFood_POJO pb)
    {
        boolean kq = false;
        String sql = String.format("INSERT INTO loaiMonAn(tenLoai) VALUES(N'%s');", pb.getTenLoai());
        CSDL_DAO provider_dao = new CSDL_DAO();
        provider_dao.open();
        int n = provider_dao.excuteUpdate(sql);
        if( n == 1)
            kq = true;
        provider_dao.close();
        return kq;
    }
    public static boolean xoaLoaiMonAn (int pb)
    {
         boolean kq = false;
        String sql = String.format("Delete loaiMonAN where id = '"+pb+"'");
        CSDL_DAO provider_dao = new CSDL_DAO();
        provider_dao.open();
        int n = provider_dao.excuteUpdate(sql);
        if( n == 1)
            kq = true;
        provider_dao.close();
        return kq;
    }
    
     public static boolean suaLoaiMonAn (int id, String tenLoai) {
    boolean kq = false;
    String sql = String.format("UPDATE loaiMonAn SET tenLoai = N'%s' WHERE id = %d", tenLoai, id);
    CSDL_DAO provider_dao = new CSDL_DAO();
    try {
        provider_dao.open();
        int n = provider_dao.excuteUpdate(sql);
        if (n == 1) {
            kq = true;
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        provider_dao.close();
    }
    return kq;
}
     
     
     public static ArrayList<Admin_CateFood_POJO> timKiem(String tuKhoa) {
    ArrayList<Admin_CateFood_POJO> danhSachLoaiMonAn = new ArrayList<Admin_CateFood_POJO>();
    try {
        CSDL_DAO provider_dao = new CSDL_DAO();
        provider_dao.open();
        String sql = String.format("SELECT * FROM loaiMonAn WHERE tenLoai LIKE N'%%%s%%'", tuKhoa);
        ResultSet resultSet = provider_dao.excuteQuery(sql);
        while (resultSet.next()) {
            Admin_CateFood_POJO loaiMonAn = new Admin_CateFood_POJO();
            loaiMonAn.setId(resultSet.getInt("id"));
            loaiMonAn.setTenLoai(resultSet.getString("tenLoai"));
            danhSachLoaiMonAn.add(loaiMonAn);
        }
        provider_dao.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return danhSachLoaiMonAn;
}

}

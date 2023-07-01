/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Xuat_Kho_POJO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Xuat_Kho_DAO {
    

    public static ArrayList<Xuat_Kho_POJO> layArrayList(){
        ArrayList<Xuat_Kho_POJO> dsPB = new ArrayList<Xuat_Kho_POJO>();
        try {
            String sql = "Select * from nhapKho";
            CSDL_DAO provider_dao = new CSDL_DAO();
            provider_dao.open();
            ResultSet resultSet = provider_dao.excuteQuery(sql);
            while(resultSet.next()){
                Xuat_Kho_POJO pb = new Xuat_Kho_POJO();
                pb.setId(resultSet.getInt("id"));
                pb.setTenNguyenLieu(resultSet.getString("tenNguyenLieu"));
                pb.setSoluong(resultSet.getInt("soLuong"));
                pb.setDongia(resultSet.getFloat("donGia"));
                dsPB.add(pb);
            }
             provider_dao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsPB;
}
    
    public static boolean sua_NL_Kho(Xuat_Kho_POJO pb) {
        boolean kq = false;
        String sql = String.format("UPDATE nhapKho SET soLuong = %d WHERE id = %d",
                 pb.getSoluong(), pb.getId());
        CSDL_DAO provider_dao = new CSDL_DAO();
        provider_dao.open();
        int n = provider_dao.excuteUpdate(sql);
        if (n == 1) {
            kq = true;
        }
        provider_dao.close();
        return kq;
}
}
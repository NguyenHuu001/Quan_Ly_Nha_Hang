/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.QL_Nhap_Kho_POJO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class QL_Nhap_Kho_DAO {
    public static ArrayList<QL_Nhap_Kho_POJO> layArrayList(){
        ArrayList<QL_Nhap_Kho_POJO> dsPB = new ArrayList<QL_Nhap_Kho_POJO>();
        try {
            String sql = "Select * from nhapKho";
            CSDL_DAO provider_dao = new CSDL_DAO();
            provider_dao.open();
            ResultSet resultSet = provider_dao.excuteQuery(sql);
            while(resultSet.next()){
                QL_Nhap_Kho_POJO pb = new QL_Nhap_Kho_POJO();
                pb.setId(resultSet.getInt("id"));
                pb.setNgayNhap(resultSet.getString("ngayNhap"));
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
    
    
    
    public static boolean them_NL_VaoKho(QL_Nhap_Kho_POJO pb) {
    boolean kq = false;
    String sql = String.format("INSERT INTO nhapKho(tenNguyenLieu, ngayNhap, soLuong, donGia) VALUES(N'%s', '%s', %d, %.3f);", 
                               pb.getTenNguyenLieu(), pb.getNgayNhap(), pb.getSoluong(), pb.getDongia());

    CSDL_DAO provider_dao = new CSDL_DAO();
    provider_dao.open();
    int n = provider_dao.excuteUpdate(sql);
    if (n == 1) {
        kq = true;
    }
    provider_dao.close();
    return kq;
}

    public static boolean xoa_NL_Kho (int pb)
    {
         boolean kq = false;
        String sql = String.format("Delete nhapKho where id = '"+pb+"'");
        CSDL_DAO provider_dao = new CSDL_DAO();
        provider_dao.open();
        int n = provider_dao.excuteUpdate(sql);
        if( n == 1)
            kq = true;
        provider_dao.close();
        return kq;
    }
    
     public static boolean sua_NL_Kho(QL_Nhap_Kho_POJO pb) {
        boolean kq = false;
        String sql = String.format("UPDATE nhapKho SET tenNguyenLieu = N'%s', ngayNhap = '%s', soLuong = %d, donGia = %.3f WHERE id = %d",
                pb.getTenNguyenLieu(), pb.getNgayNhap(), pb.getSoluong(), pb.getDongia(), pb.getId());
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

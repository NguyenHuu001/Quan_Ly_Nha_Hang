/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.databan;
import java.sql.ResultSet;
import java.util.ArrayList;
import POJO.datphong;

/**
 *
 * @author dinht
 */
public class datPhong_DAO {
     public static ArrayList<datphong> layDSDP()
    {
        ArrayList<datphong> dsPA=new ArrayList<datphong>();
        try {
            String sql="  select *from datPhong";
            CSDL_DAO kn=new CSDL_DAO();
            kn.open();
            ResultSet rs=kn.excuteQuery(sql);
            while(rs.next())
            {
                datphong pa=new datphong();
                pa.setId(rs.getInt("id"));
                pa.setTenKH(rs.getString("tenKH"));
                pa.setSdt(rs.getString("sdt"));
                pa.setIdPhong(rs.getInt("idPhong"));
                dsPA.add(pa);
            }
            kn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsPA;
    }
    public static boolean themPhongDat(datphong pa)
    {
        CSDL_DAO kn=new CSDL_DAO();
            kn.open();
        boolean kq=false;
        String sql="insert into datPhong values(N'"+pa.getTenKH()+"','"+pa.getSdt()+"',"+pa.getIdPhong()+")";
        int n=kn.excuteUpdate(sql);
        if(n==1)
        {
            kq=true;
        }
        kn.close();
        return kq;
    }
    public static boolean xPhongDat(datphong pa)
    {
        CSDL_DAO kn=new CSDL_DAO();
            kn.open();
        boolean kq=false;
        String sql="delete datPhong where id="+pa.getId()+" ";
        int n=kn.excuteUpdate(sql);
        if(n==1)
        {
            kq=true;
        }
       
        kn.close();
        return kq;
    }
    
}

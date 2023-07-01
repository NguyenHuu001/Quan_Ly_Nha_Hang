/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import POJO.databan;
import java.sql.ResultSet;

import java.util.ArrayList;

/**
 *
 * @author dinht
 */
public class datban_DAO {
    public static ArrayList<databan> layDSDB()
    {
        ArrayList<databan> dsBA=new ArrayList<databan>();
        try {
            String sql=" select *from datBan";
            CSDL_DAO kn=new CSDL_DAO();
            kn.open();
            ResultSet rs=kn.excuteQuery(sql);
            while(rs.next())
            {
                databan pb=new databan();
                pb.setId(rs.getInt("id"));
                pb.setTen(rs.getString("tenKH"));
                pb.setSdt(rs.getString("sdt"));
                pb.setIdBan(rs.getInt("idBan"));
                dsBA.add(pb);
            }
            kn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsBA;
    }
    public static boolean themBanDat(databan ba)
    {
        CSDL_DAO kn=new CSDL_DAO();
            kn.open();
        boolean kq=false;
        String sql="insert into datBan values(N'"+ba.getTen()+"','"+ba.getSdt()+"',"+ba.getIdBan()+")";
        int n=kn.excuteUpdate(sql);
        if(n==1)
        {
            kq=true;
        }
        kn.close();
        return kq;
    }
    public static boolean xBanDat(databan ba)
    {
        CSDL_DAO kn=new CSDL_DAO();
            kn.open();
        boolean kq=false;
        String sql="delete datBan where id="+ba.getId()+" ";
        int n=kn.excuteUpdate(sql);
        if(n==1)
        {
            kq=true;
        }
        kn.close();
        return kq;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class QL_Nhap_Kho_POJO {
    private int id;
    private String tenNguyenLieu;
    private int soluong;
    private float dongia;
    private String ngayNhap;
    public QL_Nhap_Kho_POJO() {
    }

    public QL_Nhap_Kho_POJO(int id, String ngayNhap, String tenNguyenLieu, int soluong, float dongia) {
        this.id = id;
        this.tenNguyenLieu = tenNguyenLieu;
        this.soluong = soluong;
        this.dongia = dongia;
        this.ngayNhap = ngayNhap;
    }

    public String getTenNguyenLieu() {
        return tenNguyenLieu;
    }

    public void setTenNguyenLieu(String tenNguyenLieu) {
        this.tenNguyenLieu = tenNguyenLieu;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public float getDongia() {
        return dongia;
    }

    public void setDongia(float dongia) {
        this.dongia = dongia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }
    
    
}

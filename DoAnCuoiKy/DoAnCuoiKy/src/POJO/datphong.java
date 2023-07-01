/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

/**
 *
 * @author dinht
 */
public class datphong {
    private int id;
    private String tenKH;
    private String sdt;
    private int idPhong;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getIdPhong() {
        return idPhong;
    }

    public void setIdPhong(int idPhong) {
        this.idPhong = idPhong;
    }

    public datphong() {
    }

    public datphong(int id, String tenKH, String sdt, int idPhong) {
        this.id = id;
        this.tenKH = tenKH;
        this.sdt = sdt;
        this.idPhong = idPhong;
    }
}

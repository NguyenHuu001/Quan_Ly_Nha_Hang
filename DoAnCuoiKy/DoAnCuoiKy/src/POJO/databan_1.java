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
public class databan_1 {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getIdBan() {
        return idBan;
    }

    public void setIdBan(int idBan) {
        this.idBan = idBan;
    }

    public databan_1(int id, String ten, String sdt, int idBan) {
        this.id = id;
        this.ten = ten;
        this.sdt = sdt;
        this.idBan = idBan;
    }

    public databan_1() {
    }
    private int id;
    private String ten;
    private String sdt;
    private int idBan;
}

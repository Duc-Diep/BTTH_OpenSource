/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1.model;

/**
 *
 * @author ĐĐ
 */
public class SanPham extends LoaiSanPham{
    private int maSp;
    private String tenSp;
    private String nhaSx;
    private int maLoai;
    
     

    public SanPham(int maSp, String tenSp, String nhaSx, int maLoaiSanPham, String tenLoaiSp) {
        super(maLoaiSanPham, tenLoaiSp);
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.nhaSx = nhaSx;
  
    }

    public SanPham() {
    }

    public int getMaSp() {
        return maSp;
    }

    public void setMaSp(int maSp) {
        this.maSp = maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public String getNhaSx() {
        return nhaSx;
    }

    public void setNhaSx(String nhaSx) {
        this.nhaSx = nhaSx;
    }

    public int getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }

    @Override
    public String toString() {
        return "{" + "Mã sản phẩm = " + maSp + ", Tên sản phẩm = " + tenSp + ", Nhà sản xuất = " + nhaSx +", " + super.toString() + '}';
    }
    
}

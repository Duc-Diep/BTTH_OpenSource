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
public class LoaiSanPham {
    private int maLoaiSanPham;
    private String tenLoaiSp;

    public LoaiSanPham(int maLoaiSanPham, String tenLoaiSp) {
        this.maLoaiSanPham = maLoaiSanPham;
        this.tenLoaiSp = tenLoaiSp;
    }

    public LoaiSanPham() {
    }
    

    public int getMaLoaiSanPham() {
        return maLoaiSanPham;
    }

    public void setMaLoaiSanPham(int maLoaiSanPham) {
        this.maLoaiSanPham = maLoaiSanPham;
    }

    public String getTenLoaiSp() {
        return tenLoaiSp;
    }

    public void setTenLoaiSp(String tenLoaiSp) {
        this.tenLoaiSp = tenLoaiSp;
    }

    @Override
    public String toString() {
        return "Loại sản phẩm = " + tenLoaiSp;
    }

    
    
}

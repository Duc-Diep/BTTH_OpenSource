/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2.model;

/**
 *
 * @author ĐĐ
 */
public class HoaDon {
    private int maHoaDon;
    private int maNhanVien;
    private String loaiHoaDon;
    private String ngayLap;
    private String ngayGiaoNhan;
    private String dienGiai;

    public HoaDon(int maHoaDon, int maNhanVien, String loaiHoaDon, String ngayLap, String ngayGiaoNhan, String dienGiai) {
        this.maHoaDon = maHoaDon;
        this.maNhanVien = maNhanVien;
        this.loaiHoaDon = loaiHoaDon;
        this.ngayLap = ngayLap;
        this.ngayGiaoNhan = ngayGiaoNhan;
        this.dienGiai = dienGiai;
    }

    public HoaDon() {
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getLoaiHoaDon() {
        return loaiHoaDon;
    }

    public void setLoaiHoaDon(String loaiHoaDon) {
        this.loaiHoaDon = loaiHoaDon;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public String getNgayGiaoNhan() {
        return ngayGiaoNhan;
    }

    public void setNgayGiaoNhan(String ngayGiaoNhan) {
        this.ngayGiaoNhan = ngayGiaoNhan;
    }

    public String getDienGiai() {
        return dienGiai;
    }

    public void setDienGiai(String dienGiai) {
        this.dienGiai = dienGiai;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "maHoaDon=" + maHoaDon + ", maNhanVien=" + maNhanVien + ", loaiHoaDon=" + loaiHoaDon + ", ngayLap=" + ngayLap + ", ngayGiaoNhan=" + ngayGiaoNhan + ", dienGiai=" + dienGiai + '}';
    }
    
}

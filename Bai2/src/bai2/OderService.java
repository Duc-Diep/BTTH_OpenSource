/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

import bai2.model.ChiTietHoaDon;
import bai2.model.HoaDon;
import bai2.model.NhanVien;
import bai2.model.SanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ĐĐ
 */
public class OderService {
    public List<SanPham> getAllProducts() {
        List<SanPham> sanPhams = new LinkedList<>();
        String sqlGetAllProducts = "SELECT * FROM SanPham";
        
        try {

            Connection connection = ConnectDB.getConnect();
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sqlGetAllProducts);
            while (resultSet.next()) {
                SanPham sanPham = new SanPham();
                sanPham.setMaSanPham(resultSet.getInt("MaSP"));
                sanPham.setTenSanPham(resultSet.getString("TenSP"));
                sanPham.setGia(resultSet.getInt("Gia"));
                sanPham.setDonViTinh(resultSet.getString("DonViTinh"));
                sanPhams.add(sanPham);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return sanPhams;
    }
    public List<NhanVien> getAllStaff() {
        List<NhanVien> nhanViens = new LinkedList<>();
        String sqlGetAllProducts = "SELECT * FROM NhanVien";
        
        try {

            Connection connection = ConnectDB.getConnect();
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sqlGetAllProducts);
            while (resultSet.next()) {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setMaNhanVien(resultSet.getInt("MaNV"));
                nhanVien.setTenNhanVien(resultSet.getString("TenNhanVien"));
                nhanVien.setDiaChi(resultSet.getString("DiaChi"));
                nhanVien.setGioiTinh(resultSet.getString("GioiTinh"));
                nhanVien.setNgaySinh(resultSet.getString("NgaySinh"));
                nhanVien.setSoDienthoai(resultSet.getString("SoDienThoai"));
                nhanViens.add(nhanVien);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return nhanViens;
    }
    public List<HoaDon> getAllOrder() {
        List<HoaDon> list = new LinkedList<>();
        String query = "select * from HoaDon";
        try {
            Connection connection = ConnectDB.getConnect();
            Statement statement = connection.createStatement();
            
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                HoaDon hoaDon = new HoaDon();
                hoaDon.setMaHoaDon(rs.getInt("MaHD"));
                hoaDon.setMaNhanVien(rs.getInt("MaNV"));
                hoaDon.setLoaiHoaDon(rs.getString("LoaiHD"));
                hoaDon.setNgayLap(rs.getString("NgayLap"));
                hoaDon.setNgayGiaoNhan(rs.getString("NgayGiaoNhan"));
                hoaDon.setDienGiai(rs.getString("DienGiai"));
                list.add(hoaDon);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
    public List<ChiTietHoaDon> getAllOrderDetails() {
        List<ChiTietHoaDon> chiTietHoaDons = new LinkedList<>();
        String query = "select * from ChiTietHoaDon";
        try {
            Connection connection = ConnectDB.getConnect();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
                chiTietHoaDon.setMaHoaDon(rs.getInt("MaHD"));
                chiTietHoaDon.setMaSanPham(rs.getInt("MaSP"));
                chiTietHoaDon.setSoLuong(rs.getInt("SoLuong"));
                chiTietHoaDons.add(chiTietHoaDon);
            }
        } catch (SQLException ex) {
              System.out.println(ex.getMessage());
        }
        return chiTietHoaDons;
    }
    
    public Boolean createNewProduct(SanPham sanPham) {
        String queryCreateSP = "INSERT INTO SanPham VALUES(?, ?, ?)";
        try {

            Connection connection = ConnectDB.getConnect();
            
            PreparedStatement preparedStatement = connection.prepareStatement(queryCreateSP);
            preparedStatement.setString(1, sanPham.getTenSanPham());
            preparedStatement.setString(2, sanPham.getDonViTinh());
            preparedStatement.setInt(3, sanPham.getGia());
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public Boolean createNewStaff(NhanVien nhanVien) {
        String queryCreateNV = "INSERT INTO NhanVien VALUES(?, ?, ?, ?, ?)";
        try {

            Connection connection = ConnectDB.getConnect();
            
            PreparedStatement preparedStatement = connection.prepareStatement(queryCreateNV);
            preparedStatement.setString(1, nhanVien.getTenNhanVien());
            preparedStatement.setString(2, nhanVien.getNgaySinh());
            preparedStatement.setString(3, nhanVien.getDiaChi());
            preparedStatement.setString(4, nhanVien.getSoDienthoai());
            preparedStatement.setString(5, nhanVien.getGioiTinh());
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public Boolean createNewOder(HoaDon hoaDon) {
        String queryCreateHD = "insert into HoaDon values(?,?,?,?,?)";
        try {

            Connection connection = ConnectDB.getConnect();
            
            PreparedStatement preparedStatement = connection.prepareStatement(queryCreateHD);
            preparedStatement.setInt(1, hoaDon.getMaHoaDon());
            preparedStatement.setString(2, hoaDon.getLoaiHoaDon());
            preparedStatement.setString(3, hoaDon.getNgayLap());
            preparedStatement.setString(4, hoaDon.getNgayGiaoNhan());
            preparedStatement.setString(5, hoaDon.getDienGiai());
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public Boolean createNewOderDetails(ChiTietHoaDon chiTietHoaDon) {
        String queryCreateHD = "insert into ChiTietHoaDon values(?,?,?)";
        try {

            Connection connection = ConnectDB.getConnect();
            PreparedStatement preparedStatement = connection.prepareStatement(queryCreateHD);
            preparedStatement.setInt(1, chiTietHoaDon.getMaHoaDon());
            preparedStatement.setInt(2, chiTietHoaDon.getMaSanPham());
            preparedStatement.setInt(3, chiTietHoaDon.getSoLuong());
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
     public Boolean updateProduct(SanPham sanPham) {
        String queryUpdateSP = "UPDATE SanPham set TenSP = ?, DonViTinh = ?, Gia = ? WHERE MaSP = " + sanPham.getMaSanPham();
        try {

            Connection connection = ConnectDB.getConnect();
            
            PreparedStatement preparedStatement = connection.prepareStatement(queryUpdateSP);
            preparedStatement.setString(1, sanPham.getTenSanPham());
            preparedStatement.setString(2, sanPham.getDonViTinh());
            preparedStatement.setInt(3, sanPham.getGia());
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
     
    public Boolean updateStaff(NhanVien nhanVien) {
        String queryUpdateNV = "UPDATE NhanVien set TenNhanVien = ?, NgaySinh = ?, DiaChi = ?, SoDienThoai = ?, GioiTinh = ?";
        try {

            Connection connection = ConnectDB.getConnect();
            
            PreparedStatement preparedStatement = connection.prepareStatement(queryUpdateNV);
            preparedStatement.setString(1, nhanVien.getTenNhanVien());
            preparedStatement.setString(2, nhanVien.getNgaySinh());
            preparedStatement.setString(3, nhanVien.getDiaChi());
            preparedStatement.setString(4, nhanVien.getSoDienthoai());
            preparedStatement.setString(5, nhanVien.getGioiTinh());
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public Boolean updateOder(HoaDon hoaDon) {
        String queryUpdateHD = "UPDATE HoaDon set MaNV = ?, LoaiHD = ?, NgayLap = ?, NgayGiaoNhan = ?, DienGiai = ?";
        try {

            Connection connection = ConnectDB.getConnect();
            
            PreparedStatement preparedStatement = connection.prepareStatement(queryUpdateHD);
            preparedStatement.setInt(1, hoaDon.getMaHoaDon());
            preparedStatement.setString(2, hoaDon.getLoaiHoaDon());
            preparedStatement.setString(3, hoaDon.getNgayLap());
            preparedStatement.setString(4, hoaDon.getNgayGiaoNhan());
            preparedStatement.setString(5, hoaDon.getDienGiai());
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public Boolean updateOderDetails(ChiTietHoaDon chiTietHoaDon) {
        String queryCreateHD = "UPDATE ChiTietHoaDon SET SoLuong WHERE MaHD = ? and MaSP = ?";
        try {
            Connection connection = ConnectDB.getConnect();
            PreparedStatement preparedStatement = connection.prepareStatement(queryCreateHD);
            preparedStatement.setInt(1, chiTietHoaDon.getMaHoaDon());
            preparedStatement.setInt(2, chiTietHoaDon.getMaSanPham());
            preparedStatement.setInt(3, chiTietHoaDon.getSoLuong());
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public Boolean deleteProduct(int id) {
        String queryDeleteSP = "DELETE FROM SanPham WHERE MaSP = ?";
        try {

            Connection connection = ConnectDB.getConnect();
            
            PreparedStatement preparedStatement = connection.prepareStatement(queryDeleteSP);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    public Boolean deleteStaff(int id) {
        String queryDeleteNV = "DELETE FROM NhanVien WHERE MaNV = ?";
        try {

            Connection connection = ConnectDB.getConnect();
            
            PreparedStatement preparedStatement = connection.prepareStatement(queryDeleteNV);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
     public Boolean deleteOrder(int id) {
        String queryDeleteOrder = "DELETE FROM HoaDon WHERE MaHD = ?";
        try {

            Connection connection = ConnectDB.getConnect();
            
            PreparedStatement preparedStatement = connection.prepareStatement(queryDeleteOrder);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
     public Boolean deleteOrderDetails(int maHD,int maSP) {
        String queryDeleteOrder = "DELETE FROM HoaDon WHERE MaHD = ? and maSP = ?";
        try {

            Connection connection = ConnectDB.getConnect();
            
            PreparedStatement preparedStatement = connection.prepareStatement(queryDeleteOrder);
            preparedStatement.setInt(1, maHD);            
            preparedStatement.setInt(2, maSP);

            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    
}

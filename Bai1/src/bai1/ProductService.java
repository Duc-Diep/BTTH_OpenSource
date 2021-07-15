/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

import bai1.model.SanPham;
import com.sun.org.apache.xpath.internal.operations.Bool;
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
public class ProductService {
    
    public List<SanPham> getAllProducts() {
        List<SanPham> sanPhams = new LinkedList<>();
        String sqlGetAllProducts = "SELECT SanPham.MaLoaiSP, TenLoaiSP, MaSP, TenSP, "
                + "NhaSanXuat FROM LoaiSanPham, SanPham WHERE LoaiSanPham.MaLoaiSP = SanPham.MaLoaiSP";
        
        try {

            Connection connection = ConnectDB.getConnect();
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sqlGetAllProducts);
            while (resultSet.next()) {
                SanPham sanPham = new SanPham();
                sanPham.setMaLoai(resultSet.getInt("MaLoaiSP"));
                sanPham.setMaSp(resultSet.getInt("MaSP"));
                sanPham.setTenSp(resultSet.getString("TenSP"));
                sanPham.setNhaSx(resultSet.getString("NhaSanXuat"));
                sanPham.setTenLoaiSp(resultSet.getString("TenLoaiSP"));
                sanPhams.add(sanPham);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return sanPhams;
    }

    public Boolean createNewProduct(SanPham sanPham) {
        String queryCreateLoaiSP = "INSERT INTO LoaiSanPham VALUES(?)";
        String queryCreateSP = "INSERT INTO SanPham VALUES(?, ?, ?)";
        try {

            Connection connection = ConnectDB.getConnect();

//            PreparedStatement preparedStatement1 = connection.prepareStatement(queryCreateLoaiSP);
//            preparedStatement1.setString(1, sanPham.getTenLoaiSp());
//
//            preparedStatement1.execute();
//            preparedStatement1.close();
            
            PreparedStatement preparedStatement2 = connection.prepareStatement(queryCreateSP);
            preparedStatement2.setString(1, sanPham.getTenSp());
            preparedStatement2.setString(2, sanPham.getNhaSx());
            preparedStatement2.setInt(3, sanPham.getMaLoai());
            preparedStatement2.execute();
            preparedStatement2.close();
            connection.close();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
}

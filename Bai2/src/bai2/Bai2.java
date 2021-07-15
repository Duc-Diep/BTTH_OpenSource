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
import java.util.List;

/**
 *
 * @author ĐĐ
 */
public class Bai2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        OderService oderService = new OderService();
        List<SanPham> listSP = oderService.getAllProducts();
        System.out.println("-----Bảng sản phẩm-----");
        for (SanPham sanPham : listSP) {
            System.out.println(sanPham.toString());
        }
        System.out.println("-----Bảng nhân viên------");
        List<NhanVien> listNV = oderService.getAllStaff();
        for (NhanVien nhanVien : listNV) {
            System.out.println(nhanVien.toString());
        }
        System.out.println("-----Bảng hóa đơn-----");
        List<HoaDon> listHD = oderService.getAllOrder();
        for (HoaDon hoaDon : listHD) {
            System.out.println(hoaDon.toString());
        }
        System.out.println("-----Bảng chi tiết hóa đơn-----");
        List<ChiTietHoaDon> listCTHD = oderService.getAllOrderDetails();
        for (ChiTietHoaDon chiTietHoaDon : listCTHD) {
            System.out.println(chiTietHoaDon.toString());
        }
        //Thêm data
        oderService.createNewProduct(new SanPham(0, "Bim bim", "Gói", 10000));
        oderService.createNewStaff(new NhanVien(0, "Đức Điệp", "17/07/2000", "Hà Nội", "Nam", "0981206317"));
        oderService.createNewOder(new HoaDon(0, 1, "Điện tử", "02/02/2021", "02/02/2021", "Giao hàng tận nhà"));
        oderService.createNewOderDetails(new ChiTietHoaDon(0, 1, 5));
        listSP = oderService.getAllProducts();
        System.out.println("-----Bảng sản phẩm sau khi thêm-----");
        for (SanPham sanPham : listSP) {
            System.out.println(sanPham.toString());
        }
        System.out.println("-----Bảng nhân viên sau khi thêm------");
        listNV = oderService.getAllStaff();
        for (NhanVien nhanVien : listNV) {
            System.out.println(nhanVien.toString());
        }
        System.out.println("-----Bảng hóa đơn sau khi thêm-----");
        listHD = oderService.getAllOrder();
        for (HoaDon hoaDon : listHD) {
            System.out.println(hoaDon.toString());
        }
        System.out.println("-----Bảng chi tiết hóa đơn sau khi thêm -----");
        listCTHD = oderService.getAllOrderDetails();
        for (ChiTietHoaDon chiTietHoaDon : listCTHD) {
            System.out.println(chiTietHoaDon.toString());
        }
        //Sửa data
        oderService.updateProduct(new SanPham(0, "Bim bim", "Gói", 10000));
        oderService.updateStaff(new NhanVien(0, "Đức Điệp", "17/07/2000", "Hà Nội", "Nam", "0981206317"));
        oderService.updateOder(new HoaDon(0, 1, "Điện tử", "02/02/2021", "02/02/2021", "Giao hàng tận nhà"));
        oderService.updateOderDetails(new ChiTietHoaDon(0, 1, 5));
        System.out.println("-----Bảng sản phẩm sau khi sửa-----");
        for (SanPham sanPham : listSP) {
            System.out.println(sanPham.toString());
        }
        System.out.println("-----Bảng nhân viên sau khi sửa------");
        listNV = oderService.getAllStaff();
        for (NhanVien nhanVien : listNV) {
            System.out.println(nhanVien.toString());
        }
        System.out.println("-----Bảng hóa đơn sau khi sửa-----");
        listHD = oderService.getAllOrder();
        for (HoaDon hoaDon : listHD) {
            System.out.println(hoaDon.toString());
        }
        System.out.println("-----Bảng chi tiết hóa đơn sau khi sửa-----");
        listCTHD = oderService.getAllOrderDetails();
        for (ChiTietHoaDon chiTietHoaDon : listCTHD) {
            System.out.println(chiTietHoaDon.toString());
        }
        //Xóa data
        oderService.deleteProduct(1);
        oderService.deleteStaff(1);
        oderService.deleteOrder(1);
        oderService.deleteOrderDetails(1, 2);
        System.out.println("-----Bảng sản phẩm sau khi xóa-----");
        for (SanPham sanPham : listSP) {
            System.out.println(sanPham.toString());
        }
        System.out.println("-----Bảng nhân viên sau khi xóa------");
        listNV = oderService.getAllStaff();
        for (NhanVien nhanVien : listNV) {
            System.out.println(nhanVien.toString());
        }
        System.out.println("-----Bảng hóa đơn sau khi xóa-----");
        listHD = oderService.getAllOrder();
        for (HoaDon hoaDon : listHD) {
            System.out.println(hoaDon.toString());
        }
        System.out.println("-----Bảng chi tiết hóa đơn sau khi xóa -----");
        listCTHD = oderService.getAllOrderDetails();
        for (ChiTietHoaDon chiTietHoaDon : listCTHD) {
            System.out.println(chiTietHoaDon.toString());
        }
    }
   
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

import bai1.model.SanPham;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ĐĐ
 */
public class Bai1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductService productService = new ProductService();
        int choice;

        while (true) {
            System.out.println("1. Hiện thị danh sách sản phẩm.");
            System.out.println("2. Thêm sản phẩm.");
            System.out.println("0. Thoát.");

            System.out.print("Lựa chọn: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    List<SanPham> sanPhams = productService.getAllProducts();
                    for (SanPham sanPham : sanPhams) {
                        System.out.println(sanPham);
                    }
                    break;
                case 2:

                    String tenSP;
                    String nhaSanXuat;
                    int maLoaiSP;
                    scanner.nextLine();
                    System.out.print("Nhập tên sản phẩm: ");
                    tenSP = scanner.nextLine();
                    System.out.print("Nhập nhà sản xuất: ");
                    nhaSanXuat = scanner.nextLine();
                    System.out.print("Nhập mã loại sản phẩm: ");
                    maLoaiSP = scanner.nextInt();
                    
                    SanPham sanPham = new SanPham();
                    sanPham.setTenSp(tenSP);
                    sanPham.setNhaSx(nhaSanXuat);
                    sanPham.setMaLoai(maLoaiSP);
                    if (productService.createNewProduct(sanPham)) {
                        System.out.println("Thêm thành công.");
                    } else {
                        System.out.println("Thêm thất bại.Không tồn tại loại hàng này");
                    }

                    break;
                case 0:
                    System.exit(0);
                    break;
            }

        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ĐĐ
 */
public class ConnectDB {
    private static Connection conn = null;
    private static String URL = "jdbc:sqlserver://localhost:1433;databaseName=QLSP";
    private static final String USER = "sa";
    private static final String PASSWORD = "123";
    
    public static Connection getConnect() {
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connect success");
        } catch (SQLException throwables) {
            System.out.println("connect error: " + throwables.getMessage());
        }
        return conn;
    }
    
}

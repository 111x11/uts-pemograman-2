/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.mysql;

import com.app.model.Payment;
import com.app.model.PaymentDatasource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ZXC
 */
public class ConnectMysql {
    public static void main(String[] args) {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setServerName("localhost");
        ds.setDatabaseName("procurement");
        ds.setPort(3306);
        ds.setUser("root");
        ds.setPassword("");
        try {
            Connection connetion = ds.getConnection();
            System.out.println("Koneksi Mysql Berhasil");
        } catch (SQLException ex) {
            System.out.println("Koneksi Mysql Gagal");
            System.out.println("Error "+ ex.getMessage()); 
        }
    }
}
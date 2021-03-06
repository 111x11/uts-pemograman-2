/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

import com.app.mysql.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ZXC
 */
public class PaymentDatasource {
    private Connection connection;
    
    public PaymentDatasource(){
        connection = ConnectionUtil.getConnection(); 
    }
    
    public List<Payment> getAll(){
        List<Payment> list = new ArrayList<>();
        String sql = "SELECT * FROM payment";
        try {
            PreparedStatement statement = connection.prepareCall(sql);
            ResultSet rs = statement.executeQuery();
            Payment pym;
            while(rs.next()){
                pym = new Payment();
                pym.setIdpayment(rs.getString("idpayment"));
                pym.setTgglpayment(rs.getString("tgglpayment"));
                pym.setNomorpo(rs.getString("nomorpo"));
                pym.setSupplier(rs.getString("supplier"));
                pym.setTotaltagihan(rs.getString("totaltagihan"));
                list.add(pym);  
            }
        }
        catch (Exception e){
            System.out.println("Error get All" + e.getMessage());
        }
        return list;
    }
    
    public Payment getByID(String idpayment){
        String sql = "SELECT * FROM payment WHERE idpayment=?";
        Payment pym = null;
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, idpayment);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                pym = new Payment();
                pym.setIdpayment(rs.getString("idpayment"));
                pym.setTgglpayment(rs.getString("tgglpayment"));
                pym.setNomorpo(rs.getString("nomorpo"));
                pym.setSupplier(rs.getString("supplier"));
                pym.setTotaltagihan(rs.getString("totaltagihan"));
            }
        }
        catch(Exception e){
        }  
        return pym;
    }
    
    public boolean insert(Payment pym){
        boolean status = false;
        String sql = "INSERT INTO payment VALUES(?,?,?,?,?)";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, pym.getIdpayment());
            statement.setString(2, pym.getTgglpayment());
            statement.setString(3, pym.getNomorpo());
            statement.setString(4, pym.getSupplier());
            statement.setString(5, pym.getTotaltagihan());
            int result = statement.executeUpdate();
            status = result > 0;  
        }
        catch(Exception e){     
        }
        return status;
    }
    
        public boolean update(Payment pym){
        boolean status = false;
        String sql = "UPDATE payment SET tgglpaymen=?, nomorpo=?, supplier=?, totaltagihan=? WHERE idpayment=?";
        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(2, pym.getTgglpayment());
            statement.setString(3, pym.getNomorpo());
            statement.setString(4, pym.getSupplier());
            statement.setString(5, pym.getTotaltagihan());
            statement.setString(1, pym.getIdpayment());
            int result = statement.executeUpdate();
            status = result > 0;  
        }
        catch(Exception e){     
        }
        return status;
    }
}


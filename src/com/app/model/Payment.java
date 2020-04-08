/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.model;

/**
 *
 * @author ZXC
 */
public class Payment {
    private String idpayment;
    private String tgglpayment;
    private String nomorpo;
    private String supplier;
    private String totaltagihan;
    
    public Payment(){
    }
    
    public Payment(String idpayment, String tgglpayment, String nomorpo, String supplier, String totaltagihan){
        this.idpayment = idpayment;
        this.tgglpayment = tgglpayment;
        this.nomorpo = nomorpo;
        this.supplier = supplier;
        this.totaltagihan = totaltagihan;
    }

    public String getIdpayment() {
        return idpayment;
    }

    public void setIdpayment(String idpayment) {
        this.idpayment = idpayment;
    }

    public String getTgglpayment() {
        return tgglpayment;
    }

    public void setTgglpayment(String tgglpayment) {
        this.tgglpayment = tgglpayment;
    }

    public String getNomorpo() {
        return nomorpo;
    }

    public void setNomorpo(String nomorpo) {
        this.nomorpo = nomorpo;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getTotaltagihan() {
        return totaltagihan;
    }

    public void setTotaltagihan(String totaltagihan) {
        this.totaltagihan = totaltagihan;
    }
    
}



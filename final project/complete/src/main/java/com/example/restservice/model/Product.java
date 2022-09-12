package com.example.restservice.model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Product {
    private int id;
    private String sku_id;
    private String product_name;
    private Date expiry_date;
    private int days_to_expire_from_today;
    LocalDate date = LocalDate.now();
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy");

    public Product(int id, String sku_id, String product_name, Date expiry_date, int days_to_expire_from_today) {
        this.id = id;
        this.sku_id = sku_id;
        this.product_name = product_name;
        this.expiry_date = expiry_date;
        //I think to find days to expiry, i have to convert all dates to milliseconds before doing the substraction, then reconvert back to dates, but i dont know how to implement that
        this.days_to_expire_from_today = days_to_expire_from_today;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSku_id() {
        return sku_id;
    }

    public void setSku_id(String sku_id) {
        this.sku_id = sku_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Date getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(Date expiry_date) {
        this.expiry_date = expiry_date;
    }

    public int getDays_to_expire_from_today() {
        return days_to_expire_from_today;
    }

    public void setDays_to_expire_from_today(int days_to_expire_from_today) {
        this.days_to_expire_from_today = days_to_expire_from_today;
    }
}

package com.example.restservice.repository;

import com.example.restservice.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {

    @Autowired
    private Product product;

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Product(rs.getInt("ID"), rs.getString("SKU_ID"), rs.getString("PRODUCT_NAME"), rs.getDate("Expiry_Date"), this.product.getDays_to_expire_from_today());
    }
}
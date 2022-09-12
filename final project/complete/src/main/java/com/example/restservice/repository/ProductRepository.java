package com.example.restservice.repository;

import com.example.restservice.exception.DatabaseException;
import com.example.restservice.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Product> getAll(){
        try {
            List<Product> productList = jdbcTemplate.query("SELECT * FROM product",
                    (rs, rowNum) ->
                            new Product(rs.getInt("id"),
                                    rs.getString("sku_id"),
                                    rs.getString("product_name"),
                                    rs.getDate("expiry_date"),
                                    getProductById(rs.getInt("id")).getDays_to_expire_from_today()));
            return productList;
        }catch (DatabaseException exception){
            throw  new DatabaseException(exception.getMessage());
        }
    }

    public int createProduct(Product product){
        jdbcTemplate.update("INSERT into product(sku_id, product_name, expiry_date) VALUES(?,?,?)",
                product.getSku_id(), product.getProduct_name(), product.getExpiry_date());

        return jdbcTemplate.queryForObject("SELECT max(id) from product", Integer.class);
    }

    public Product getProductById(int id){
        try {
            String sql = "SELECT * FROM Product WHERE ID = ?";

            return jdbcTemplate.queryForObject(sql, new Object[]{id}, new ProductRowMapper());
        }catch (DatabaseException exception){
            throw new DatabaseException("Database Error");
        }
    }

    public Product getStudentBySku(String sku_id){
        try {
            String sql = "SELECT * FROM STUDENT WHERE SKU_ID = ?";

            return jdbcTemplate.queryForObject(sql, new Object[]{sku_id}, new ProductRowMapper());
        }catch (DatabaseException exception){
            throw new DatabaseException("Database Error");
        }
    }

    public Product updateProduct(int id, Product product){
        int result = jdbcTemplate.update("UPDATE product set sku_id=?, product_name=?, expiry_date=? where id=?", product.getSku_id(), product.getProduct_name(), product.getExpiry_date(), id);
        if (result == 1){
            product.setId(id);
            return product;
        }
        return null;
    }
}

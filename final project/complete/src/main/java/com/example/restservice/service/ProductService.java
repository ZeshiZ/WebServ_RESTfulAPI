package com.example.restservice.service;

import com.example.restservice.exception.DatabaseException;
import com.example.restservice.exception.ProductNotFoundException;
import com.example.restservice.model.Product;
import com.example.restservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    static List<Product> productList = new ArrayList<>();


    public List<Product> getProducts(){
        try {
            return this.repository.getAll();
        }catch (Exception exception){
            throw new DatabaseException(exception.getMessage());
        }
    }

    public int createProduct(Product product){
        return repository.createProduct(product);
    }

    public Product getProductById(int id){
        try {
            Product product = this.repository.getProductById(id);
            if (product == null) {
                throw new ProductNotFoundException("The product was not found");
            }
            return product;
        }catch (Exception exception){
            throw new ProductNotFoundException("The product was not found");
        }
    }

    public Product getProductBySku(String sku_id){
        try {
            Product product = this.repository.getStudentBySku(sku_id);
            if (product == null) {
                throw new ProductNotFoundException("The product was not found");
            }
            return product;
        }catch (Exception exception){
            throw new ProductNotFoundException("The product was not found");
        }
    }

    public Product updateProduct(int id, Product product){
        return this.repository.updateProduct(id, product);
    }
}

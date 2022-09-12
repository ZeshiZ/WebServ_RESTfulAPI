package com.example.restservice.api;

import com.example.restservice.exception.ProductNotFoundException;
import com.example.restservice.model.Product;
import com.example.restservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAll(){
        try {
            return new ResponseEntity<>(service.getProducts(), HttpStatus.OK);
        }catch (Exception exception){
            return new ResponseEntity(exception.getMessage(), HttpStatus.CONFLICT);
        }
    }
    //I think to find days to expiry, i have to convert all dates to milliseconds before doing the substraction, then reconvert back to dates, but i dont know how to implement that

    @PostMapping("/product")
    public ResponseEntity<Integer> postProduct(@RequestBody Product product){
        return new ResponseEntity<>(service.createProduct(product), HttpStatus.CREATED);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        try {
            return new ResponseEntity<>(service.getProductById(id), HttpStatus.OK);
        }catch(ProductNotFoundException exception){
            return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/product/{sku_id}")
    public ResponseEntity<Product> getProductBySku(@PathVariable String sku_id){
        try {
            return new ResponseEntity<>(service.getProductBySku(sku_id), HttpStatus.OK);
        }catch(ProductNotFoundException exception){
            return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable int id){
        return new ResponseEntity<>(service.updateProduct(id, product), HttpStatus.OK);
    }
}

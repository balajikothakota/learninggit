package com.redis_cache.project.controller;

import com.redis_cache.project.dao.Product;
import com.redis_cache.project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductClient {
    private ProductService productService;

    public ProductClient(@Autowired ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getAllProductDetails")
    public List<Product> getProductDetails(){
        return productService.getProductDetails();
    }

    @GetMapping("/getProductById/{id}")
    public Product getProductWithId(@PathVariable int id) {
        return productService.getByProductId(id);
    }
    @PostMapping("/newProduct")
    public Product newProduct(@RequestBody Product product){
        System.out.println("here.....");
        return productService.save(product);
    }
    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable int id){
        return productService.deleteProduct(id);
    }
}

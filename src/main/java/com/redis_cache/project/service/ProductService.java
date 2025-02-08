package com.redis_cache.project.service;

import com.redis_cache.project.dao.Product;
import com.redis_cache.project.repository.ProductRepo;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        System.out.println("inside service");
        this.productRepo = productRepo;
    }

    @Cacheable(value = "product")
    public List<Product> getProductDetails() {
        System.out.println(" inside get products");
        List<Product> products = productRepo.findAll();
        System.out.println("values :::::::::::::::::::: " + products.isEmpty());
        return productRepo.findAll();
    }
    @Cacheable(value = "product", key = "#id")
    public Product getByProductId(int id) {
        System.out.println("inside get product by id");
        Optional<Product> product = productRepo.findById(id);
        return product.get();
    }
    @Caching(evict = {@CacheEvict(value = "product", allEntries = true)})
    public Product save(Product product) {
        System.out.println("save product");
       return productRepo.save(product);
    }
    @Caching(evict = {@CacheEvict(value = "product", allEntries = true), @CacheEvict(value = "product",key = "#id")})
    public String deleteProduct(int id) {
        System.out.println("delete product");
        productRepo.deleteById(id);
        return "Product got deleted";
    }
}

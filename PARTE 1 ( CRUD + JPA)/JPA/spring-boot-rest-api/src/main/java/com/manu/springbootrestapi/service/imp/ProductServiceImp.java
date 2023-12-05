package com.manu.springbootrestapi.service.imp;

import com.manu.springbootrestapi.entity.Product;
import com.manu.springbootrestapi.repository.ProductRepository;
import com.manu.springbootrestapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
 @Service
public class ProductServiceImp implements ProductService {

     private ProductRepository productRepository;

     public ProductServiceImp(ProductRepository productRepository) {
         this.productRepository = productRepository;
     }

     @Override
    public List<Product> searchProducts(String query) {
         return productRepository.searchProducts(query);
    }

     @Override
     public Product createProduct(Product product) {
         return productRepository.save(product);
     }
 }

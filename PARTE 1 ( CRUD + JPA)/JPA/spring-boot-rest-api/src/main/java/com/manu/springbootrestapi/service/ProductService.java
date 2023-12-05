package com.manu.springbootrestapi.service;

import java.util.List;
import com.manu.springbootrestapi.entity.Product;

public interface ProductService {
    List<Product> searchProducts(String query);

    Product createProduct(Product product);
}

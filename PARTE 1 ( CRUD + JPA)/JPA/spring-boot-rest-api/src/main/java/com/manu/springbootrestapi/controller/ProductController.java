package com.manu.springbootrestapi.controller;

import com.manu.springbootrestapi.entity.Product;
import com.manu.springbootrestapi.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController("/api/v1/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam("query") String query)
    {
        return ResponseEntity.ok(productService.searchProducts(query));
    }

    @PostMapping()
    public Product createProduct(@RequestBody Product product)
    {
        return  productService.createProduct(product);
    }
}

package manu.Jpa.service;

import manu.Jpa.entity.Product;
import manu.Jpa.repository.ProductRepository;

import java.util.List;

public class ProductService {

    private ProductRepository productRepository;

    public String saveProduct(Product product)
    {
        productRepository.save(product);
        return product + " has been added to store!";
    }

    public List<Product> saveAllProducts(List<Product> products)
    {
        return productRepository.saveAll(products);
    }

    public  List<Product> getAllProducts()
    {
        return productRepository.findAll();
    }

    public  Product getProductById(Integer id)
    {
        return productRepository.findById(id).get();
    }

    public Product getProductByName(String name)
    {
        return productRepository.findByName(name);
    }

    public boolean checkIfExistById(Integer id)
    {
        return productRepository.existsById(id);
    }

    public long getCount()
    {
        return productRepository.count();
    }

    public String deleteProductById(int id)
    {
        productRepository.deleteById(id);
        return id + " has been deleted.";
    }

    public String deleteProductByEntity(Product product)
    {
        productRepository.delete(product);
        return product + " has been deleted!";
    }

    public String deleteAll()
    {
        productRepository.deleteAll();
        return "All records has been deleted!";
    }

    public String updateProduct(Product product)
    {
        Product existProduct = productRepository.findById(product.getId()).get();

        existProduct.setName(product.getName());
        existProduct.setDescription(product.getDescription());

        productRepository.save(existProduct);

        return product + " has been modified!";
    }
}